import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CreditApplicationComponent} from './credit-application/credit-application.component';
import {CreditCardPaymentComponent} from './credit-card-payment/credit-card-payment.component';

const routes: Routes = [
  {path: 'credit-application', component: CreditApplicationComponent} ,
  {path: '', redirectTo: '/credit-application', pathMatch: 'full'},
  {path: 'credit-card-payment', component:CreditCardPaymentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
