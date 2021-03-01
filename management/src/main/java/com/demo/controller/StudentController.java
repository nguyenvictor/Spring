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

    @GetMapping("/{userId}")
    ResponseEntity<Student> getSpecificStudentId(@PathVariable("userId") Integer userId){
        Student response = studentService.getSpecificStudentId(userId);

//        Student student = new Student(1234,"h","g");
        return new ResponseEntity<>(response, HttpStatus.OK);
//        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping()
    ResponseEntity<List<Student>> getAllStudentId(){
        List<Student> response = studentService.getAllStudentId();
        return new ResponseEntity<List<Student>>(response,HttpStatus.OK);
    }

    @PostMapping(value = "/add", consumes="application/json")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        System.out.println("student has been added");
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("userId") Integer userId){
        String response = studentService.deleteStudent(userId);
        System.out.println("Student has been deleted");
        return ResponseEntity.ok(response);
    }

    @PutMapping()
    public ResponseEntity<String> editStudent(Student student){
        String response = studentService.editStudent(student);
        System.out.println("Student has been edited");
        return ResponseEntity.ok(response);
    }
}
