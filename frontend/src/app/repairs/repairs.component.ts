import { Component, OnInit } from '@angular/core';
import { Team06Service } from '../team06.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-repairs',
  templateUrl: './repairs.component.html',
  styleUrls: ['./repairs.component.css']
})
export class RepairsComponent implements OnInit {
  repairs: Array<any>;
  repairsType: Array<any>;
  employees: Array<any>;
  equipments: Array<any>;

  houseid: number;
  renthouseid: number;
  employeeid: number;
  equipmentid: number;

  constructor(private data: Team06Service,private httpClient: HttpClient) { }

  ngOnInit() {
    this.data.HouseAll().subscribe(data => {this.repairs = data;})
    this.data.RentHouseAll().subscribe(data => {this.repairsType = data;})
    this.data.EmployeeAll().subscribe(data => {this.employees = data;})
    this.data.EquipmentAll().subscribe(data => {this.equipments = data;})
  }

  save(){
    if (this.houseid === undefined || this.renthouseid === undefined
       || this.employeeid === undefined || this.equipmentid === undefined ) {   alert('กรุณากรอกข้อมูลให้ครบถ้วน');   }
    else{
        this.httpClient.post('http://localhost:8080/api/repair/save/'
        + this.houseid + '/' + this.renthouseid + '/' + this.employeeid + '/' + this.equipmentid,null).subscribe(
        data => {
                console.log('PUT Code and repairs is successful', data);
            },
            error => {
                console.log('------------Error----------', error);
                //window.location.reload();
            }

      );
  }
  }

}
