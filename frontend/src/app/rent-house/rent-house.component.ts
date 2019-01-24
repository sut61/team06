import { Team06Service } from './../team06.service';
import { Component, OnInit } from '@angular/core';
import { Observable, from } from 'rxjs';


@Component({
  selector: 'app-rent-house',
  templateUrl: './rent-house.component.html',
  styleUrls: ['./rent-house.component.css']
})
export class RentHouseComponent implements OnInit {

  rents: Array<any>;
  constructor(private data: Team06Service) { }
  ngOnInit() {
    this.data.RentHouseAll().subscribe(data => {this.rents = data;})
  }

}
