import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BkashPayData } from '../types/bkashData';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {

  data: BkashPayData = {
    invoiceId: '', totalAmount: 0.0, phone: null, otp: 0
  };

  isError: boolean = false;

  constructor(private router: Router) { }

  ngOnInit(): void {

    let dataSource = localStorage.getItem('bkashData');
    this.data = dataSource != null ? JSON.parse(dataSource) : this.data;

  }

  onSubmit() {
    if (this.data.phone) {
      const data = JSON.stringify(this.data);
      window.localStorage.setItem('bkashData', data);
      this.router.navigate(["/payment_v"]);
    } else {
      this.isError = true;
    }
  }

}
