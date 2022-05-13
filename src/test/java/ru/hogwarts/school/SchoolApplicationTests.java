package ru.hogwarts.school;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import ru.hogwarts.school.controller.StudentController;
import ru.hogwarts.school.model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private StudentController studentController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetStudent() throws Exception {
		Assertions
				.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class))
				.isNotNull();
	}

	@Test
	public void testPostStudent() throws Exception {
		Student student = new Student();
		student.setId(7L);
		student.setName("BobTest");
		student.setAge(99);

		Assertions
				.assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/student", student, String.class))
				.isNotNull();
	}

	@Test
	public void testUpdateStudent() throws Exception {
		Student newStudent = new Student();
		newStudent.setId(7L);
		newStudent.setName("BobTest1");
		newStudent.setAge(100);

		Assertions
				.assertThat(this.restTemplate.put("http://localhost:" + port + "/student", newStudent, String.class))
				.isNotNull();
	}

	@Test
	public void testRemoveStudent() throws Exception {
		Student newStudent = new Student();
		newStudent.setId(7L);
		newStudent.setName("BobTest1");
		newStudent.setAge(100);

		Assertions
				.assertThat(this.restTemplate.delete("http://localhost:" + port + "/student" + newStudent.getId()))
				.isNull();
	}
}
