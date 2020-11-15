package documentsModule;



/**
 * this class represents the destination of a document as a criterion for filtering
 *
 */
public class DestinationCriterion implements Filtering{
	
	private String destination;
	
	public DestinationCriterion(String destination) {
		
		this.destination = destination;
	}

	@Override
	public boolean testDocument(Document doc) {
		
		if(this.destination.contentEquals(doc.getDestination()))
			return true;
		else
			return false;
	}

}
