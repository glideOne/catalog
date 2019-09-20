package com.students.catalog.controller;

import com.students.catalog.entity.Student;
import com.students.catalog.exceptions.StudentNotFoundException;
import com.students.catalog.repository.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (!student.isPresent()) {
            throw new StudentNotFoundException("id-" + id);
        }
        return student.get();
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) {
//        studentRepo.deleteById(id);
        if (studentRepo.deleteStudentById(id) == 0) {
            throw new StudentNotFoundException("id-" + id);
        }
    }

}
