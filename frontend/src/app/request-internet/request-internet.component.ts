import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-request-internet',
  templateUrl: './request-internet.component.html',
  styleUrls: ['./request-internet.component.css']
})
export class RequestInternetComponent implements OnInit {
  state1: boolean;
  state2: boolean;
  noti: boolean;
  noti2: boolean;
  notimag: String;
  constructor() { }

  ngOnInit() {
    this.state1 = true;
    this.state2 = false;
  }


}
