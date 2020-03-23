package br.com.bradesco.models;

public class DSIPPreProcessCustomRequest  {

	private String file64;
	private String fileName;
	private int binarizeMode;
	private int deskewMode;
	private int cropMode;
	private int deskewCropOrder;
	private String imageFilters;
	
	public String getFile64() {
		return file64;
	}
	public void setFile64(String file64) {
		this.file64 = file64;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getBinarizeMode() {
		return binarizeMode;
	}
	public void setBinarizeMode(int binarizeMode) {
		this.binarizeMode = binarizeMode;
	}
	public int getDeskewMode() {
		return deskewMode;
	}
	public void setDeskewMode(int deskewMode) {
		this.deskewMode = deskewMode;
	}
	public int getCropMode() {
		return cropMode;
	}
	public void setCropMode(int cropMode) {
		this.cropMode = cropMode;
	}
	public int getDeskewCropOrder() {
		return deskewCropOrder;
	}
	public void setDeskewCropOrder(int deskewCropOrder) {
		this.deskewCropOrder = deskewCropOrder;
	}
	public String getImageFilters() {
		return imageFilters;
	}
	public void setImageFilters(String imageFilters) {
		this.imageFilters = imageFilters;
	}
	
	
}
