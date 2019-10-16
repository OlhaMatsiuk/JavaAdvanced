package logos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import logos.domain.University;
import logos.service.UniversityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		UniversityService universitySerice = ctx.getBean(UniversityService.class);
		
		
		//create 
		
		University university1 = new University();
		university1.setName("PNU");
		university1.setLevelOfAccreditation(3);
		university1.setNumberOfInstitutes(5);
		university1.setAmounOfStudents(1000);
		university1.setAddress("Ukraine, IF");
		
		University university2 = new University();
		university2.setName("LNU");
		university2.setLevelOfAccreditation(3);
		university2.setNumberOfInstitutes(5);
		university2.setAmounOfStudents(1000);
		university2.setAddress("Ukraine, Lviv");
		
		University university3 = new University();
		university3.setName("ChNU");
		university3.setLevelOfAccreditation(3);
		university3.setNumberOfInstitutes(5);
		university3.setAmounOfStudents(1000);
		university3.setAddress("Ukraine, Chernivtsi");
		
		University university4 = new University();
		university4.setName("KNU");
		university4.setLevelOfAccreditation(3);
		university4.setNumberOfInstitutes(5);
		university4.setAmounOfStudents(1000);
		university4.setAddress("Ukraine, Kyiv");
		
//		universitySerice.save(university1);
//		universitySerice.save(university2);
//		universitySerice.save(university3);
//		universitySerice.save(university4);
		
		
		//read
		
		System.out.println(universitySerice.findById(3));
		
		System.out.println("------------------");
		
		universitySerice.findAll().stream().forEach(System.out::println);
		
		System.out.println("------------------");
		
		universitySerice.findByAddress("Ukraine, IF").stream().forEach(System.out::println);
		
		universitySerice.findByName("KNU").stream().forEach(System.out::println);
		
		
		//update
		
		University unForUpdate = universitySerice.findById(3);
		unForUpdate.setLevelOfAccreditation(10);

		universitySerice.update(unForUpdate);
		
		//delete
		
		universitySerice.deleteById(2);
		
	}
}
