package br.com.bradesco.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="document")
public class Document {
	private List<Page> pages = new ArrayList<Page>();
	private int pageCount;
	
	public Document(List<Page> pages, int pageCount) {
		super();
		this.pages = pages;
		this.pageCount = pageCount;
	}
	public Document() {


	}

	@XmlAttribute
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@XmlElement(name="page")
	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
	}}

