package br.com.bradesco.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import br.com.bradesco.domain.Document;
import br.com.bradesco.expections.ImageProcessServiceExecption;
import br.com.bradesco.models.DSIPPreProcessCustomMemoryResponse;
import br.com.bradesco.models.DSIPPreProcessCustomResponse;
import br.com.bradesco.models.HubResponse;
import br.com.bradesco.models.OcrDto;
import br.com.bradesco.models.OcrForm;
import br.com.bradesco.models.PdfResponse;

@Service
public class CallereHubService {

	@Autowired
	private ImageProcessService serviceImageProcess;
	@Autowired
	private PdfUtilsService servicePdfUtils;
	@Autowired
	private OcrService serviceOcr;
	@Autowired
	private DiscoveryClient discoveryClient;
	private OcrDto response = new OcrDto(new Document());
	private Logger LOGGER = LoggerFactory.getLogger(CallereHubService.class);

	public HubResponse extract(OcrForm request) throws ImageProcessServiceExecption {
		LOGGER.debug("Started");
		String ext = getExt(request.getFileName());

		if (ext.equals(".tif") || ext.equals(".tiff")) {
			response = extractTif(request);
		} else if (ext.equals(".png") || ext.equals(".jpg") || ext.equals(".jpeg")) {
			response = extractJpgPng(request);
			response.getDoc().getPages();
		} else if (ext.equals(".pdf")) {
			return extractPdf(request);
		} else {
			response = new OcrDto(new Document());
			HubResponse r = new HubResponse();
			r.setOcrResponse(response);

			return r;
		}
		return getHubResponse(response);
	}

	private HubResponse getHubResponse(OcrDto response) {
		HubResponse hubResponse = new HubResponse();
		hubResponse.setOcrResponse(response);
		hubResponse.setFullText(serviceOcr.getFullText(response.getDoc()));
		hubResponse.setMessage(response.getMessage());
		return hubResponse;
	}

	private HubResponse extractPdf(OcrForm request) throws ImageProcessServiceExecption {

		PdfResponse pdfResponse = servicePdfUtils.convert(request);
		request.setFileBase64(pdfResponse.getFileBase64());
		response = extractTif(request);
		HubResponse hubResponse = new HubResponse();
		hubResponse.setOcrResponse(response);
		hubResponse.setFullText(serviceOcr.getFullText(response.getDoc()));
		return hubResponse;
	}

	private OcrDto extractJpgPng(OcrForm request) {

		DSIPPreProcessCustomMemoryResponse responseIP = serviceImageProcess.processMemory(request);
		if (responseIP.isProcessed()) {
			request.setFileName(request.getFileName());
			request.setFileBase64(responseIP.getrImagesBinary());
			response.setDocument(getOcr(request));
		}
		return response;
	}

	private OcrDto extractTif(OcrForm request) throws ImageProcessServiceExecption {
		DSIPPreProcessCustomResponse imageProcessResponse = serviceImageProcess.process(request);
		int instances = discoveryClient.getInstances("dsocr-api").size();
		if (imageProcessResponse.isProcessed() && imageProcessResponse.getFiles64().size() > 1 && instances > 1) {
			response = serviceOcr.processMultTask(imageProcessResponse.getFiles64());
		} else if (instances == 1) {
			PdfResponse compiledImagesResponse = servicePdfUtils.compile(imageProcessResponse.getFiles64());
			request.setFileBase64(compiledImagesResponse.getFileBase64());
			response.setDocument(getOcr(request));
			response.setMessage("sucesso");
		} else {
			request.setFileBase64(imageProcessResponse.getFiles64().get(0));
			response.setDocument(getOcr(request));
		}

		return response;
	}

	private Document getOcr(OcrForm request) {
		return serviceOcr.process(request);
	}

	private String getExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
	}
}
