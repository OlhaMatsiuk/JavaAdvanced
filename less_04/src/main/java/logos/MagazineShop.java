package logos;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import logos.basic.Magazine;
import logos.dao.MagazineDao;
import logos.basic.User;
import logos.dao.UserDao;
import logos.basic.Subscribers;
import logos.dao.SubscribersDao;
import logos.service.ConnectionUtils;

public class MagazineShop {
	
	private static Logger LOG = Logger.getLogger(MagazineShop.class);	
	
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		DOMConfigurator.configure("loggerConfiguration.xml");	

		// TABLE MAGAZINE ------------------------------------------------
		MagazineDao magazineDao = new MagazineDao(ConnectionUtils.openConnection());
	
		System.out.println("************************************************\n");
		
		List<Magazine> listOfMagazine = new ArrayList<>();
	
		String title = " vinci";
		
		if(title == "Da vinci") 
			listOfMagazine.add(new Magazine(title, "science", 120.00, LocalDate.parse("2019-01-01")));
		else LOG.error("title not found");
		
		
		listOfMagazine.add(new Magazine("Science", "science", 100.50, LocalDate.parse("2019-03-01")));
		listOfMagazine.add(new Magazine("Love", "beauty", 230.60, LocalDate.parse("2018-12-01")));
		listOfMagazine.add(new Magazine("Do-do", "natural", 10.00, LocalDate.parse("2008-10-11")));

		// INSERT
		listOfMagazine.forEach(mag -> {
			try {
				magazineDao.insert(mag);
			} catch (SQLException e) {
				LOG.error("Erorr SQLException");
				e.printStackTrace();
			}
		});

		// READ-ALL
		magazineDao.readAll().forEach(System.out::print);
		System.out.println("************************************************\n");

		// READ-ById
		Magazine magazineFromId = magazineDao.read(1);
		System.out.println(magazineFromId);
		System.out.println("************************************************\n");

		// UPDATE-ById
		Magazine magazineUpdate = magazineDao.read(2);
		magazineUpdate.setPrice(111.11);
		magazineDao.updateById(magazineUpdate.getId(), magazineUpdate);

		// READ-ALL
		magazineDao.readAll().forEach(System.out::print);
		System.out.println("************************************************\n");

		// DELETE
		magazineDao.delete(3);

		// READ-ALL
		magazineDao.readAll().forEach(System.out::print);
		System.out.println("************************************************\n");


/*		// TABLE USER ------------------------------------------------
		UserDao userDao = new UserDao(ConnectionUtils.openConnection());

		List<User> listOfUser = new ArrayList<>();
		listOfUser.add(new User("Olha", "Matsiuk", "o.zakharchuk@gmail.com", "pppp"));
		listOfUser.add(new User("Bohdan", "Matsiuk", "matsiuk@gmail.com", "qqqq"));
		listOfUser.add(new User("Natali", "Sinitivich", "sinit@gmail.com", "hhhh"));

		// INSERT
		listOfUser.forEach(mag -> {
			try {
				userDao.insert(mag);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// READ-ALL
		userDao.readAll().forEach(System.out::print);
		System.out.println("************************************************\n");

		// READ-ById
		User userFromId = userDao.read(1);
		System.out.println(userFromId);
		System.out.println("************************************************\n");

		// UPDATE-ById
		User userUpdate = userDao.read(2);
		userUpdate.setFirst_name("Vika");
		userDao.updateById(userUpdate.getId(), userUpdate);

		// READ-ALL
		userDao.readAll().forEach(System.out::print);
		System.out.println("************************************************\n");

		// DELETE
		userDao.delete(3);

		// READ-ALL
		userDao.readAll().forEach(System.out::print);
		System.out.println("************************************************\n");

*/
		
/*  	// TABLE Subscribers ------------------------------------------------
		SubscribersDao subscribersDao = new SubscribersDao(ConnectionUtils.openConnection());

		List<Subscribers> listOfSubscribers = new ArrayList<>();
		listOfSubscribers.add(new Subscribers(1, 2, false, LocalDate.parse("2008-12-01"), 31));
		listOfSubscribers.add(new Subscribers(2, 2, true, LocalDate.parse("2019-10-12"), 66));
		listOfSubscribers.add(new Subscribers(2, 1, true, LocalDate.parse("2020-09-30"), 77));
		listOfSubscribers.add(new Subscribers(1, 1, true, LocalDate.parse("2000-01-05"), 88));

		// INSERT
		listOfSubscribers.forEach(mag -> {
			try {
				subscribersDao.insert(mag);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		// READ-ALL
		subscribersDao.readAll().forEach(System.out::print);
		System.out.println("************************************************\n");

		// READ-ById
		Subscribers subscribersFromId = subscribersDao.read(1);
		System.out.println(subscribersFromId);
		System.out.println("************************************************\n");

		// UPDATE-ById
		Subscribers subscriberUpdate = subscribersDao.read(2);
		subscriberUpdate.setDuration(40);
		subscribersDao.updateById(subscriberUpdate.getId(), subscriberUpdate);

		// READ-ALL
		subscribersDao.readAll().forEach(System.out::print);
		System.out.println("************************************************\n");

		// DELETE
		subscribersDao.delete(3);

		// READ-ALL
		subscribersDao.readAll().forEach(System.out::print);
		System.out.println("************************************************\n");
*/

	}
}
