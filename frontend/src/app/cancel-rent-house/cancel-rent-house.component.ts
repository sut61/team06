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
  notimag: String;
  noti: boolean;

  renthouseid: number;
  employeeid: '';
  clientid: number;
  comment: String;
  canceltype: number;

  constructor(private data: Team06Service,private httpClient: HttpClient) { this.noti = true; }

  ngOnInit() {
    this.data.EmployeeAll().subscribe(data => {this.employees = data;})
    this.data.ClientAll().subscribe(data => {this.clients = data;})
    this.data.RentHouseAll().subscribe(data => {this.renthouses = data;})
    this.data.canceltypeAll().subscribe(data => {this.canceltypes = data;})
  }
  save(){
    this.employeeid = JSON.parse(localStorage.getItem('employee')).empId;
    if (this.renthouseid === undefined || this.employeeid === undefined
       || this.comment === undefined || this.canceltype === undefined ) {
        this.noti = false;
      this.notimag = 'บันทึกไม่สำเร็จ'  }
    else{
        this.httpClient.post('http://localhost:8080/cancelrenthouse/save/'
        + this.renthouseid + '/' + this.employeeid + '/' + this.comment + '/' + this.canceltype,null).subscribe(
        data => {
                console.log('Cancel RentHouse is successful', data);
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
