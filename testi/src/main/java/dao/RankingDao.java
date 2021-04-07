package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RankingModel;


public class RankingDao {
	private String jdbcUrl = "jdbc:mysql://localhost3306/webappdb";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Mavluda99";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	private String INSERT_QUERY = "insert into ranking(qusetion_id,rank,time) value(?,?,?)";
	private String UPDATE_QUERY = "update ranking question_id=?,rank=?,time=? where id=?";
	private String DELETE_QUERY = "delete from ranking where id=?";
	private String SELECT_QUERY = "select id,question_id,rank,time from ranking where id=?";
	private String SELECT_ALL_QUERY = "select id,question_id,rank,time from ranking";

	public RankingDao() {

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

	public void insert(RankingModel r) {
		try (Connection con = getConnection();) {
			PreparedStatement statement = con.prepareStatement(INSERT_QUERY);
			statement.setLong(1, r.getQuestionId());
			statement.setInt(2, r.getRank());
			statement.setString(3, r.getTime());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void update(RankingModel r) {
		try (Connection con = getConnection();) {
			PreparedStatement statement = con.prepareStatement(UPDATE_QUERY);
			statement.setLong(1, r.getQuestionId());
			statement.setInt(2, r.getRank());
			statement.setString(3, r.getTime());
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

	public List<RankingModel> getAll() {
		List<RankingModel> resList = new ArrayList<RankingModel>();
		try (Connection connection = getConnection();) {
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("id");
				Long questionId = rs.getLong("question_id");
				Integer arank = rs.getInt("rank");
				String time = rs.getString("time");
				RankingModel r = new RankingModel(id, questionId, arank, time);
				resList.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resList;
	}
	
	public RankingModel getById() {
		RankingModel result = new RankingModel();
		try (Connection connection = getConnection();) {
			PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("id");
				Long questionId = rs.getLong("question_id");
				Integer arank = rs.getInt("rank");
				String time = rs.getString("time");
				result = new RankingModel(id, questionId, arank, time);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
