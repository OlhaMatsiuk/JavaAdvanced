package ua.lviv.lgs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import ua.lviv.lgs.basic.Magazine;

public class MagazineDao {

	private static String READ_ALL = "select * from magazine";
	private static String CREATE = "insert into magazine(`title`, `category`, `price`, `publish_date`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from magazine where id =?";
	private static String UPDATE_BY_ID = "update magazine set title=?, category=?, price=?, publish_date=? where id = ?";
	private static String DELETE_BY_ID = "delete from magazine where id=?";
	
	private static Logger LOG = Logger.getLogger(MagazineDao.class);	


	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public MagazineDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Magazine magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
		preparedStatement.setString(1, magazine.getTitle());
		preparedStatement.setString(2, magazine.getCategory());
		preparedStatement.setDouble(3, magazine.getPrice());
		preparedStatement.setDate(4, Date.valueOf(magazine.getPublish_date()));
		preparedStatement.executeUpdate();
		LOG.info("Insert was succesfully!");
	}

	public Magazine read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return Magazine.map(result);
	}

	public void updateById(int id, Magazine magazine) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, magazine.getTitle());
		preparedStatement.setString(2, magazine.getCategory());
		preparedStatement.setDouble(3, magazine.getPrice());
		preparedStatement.setDate(4, Date.valueOf(magazine.getPublish_date()));
		preparedStatement.setInt(5, id);
		preparedStatement.executeUpdate();
		LOG.info("Update by id was succesfully!");
	}

	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		LOG.info("Delete was succesfully!");
	}
	
	public List<Magazine> readAll() throws SQLException {
		List<Magazine> listOfMagazine = new ArrayList<>();
		preparedStatement = connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfMagazine.add(Magazine.map(result));
		}
		return listOfMagazine;
	}
	
}
