import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Team06Service } from '../team06.service';

@Component({
  selector: 'app-transport-car',
  templateUrl: './transport-car.component.html',
  styleUrls: ['./transport-car.component.css']
})
export class TransportCarComponent implements OnInit {

  houses: Array<any>;
  clients: Array<any>;
  employees: Array<any>;
  cars: Array<any>;
  transportcars: Array<any>;
  notimag: String;
  noti: boolean;

  houseid: number;
  client: String;
  carId: number;
  place: String;
  amount: number;
  Detail: String;
  employeeid: number;






  constructor(private data: Team06Service, private httpClient: HttpClient) { this.noti = true; }

  ngOnInit() {
    this.data.HouseAll().subscribe(data => {this.houses = data; });
    this.data.ClientAll().subscribe(data => {this.clients = data; });
    this.data.EmployeeAll().subscribe(data => {this.employees = data; });
    this.data.CarAll().subscribe(data => {this.cars = data; });
    this.data.TransportationCarAll().subscribe(data => {this.transportcars = data; });
  }
  save() {
    this.employeeid = JSON.parse(localStorage.getItem('employee')).empId;
    if (this.houseid === undefined || this.client === undefined
       || this.carId === undefined || this.place === undefined
       || this.amount === undefined || this.Detail === undefined
       || this.employeeid === undefined ) {
        this.noti = false;
        this.notimag = 'บันทึกไม่สำเร็จ';
       } else {
        this.httpClient.post('http://localhost:8080/TransportationCar/save/'
        + this.houseid + '/' + this.client + '/' + this.carId + '/'
        + this.place + '/' + this.amount + '/' + this.Detail + '/' + this.employeeid, null).subscribe(
        data => {
                console.log('PUT Code and TransportationCar is successful', data);
                this.noti = false;
                this.notimag = 'บันทึกสำเร็จ';
            },
            error => {
                console.log('------------Error----------', error);
                this.noti = false;
                this.notimag = 'ไม่สำเร็จกรุณาใส่ข้อมูลให้ถูกต้อง';
                //window.location.reload();
              }

      );
  }
  }

}
