import { Component, OnInit } from '@angular/core';
import { MangagePackageService } from '../service/mangage-package.service';
@Component({
  selector: 'app-manage-package-out',
  templateUrl: './manage-package-out.component.html',
  styleUrls: ['./manage-package-out.component.css']
})
export class ManagePackageOutComponent implements OnInit {
  managepak: any = {};
  state: boolean;
  datadetail: any = [];
  noti: boolean;
  submit: boolean;
  notimag: String;
  empid: String;
  packalist: any = [];
  package: any = [];
  constructor(private mangagePackageService: MangagePackageService) { }
  ngOnInit() {
    this.state = true;
    this.submit = true;
    this.noti = true;
  }
  onCheck() {
    // console.log(this.managepak);
    if ( Object.keys(this.managepak).length === 3 ) {
      this.mangagePackageService.getRentHouseById(this.managepak.rentid.trim()).subscribe(rent => {
      //  console.log(rent);
       if (rent != null ) {
        this.mangagePackageService.getPackageIn(this.managepak.houseNumber.trim(), this.managepak.rentid.trim()).subscribe(data => {
          // console.log(data.length !== 0);
          if (data.length !== 0) {
                    data.forEach( (element, id) => {
                      this.mangagePackageService.checkPackeIn(element.mpInId).subscribe(check => {
                          if (check == null) {
                              this.package.push(data[id]);
                              // console.log(data[id]);
                          }
                      });
                  });

                this.datadetail = data;
                this.packalist = this.package;
                this.state = false;
                // this.package = [];

          } else {
                  this.noti = false;
                  this.notimag = 'ไม่มีพัสดุ';
                  this.managepak = {};
          }
        }, error => {
                this.state = true;
                this.noti = false;
                this.notimag = 'ไม่มีพัสดุ';
                this.managepak = {};
        });
      } else {
                this.noti = false;
                this.notimag = 'ID ผู้เช่าไม่ถูกต้อง';
                this.managepak = {};
                setTimeout(() => {
                    this.noti = true;
                    this.managepak = {};
              }, 1500);
      }
    },  error => {
              this.noti = false;
              this.notimag = 'ID ผู้เช่าไม่ถูกต้อง';
              this.managepak = {};
    });
  } else {
            this.noti = false;
            this.notimag = 'empty input';
            this.managepak = {};
            setTimeout(() => {
            this.noti = true;
            this.managepak = {};
          }, 1000);
  }
    // this.mangagePackageService.
  }
  onSubmit() {
      this.empid = JSON.parse(localStorage.getItem('employee')).empId;
      this.mangagePackageService.savePackageOut(this.empid, this.managepak.receiver, this.datadetail.mpInId).subscribe(data => {
            console.log(data);
            this.state = true;
            this.noti = false;
            this.submit = true;
            this.notimag = 'พัสดุถูกนำส่ง';
            this.package = [];
            setTimeout(() => {
               this.noti = true;
               this.managepak = {};
            }, 1500);
      });
      // console.log("loser");
  }
  onChood(datain: any) {
    this.submit =  false;
     this.mangagePackageService.getPackageInbyId(datain).subscribe(data => {
        this.datadetail = data;
        this.datadetail['empname'] = data.employee.name;
        this.datadetail['delivername'] = data.deliveryCompany.name;
        // console.log(data);
    });
    // console.log(datain);
  }
}
