package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private StudentController studentController;

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private StudentRepository mockRepository;

	@BeforeEach
	public  void init() {
		Student student = new Student("BobTest", 99);
		when(mockRepository.findById(1L)).thenReturn(Optional.of(student));
	}

	@Test
	public void testGetStudent() throws Exception {
		Assertions
				.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class))
				.isNotNull();
	}

	@Test
	public void testPostStudent() throws Exception {
		Student student = new Student();
		when(mockRepository.save(any(Student.class))).thenReturn(student);

		Assertions
				.assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
				.isNotNull();
	}

	@Test
	public void testUpdateStudent() throws Exception {
		Student newStudent = new Student();
		newStudent.setId(7);
		newStudent.setName("BobTest1");
		newStudent.setAge(100);
		HttpEntity<Student> entity = new HttpEntity<>(newStudent, new HttpHeaders());
		when(mockRepository.save(any(Student.class))).thenReturn(newStudent);


		Assertions
				.assertThat(this.restTemplate.exchange("http://localhost:" + port + "/student", HttpMethod.PUT, entity, String.class))
				.isNotNull();
	}

	@Test
	public void testRemoveStudent() throws Exception {
		Student newStudent = new Student();
		newStudent.setId(7);
		newStudent.setName("BobTest1");
		newStudent.setAge(100);
		HttpEntity<Student> entity = new HttpEntity<>(null, new HttpHeaders());
		when(mockRepository.save(any(Student.class))).thenReturn(newStudent);


		Assertions
				.assertThat(this.restTemplate.exchange("http://localhost:" + port + "/student", HttpMethod.DELETE, entity, String.class))
				.isNotNull();
	}


}
