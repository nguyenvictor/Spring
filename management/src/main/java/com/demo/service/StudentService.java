package com.demo.service;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;
import com.demo.repository.StudentRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @HystrixCommand(fallbackMethod = "getStudentFallback")
    public Student getSpecificStudentId(Integer studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            return student.get();
        }
        else{
            throw new NullPointerException();
        }

    }

    public Student getStudentFallback(Integer studentId){
        return new Student();
    }

    @HystrixCommand(fallbackMethod = "getAllStudentFallback")
    public List<Student> getAllStudentId(){
        List<Student> listOfStudent = studentRepository.findAll();

        return listOfStudent;
    }

    public List<Student> getAllStudentFallback(){
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "addStudentFallback")
    public String addStudent(Student student){
        Student student1 = student;
        studentRepository.save(student1);
        return "Student with id: " + student.getStudentId()+ " added successfully";
    }

    public String addStudentFallback(Student student){
        return "Fallback: Student has not been added";
    }

    @HystrixCommand(fallbackMethod = "deleteStudentFallback")
    public String deleteStudent(Integer studentId){

            studentRepository.deleteById(studentId);
            return "Student with id: " + studentId + " deleted successfully";
    }

    public String delteStudentFallback(Integer studentId){
        return "Fallbackmethod: Student has not been deleted";
    }

    @HystrixCommand(fallbackMethod = "editStudentFallback")
    public String editStudent(Student student){

        Optional<Student> studentChange = studentRepository.findById(student.getStudentId());
        if(studentChange.isPresent()){
            studentRepository.save(studentChange.get());
            return "Student with id: " + student.getStudentId() + " changed successfully";
        }
        else{
            throw new NullPointerException();
        }
    }

    public String editStudentFallback(){
        return "Fallbackmethod: Student has not been edited";
    }
}
