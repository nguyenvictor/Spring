package com.demo.dto;

import com.demo.entity.Student;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDTO {

    @NotNull(message = "UserId must not be blank.")
    @Size(min = 4, max = 15, message = "UserId must be between 4 to 15 Characters.")
    private Integer userId;

    @NotNull(message = "First name must not be blank.")
    private String firstName;

    @NotNull(message = "Last name must not be blank.")
    private String lastName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Student createEntity(){
        Student stud = new Student();
        stud.setStudentId(this.getUserId());
        stud.setFirstName(this.getFirstName());
        stud.setLastName(this.getLastName());
        return stud;
    }
}
