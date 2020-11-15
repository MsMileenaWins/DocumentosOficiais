package recorderModule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import documentsModule.Document;
import documentsModule.TYPE;


/**
 * @author Carol
 *	a device to read and record DocumentsCollection objects.
 *	uses .bin files to store data.
 */
public class DocumentsRecorder {

	private final String oficiosFile= "oficios.bin";
	private final String memosFile= "memos.bin";
	private final String resolucoesFile= "resolucoes.bin";
	
	
	
	public void recordDocuments(TYPE type, ArrayList<Document> documents){
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		switch(type) {
		case OFICIO:
			 try {
				fos = new FileOutputStream(this.oficiosFile);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
				return;
			}
			break;
		
		case MEMO:
			 try {
				fos = new FileOutputStream(this.memosFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			break;
			
		case RESOLUCAO:
			 try {
				fos = new FileOutputStream(this.resolucoesFile);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			break;
		}
		
		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(documents);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		return;
		
	}

	public ArrayList<Document> readDocuments(TYPE type){
		
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		ArrayList<Document> documents= new ArrayList<Document>();
		
		
		
		switch(type) {
		case OFICIO:
			File file = new File("oficios.bin");
			
						
			try {
				file.createNewFile();
				fis = new FileInputStream(this.oficiosFile);
			} catch (IOException e1) {			
				e1.printStackTrace();
			}
					
			break;
		
		case MEMO:
			File file2 = new File("memos.bin");
			 try {
				  file2.createNewFile();
				  fis = new FileInputStream(this.memosFile);
			 }
			catch (IOException e) {					
					e.printStackTrace();									
				}
			break;
			
		case RESOLUCAO:
			File file3 = new File("resolucoes.bin");
			 try {
				  file3.createNewFile();
				  fis = new FileInputStream(this.resolucoesFile);
				 }
				
			 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
								
				}
			break;
		}
		
			try {
				ois = new ObjectInputStream(fis);
				documents = (ArrayList<Document>) ois.readObject(); // handle problem
				ois.close();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		return documents;
		
	}

	public void saveDocument( Document document ) {
	
		TYPE type = document.getType(); 
	
		ArrayList<Document> documents = readDocuments(type); 
	
		documents.add(document);	
	
		recordDocuments(type,documents); // salva no arquivo
		
}







}
