package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import connectionFactory.ConnectionFactory;
import documentsModule.*;

public class DocumentDAO {

	public void saveDocument(Document doc) {
	
		String table = doc.getType().toString().toLowerCase();
		String sql = "INSERT INTO "+table+"(doc_date,doc_number,doc_subject,doc_origin,doc_destination) VALUES(?,?,?,?,?);";
		Connection con =  null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnectionToMYSQL();
			pstm = (PreparedStatement)con.prepareStatement(sql);
			
			pstm.setDate(1,Date.valueOf(doc.getDate()));
			pstm.setString(2, doc.getNumber());
			pstm.setString(3, doc.getSubject());
			pstm.setString(4, doc.getOrigin());
			pstm.setString(5, doc.getDestination());
			
			pstm.execute();
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				pstm.close();
				con.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		
		}
			
		
	}
	
	
	public List<Document> readDocuments( TYPE type) {
	
		String table = type.toString().toLowerCase();
		String sql = "select * from "+table;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rset =null;
		List<Document> documents = new ArrayList<Document>();
		
		try {
			con = ConnectionFactory.createConnectionToMYSQL();
			pstm = (PreparedStatement) con.prepareStatement(sql);
			rset= pstm.executeQuery();			
			
			while(rset.next()) {				
				Date date = rset.getDate("doc_date");
				String number =rset.getString("doc_number");
				String subject =rset.getString("doc_subject");
				String origin =rset.getString("doc_origin");
				String destination =rset.getString("doc_destination");				
				Document doc = new Document (type,date.toLocalDate(),number,subject,origin,destination);
				documents.add(doc);
			}	
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			try {
				if(con !=null)
					con.close();
				if(pstm!=null) 
					pstm.close();
				if(rset!=null) 
					rset.close();			
			}
			catch(Exception e1) {
				System.err.println(e1.getMessage());
			}
		}
		return documents;			
	}
	
	public void deleteDocument(int id, TYPE type) {
		
		String table = type.toString().toLowerCase();
		String sql = "DELETE FROM "+table+" where id = "+id;
		Connection con =  null;
		PreparedStatement pstm = null;
		
		try {
			con = ConnectionFactory.createConnectionToMYSQL();
			pstm = (PreparedStatement)con.prepareStatement(sql);						
			pstm.execute();					
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			
			try {
				pstm.close();
				con.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		
		}
			
		
	}
	
	
}
