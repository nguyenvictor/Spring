import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient,HttpErrorResponse} from '@angular/common/http';
import {Student} from './student';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class StudentService{
    private apiServerUrl = environment.apiBaseUrl

    constructor(private http: HttpClient){

    }
    public getStudentList(): Observable<Student[]>{
        return this.http.get<Student[]>(`${this.apiServerUrl}/student`)
    }

    public addStudent(student:Student): Observable<Student>{
        return this.http.post<Student>(`${this.apiServerUrl}/student/add`, student)
    }

    public updateStudent(student:Student): Observable<Student>{
        return this.http.put<Student>(`${this.apiServerUrl}/student/update`,student)
    }

    public deleteStudent(studentId: number): Observable<void>{
        return this.http.delete<void>(`${this.apiServerUrl}/student/delete/${studentId}`,{responseType:'json'});
    }
}