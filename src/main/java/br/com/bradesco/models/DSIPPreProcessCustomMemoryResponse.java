package br.com.bradesco.models;


public class DSIPPreProcessCustomMemoryResponse extends DSIPBaseResponse{
	
	
	private String rImagesBinary;
	private int rImagesBinarySize;
	private int rImagesBinarySizes;
	private String rImagesGray;
	private int rImagesGraySize;
	private int rImagesGraySizes;
	private	int rNumImages;
	
	public String getrImagesBinary() {
		return rImagesBinary;
	}
	public void setrImagesBinary(String rImagesBinary) {
		this.rImagesBinary = rImagesBinary;
	}
	public int getrImagesBinarySize() {
		return rImagesBinarySize;
	}
	public void setrImagesBinarySize(int rImagesBinarySize) {
		this.rImagesBinarySize = rImagesBinarySize;
	}
	public int getrImagesBinarySizes() {
		return rImagesBinarySizes;
	}
	public void setrImagesBinarySizes(int rImagesBinarySizes) {
		this.rImagesBinarySizes = rImagesBinarySizes;
	}
	public String getrImagesGray() {
		return rImagesGray;
	}
	public void setrImagesGray(String rImagesGray) {
		this.rImagesGray = rImagesGray;
	}
	public int getrImagesGraySize() {
		return rImagesGraySize;
	}
	public void setrImagesGraySize(int rImagesGraySize) {
		this.rImagesGraySize = rImagesGraySize;
	}
	public int getrImagesGraySizes() {
		return rImagesGraySizes;
	}
	public void setrImagesGraySizes(int rImagesGraySizes) {
		this.rImagesGraySizes = rImagesGraySizes;
	}
	public int getrNumImages() {
		return rNumImages;
	}
	public void setrNumImages(int rNumImages) {
		this.rNumImages = rNumImages;
	}
	

}
