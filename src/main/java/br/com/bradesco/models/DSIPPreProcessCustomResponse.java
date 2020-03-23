package br.com.bradesco.models;

import java.util.List;

public class DSIPPreProcessCustomResponse extends DSIPBaseResponse {
	
	private List<String> files64;

	public List<String> getFiles64() {
		return files64;
	}
	public void setFiles64(List<String> files64) {
		this.files64 = files64;
	}

}
