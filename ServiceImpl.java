package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.serviceinterface.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getStudent() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		return student.orElse(null);
	}

	public Student getStudentByName(String name) {
		Student student = studentRepository.findByName(name);
		return student;
	}

	public Student postStudent(Student student) {
		Student s = studentRepository.save(student);
		return s;
	}

	public String deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
		return "Delete Success";
	}

	public String updateStudentById(Integer id, Student updatingStudent) {
		//get the record from DB
		Optional<Student> existingStudent = studentRepository.findById(id);

		if(existingStudent.isPresent()) {

			//modify in appstudentRepository layer
			Student student = existingStudent.get();
			student.setName(updatingStudent.getName());

			//save the updated record
			studentRepository.save(student);

			return "Update success";
		}
		else {
			return "record not found";
		}
	}


}
