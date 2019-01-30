import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    console.log(JSON.parse(localStorage.getItem('client')));
    console.log(JSON.parse(localStorage.getItem('employee')));
  }

}
