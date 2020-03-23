package br.com.bradesco.services;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bradesco.domain.Document;
import br.com.bradesco.models.OcrDto;
import br.com.bradesco.models.OcrForm;
import br.com.bradesco.services.listerners.ResponseListener;

@Service
class OcrService {

	@Autowired
	private RestTemplate restTemplate;
	@Value("${url.callere.ocr.dll}")
	private String URL_DSOCR;
	@Autowired
	private DiscoveryClient discoveryClient;
	private Logger LOGGER = LoggerFactory.getLogger(OcrService.class);
	private int pageNumber = 0;

	public Document process(OcrForm request) {
		return restTemplate.exchange(URL_DSOCR, HttpMethod.POST, new HttpEntity<OcrForm>(request), Document.class)
				.getBody();
	}

	public OcrDto processMultTask(List<String> files64) {
		int instances = discoveryClient.getInstances("dsocr-api").size();
		int capacity = instances > files64.size() ? files64.size() : instances;

		Pool pool = new Pool(capacity);
		ResponseListener listener = new ResponseOcrListener(pool, files64.size());

		pageNumber = 0;
		files64.forEach(file64 -> {
			try {
				String name = UUID.randomUUID().toString();
				pool.execute(new ClientRestTemplateOcr(URL_DSOCR, new OcrForm(file64, name + ".tif", pageNumber),
						listener, restTemplate));
				pageNumber++;
			} catch (Error e) {
				LOGGER.error(e.getMessage());
			}
		});

		while (pool.getRunningCount() > 0) {
		}

		if (listener.onComplete().getPageCount() != files64.size()) {

			listener.getFails().forEach(fail -> {
				pool.execute(new ClientRestTemplateOcr(URL_DSOCR, fail.getRequest(), listener, restTemplate));
			});
			while (pool.getRunningCount() > 0) {
			}
		}

		if (listener.onComplete().getPageCount() != files64.size()) {
			LOGGER.info("Paginas extraidas " + listener.onComplete().getPageCount());
			return new OcrDto(listener.onComplete(), "incompleto");
		}

		pool.forceDone();
		LOGGER.info("Paginas extraidas " + listener.onComplete().getPageCount());
		return new OcrDto(listener.onComplete(), "sucesso");
	}

	public String getFullText(Document doc) {
		StringBuffer buff = new StringBuffer();
		try {
			doc.getPages().forEach(page -> {
				page.getWord().forEach(w -> {
					buff.append(w.getWord() + " ");
				});
			});
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar docuento. Ex:" + e.getMessage());
		}
		return buff.toString();
	}
}
