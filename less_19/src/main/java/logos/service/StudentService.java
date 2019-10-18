package logos.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import logos.domain.Student;
import logos.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(MultipartFile file, Student student) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		if (!fileName.contains("..")) {
			student.setFileName(fileName);
			student.setFileType(file.getContentType());
			student.setData(file.getBytes());
		}

		return studentRepository.save(student);
	}

	public Student findById(String id) {
		return studentRepository.getOne(id);
	}
}
