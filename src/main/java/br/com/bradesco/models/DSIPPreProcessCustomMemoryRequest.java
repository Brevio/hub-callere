package br.com.bradesco.models;

public class DSIPPreProcessCustomMemoryRequest  {

	private int binarizeMode;
	private int deskewMode;
	private int cropMode;
	private int deskewCropOrder;
	private String imageFilters;
	private byte[] pImage;
	private int sizeImage;

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
	public byte[] getpImage() {
		return pImage;
	}
	public void setpImage(byte[] pImage) {
		this.pImage = pImage;
	}
	public int getSizeImage() {
		return sizeImage;
	}
	public void setSizeImage(int sizeImage) {
		this.sizeImage = sizeImage;
	}
	
}
