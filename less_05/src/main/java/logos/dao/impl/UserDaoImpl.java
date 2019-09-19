package logos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logos.dao.UserDao;
import logos.domain.User;
import logos.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao{

	private static String READ_ALL = "select * from user";
	private static String CREATE = "insert into user(`first_name`, `last_name`, `email`, `password`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from user where id =?";
	private static String UPDATE_BY_ID = "update user set first_name=?, last_name=?, email=?, password=? where id = ?";
	private static String DELETE_BY_ID = "delete from user where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public UserDaoImpl() {
		try {
			this.connection = ConnectionUtils.openConnection();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public User create(User user) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getFirst_name());
			preparedStatement.setString(2, user.getLast_name());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			user.setId(rs.getInt(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User read(Integer id) {
		User user = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			user = User.map(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User update(User user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, user.getFirst_name());
			preparedStatement.setString(2, user.getLast_name());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setInt(5, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> readAll() {
		List<User> listOfUser = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfUser.add(User.map(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfUser;
	}

}
