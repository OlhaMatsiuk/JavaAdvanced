package logos.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import logos.domain.Student;
import logos.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/registration")
	public String registration(@RequestParam("photo") MultipartFile file, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("age") int age) throws IOException {

		Student student = new Student(firstName, lastName, age);
		studentService.saveStudent(file, student);

		return "redirect:/cabinet?id=" + student.getId();
	}

	@GetMapping("/cabinet")
	public String cabinet(@RequestParam("id") String id, HttpServletRequest req) throws UnsupportedEncodingException {

		Student student = studentService.findById(id);
		
		byte[] fileBytes = student.getData();
        byte[] fileEncodeBase64 = Base64.encodeBase64(fileBytes);
        String fileBase64Encoded = new String(fileEncodeBase64, "UTF-8");

		req.setAttribute("student", student);
		req.setAttribute("photo", fileBase64Encoded);
		req.setAttribute("mode", "VIEW");

		return "cabinet";
	}

}
