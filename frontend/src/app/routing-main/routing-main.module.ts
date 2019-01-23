import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

// keng
import { IndexComponent } from '../index/index.component';
import { ManagePackageMainComponent } from '../manage-package-main/manage-package-main.component';
// ...
const routes: Routes = [
  { path: '' , component: IndexComponent },
  { path: 'manage/package' , component: ManagePackageMainComponent}
];

@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class RoutingMainModule { }
