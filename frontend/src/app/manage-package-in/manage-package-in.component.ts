import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-manage-package-in',
  templateUrl: './manage-package-in.component.html',
  styleUrls: ['./manage-package-in.component.css']
})
export class ManagePackageInComponent implements OnInit {
  managepak: any = {};
  constructor() { }
  ngOnInit() {

  }

  onSave() {
    console.log(this.managepak);
  }
}
