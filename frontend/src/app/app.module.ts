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
         MatDialogModule } from '@angular/material';
import {MatTableModule} from '@angular/material/table';
import {MatSelectModule} from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

// import rourting
import {RoutingMainModule} from './routing-main/routing-main.module';
import { IndexComponent } from './index/index.component';
import { ManagePackageInComponent } from './manage-package-in/manage-package-in.component';
import { ManagePackageOutComponent } from './manage-package-out/manage-package-out.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    ManagePackageInComponent,
    ManagePackageOutComponent
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
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
