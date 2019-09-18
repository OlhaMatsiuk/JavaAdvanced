package logos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logos.basic.Magazine;
import logos.basic.Subscribers;
import logos.basic.User;

public class UserDao {

	private static String READ_ALL = "select * from user";
	private static String CREATE = "insert into user(`first_name`, `last_name`, `email`, `password`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from user where id =?";
	private static String UPDATE_BY_ID = "update user set first_name=?, last_name=?, email=?, password=? where id = ?";
	private static String DELETE_BY_ID = "delete from user where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public UserDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(User user) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, user.getFirst_name());
		preparedStatement.setString(2, user.getLast_name());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.executeUpdate();
	}

	public User read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return User.map(result);
	}

	public void updateById(int id, User user) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, user.getFirst_name());
		preparedStatement.setString(2, user.getLast_name());
		preparedStatement.setString(3, user.getEmail());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setInt(5, id);
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
	
	public List<User> readAll() throws SQLException {
		List<User> listOfUser = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfUser.add(User.map(result));
		}
		return listOfUser;
	}
	
}
