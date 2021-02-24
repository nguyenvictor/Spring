package com.demo.controller;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    ResponseEntity<Student> getSpecificStudentId(@PathVariable("id") Integer studentId){
        Student response = studentService.getSpecificStudentId(studentId);
        return new ResponseEntity<Student>(response, HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity<List<Student>> getAllStudentId(){
        List<Student> response = studentService.getAllStudentId();
        return new ResponseEntity<List<Student>>(response,HttpStatus.OK);
    }

    @PostMapping()
    void addStudent(StudentDTO student){
        studentService.addStudent(student);

    }

    @DeleteMapping()
    void deleteStudent(Integer studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping()
    void editStudent(Student student){
        studentService.editStudent(student);
    }
}
