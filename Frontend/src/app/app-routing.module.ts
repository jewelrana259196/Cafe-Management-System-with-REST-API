import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { FullComponent } from './layouts/full/full.component';
import { PaymentPComponent } from './payment-p/payment-p.component';
import { PaymentVComponent } from './payment-v/payment-v.component';
import { PaymentComponent } from './payment/payment.component';
import { RouteGuardService } from './services/route-guard.service';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  {
    path: 'cafe',
    component: FullComponent,
    children: [
      {
        path: '',
        redirectTo: '/cafe/dashboard',
        pathMatch: 'full',
      },
      {
        path: '',
        loadChildren:
          () => import('./material-component/material.module').then(m => m.MaterialComponentsModule),
          canActivate:[RouteGuardService],
          data:{
            expectedRole:['admin','user']
          }
        },
      {
        path: 'dashboard',
        loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule),
        canActivate:[RouteGuardService],
          data:{
            expectedRole:['admin','user']
          }
      }
    ]
  },
  {path:'payment', component:PaymentComponent},
  {path:'payment_v', component:PaymentVComponent},
  {path:'payment_p', component:PaymentPComponent},
  { path: '**', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
