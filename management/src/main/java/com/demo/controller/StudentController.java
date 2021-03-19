package com.demo.controller;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;
import com.demo.service.StudentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StudentService studentService;


    @GetMapping("/{userId}")
    ResponseEntity<Student> getSpecificStudentId(@PathVariable("userId") Integer userId){
        Student response = studentService.getSpecificStudentId(userId);

//        Student student = new Student(1234,"h","g");
        logger.info("Getting a student");
        return new ResponseEntity<>(response, HttpStatus.OK);
//        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity<List<Student>> getAllStudentId(){
        logger.info("Getting all student");
        List<Student> response = studentService.getAllStudentId();
        return new ResponseEntity<List<Student>>(response,HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes="application/json")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student response = studentService.addStudent(student);
        logger.info("Student has been added");
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteStudent(@PathVariable("userId") Integer userId){
        studentService.deleteStudent(userId);
        logger.info("Student has been deleted");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> editStudent(@RequestBody Student student){
        Student response = studentService.editStudent(student);
        logger.info("Student has been changed");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
