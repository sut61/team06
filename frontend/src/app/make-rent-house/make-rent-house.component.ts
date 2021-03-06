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
  notimag: String;
  noti: boolean;

  houseid: number;
  housetypesid: number;
  employeeid: '';
  client: String;
  resident: String;

  constructor(private data: Team06Service,private httpClient: HttpClient) { this.noti = true; }

  ngOnInit() {
    this.data.HouseAll().subscribe(data => {this.houses = data;})
    this.data.RentHouseTypeAll().subscribe(data => {this.housetypes = data;})
    this.data.EmployeeAll().subscribe(data => {this.employees = data;})
    this.data.ClientAll().subscribe(data => {this.clients = data;})
  }

  save(){
    this.employeeid = JSON.parse(localStorage.getItem('employee')).empId;
    if (this.houseid === undefined || this.housetypesid === undefined || this.resident === undefined ) {
      this.noti = false;
      this.notimag = 'บันทึกไม่สำเร็จ'  }
    else{
        this.httpClient.post('http://localhost:8080/renthouse/save/'
        + this.houseid + '/' + this.housetypesid + '/' + this.employeeid + '/'  + this.resident,null).subscribe(
        data => {
                console.log('PUT Code and renthouse is successful', data);
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
