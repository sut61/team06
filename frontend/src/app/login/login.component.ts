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
  clintnoti: boolean;
  empnoti: boolean;
  empmsg: String;
  clientmsg: String;
  ngOnInit() {
      this.empnoti = true;
      this.clintnoti  = true;
  }
  LoginSubmit() {
    this.app.empLogin(this.credentials.username.trim(), this.credentials.password.trim()).subscribe(datalogin => {
        if ( datalogin['success'] ) {
          this.app.authenticatedemp = true;
            localStorage.setItem('employee', JSON.stringify(datalogin['employee']));
            this.router.navigate(['']);
            this.empnoti = true;
            this.empmsg  = '';
        } else {
          this.empnoti = false;
          this.empmsg = 'Incorrect username or password';
          this.app.authenticatedemp = false;
          this.router.navigate(['/login']);
        }
    }, error => {
         this.empnoti = false;
         this.empmsg = 'Incorrect username or password';
    });
  }
  LoginSubmitClint() {
    this.app.clientLogin(this.credentials.username.trim(), this.credentials.password.trim()).subscribe(datalogin => {
      if ( datalogin['success'] ) {
          this.app.authenticatedclient = true;
          this.clintnoti = true;
          this.clientmsg = '';
          localStorage.setItem('client', JSON.stringify(datalogin['employee']));
          this.router.navigate(['']);
      } else {
          this.clintnoti = false;
          this.clientmsg = 'Incorrect username or password';
          this.app.authenticatedclient = false;
          this.router.navigate(['/login']);
      }
  }, error => {
          this.clintnoti = false;
          this.clientmsg = 'Incorrect username or password';

  });
  }

}
