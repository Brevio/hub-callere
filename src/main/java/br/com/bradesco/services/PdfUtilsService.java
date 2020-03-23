package br.com.bradesco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bradesco.models.PDFUtilsCompileForm;
import br.com.bradesco.models.OcrForm;
import br.com.bradesco.models.PdfRequest;
import br.com.bradesco.models.PdfResponse;

@Service
class PdfUtilsService {

	@Autowired
	private RestTemplate restTemplate;
	@Value("${url.pdf.utils.convert}")
	private String URL_PDF_UTILS_CONVERT;
	@Value("${url.pdf.utils.comp}")
	private String URL_COMPILA_TIF;

	public PdfResponse compile(List<String> listFilesBase64) {
		PDFUtilsCompileForm compRequest = new PDFUtilsCompileForm();
		compRequest.setListFileBase64(listFilesBase64);
		return restTemplate.postForEntity(URL_COMPILA_TIF, compRequest, PdfResponse.class).getBody();
	}

	public PdfResponse convert(OcrForm request) {
		PdfRequest pdfRequest = new PdfRequest();
		pdfRequest.setFileBase64(request.getFileBase64());
		pdfRequest.setFileName(request.getFileName());
		return restTemplate.postForEntity(URL_PDF_UTILS_CONVERT, pdfRequest, PdfResponse.class).getBody();
	}

}
