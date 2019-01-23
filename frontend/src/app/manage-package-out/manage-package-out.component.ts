import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-manage-package-out',
  templateUrl: './manage-package-out.component.html',
  styleUrls: ['./manage-package-out.component.css']
})
export class ManagePackageOutComponent implements OnInit {
  managepak: any = {};
  constructor() { }

  ngOnInit() {
  }
  onCheck() {
    console.log(this.managepak);
  }
}
