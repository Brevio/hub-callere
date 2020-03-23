package br.com.bradesco.models;

public class HubResponse {

	private String fullText;
	private OcrDto ocrResponse;
	private String message;
	
	public OcrDto getOcrResponse() {
		return ocrResponse;
	}

	public void setOcrResponse(OcrDto ocrResponse) {
		this.ocrResponse = ocrResponse;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
