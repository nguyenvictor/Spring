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

    public void addStudent(StudentDTO student){
        Student stud = student.createEntity();
        studentRepository.save(stud);
    }

    public void deleteStudent(Integer studentId){
            studentRepository.deleteById(studentId);
    }

    public void editStudent(Student student){

        Optional<Student> studentChange = studentRepository.findById(student.getStudentId());
        if(studentChange.isPresent()){
            studentRepository.save(studentChange.get());
        }
        else{
            throw new NullPointerException();
        }
    }
}
