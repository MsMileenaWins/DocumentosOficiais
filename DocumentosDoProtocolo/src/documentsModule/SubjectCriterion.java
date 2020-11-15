package documentsModule;

/**
 * this class represents the subject of a document as a criterion for filtering
 *
 */

public class SubjectCriterion implements Filtering{

	private String assunto;
	
	public SubjectCriterion(String assunto) {
		
		this.assunto = assunto;
	}
	
	@Override
	public boolean testDocument(Document doc) {

		if(this.assunto.contentEquals(doc.getSubject()) )
			return true;
		else
			return false;
	}

}
