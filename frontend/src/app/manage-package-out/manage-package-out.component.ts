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
    console.log(this.managepak);
    this.mangagePackageService.getPackageIn(this.managepak.houseNumber).subscribe(data => {
      data.forEach( (element, id) => {
        this.mangagePackageService.checkPackeIn(element.mpInId).subscribe(check => {
            if (check == null) {
                 this.package.push(data[id]);
            }
        });
    });
        this.datadetail = data;
        this.packalist = this.package;
        console.log(data);
        if ( data !== null ) {
          this.state = false;
        } else if ( data === null ) {
          this.state = true;
          this.noti = false;
          this.notimag = 'ไม่พบพัสดุ';
          this.managepak = {};
          setTimeout(() => {
           this.noti = true;
           this.managepak = {};
        }, 1000);
        }
    });
    // this.mangagePackageService.
  }
  onSubmit() {
      this.empid = JSON.parse(localStorage.getItem('employee')).empId;
      this.mangagePackageService.savePackageOut(this.empid, this.managepak.receiver, this.datadetail.mpInId).subscribe(data => {
            console.log(data);
            this.state = true;
            this.noti = false;
            this.submit = true;
            this.notimag = 'บันทึกการส่งพัสดุ';
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
        console.log(data);
    });
    console.log(datain);
  }
}
