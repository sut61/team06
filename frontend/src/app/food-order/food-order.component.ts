import { Component, OnInit } from '@angular/core';
import { Team06Service } from '../team06.service';

@Component({
  selector: 'app-food-order',
  templateUrl: './food-order.component.html',
  styleUrls: ['./food-order.component.css']
})
export class FoodOrderComponent implements OnInit {
  houses: Array<any>;
  employees: Array<any>;
  clients: Array<any>;
  foodlists: Array<any>;

  employeeid: number;
  client: String;
  foodlist: String;
  constructor(private data: Team06Service) { }

  ngOnInit() {
    this.data.HouseAll().subscribe(data => {this.houses = data;})
    this.data.EmployeeAll().subscribe(data => {this.employees = data;})
    this.data.ClientAll().subscribe(data => {this.clients = data;})
    this.data.FoodListAll().subscribe(data => {this.foodlists = data;})
  }

}
