package logos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import logos.dao.MagazineDao;
import logos.domain.Magazine;
import logos.utils.ConnectionUtils;

public class MagazineDaoImpl implements MagazineDao{

	private static String READ_ALL = "select * from magazine";
	private static String CREATE = "insert into magazine(`title`, `category`, `price`, `publish_date`) values (?,?,?,?)";
	private static String READ_BY_ID = "select * from magazine where id =?";
	private static String UPDATE_BY_ID = "update magazine set title=?, category=?, price=?, publish_date=? where id = ?";
	private static String DELETE_BY_ID = "delete from magazine where id=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private static Logger LOGGER = Logger.getLogger(MagazineDaoImpl.class);
	
	public MagazineDaoImpl() {
		try {
			this.connection = ConnectionUtils.openConnection();
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}
	
	@Override
	public Magazine create(Magazine magazine) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, magazine.getTitle());
			preparedStatement.setString(2, magazine.getCategory());
			preparedStatement.setDouble(3, magazine.getPrice());
			preparedStatement.setInt(4, magazine.getPublish_date());
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			magazine.setId(rs.getInt(1));
			
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		
		return magazine;
	}

	@Override
	public Magazine read(Integer id) {
		Magazine magazine = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			magazine = Magazine.map(result);

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return magazine;
	}

	@Override
	public Magazine update(Magazine magazine) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, magazine.getTitle());
			preparedStatement.setString(2, magazine.getCategory());
			preparedStatement.setDouble(3, magazine.getPrice());
			preparedStatement.setInt(4, magazine.getPublish_date());
			preparedStatement.setInt(5, magazine.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return magazine;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<Magazine> readAll() {
		List<Magazine> listOfMagazine = new ArrayList<>();
		try{
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfMagazine.add(Magazine.map(result));
			}
		}catch (SQLException e) {
			LOGGER.error(e);
		}
		return listOfMagazine;
	}

}
