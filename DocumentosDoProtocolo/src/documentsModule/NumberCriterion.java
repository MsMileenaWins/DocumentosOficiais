package documentsModule;

/**
 * this class represents the number of a document as a criterion for filtering
 *
 */
public class NumberCriterion implements Filtering{
	
private String numero;
	
	public NumberCriterion(String numero) {
		this.numero = numero;
	}
	@Override
	public boolean testDocument(Document doc) {
		
		if( this.numero.contentEquals(doc.getNumber()) )
			return true;
		else
			return false;
	}

}
