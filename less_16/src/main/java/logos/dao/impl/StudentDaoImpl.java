package logos.dao.impl;

import java.util.ArrayList;
import java.util.List;

import logos.dao.StudentDao;
import logos.domain.Student;

public class StudentDaoImpl implements StudentDao{

	List<Student> students = new ArrayList<>();
	
	@Override
	public Student create(Student t) {
		students.add(t);
		return t;
	}

	@Override
	public Student read(Integer id) {
		return students.get(id-1);
	}

	@Override
	public Student update(Student t) {
		students.set(t.getId()-1, t);
		return t;
	}

	@Override
	public void delete(Integer id) {
		students.remove(id-1);
	}

	@Override
	public List<Student> readAll() {
		return students;
	}

}
