import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-request-internet',
  templateUrl: './request-internet.component.html',
  styleUrls: ['./request-internet.component.css']
})
export class RequestInternetComponent implements OnInit {
  detail: any = {};
  reqinternet: any = {};
  timeType: Array<any>;
  TypeSpeed: Array<any>;
  state1: boolean;
  state2: boolean;
  noti: boolean;
  noti2: boolean;
  notimag: String;
  // page1 01
  // page2 10
  // page3 11
  constructor() { }

  ngOnInit() {
     this.state1 = true;
     this.state2 = false;
     this.noti = true;
     this.noti2 = true;

  }
  onCheck() {
  }
  onSave() {

  }
  speedCheck() {
    const  { netname, netpassword, typeSpeedId, timeTypeId, rentid } = this.reqinternet;
  }
}

