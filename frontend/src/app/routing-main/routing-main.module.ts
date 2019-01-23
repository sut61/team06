import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

// keng
import { IndexComponent } from '../index/index.component';
import { ManagePackageMainComponent } from '../manage-package-main/manage-package-main.component';
// best
import { MakeInsuranceComponent } from '../make-insurance/make-insurance.component';
import { InsuranceTableComponent } from '../insurance-table/insurance-table.component';
// jump
import { MakeRentHouseComponent } from '../make-rent-house/make-rent-house.component';
import { RentHouseComponent } from '../rent-house/rent-house.component';
//pheekay
import { FoodOrderComponent } from '../food-order/food-order.component';
// ...
const routes: Routes = [
  { path: '' , component: IndexComponent },
  { path: 'manage/package' , component: ManagePackageMainComponent},
  { path: 'makeinsurance' , component: MakeInsuranceComponent},
  { path: 'insurancetable' , component: InsuranceTableComponent},
  { path: 'makerenthouse' , component: MakeRentHouseComponent},
  { path: 'renthouse' , component: RentHouseComponent},
  { path: 'foodorder' , component: FoodOrderComponent} 
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class RoutingMainModule { }
