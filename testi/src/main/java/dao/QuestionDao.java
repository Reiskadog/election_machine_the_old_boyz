package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import model.QuestionModel;

public class QuestionDao {
	private String jdbcUrl = "jdbc:mysql://localhost3306/webappdb";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Mavluda99";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	private String INSERT_QUERY = "insert into question(question) value(?)";
	private String UPDATE_QUERY = "update questions set question=? where id=?";
	private String DELETE_QUERY = "delete from questions where id=?";
	private String SELECT_QUERY = "select id,question from questions where id=?";
	private String SELECT_ALL_QUERY = "select id,question from questions";

	public QuestionDao() {

	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}

	/**
	 * getQuestionList
	 * 
	 * @return
	 */
	public List<QuestionModel> getQuestions() {
		List<QuestionModel> resList = new ArrayList<QuestionModel>();
		try (Connection con = getConnection();) {
			PreparedStatement statement = con.prepareStatement(SELECT_ALL_QUERY);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String questionRes = rs.getString("question");
				QuestionModel q = new QuestionModel(id, questionRes);
				resList.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resList;
	}

	/**
	 * update question
	 * 
	 * @param q
	 */
	public void update(QuestionModel q) {
		try (Connection con = getConnection();) {
			PreparedStatement statement = con.prepareStatement(UPDATE_QUERY);
			statement.setString(1, q.getQuestion());
			statement.setLong(2, q.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * insert questions
	 * 
	 * @param q
	 */
	public void insert(QuestionModel q) {
		try (Connection con = getConnection();) {
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			statement.setString(1, q.getQuestion());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Long id) {
		try (Connection con = getConnection();) {
			PreparedStatement statement = con.prepareStatement(DELETE_QUERY);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getQuestionById
	 * @param idR
	 * @return
	 */
	public QuestionModel getQuestionById(Long idR) {
		QuestionModel questionBean = new QuestionModel();
		try (Connection con = getConnection();) {
			PreparedStatement statement = con.prepareStatement(SELECT_QUERY);
			statement.setLong(1, idR);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String questionRes = rs.getString("question");
				questionBean = new QuestionModel(id, questionRes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questionBean;
	}
}
