import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgxUiLoaderService } from 'ngx-ui-loader';
import { BillService } from '../services/bill.service';
import { BkashDataService } from '../services/bkashdata.service';
import { CategoryService } from '../services/category.service';
import { ProductService } from '../services/product.service';
import { SnackbarService } from '../services/snackbar.service';
import { BkashPayData } from '../types/bkashData';

@Component({
  selector: 'app-payment-p',
  templateUrl: './payment-p.component.html',
  styleUrls: ['./payment-p.component.scss']
})
export class PaymentPComponent implements OnInit {

  data: BkashPayData = {
    invoiceId: '', totalAmount: 0.0, phone: '', otp: 0
  };

  pin: string = '';
  error: boolean = false;

  constructor(private router: Router, 
    private bkashDataService: BkashDataService, 
    private catetoryService: CategoryService,
    private productService: ProductService,
    private billService: BillService,
    private ngxService: NgxUiLoaderService) { }

  ngOnInit(): void {
    let dataSource = localStorage.getItem('bkashData');
    this.data = dataSource != null ? JSON.parse(dataSource) : this.data;
    this.data.otp = 468024;
  }

  getMaskedPhone(): string {
    const phone = this.data.phone && this.data.phone.length ? `${this.data.phone?.substring(0, 3)} ** *** ${this.data.phone?.substring(8, 11)}` : '017 ** *** 257';
    return phone;
  }

  onConfirm() {
    if (this.pin === `11223`) {
      this.ngxService.start();
      this.bkashDataService.add(this.data).subscribe(
        res => {
          window.localStorage.removeItem('bkashData');
          this.submitBill();
        },
        error => {
          this.ngxService.stop();
          console.error(error);
        }
      );
    } else {
      this.error = true;
    }

  }

  submitBill() {
    var data = localStorage.getItem('cafeBillData');
    this.billService.generateReport(data).subscribe((response: any) => {
      this.ngxService.stop();
      this.router.navigate(["/cafe/bill"]);
    }, (error: any) => {
      this.ngxService.stop();
      if (error.error?.message) {
        console.error(error);
      }

    })
  }

}
