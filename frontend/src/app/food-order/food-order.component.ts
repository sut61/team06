import { Component, OnInit } from '@angular/core';
import { Team06Service } from '../team06.service';
import { HttpClient} from '@angular/common/http';
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
  FoodOrders: Array<any>;
  notimag: String;
  noti: boolean;
  employeeid: number;
  client: number;
  foodlist: String;
  house: number ;
  constructor(private data: Team06Service, private httpClient: HttpClient) { }
  ngOnInit() {
    this.data.HouseAll().subscribe(data => {this.houses = data; });
    this.data.EmployeeAll().subscribe(data => {this.employees = data; });
    this.data.ClientAll().subscribe(data => {this.clients = data; });
    this.data.FoodListAll().subscribe(data => {this.foodlists = data; });
    this.data.FoodOrderAll().subscribe(data => {this.FoodOrders = data; });
  }

  save() {
    this.employeeid = JSON.parse(localStorage.getItem('employee')).empId;
     if (this.employeeid === undefined
     || this.foodlist === undefined || this.client === undefined
     || this.house === undefined )  {
      console.log('กรุณากรอกข้อมูลให้ครบ');
      this.noti = false;
      this.notimag = 'กรุณากรอกข้อมูลให้ครบ';

     } else {
        this.httpClient.post('http://localhost:8080/FoodOrder/save/'
        + this.employeeid + '/' + this.foodlist + '/' + this.client + '/' + this.house, null).subscribe(
        data => {
                console.log('PUT Code and FoodOrder is successful', data);
                this.noti = false;
                this.notimag = 'บันทึกสำเร็จ';
            },
            error => {
                console.log('------------Error----------', error);
                this.noti = false;
                this.notimag = 'ไม่สำเร็จกรุณาใส่ข้อมูลให้ถูกต้อง';
               // window.location.reload();
            }

      );
  }
}
}
