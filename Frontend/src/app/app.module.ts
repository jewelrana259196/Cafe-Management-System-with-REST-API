import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './shared/material-module';
import { HomeComponent } from './home/home.component';
import { BestSellerComponent } from './best-seller/best-seller.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { SharedModule } from './shared/shared.module';
import { FullComponent } from './layouts/full/full.component';
import { AppHeaderComponent } from './layouts/full/header/header.component';
import { AppSidebarComponent } from './layouts/full/sidebar/sidebar.component';

import { SignupComponent } from './signup/signup.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {MatDialogModule} from '@angular/material/dialog';

import { NgxUiLoaderModule, SPINNER, PB_DIRECTION, NgxUiLoaderConfig} from 'ngx-ui-loader';
import { LoginComponent } from './login/login.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { DashboardComponent } from './services/dashboard/dashboard.component';
import { TokenInterceptorInterceptor } from './services/token-interceptor.interceptor';
import { PaymentComponent } from './payment/payment.component';
import { PaymentVComponent } from './payment-v/payment-v.component';
import { PaymentPComponent } from './payment-p/payment-p.component';


const ngxUiLoaderConfig: NgxUiLoaderConfig = {
  text: 'Loading...',
  textColor: '#FFFFFF',
  textPosition: 'center-center',
  pbColor: 'red',
  bgsColor: 'red',
  fgsColor: 'red',
  fgsType: SPINNER.ballSpinClockwise,
  fgsSize: 100,
  pbDirection: PB_DIRECTION.leftToRight,
  pbThickness: 5
};






@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BestSellerComponent,
    FullComponent,
    AppHeaderComponent,
    AppSidebarComponent,
    SignupComponent,
    LoginComponent,
    ForgotPasswordComponent,
    DashboardComponent,
    PaymentComponent,
    PaymentVComponent,
    PaymentPComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule,
    FlexLayoutModule,
    SharedModule,
    HttpClientModule,
    MatDialogModule,

NgxUiLoaderModule.forRoot(ngxUiLoaderConfig)
  ],
  providers: [HttpClientModule,{provide: HTTP_INTERCEPTORS, useClass: TokenInterceptorInterceptor,multi:true}],
  bootstrap: [AppComponent]
})
export class AppModule { }