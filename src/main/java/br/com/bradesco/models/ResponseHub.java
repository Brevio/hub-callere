package br.com.bradesco.models;

public class ResponseHub {
	private String fullText;
	private OcrResponse ocrResponse;
	public String getFullText() {
		return fullText;
	}
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	public OcrResponse getOcrResponse() {
		return ocrResponse;
	}
	public void setOcrResponse(OcrResponse ocrResponse) {
		this.ocrResponse = ocrResponse;
	}
	
	
}
