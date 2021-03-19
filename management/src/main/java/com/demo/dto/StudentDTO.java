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

    @NotNull(message = "Email must not be blank.")
    private String email;

    @NotNull(message = "Phone Number must not be blank.")
    private String phoneNo;

    public StudentDTO(@NotNull(message = "UserId must not be blank.") @Size(min = 4, max = 15, message = "UserId must be between 4 to 15 Characters.") Integer userId, @NotNull(message = "First name must not be blank.") String firstName, @NotNull(message = "Last name must not be blank.") String lastName, @NotNull(message = "Email must not be blank.") String email, @NotNull(message = "Phone Number must not be blank.") String phoneNo) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    public Student createEntity(){
        Student stud = new Student();
        stud.setStudentId(this.getUserId());
        stud.setFirstName(this.getFirstName());
        stud.setLastName(this.getLastName());
        stud.setEmail(this.getEmail());
        stud.setPhoneNo(this.getPhoneNo());
        return stud;
    }
}
