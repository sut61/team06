import { Component, OnInit } from '@angular/core';
import { Team06Service } from './../team06.service';
import { HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-make-rent-house',
  templateUrl: './make-rent-house.component.html',
  styleUrls: ['./make-rent-house.component.css']
})
export class MakeRentHouseComponent implements OnInit {

  houses: Array<any>;
  housetypes: Array<any>;
  employees: Array<any>;
  clients: Array<any>;

  houseid: number;
  housetypesid: number;
  employeeid: number;
  client: String;

  constructor(private data: Team06Service,private httpClient: HttpClient) { }

  ngOnInit() {
    this.data.HouseAll().subscribe(data => {this.houses = data;})
    this.data.RentHouseTypeAll().subscribe(data => {this.housetypes = data;})
    this.data.EmployeeAll().subscribe(data => {this.employees = data;})
    this.data.ClientAll().subscribe(data => {this.clients = data;})
  }

  save(){
    if (this.houseid === undefined || this.housetypesid === undefined
       || this.employeeid === undefined || this.client === undefined ) {   alert('กรุณากรอกข้อมูลให้ครบถ้วน');   }
    else{
        this.httpClient.post('http://localhost:8080/renthouse/save/'
        + this.houseid + '/' + this.housetypesid + '/' + this.employeeid + '/' + this.client,null).subscribe(
        data => {
                console.log('PUT Code and renthouse is successful', data);
            },
            error => {
                console.log('------------Error----------', error);
                window.location.reload();
            }

      );
  }
  }

}
