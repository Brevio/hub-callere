package br.com.bradesco.domain;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class Word {

	private String word;
	private String confidence;
	private int rightd;
	private int bottomd;
	private int leftd;
	private int topd;
	private int right;
	private int bottom;
	private int left;
	private int top;
	
	@XmlValue
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@XmlAttribute(name="confidence")
	public String getConfidence() {
		return confidence;
	}
	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}
	@XmlAttribute(name="rightd")
	public int getRightd() {
		return rightd;
	}
	public void setRightd(int rightd) {
		this.rightd = rightd;
	}
	@XmlAttribute(name="bottomd")
	public int getBottomd() {
		return bottomd;
	}
	public void setBottomd(int bottomd) {
		this.bottomd = bottomd;
	}
	@XmlAttribute(name="leftd")
	public int getLeftd() {
		return leftd;
	}
	public void setLeftd(int leftd) {
		this.leftd = leftd;
	}
	@XmlAttribute(name="topd")
	public int getTopd() {
		return topd;
	}
	public void setTopd(int topd) {
		this.topd = topd;
	}
	@XmlAttribute(name="right")
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	@XmlAttribute(name="bottom")
	public int getBottom() {
		return bottom;
	}
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}
	@XmlAttribute(name="left")
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	@XmlAttribute(name="top")
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
}
