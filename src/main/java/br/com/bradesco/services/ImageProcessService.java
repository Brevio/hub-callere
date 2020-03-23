package br.com.bradesco.services;

import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.bradesco.expections.ImageProcessServiceExecption;
import br.com.bradesco.models.DSIPPreProcessCustomMemoryRequest;
import br.com.bradesco.models.DSIPPreProcessCustomMemoryResponse;
import br.com.bradesco.models.DSIPPreProcessCustomRequest;
import br.com.bradesco.models.DSIPPreProcessCustomResponse;
import br.com.bradesco.models.OcrForm;

@Service
class ImageProcessService {

	@Value("${binarize.mode}")
	private String binarizeMode;
	@Value("${crop.mode}")
	private String cropMode;
	@Value("${deskew.crop.order}")
	private String deskewCropOrder;
	@Value("${deskew.mode}")
	private String deskewMode;
	@Value("${image.filters}")
	private String imageFilters;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${url.dsip}")
	private String URL_IMAGE_PROCESS;
	@Value("${url.dsip.file}")
	private String URL_IMAGE_PROCESS_FILE;
	
	public DSIPPreProcessCustomMemoryResponse processMemory (OcrForm request) {
		return restTemplate.postForEntity(URL_IMAGE_PROCESS,
				buildRequestIPMemory(request), DSIPPreProcessCustomMemoryResponse.class).getBody();
	}

	public DSIPPreProcessCustomResponse process (OcrForm request) throws ImageProcessServiceExecption {
		
		try { 
			return restTemplate.postForEntity(URL_IMAGE_PROCESS_FILE,
					buildRequestIP(request), DSIPPreProcessCustomResponse.class).getBody();
		} catch ( HttpClientErrorException e) {
			throw new ImageProcessServiceExecption(e.getResponseBodyAsString());
		}
		
	}
	
	private DSIPPreProcessCustomMemoryRequest buildRequestIPMemory(OcrForm request) {

		DSIPPreProcessCustomMemoryRequest requestIP = new DSIPPreProcessCustomMemoryRequest();
		requestIP.setBinarizeMode(Integer.parseInt(binarizeMode));
		requestIP.setCropMode(Integer.parseInt(cropMode));
		requestIP.setDeskewCropOrder(Integer.parseInt(deskewCropOrder));
		requestIP.setDeskewMode(Integer.parseInt(deskewMode));
		requestIP.setImageFilters(imageFilters);

		byte[] img = Base64.getDecoder().decode(request.getFileBase64());
		requestIP.setpImage(img);
		requestIP.setSizeImage(img.length);

		return requestIP;
	}

	private DSIPPreProcessCustomRequest buildRequestIP(OcrForm request) {

		DSIPPreProcessCustomRequest requestIP = new DSIPPreProcessCustomRequest();
		requestIP.setBinarizeMode(Integer.parseInt(binarizeMode));
		requestIP.setCropMode(Integer.parseInt(cropMode));
		requestIP.setDeskewCropOrder(Integer.parseInt(deskewCropOrder));
		requestIP.setDeskewMode(Integer.parseInt(deskewMode));
		requestIP.setImageFilters(imageFilters);
		requestIP.setFileName(String.valueOf(new Date().getTime()));
		requestIP.setFile64(request.getFileBase64());

		return requestIP;
	}
}
