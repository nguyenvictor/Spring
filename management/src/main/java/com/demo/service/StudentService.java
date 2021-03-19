package com.demo.service;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;
import com.demo.exception.StudentNotFoundException;
import com.demo.repository.StudentRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
//        Optional<Student> student = studentRepository.findById(studentId);
//        if(student.isPresent()){
//            return student.get();
//        }
//        else{
//            throw new NullPointerException();
//        }
        return studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException("Student not found by id:" + studentId));
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
    public Student addStudent(Student student){
        Student student1 = student;
        return studentRepository.save(student1);
    }

    public Student addStudentFallback(Student student){
        return new Student();
    }

//    @HystrixCommand(fallbackMethod = "deleteStudentFallback")
    public void deleteStudent(Integer studentId){

            studentRepository.deleteById(studentId);
    }

//    public String deleteStudentFallback(Integer studentId){
//        return "Fallbackmethod: Student has not been deleted";
//    }

//    @HystrixCommand(fallbackMethod = "editStudentFallback")
    public Student editStudent(Student student){
        Optional<Student> updateStudent = studentRepository.findById(student.getStudentId());
        if(updateStudent.isPresent()){
            Student s = updateStudent.get();
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setEmail(student.getEmail());
            s.setPhoneNo(student.getPhoneNo());
            studentRepository.save(s);
            return s;
        }
        else {
            throw new StudentNotFoundException("No student with ID");
        }

    }

//    public Student editStudentFallback(Student student){
//        return new Student();
//    }
}
