package br.com.bradesco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bradesco.expections.ImageProcessServiceExecption;
import br.com.bradesco.models.HubResponse;
import br.com.bradesco.models.OcrForm;
import br.com.bradesco.models.OcrResponse;
import br.com.bradesco.models.ResponseHub;
import br.com.bradesco.services.CallereHubService;

@Scope("request")
@RestController
@RequestMapping("hub-callere/v2")
public class CallereHubController {

	@Autowired
	private CallereHubService service;

	@PostMapping("/extract")
	public ResponseHub extract(@RequestBody OcrForm request) throws ImageProcessServiceExecption {
		ResponseHub response = null; 
		 HubResponse extract = service.extract(request);
		 if(extract.getFullText() != null && extract.getOcrResponse() != null) {
			 response = new ResponseHub();
			 response.setFullText(extract.getFullText());
			 OcrResponse ocrResponse = new OcrResponse();
			 ocrResponse.setDoc(extract.getOcrResponse().getDoc());
			 ocrResponse.setMensagem(extract.getMessage());
			 ocrResponse.setStatus(200);
			 response.setOcrResponse(ocrResponse);
		 }
		return response;
	}
}
