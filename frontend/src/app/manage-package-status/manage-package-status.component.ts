import { Component, OnInit } from '@angular/core';
import { MangagePackageService } from '../service/mangage-package.service';
import { Router } from '@angular/router';
import { async } from '@angular/core/testing';
@Component({
  selector: 'app-manage-package-status',
  templateUrl: './manage-package-status.component.html',
  styleUrls: ['./manage-package-status.component.css']
})
export class ManagePackageStatusComponent implements OnInit {
  statusList: any = [];
  constructor(private mangagePackageService: MangagePackageService) { }
  ngOnInit() {
      this.mangagePackageService.getManageAll().subscribe(data => {
          console.log(data);
          data.forEach( (element, id) => {
              this.mangagePackageService.checkPackeIn(element.mpInId).subscribe(check => {
                  if (check == null) {
                       data[id].status = 'In Stock';
                  } else {
                      data[id].status = 'Out Stock';
                  }
              });
          });
          this.statusList = data;
          // this.mangagePackageService.checkPackeIn(data.mpInId)
      });
      console.log(this.statusList);
  }

}
