package documentsModule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * this class represents a document of a specific type (ofício, memo or resolução)
 * 
 */

public class Document  {

	private int id;
	private TYPE type;
	private LocalDate date;
	private String number;
	private String subject;
	private String origin;
	private String destination;

	/**
	 * Constructs a new document. 
	 *  All attributes except id are passed as arguments ( type, date, number, subject, origin and destination)
	 */	
	
	public Document(TYPE type, LocalDate date, String number, String subject, String origin, String destination){
		this.type = type;
		this.date = date;
		this.number=number;
		this.subject=subject;
		this.origin=origin;
		this.destination=destination;		
	}
	/**
	 * Constructs a new document. 
	 *  All attributes are passed as arguments ( type, date, number, subject, origin and destination)
	 */	
	public Document(int id,TYPE type, LocalDate date, String number, String subject, String origin, String destination){
		
		this.id = id;
		this.type = type;
		this.date = date;
		this.number=number;
		this.subject=subject;
		this.origin=origin;
		this.destination=destination;		
	}

	/**
	 * sets the attribute id
	 *
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * gets the attribute id
	 *
	 */	
	public int getId() {		
		return this.id;
	}
	
	/**
	 * returns the type of the document as an enum TYPE
	 *
	 */
	public TYPE getType() {
		return type;
	}
	
	/**
	 * returns the date when the document was created as LocalDate
	 *
	 */
	
	public LocalDate getDate() {
		return date;
	}

	/**
	 *sets the date of creation of the document from a String that represents the date in the format dd/MM/yyyy
	 *
	 */
	public void setDate(String dateStr) {
		LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.date = date;
	}

	/**
	 * returns the number of the document as a string
	 *
	 */	
	public String getNumber() {
		return number;
	}

	/**
	 * sets the number of the document from a string passed as an argument
	 *
	 */
	public void getNumber(String number) {
		this.number = number;
	}
	
	/**
	 * returns the subject of the document as a string
	 *
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * sets the subject of the document as a string
	 *
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * returns the origin of the document as a string
	 *
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * sets the origin of the document from a string passed as an argument
	 *
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * returns the destinations of the document as a string
	 *
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * sets the destination of the document from a string passed as an argument
	 *
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * returns the string representations of the document's attributes
	 *
	 */
	@Override
	public String toString() {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return String.format("|%20s",type.toString())
		+ " | "
		+ String.format("|%20s",date.format(formatter))
		+ " | "	
		+ String.format("|%20s",number)
		+ " | "
		+ String.format("|%100s",subject)
		+ " | "
		+ String.format("|%20s",origin)
		+ " | "
		+ String.format("|%20s",destination);
	}




	
	
	
	

}
