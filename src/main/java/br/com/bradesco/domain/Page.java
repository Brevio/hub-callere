package br.com.bradesco.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="page")
public class Page {

	private int height;
	private int width;
	private int rotation;
	private int number;
	private List<Word> word;
	
	@XmlAttribute(name="height")
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@XmlAttribute(name="width")
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	@XmlAttribute(name="rotation")
	public int getRotation() {
		return rotation;
	}
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	@XmlAttribute(name="number")
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@XmlElement(name="word")
	public List<Word> getWord(){
		return word;
	}
	public void setWord(List<Word> word){
		this.word = word;
	}
}
