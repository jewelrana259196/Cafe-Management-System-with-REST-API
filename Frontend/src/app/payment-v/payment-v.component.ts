import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BkashPayData } from '../types/bkashData';

@Component({
  selector: 'app-payment-v',
  templateUrl: './payment-v.component.html',
  styleUrls: ['./payment-v.component.scss']
})
export class PaymentVComponent implements OnInit {

  data: BkashPayData = {
    invoiceId: '', totalAmount: 0.0, phone: '', otp: 0
  };

  otpInp: string = '';
  error: boolean = false;

  constructor(private router: Router) { }

  ngOnInit(): void {
    let dataSource = localStorage.getItem('bkashData');
    this.data = dataSource != null ? JSON.parse(dataSource) : this.data;
    this.data.otp = 468024;
  }

  getMaskedPhone(): string {
    const phone = this.data.phone && this.data.phone.length ? `${this.data.phone?.substring(0, 3)} ** *** ${this.data.phone?.substring(8, 11)}` : '017 ** *** 257';
    return phone;
  }

  onConfirm(){
    if(this.otpInp === `${this.data.otp}`){
      const data = JSON.stringify(this.data);
      window.localStorage.setItem('bkashData', data);
      this.router.navigate(["/payment_p"]);
    } else {
      this.error = true;
    }

  }

}
