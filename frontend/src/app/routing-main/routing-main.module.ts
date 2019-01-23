import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

// keng
import { IndexComponent } from '../index/index.component';
import { ManagePackageInComponent } from '../manage-package-in/manage-package-in.component';
import { ManagePackageOutComponent } from '../manage-package-out/manage-package-out.component';
import { ManagePackageDetailComponent } from '../manage-package-detail/manage-package-detail.component';
// ...
const routes: Routes = [
  { path: '' , component: IndexComponent },
  { path: 'manage/packagein' , component:  ManagePackageInComponent},
  { path: 'manage/packageout' , component: ManagePackageOutComponent},
  { path: 'manage/packagedetail' , component: ManagePackageDetailComponent}
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class RoutingMainModule { }
