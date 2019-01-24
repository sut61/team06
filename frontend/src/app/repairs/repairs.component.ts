import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-repairs',
  templateUrl: './repairs.component.html',
  styleUrls: ['./repairs.component.css']
})
export class RepairsComponent implements OnInit {
  repairs: any = {};
  constructor() { }

  ngOnInit() {
  }

}
