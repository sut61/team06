import { Component, OnInit } from '@angular/core';
import {MangagePackageService} from '../service/mangage-package.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials = {username: '', password: ''};
  constructor(private app: MangagePackageService, private router: Router) { }

  ngOnInit() {
  }
  LoginSubmit() {
    this.app.empLogin(this.credentials.username, this.credentials.password).subscribe(datalogin => {
        if ( datalogin['success'] ) {
          this.app.authenticatedemp = true;
            localStorage.setItem('employee', JSON.stringify(datalogin['employee']));
            this.router.navigate(['']);
        } else {
          this.app.authenticatedemp = false;
          this.router.navigate(['/login']);
        }
    });
  }
  LoginSubmitClint() {
    this.app.clientLogin(this.credentials.username, this.credentials.password).subscribe(datalogin => {
      if ( datalogin['success'] ) {
        this.app.authenticatedclient = true;
          localStorage.setItem('client', JSON.stringify(datalogin['employee']));
          this.router.navigate(['']);
      } else {
        this.app.authenticatedclient = false;
        this.router.navigate(['/login']);
      }
  });
  }

}
