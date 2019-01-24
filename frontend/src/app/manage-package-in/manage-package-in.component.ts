import { Component, OnInit } from '@angular/core';
import { MangagePackageService } from '../service/mangage-package.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-manage-package-in',
  templateUrl: './manage-package-in.component.html',
  styleUrls: ['./manage-package-in.component.css']
})
export class ManagePackageInComponent implements OnInit {
  managepak: any = {};
  deliverCom: Array<any>;
  noti: boolean;
  notimag: String;

  constructor(private mangagePackageService: MangagePackageService, private router: Router) {
       this.noti = true;
  }
  ngOnInit() {
     this.mangagePackageService.getDeliverComAll().subscribe(data => {
           this.deliverCom = data;
           console.log(data);
     });
    //  this.managepak = {};
  }

  onSave() {
    // tslint:disable-next-line:no-non-null-assertion
    // console.log((Object.keys(this.managepak).length);
  if (Object.keys(this.managepak).length !== 0) {
     // tslint:disable-next-line:max-line-length
        this.mangagePackageService.savePackageIn('1', this.managepak.packageId, this.managepak.deliverId, this.managepak.houseNumber).subscribe(data => {
              console.log(data);
              this.noti = false;
              this.notimag = 'บันทึกพัสดุสำเร็จ';
              setTimeout(() => {
                  this.noti = true;
                  // this.router.navigateByUrl('manage/package');
                  this.managepak = {};
              }, 1000);
        });

    } else {
        console.log('empty input');
        this.notimag = 'empty input';
        this.noti = false;
        setTimeout(() => {
          this.noti = true;
          this.managepak = {};
        }, 1000);
    }

  }
}
