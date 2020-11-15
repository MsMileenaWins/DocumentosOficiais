package graphicInterfaceModule;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import javax.swing.*;

import org.jdatepicker.DatePicker;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilCalendarModel;

import documentsModule.SubjectCriterion;
import documentsModule.DateCriterion;
import documentsModule.DestinationCriterion;
import documentsModule.NumberCriterion;
import documentsModule.OriginCriterion;
import documentsModule.Document;
import documentsModule.DocumentUtils;
import documentsModule.Filtering;
import documentsModule.TYPE;
import recorderModule.DocumentsRecorder;  
  
/**
 * this class represents the entire graphical interface accessed by the user
 *
 */

public class MyGui extends JFrame{  
	
		
	

	private JPanel panel;
	private JPanel labelPanel;
	private JPanel textFieldPanel;
	private JPanel buttonPanel;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JComboBox<String> comboBox;
	private DatePicker datePicker;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JList<String> list;
	private JPanel listPanel;
	private JScrollPane scrollPane;
	private JButton saveBtn;
	private JButton deleteBtn;
	private JButton restoreBtn;
	private JPanel filterByPanel;
	private JRadioButton filterByDate;
	private JRadioButton filterByNumber;
	private JRadioButton filterBySubject;
	private JRadioButton filterByOrigin;
	private JRadioButton filterByDestination;
	private ButtonGroup filterBybtnGroup;
	private JButton filterByBtn;
	private DocumentsRecorder recorder;
	private TYPE type = TYPE.OFICIO;
	private int realListIndex[];
	
	public static void main(String[] args) {  
		new MyGui();  
		
		}  
	
		public MyGui(){
			
		super("Documentos do Protocolo");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenDim=tk.getScreenSize();
		Dimension frameDim = new Dimension(screenDim.width,screenDim.height/2);
	
		this.setSize(frameDim);
		
		String[] comboBoxItems = {"Ofício","Memo","Resolução"};
		comboBox= new JComboBox<String>(comboBoxItems);
		
		ListenForComboBox comboBoxListener = new ListenForComboBox();
		comboBox.addActionListener(comboBoxListener);
		
		label1 = new JLabel("Tipo:"); 
		label2 = new JLabel("Data:");
		label3 = new JLabel("Número:");
		label4 = new JLabel("Assunto:");
		label5 = new JLabel("Origem:");
		label6 = new JLabel("Destino:");
		 
		datePicker= new JDatePicker();
		datePicker.setTextEditable(true);
	    datePicker.setShowYearButtons(true);
		 
		textField2 = new JTextField();	
		textField3 = new JTextField();		 
		textField4 = new JTextField();		
		textField5 = new JTextField();
		 
		list = new JList<>();
		updateList();
		 
		scrollPane = new JScrollPane(list);
		 
		listPanel= new JPanel();
		listPanel.setLayout(new GridLayout(1,1));
		listPanel.add(scrollPane);
	    
	      
	    labelPanel = new JPanel();
	    labelPanel.setLayout(new GridLayout(1,6));
	   
	    labelPanel.add(label1);
	    labelPanel.add(label2);
	    labelPanel.add(label3);
	    labelPanel.add(label4);
	    labelPanel.add(label5);
	    labelPanel.add(label6);
	    
	    textFieldPanel= new JPanel();
	    textFieldPanel.setLayout(new GridLayout(1,6));
	    textFieldPanel.add(comboBox);
	    textFieldPanel.add((JComponent) datePicker);
	    textFieldPanel.add(textField2);
	    textFieldPanel.add(textField3);
	    textFieldPanel.add(textField4);
	    textFieldPanel.add(textField5);
	  
	  
		 saveBtn = new JButton("cadastrar");
		 ListenForSaveBtn saveBtnListener= new ListenForSaveBtn();
		 saveBtn.addActionListener(saveBtnListener);
		 
		 deleteBtn= new JButton("deletar");
		 ListenForDeleteBtn deleteBtnListener= new ListenForDeleteBtn();
		 deleteBtn.addActionListener(deleteBtnListener);
		 
		 restoreBtn = new JButton("ver tudo");
		 ListenForRestoreBtn restoreBtnListener = new ListenForRestoreBtn();
		 restoreBtn.addActionListener(restoreBtnListener);
	    
		 buttonPanel= new JPanel();
	     buttonPanel.add(saveBtn);
	     buttonPanel.add(deleteBtn);
	     buttonPanel.add(restoreBtn);
	     
	 	 filterByPanel = new JPanel();
	 	 filterByPanel.setBorder(BorderFactory.createTitledBorder("Filtrar por:"));
		 filterByDate = new JRadioButton("Data");
		 filterByDate.setActionCommand("Data");
		 filterByNumber = new JRadioButton("Número");
		 filterByNumber.setActionCommand("Número");
		 filterBySubject = new JRadioButton("Assunto");
		 filterBySubject.setActionCommand("Assunto");
		 filterByOrigin = new JRadioButton("Origem");
		 filterByOrigin.setActionCommand("Origem");
		 filterByDestination = new JRadioButton("Destino");
		 filterByDestination.setActionCommand("Destino");
		 filterBybtnGroup = new ButtonGroup();
		 
		 filterBybtnGroup.add(filterByDate);
		 filterBybtnGroup.add(filterByNumber);
		 filterBybtnGroup.add(filterBySubject);
		 filterBybtnGroup.add(filterByOrigin);
		 filterBybtnGroup.add(filterByDestination);
		 
		 filterByPanel.add(filterByDate);
		 filterByPanel.add(filterByNumber);
		 filterByPanel.add(filterBySubject);
		 filterByPanel.add(filterByOrigin);
		 filterByPanel.add(filterByDestination);
	    
		 filterByBtn= new JButton("filtrar");
		 ListenForFilterByBtn filterByBtnListener= new ListenForFilterByBtn();
		 filterByBtn.addActionListener(filterByBtnListener);
		 
		 filterByPanel.add(filterByBtn);
		 
		 buttonPanel.add(filterByPanel);
	     
	    
	    panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
	    panel.add(labelPanel);
	    panel.add(textFieldPanel);
	    panel.add(listPanel);
	    panel.add(buttonPanel);
	    
	    
	   
	    this.add(panel);
	    this.setResizable(true);
		this.setVisible(true);
		
		
	}

