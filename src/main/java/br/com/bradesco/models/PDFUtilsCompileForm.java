package br.com.bradesco.models;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PDFUtilsCompileForm {
	@NotEmpty
	private List<@NotBlank @NotNull String> listFileBase64;

	public List<String> getListFileBase64() {
		return listFileBase64;
	}

	public void setListFileBase64(List<String> listFileBase64) {
		this.listFileBase64 = listFileBase64;
	}
}