import { Component, OnInit } from '@angular/core';
import { Team06Service } from './../team06.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-cancel-rent-house',
  templateUrl: './cancel-rent-house.component.html',
  styleUrls: ['./cancel-rent-house.component.css']
})
export class CancelRentHouseComponent implements OnInit {

  employees: Array<any>;
  clients: Array<any>;
  renthouses: Array<any>;

  employeeid: number;
  client: String;

  constructor(private data: Team06Service,private httpClient: HttpClient) { }

  ngOnInit() {
    this.data.EmployeeAll().subscribe(data => {this.employees = data;})
    this.data.ClientAll().subscribe(data => {this.clients = data;})
    this.data.RentHouseAll().subscribe(data => {this.renthouses = data;})
  }

}
