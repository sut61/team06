import { Component , OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MangagePackageService} from './service/mangage-package.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Rent House';
  constructor(private app: MangagePackageService,  private router: Router) {
  }
  ngOnInit() {
    if ( localStorage.getItem('employee') == null && localStorage.getItem('employee') == null ) {
      this.router.navigate(['home']);
    } else {
      this.app.authenticatedemp = true;
      this.app.authenticatedclient = true;
    }
  }
  authed() {
    return this.app.authenticatedemp || this.app.authenticatedclient;
  }
  emp() {
      return this.app.authenticatedemp;
  }
  client() {
     return this.app.authenticatedclient ||  this.app.authenticatedemp;
  }
  logOut() {
      console.log('logout');
      this.app.authenticatedemp = false;
      this.app.authenticatedclient = false;
      this.router.navigate(['']);
      localStorage.removeItem('employee');
      localStorage.removeItem('client');
  }
  names() {
    // tslint:disable-next-line:max-line-length
    return  (localStorage.getItem('employee') != null) ? JSON.parse(localStorage.getItem('employee')).name : '' || (localStorage.getItem('employee') != null) ? JSON.parse(localStorage.getItem('client')).name : '';
  }
}
