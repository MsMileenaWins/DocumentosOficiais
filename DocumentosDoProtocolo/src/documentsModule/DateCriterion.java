package documentsModule;

import java.time.LocalDate;

/**
 * this class represents the date of creation of a document as a criterion for filtering
 *
 */
public class DateCriterion implements Filtering{

private LocalDate date;
	
	public DateCriterion(LocalDate date) {
		this.date = date;
	}
	@Override
	public boolean testDocument(Document doc) {
		
		if( this.date.compareTo(doc.getDate()) == 0  )
			return true;
		else
			return false;
	}
}
