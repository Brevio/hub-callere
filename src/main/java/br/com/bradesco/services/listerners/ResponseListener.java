package br.com.bradesco.services.listerners;

import java.util.List;

import br.com.bradesco.domain.Document;
import br.com.bradesco.models.ClientRestTemplateOcrFail;
import br.com.bradesco.services.ClientRestTemplateOcr;

public interface ResponseListener {
	public List<Document> getDocuments();

	public Document onComplete();

	public void addDocument(Document doc, int pageNumber);

	public void release(ClientRestTemplateOcr t);

	public void fails(ClientRestTemplateOcrFail clientRestTemplateOcrFail);
	
	public List<ClientRestTemplateOcrFail> getFails();
}
