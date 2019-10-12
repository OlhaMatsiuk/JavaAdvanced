package logos;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("/META-INF/hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

		Cart cart = new Cart("total", "name1");

		Item total1 = new Item("total1");
		Item total2 = new Item("total2");
		cart.setItems(new HashSet<>(Arrays.asList(total1, total2)));
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.persist(cart);

		transaction.commit();
		session.close();

	}
}