		private class ListenForSaveBtn implements ActionListener{

				@Override
				public void actionPerformed(ActionEvent e) {
					
					if (emptyFields()) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
					

					}
					else {
						Document document = createDocument();
						recorder.saveDocument(document);
						
						updateList();
					}
						
					
					
				}	
				private boolean emptyFields() {

					UtilCalendarModel dateField =  (UtilCalendarModel) datePicker.getModel();
					boolean textField2Empty = textField2.getText().trim().isEmpty();
					boolean textField3Empty = textField3.getText().trim().isEmpty();
					boolean textField4Empty = textField4.getText().trim().isEmpty();
					boolean textField5Empty = textField5.getText().trim().isEmpty();
					if( (!dateField.isSelected())||(textField2Empty)||(textField3Empty)|| (textField4Empty)||(textField5Empty))
						return true;
					else
						return false;					
				}
				
				private Document createDocument() {

					TYPE type;
					switch(comboBox.getSelectedIndex()) {
					
					case 0: 
						type= TYPE.OFICIO;
						break;
					case 1:
						type= TYPE.MEMO;
						break;
					case 2:
						type= TYPE.RESOLUCAO;
						break;
					default:
						type= TYPE.OFICIO;
					}
					
					LocalDate date = getDatePickerDate();						
					String textField2Str = textField2.getText().trim();
					String textField3Str = textField3.getText().trim();
					String textField4Str = textField4.getText().trim();
					String textField5Str = textField5.getText().trim();
					Document document= new Document(type,date,textField2Str,textField3Str,textField4Str,textField5Str); 
					return document;
				}			
			}
			
			
		
			
			private class ListenForDeleteBtn implements ActionListener{

				@Override
				public void actionPerformed(ActionEvent e) {
									
					int apparentIndex = list.getSelectedIndex();
					if(apparentIndex < 0)
						return; // nothing is selected
					int realIndex = realListIndex[apparentIndex];
					
					DefaultListModel<String> listModel = (DefaultListModel<String>) list.getModel();					
					listModel.remove(apparentIndex);
					list.setModel(listModel);
					
					ArrayList<Document> documents = recorder.readDocuments(type);
					documents.remove(realIndex); 
					recorder.recordDocuments(type,documents);					
				}
			}

			private class ListenForRestoreBtn implements ActionListener{

				@Override
				public void actionPerformed(ActionEvent e) {

					updateList();
				}

			}
			
			private class ListenForFilterByBtn implements ActionListener{

				@Override
				public void actionPerformed(ActionEvent e) {
					
					String radioSelection =filterBybtnGroup.getSelection().getActionCommand();
					ArrayList<Document> documents = recorder.readDocuments(type);
					Filtering criterion = null;
					
					switch(radioSelection) {
					
					case "Data":
						LocalDate date = getDatePickerDate();
						if(date != null) {                 																			
							 criterion = new DateCriterion(date);																				
							}
						break;
												
					case "Número":
						String textField2Str = textField2.getText().trim();
											
						if(textField2Str!= null) {
							criterion = new NumberCriterion(textField2Str);
						}
						break;
					case "Assunto":
						
						String textField3Str = textField3.getText().trim();
						
						if(textField3Str!= null) {							
							 criterion = new SubjectCriterion(textField3Str);						
						}
						break;
						
					case "Origem":
						String textField4Str = textField4.getText().trim();
										
						if(textField4Str!= null) {
							criterion = new OriginCriterion(textField4Str);	
						}
						
					case "Destino":
						String textField5Str = textField5.getText();
						
						if(textField5Str!= null) {
							criterion = new DestinationCriterion(textField5Str);
					
						}				
						break;
					
					}					
					
					HashMap<Integer,Document> filteredDocuments = DocumentUtils.filter(criterion, documents);
					
					Set<Integer> keys = filteredDocuments.keySet();
					
					int[] array = new int[keys.size()];
					int index = 0;
					for(Integer i : keys)
						array[index++] = i.intValue();
					realListIndex = array;
					
					Collection<Document> collection = (Collection<Document>)filteredDocuments.values();
					ArrayList<Document> filteredDocumentsAL = new ArrayList<Document>(collection); 
					DefaultListModel<String> defListModel = DocumentUtils.toDefListModel(filteredDocumentsAL);
					
					updateList(defListModel);					
				
				}

			}
			
			private class ListenForComboBox implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					int selectedType =  comboBox.getSelectedIndex();
					
					switch(selectedType) {
					
					case 0:
						type = TYPE.OFICIO;
						break;
						
					case 1:
						type = TYPE.MEMO;
						break;
						
					case 2:
						type = TYPE.RESOLUCAO;
						
					}
					
					updateList();
					
				}
			
			}
			
			private void updateList() {
				
				DefaultListModel<String> defListModel = getDocListFromFile();
				list.setModel(defListModel);
			}


			private void updateList(DefaultListModel<String> defListModel) {

				list.setModel(defListModel);
			}

			private LocalDate getDatePickerDate() {
				
				UtilCalendarModel model =  (UtilCalendarModel) datePicker.getModel();
				int day = model.getDay();
				int month = model.getMonth();
				int year = model.getYear();
				
				String dayStr = (day < 10 ? "0"+day : ""+day );
				String monthStr = (month < 10 ? "0"+month : ""+month );
				String dataStr = dayStr+"/"+monthStr+"/"+year;
				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate data = LocalDate.parse(dataStr, formatador);
				return data;
			}

			private DefaultListModel<String> getDocListFromFile() {
			
				recorder = new DocumentsRecorder();
				ArrayList<Document> documents = recorder.readDocuments(this.type);
				realListIndex = getStandardIndexArray(documents.size());
				DefaultListModel<String> defListModel = DocumentUtils.toDefListModel(documents);
				return defListModel;
			}

			private int[] getStandardIndexArray(int length) {

				int array[]= new int [length];
				
				for(int i =0; i<length; ++i) {
					array[i]=i;
				}
				return array;
			}
		
	


}

