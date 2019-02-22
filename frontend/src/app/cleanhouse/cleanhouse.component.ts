import { Component, OnInit } from '@angular/core';
import { Team06Service } from '../team06.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-cleanhouse',
  templateUrl: './cleanhouse.component.html',
  styleUrls: ['./cleanhouse.component.css']
})
export class CleanHouseComponent implements OnInit {
  cleanhousedata: any= {};
  cleanhouse: Array<any>;
  cleanhouseType: Array<any>;
  cleanhouseofType: Array<any>;
  housekeepername: Array<any>;
  housekeeperid: Array<any>;
  housekeepertel: Array<any>;
  typeKeeper: Array<any>;
  houseid: number;
  renthouseid: number;
  noti: boolean;
  notimag: String;
  constructor(private data: Team06Service,private httpClient: HttpClient) { }

  ngOnInit() {
    this.noti = true;
    this.data.HouseAll().subscribe(data => {this.cleanhouse = data;})
    this.data.RentHouseAll().subscribe(data => {this.cleanhouseType = data;})
    this.data.getTypeKeeperAll().subscribe(data=> { this.typeKeeper = data})
  
  }

  save(){
     console.log(this.cleanhousedata);
    //  /houseKeeper/save/{houseid}/{renthouse}/{housekeepername}/{housekeepertype}/{housekeepertel}
   
     const api = 'http://localhost:8080/api/houseKeeper/save/'
    if (Object.keys(this.cleanhousedata).length < 5) {   
      const re = new RegExp("[A-Za-z]{5,10}");
      const re2 = new RegExp("[(09|06|08)][0-9]{8}");
      console.log(!re2.test(this.cleanhousedata.housekeepertel))
      if (!re2.test(this.cleanhousedata.housekeepertel) &&this.cleanhousedata.housekeepertel !== undefined ){
        this.noti = false;
        this.notimag = 'บันทึกไม่สำเสร็จ housekeepertel pattern';
      }
      else if (!re.test(this.cleanhousedata.housekeepername) && this.cleanhousedata.housekeepername !== undefined){
        this.noti = false;
        this.notimag = 'บันทึกไม่สำเสร็จ housekeepername pattern';
      } else {
        this.noti = false;
        this.notimag = 'บันทึกไม่สำเสร็จ ข้อมูลไม่ครบ';
      }
    }
    else{
      // const {houseId, typehouseKeeperId,housekeepername,housekeepertel,rentId} = this.cleanhousedata;
      const empid  = JSON.parse(localStorage.getItem('employee')).empId;
        this.httpClient.post(api
        + this.cleanhousedata.houseid + '/' + this.cleanhousedata.rentId + '/' + this.cleanhousedata.housekeepername + '/' + this.cleanhousedata.typeKeeperid + '/' 
        + this.cleanhousedata.housekeepertel +'/' + empid ,null).subscribe(
        data => {
                console.log('PUT Code and repairs is successful', data);
                this.noti = false;
                this.notimag = 'บันทึกสำเสร็จ';
            },
            error => {
                this.noti = false;
                this.cleanhousedata = {};
                this.notimag = 'บันทึกไม่สำเสร็จ ข้อมูลผิดพลาด';
                console.log('------------Error----------', error);
                //window.location.reload();
            }

      );
    }
  }

}
