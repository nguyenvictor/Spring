package com.demo.service;

import com.demo.dto.StudentDTO;
import com.demo.entity.Student;
import com.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getSpecificStudentId(Integer studentId){
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            return student.get();
        }
        else{
            throw new NullPointerException();
        }

    }
    public List<Student> getAllStudentId(){
        List<Student> listOfStudent = studentRepository.findAll();

        return listOfStudent;
    }

    public String addStudent(Student student){
        Student student1 = student;
        studentRepository.save(student1);
        return "Student with id: " + student.getStudentId()+ " added successfully";
    }

    public String deleteStudent(Integer studentId){

            studentRepository.deleteById(studentId);
            return "Student with id: " + studentId + " deleted successfully";
    }

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
}
