import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';

import { MatButtonModule,
         MatCardModule,
         MatInputModule,
         MatListModule,
         MatToolbarModule,
         MatIconModule,
         MatDialogModule,
         MatTabsModule} from '@angular/material';
import {MatTableModule} from '@angular/material/table';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import {MatMenuModule} from '@angular/material/menu';
// import rourting
import {RoutingMainModule} from './routing-main/routing-main.module';
import { IndexComponent } from './index/index.component';
import { ManagePackageInComponent } from './manage-package-in/manage-package-in.component';
import { ManagePackageOutComponent } from './manage-package-out/manage-package-out.component';
import { ManagePackageDetailComponent } from './manage-package-detail/manage-package-detail.component';
import { ManagePackageMainComponent } from './manage-package-main/manage-package-main.component';

import { InsuranceTableComponent } from './insurance-table/insurance-table.component';
import { MakeInsuranceComponent } from './make-insurance/make-insurance.component';

import { ManagePackageStatusComponent } from './manage-package-status/manage-package-status.component';
import { MakeRentHouseComponent } from './make-rent-house/make-rent-house.component';
import { RentHouseComponent } from './rent-house/rent-house.component';
import { FoodOrderComponent } from './food-order/food-order.component';

import { Team06Service } from './team06.service';
import { MangagePackageService } from './service/mangage-package.service';
import { RepairsComponent } from './repairs/repairs.component';
import { LoginComponent } from './login/login.component';
import { MakeReceiptComponent } from './make-receipt/make-receipt.component';
import { CancelRentHouseComponent } from './cancel-rent-house/cancel-rent-house.component';
import { ShowReceiptComponent } from './show-receipt/show-receipt.component';
import { RequestInternetComponent } from './request-internet/request-internet.component';
import { ReqInternetService } from './service/req-internet.service';
import { CleanHouseComponent } from './cleanhouse/cleanhouse.component';
import { TransportCarComponent } from './transport-car/transport-car.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    ManagePackageInComponent,
    ManagePackageOutComponent,
    ManagePackageDetailComponent,
    ManagePackageMainComponent,
    InsuranceTableComponent,
    MakeInsuranceComponent,
    ManagePackageStatusComponent,
    MakeRentHouseComponent,
    RentHouseComponent,
    FoodOrderComponent,
    RepairsComponent,
    LoginComponent,
    MakeReceiptComponent,
    CancelRentHouseComponent,
    ShowReceiptComponent,
    RequestInternetComponent,
    CleanHouseComponent,
    TransportCarComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    RoutingMainModule,
    FormsModule,
    MatTableModule,
    MatSelectModule,
    MatIconModule,
    MatDialogModule,
    MatTabsModule,
    MatFormFieldModule,
    MatMenuModule


  ],
  providers: [Team06Service, MangagePackageService, ReqInternetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
