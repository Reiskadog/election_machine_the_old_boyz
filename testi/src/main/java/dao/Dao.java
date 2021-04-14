package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.ListedData;

public class Dao {

	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ArrayList<ListedData> readAllQuestionData() {
		ArrayList<ListedData> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from questions");
			while (RS.next()){
				ListedData f=new ListedData();
				f.setId(RS.getInt("question_id"));
				f.setData(RS.getString("question"));
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<ListedData> readAllElecteeData() {
		ArrayList<ListedData> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from electees");
			while (RS.next()){
				ListedData f=new ListedData();
				f.setId(RS.getInt("electee_id"));
				f.setfName(RS.getString("first_name"));
				f.setlName(RS.getString("last_name"));
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public ListedData readElectee(String id) {
		ListedData f=null;
		try {
			String sql="select * from electees where electee_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new ListedData();
				f.setId(RS.getInt("electee_id"));
				f.setfName(RS.getString("first_name"));
				f.setlName(RS.getString("last_name"));
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public void AddTableData(int id, String question) {
			String sql = "INSERT INTO questions (question_id, question) VALUES (?, ?)";
			try {
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1, id); // Now indexing start from 1 !!!! (Remember ID also)
				statement.setString(2, question);
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("A new user was inserted successfully!");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	
	public void AddElecteeTableData(int id, String fName, String lName) {
		String sql = "INSERT INTO electees (electee_id, first_name, last_name) VALUES (?, ?, ?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id); // Now indexing start from 1 !!!! (Remember ID also)
			statement.setString(2, fName);
			statement.setString(3, lName);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<ListedData> deleteQuestionData(String id) {
		try {
			String sql="delete from questions where question_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllQuestionData();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<ListedData> deleteElecteeData(String id) {
		try {
			String sql="delete from electees where electee_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllElecteeData();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<ListedData> updateElectee(ListedData f) {
		try {
			String sql="update electees set first_name=?, last_name=? where electee_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getfName());
			pstmt.setString(2, f.getlName());
			pstmt.setInt(3, f.getId());
			pstmt.executeUpdate();
			return readAllQuestionData();
		}
		catch(SQLException e) {
			return null;
		}
	}
}



