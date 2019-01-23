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
         MatTabsModule } from '@angular/material';
import {MatTableModule} from '@angular/material/table';
import {MatSelectModule} from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

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
    ManagePackageStatusComponent

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
    MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
