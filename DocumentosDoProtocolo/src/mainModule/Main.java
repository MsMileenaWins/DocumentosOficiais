package mainModule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DAO.DocumentDAO;
import documentsModule.*;

public class Main {

	public static void main(String[] args) {
		
//		Document doc = new Document(TYPE.OFICIO,LocalDate.now(),"000","ANY","DP","PRESIDENCIA");
		DocumentDAO documentDAO= new DocumentDAO();
//		documentDAO.saveDocument(doc);
//		documentDAO.deleteDocument(3, TYPE.OFICIO);
		List<Document> docs = new ArrayList<Document>();
		docs = documentDAO.readDocuments(TYPE.OFICIO);
		for(Document doc1 : docs ) {
			System.out.println(doc1.toString());
			
		}
	}

}
