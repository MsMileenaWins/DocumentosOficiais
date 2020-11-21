package documentsModule;
import java.util.List;

import javax.swing.DefaultListModel;

public class DocumentUtils {
	
	public static DefaultListModel<String> toDefListModel(List<Document> documents) {

		DefaultListModel<String> defListModel= new DefaultListModel<>();
		
		for (Document doc: documents) {			
			defListModel.addElement(doc.toString());			
		}
		
		return defListModel;
	}

}
