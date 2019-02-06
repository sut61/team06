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
  canceltypes: Array<any>;

  renthouseid: number;
  employeeid: number;
  clientid: number;
  comment: String;
  canceltype: number;

  constructor(private data: Team06Service,private httpClient: HttpClient) { }

  ngOnInit() {
    this.data.EmployeeAll().subscribe(data => {this.employees = data;})
    this.data.ClientAll().subscribe(data => {this.clients = data;})
    this.data.RentHouseAll().subscribe(data => {this.renthouses = data;})
    this.data.canceltypeAll().subscribe(data => {this.canceltypes = data;})
  }
  save(){
    if (this.renthouseid === undefined || this.employeeid === undefined
       || this.clientid === undefined || this.comment === undefined ||
       this.canceltype === undefined ) {   alert('กรุณากรอกข้อมูลให้ครบถ้วน');   }
    else{
        this.httpClient.post('http://localhost:8080/cancelrenthouse/save/'
        + this.renthouseid + '/' + this.employeeid + '/' + this.clientid + '/' + this.comment + '/' + this.canceltype,null).subscribe(
        data => {
                console.log('Cancel RentHouse is successful', data);
            },
            error => {
                console.log('------------Error----------', error);
                //window.location.reload();
            }

      );
  }
  }
}
