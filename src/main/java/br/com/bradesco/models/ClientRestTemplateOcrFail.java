package br.com.bradesco.models;

import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

public class ClientRestTemplateOcrFail {

	private Exception e;
	private OcrForm request;

	public ClientRestTemplateOcrFail(RestClientException e, OcrForm request) {
		this.e = e;
		this.request = request;
	}

	public ClientRestTemplateOcrFail(HttpServerErrorException e, OcrForm request) {
		this.e = e;
		this.request = request;
	}

	public ClientRestTemplateOcrFail(ResourceAccessException e, OcrForm request) {
		this.e = e;
		this.request = request;
	}

	public Exception getException() {
		return e;
	}

	public OcrForm getRequest() {
		return request;
	}
}
