package logos.many_to_one;

import java.util.HashSet;
import java.util.Set;

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
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Post post = new Post();
		post.setTitle("MyApple");
		
		Comment comment1 = new Comment();
		comment1.setAuthorName("Olha");
		comment1.setPost(post);
		
		Comment comment2 = new Comment();
		comment1.setAuthorName("Bohdan");
		comment1.setPost(post);
		
		Comment comment3 = new Comment();
		comment1.setAuthorName("Vika");
		comment1.setPost(post);
		
		Set<Comment> comments = new HashSet<>();
		comments.add(comment1);
		comments.add(comment2);
		comments.add(comment3);
		
		post.setComments(comments);
		
		session.save(post);
		
		transaction.commit();
		session.close();
		
		
		
	}
}
