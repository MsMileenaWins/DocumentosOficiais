package documentsModule;

/**
 * this class represents the origin of a document as a criterion for filtering
 *
 */

public class OriginCriterion implements Filtering{

	private String origem;	
	
	public OriginCriterion(String origem) {
		
		this.origem = origem;
	}


	@Override
	public boolean testDocument(Document doc) {
			
		if(this.origem.contentEquals(doc.getOrigin()))
			return true;
		else
			return false;
	}
	

}
