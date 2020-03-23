package br.com.bradesco.services;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import br.com.bradesco.domain.Document;
import br.com.bradesco.models.ClientRestTemplateOcrFail;
import br.com.bradesco.models.OcrForm;
import br.com.bradesco.services.listerners.ResponseListener;

public class ClientRestTemplateOcr extends Thread implements Runnable {

	
	private String URL_DSOCR;
	private OcrForm request;
	private RestTemplate restTemplate;
	private ResponseListener listener;

	public ClientRestTemplateOcr() {

	}

	public ClientRestTemplateOcr(String ULR_DSOCR, OcrForm request, ResponseListener listener, RestTemplate restTemplate) {
		this.request = request;
		this.listener = listener;
		this.restTemplate = restTemplate;
		this.URL_DSOCR = ULR_DSOCR;

	}

	@Override
	public void run() {
		try {
			listener.addDocument(restTemplate.postForEntity(URL_DSOCR, request, Document.class).getBody(), request.getPageNumber());
			
		} catch (HttpClientErrorException | HttpServerErrorException | ResourceAccessException e) {
			listener.fails(new ClientRestTemplateOcrFail(e, request));
		} finally {
			try {
				this.finalize();
				listener.release(this);
			} catch (Throwable e) {
				listener.release(this);
			}
		}
	}
}
