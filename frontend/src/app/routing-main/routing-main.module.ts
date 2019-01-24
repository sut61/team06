import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

// yuu

import { RepairsComponent } from '../repairs/repairs.component'

// keng
import { IndexComponent } from '../index/index.component';
import {ManagePackageInComponent} from '../manage-package-in/manage-package-in.component';
import {ManagePackageOutComponent} from '../manage-package-out/manage-package-out.component';
import {ManagePackageStatusComponent} from '../manage-package-status/manage-package-status.component';
// best
import { MakeInsuranceComponent } from '../make-insurance/make-insurance.component';
import { InsuranceTableComponent } from '../insurance-table/insurance-table.component';
// jump
import { MakeRentHouseComponent } from '../make-rent-house/make-rent-house.component';
import { RentHouseComponent } from '../rent-house/rent-house.component';
// pheekay
import { FoodOrderComponent } from '../food-order/food-order.component';
import { from } from 'rxjs';
// ...
import {LoginComponent} from '../login/login.component';
const routes: Routes = [
  { path: '' , component: IndexComponent },
  { path: 'manage/packagein' , component: ManagePackageInComponent},
  { path: 'manage/packageout' , component: ManagePackageOutComponent},
  { path: 'manage/packagestatus' , component: ManagePackageStatusComponent},
  { path: 'makeinsurance' , component: MakeInsuranceComponent},
  { path: 'insurancetable' , component: InsuranceTableComponent},
  { path: 'makerenthouse' , component: MakeRentHouseComponent},
  { path: 'renthouse' , component: RentHouseComponent},
  { path: 'foodorder' , component: FoodOrderComponent},
  { path: 'repairs' , component: RepairsComponent},
  { path: 'login' , component: LoginComponent}
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class RoutingMainModule { }
