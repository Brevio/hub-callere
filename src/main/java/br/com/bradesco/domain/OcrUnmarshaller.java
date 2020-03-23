package br.com.bradesco.domain;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class OcrUnmarshaller {

	public static Document unmarshaller(File xml) throws IOException{
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Document.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			 
			return (Document) unmarshaller.unmarshal(xml);
		} catch (JAXBException e) {
			throw new IOException("Não foi possível realizar a conversão do xml para objeto.");
		}
	}
	
	public static Document unmarshaller(StringReader xml) throws IOException{
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Document.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (Document) unmarshaller.unmarshal(xml);
		} catch (JAXBException e) {
			throw new IOException("Não foi possível realizar a conversão do xml para objeto.");
		}
	}
}
