import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentPComponent } from './payment-p.component';

describe('PaymentPComponent', () => {
  let component: PaymentPComponent;
  let fixture: ComponentFixture<PaymentPComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymentPComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
