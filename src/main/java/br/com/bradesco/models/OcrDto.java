package br.com.bradesco.models;

import br.com.bradesco.domain.Document;

public class OcrDto {

	private Document doc;
	private String message;

	public OcrDto(Document doc) {
		this.doc = doc;
	}

	public OcrDto(Document doc, String message) {
		super();
		this.doc = doc;
		this.message = message;
	}

	public Document getDoc() {
		return doc;
	}
	
	public void setDocument(Document doc) {
		this.doc = doc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
