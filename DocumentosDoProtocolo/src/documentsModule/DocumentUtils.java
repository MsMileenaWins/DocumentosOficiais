package documentsModule;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;

public class DocumentUtils {

	
	public static DefaultListModel<String> toDefListModel(ArrayList<Document> documents) {

		DefaultListModel<String> defListModel= new DefaultListModel<>();
		
		for (Document doc: documents) {			
			defListModel.addElement(doc.toString());			
		}
		
		return defListModel;
	}

	
	
	public static HashMap<Integer,Document> filter(Filtering criterion, ArrayList<Document> documents) {
					
		HashMap<Integer,Document> filteredDocuments = new HashMap<Integer,Document>();
					
		Integer i = 0;
		
		for ( Document doc : documents) {
			if(criterion.testDocument(doc)) {				
				filteredDocuments.put(i, doc);				
			}
			++i;
		}
		
		return filteredDocuments;
	}
}
