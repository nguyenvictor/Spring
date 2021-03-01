import { Component, OnInit } from '@angular/core';
import {FormBuilder,Validators,FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-credit-card-payment',
  templateUrl: './credit-card-payment.component.html',
  styleUrls: ['./credit-card-payment.component.css']
})
export class CreditCardPaymentComponent implements OnInit {

  creditInfoForm: FormGroup;
  submitted: boolean;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.creditInfoForm = this.formBuilder.group({
      ccNumber: new FormControl('', Validators.required),
      ccName: new FormControl('', Validators.required),
      ccExp: new FormControl('', Validators.required),
      ccCvv: new FormControl('',Validators.required)

    });
  }

}
