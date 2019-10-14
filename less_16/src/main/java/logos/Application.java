package logos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import logos.dao.StudentDao;
import logos.domain.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		StudentDao studentDao = (StudentDao) ctx.getBean("StudentDaoImpl");
		
		Student s1 = new Student(1,"olha",20);
		Student s2 = new Student(2,"olya",19);
		studentDao.create(s1);
		studentDao.create(s2);
	
		System.out.println("=====================");
		System.out.println(studentDao.read(1));
		
		System.out.println("=====================");
		studentDao.readAll().stream().forEach(System.out::println);
		
		Student s3 = new Student(2,"bohdan",19);
		studentDao.update(s3);
		System.out.println("=====================");
		studentDao.readAll().stream().forEach(System.out::println);
		
		studentDao.delete(2);
		System.out.println("=====================");
		studentDao.readAll().stream().forEach(System.out::println);
	}

}
