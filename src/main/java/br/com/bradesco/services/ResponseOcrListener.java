package br.com.bradesco.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.bradesco.domain.Document;
import br.com.bradesco.domain.Page;
import br.com.bradesco.models.ClientRestTemplateOcrFail;
import br.com.bradesco.services.listerners.ResponseListener;

public class ResponseOcrListener implements ResponseListener {

	private List<Document> listDocuments = new ArrayList<Document>();
	private Pool pool;
	private List<ClientRestTemplateOcrFail> fails;
	private Document[] arrayDoc;
	private Logger LOGGER = LoggerFactory.getLogger(ResponseOcrListener.class);

	public ResponseOcrListener(Pool pool, int pages) {
		this.pool = pool;
		arrayDoc = new Document[pages];
		fails = new ArrayList<ClientRestTemplateOcrFail>(pool.getCapacity());
	}

	@Override
	public List<Document> getDocuments() {
		return listDocuments;
	}

	@Override
	public void addDocument(Document doc, int pageNumber) {
		arrayDoc [pageNumber] = doc;
	}

	@Override
	public Document onComplete() {
		List<Page> pages = new ArrayList<Page>();
		listDocuments = new ArrayList<Document>();
		for (int i = 0; i < arrayDoc.length; i++ ) {
			if(arrayDoc[i] != null) {
				listDocuments.add(arrayDoc[i]);
			}
		}
		listDocuments.forEach(doc -> pages.add(doc.getPages().get(0)));
		return new Document(pages, pages.size());
	}

	@Override
	public void release(ClientRestTemplateOcr t) {
		pool.release(t);
		LOGGER.info("Threads running "+pool.getRunningCount());
	}

	@Override
	public void fails(ClientRestTemplateOcrFail clientRestTemplateOcrFail) {
		fails.add(clientRestTemplateOcrFail);
	}

	@Override
	public List<ClientRestTemplateOcrFail> getFails() {
		return fails;
	}

}
