import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CreditApplicationComponent } from './credit-application/credit-application.component';
import { CreditCardPaymentComponent } from './credit-card-payment/credit-card-payment.component';

@NgModule({
  declarations: [
    AppComponent,
    CreditApplicationComponent,
    CreditCardPaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
