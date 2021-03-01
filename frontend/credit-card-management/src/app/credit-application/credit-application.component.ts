import { Component, OnInit } from '@angular/core';
import {FormBuilder,Validators,FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-credit-application',
  templateUrl: './credit-application.component.html',
  styleUrls: ['./credit-application.component.css']
})
export class CreditApplicationComponent implements OnInit {

  creditForm!: FormGroup;
  submitted: boolean = false;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.creditForm = this.formBuilder.group({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      address: this.formBuilder.group({
        street: new FormControl('',Validators.required),
        city: new FormControl('', Validators.required),
        state: new FormControl('',Validators.required),
        zip: new FormControl('', Validators.required),
      }),
      phoneNo: new FormControl('', [Validators.required,Validators.pattern('^\\(\\d{3}\\)\\s\\d{3}-\\d{4}')]),
      ssn: new FormControl('', [Validators.required,Validators.pattern('^\\d{3}-?\\d{2}-?\\d{4}$')])
    });
  }




}
