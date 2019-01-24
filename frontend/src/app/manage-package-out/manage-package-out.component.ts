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
  notimag: String;
  constructor(private mangagePackageService: MangagePackageService) { }
  ngOnInit() {
    this.state = true;
    this.noti = true;
  }
  onCheck() {
    console.log(this.managepak);
    this.mangagePackageService.getPackageIn(this.managepak.houseNumber).subscribe(data => {
        this.datadetail = data;
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
      this.mangagePackageService.savePackageOut('1', this.managepak.receiver, this.datadetail.mpInId).subscribe(data => {
            console.log(data);
            this.state = true;
            this.noti = false;
            this.notimag = 'บันทึกการส่งพัสดุ';
            setTimeout(() => {
               this.noti = true;
               this.managepak = {};
            }, 1500);
      });
      // console.log("loser");
  }
}
