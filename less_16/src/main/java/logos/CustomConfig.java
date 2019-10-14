package logos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import logos.dao.StudentDao;
import logos.dao.impl.StudentDaoImpl;

@Configuration
public class CustomConfig {

	@Bean(name = "StudentDaoImpl")
	public StudentDao getStudentDaoImpl() {
		return new StudentDaoImpl();	
	}
}
