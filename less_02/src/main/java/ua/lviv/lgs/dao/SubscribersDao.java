package ua.lviv.lgs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ua.lviv.lgs.basic.Subscribers;

public class SubscribersDao {

	private static String READ_ALL = "select * from subscribers";
	private static String CREATE = "insert into subscribers(`user_id`, `magazine_id`, `status`, `start`, `duration`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from subscribers where id =?";
	private static String UPDATE_BY_ID = "update subscribers set user_id=?, magazine_id=?, status=?, start=?, duration=? where id = ?";
	private static String DELETE_BY_ID = "delete from subscribers where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public SubscribersDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Subscribers subscribers) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setInt(1, subscribers.getUser_id());
		preparedStatement.setInt(2, subscribers.getMagazine_id());
		preparedStatement.setBoolean(3, subscribers.isStatus());
		preparedStatement.setDate(4, Date.valueOf(subscribers.getStart()));
		preparedStatement.setInt(5, subscribers.getDuration());
		preparedStatement.executeUpdate();
	}

	public Subscribers read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return Subscribers.map(result);
	}

	public void updateById(int id, Subscribers subscribers) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setInt(1, subscribers.getUser_id());
		preparedStatement.setInt(2, subscribers.getMagazine_id());
		preparedStatement.setBoolean(3, subscribers.isStatus());
		preparedStatement.setDate(4, Date.valueOf(subscribers.getStart()));
		preparedStatement.setInt(5, subscribers.getDuration());
		preparedStatement.setInt(6, id);
		preparedStatement.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
	}
	
	public List<Subscribers> readAll() throws SQLException {
		List<Subscribers> listOfSubscribers = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfSubscribers.add(Subscribers.map(result));
		}
		return listOfSubscribers;
	}
	
}
