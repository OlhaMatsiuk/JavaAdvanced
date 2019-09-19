package logos.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logos.dao.SubscriptionsDao;
import logos.domain.Subscriptions;
import logos.utils.ConnectionUtils;

public class SubscriptionsDaoImpl implements SubscriptionsDao{
	
	private static String READ_ALL = "select * from subscriptions";
	private static String CREATE = "insert into subscriptions(`user_id`, `magazine_id`, `status`, `start`, `duration`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from subscriptions where id =?";
	private static String UPDATE_BY_ID = "update subscriptions set user_id=?, magazine_id=?, status=?, start=?, duration=? where id = ?";
	private static String DELETE_BY_ID = "delete from subscriptions where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public SubscriptionsDaoImpl() {
		try {
			this.connection = ConnectionUtils.openConnection();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Subscriptions create(Subscriptions sub) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, sub.getUser_id());
			preparedStatement.setInt(2, sub.getMagazine_id());
			preparedStatement.setBoolean(3, sub.isStatus());
			preparedStatement.setDate(4, new Date(sub.getStart().getTime()));
			preparedStatement.setInt(5, sub.getDuration());
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			sub.setId(rs.getInt(1));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sub;
	}

	@Override
	public Subscriptions read(Integer id) {
		Subscriptions sub = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			sub = Subscriptions.map(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sub;
	}

	@Override
	public Subscriptions update(Subscriptions sub) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setInt(1, sub.getUser_id());
			preparedStatement.setInt(2, sub.getMagazine_id());
			preparedStatement.setBoolean(3, sub.isStatus());
			preparedStatement.setDate(4, new Date(sub.getStart().getTime()));
			preparedStatement.setInt(5, sub.getDuration());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sub;
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
	public List<Subscriptions> readAll() {
		List<Subscriptions> listOfSubscribers = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfSubscribers.add(Subscriptions.map(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfSubscribers;
	}
	
	
}
