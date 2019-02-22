import { Component, OnInit } from '@angular/core';
import { Team06Service } from '../team06.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-repairs',
  templateUrl: './repairs.component.html',
  styleUrls: ['./repairs.component.css']
})
export class RepairsComponent implements OnInit {
  repairsdata: Array<any>;
  repairs: Array<any>;
  repairsType: Array<any>;
  employees: Array<any>;
  equipments: Array<any>;
  repairsManName: Array<any>;
  repairsManNumid: Array<any>;
  repairsManTel: Array<any>;
  repairsManTel2: Array<any>;
  repairsManEmail: Array<any>;
  houseid: number;
  renthouseid: number;
  employeeid: number;
  equipmentid: number;
  
  noti: boolean;
  notimag: String;

  constructor(private data: Team06Service,private httpClient: HttpClient) { }

  ngOnInit() {
    this.noti = true;
    this.data.HouseAll().subscribe(data => {this.repairs = data;})
    this.data.RentHouseAll().subscribe(data => {this.repairsType = data;})
    this.data.EmployeeAll().subscribe(data => {this.employees = data;})
    this.data.EquipmentAll().subscribe(data => {this.equipments = data;})

  
  }

  save(){
    console.log(this.repairsdata);
    if (this.houseid === undefined || this.renthouseid === undefined
      || this.equipmentid === undefined || this.repairsManName === undefined || this.repairsManNumid === undefined
       || this.repairsManTel === undefined || this.repairsManTel2 == undefined || this.repairsManEmail === undefined) {   
        //  alert('กรุณากรอกข้อมูลให้ครบถ้วน');   
          this.noti = false;
          this.notimag = 'กรุณากรอกข้อมูลให้ครบถ้วน';
        }
    else{
       const empid  = JSON.parse(localStorage.getItem('employee')).empId;
        this.httpClient.post('http://localhost:8080/api/repair/save/'
        + this.houseid + '/' + this.renthouseid + '/' + empid + '/' + this.equipmentid +'/'+ this.repairsManName + '/' +  this.repairsManNumid + '/'
        + this.repairsManTel + '/' + this.repairsManTel2 + '/' + this.repairsManEmail,null).subscribe(
        data => {
                this.noti = false;
                this.notimag = 'บันทึกข้อมูลสำเร็จ';
                console.log('PUT Code and repairs is successful', data);
            },
            error => {
                this.noti = false;
                this.notimag = 'error บันทึกข้อมูล';
                console.log('------------Error----------', error);
                //window.location.reload();
            }

      );
    }
  }

}
