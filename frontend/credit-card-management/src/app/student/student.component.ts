import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {Student} from './student';
import { StudentService } from './student.service';
import {NgForm} from '@angular/forms';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  students : Student[];
  editStudent: Student;
  deleteStudent: Student;
  
  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.getStudentList();
  }

  public getStudentList(): void {
    this.studentService.getStudentList().subscribe(
      (response: Student[])=> {this.students = response},
      (error: HttpErrorResponse)=>{alert(error.message)}

    )
  }

  public onAddStudent(addForm: NgForm): void{
    document.getElementById('add-student-form').click();
    this.studentService.addStudent(addForm.value).subscribe(
      (response: Student) =>{console.log(response);
        this.getStudentList();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateStudent(student: Student): void{
    document.getElementById('edit-student-form').click();
    this.studentService.updateStudent(student).subscribe(
      (response: Student) =>{
        console.log(response);
        this.getStudentList()},
      (error: HttpErrorResponse) => {alert(error.message)
      }
    );
  }

  public onDeleteStudent(studentId: number): void{
    this.studentService.deleteStudent(studentId).subscribe(
      (response: void) =>{
        console.log(response);
        this.getStudentList();},
      (error: HttpErrorResponse) => {alert(error.message)
      }
    );
  }

  public onOpenModal(student: Student, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    if(mode === 'add'){
      button.setAttribute('data-target','#addStudentModal');
    }
    if(mode === 'edit'){
      this.editStudent = student;
      button.setAttribute('data-target','#updateStudentModal');
    }
    if(mode === 'delete'){
      this.deleteStudent = student;
      button.setAttribute('data-target','#deleteStudentModal');
    }
    container.appendChild(button);
    button.click();
  }
}
