import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

// example
import {IndexComponent} from '../index/index.component';

const routes: Routes = [
  { path: '' , component: IndexComponent }
];
@NgModule({
  exports: [ RouterModule ],
  imports: [ RouterModule.forRoot(routes) ]
})
export class RoutingMainModule { }
