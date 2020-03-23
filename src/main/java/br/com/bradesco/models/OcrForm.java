package br.com.bradesco.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OcrForm {

	@NotNull
	@NotEmpty
	private String fileBase64;
	@NotNull
	@NotEmpty
	private String fileName;
	private int pageNumber;

	public OcrForm(String fileBase64, String fileName, int pageNumber) {
		this.fileBase64 = fileBase64;
		this.fileName = fileName;
		this.pageNumber = pageNumber;
	}

	public OcrForm() {

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileBase64() {
		return fileBase64;
	}

	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}

	public int getPageNumber() {
		return pageNumber;
	}
}
