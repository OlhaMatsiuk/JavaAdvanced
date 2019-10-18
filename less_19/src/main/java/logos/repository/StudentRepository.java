package logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import logos.domain.Student;

public interface StudentRepository extends JpaRepository<Student, String>, 
											CrudRepository<Student, String> {
}
