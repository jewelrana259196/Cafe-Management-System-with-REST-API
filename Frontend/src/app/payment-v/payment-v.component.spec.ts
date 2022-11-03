import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentVComponent } from './payment-v.component';

describe('PaymentVComponent', () => {
  let component: PaymentVComponent;
  let fixture: ComponentFixture<PaymentVComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymentVComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentVComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
