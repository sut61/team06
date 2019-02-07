import { Component, OnInit } from '@angular/core';
import { Team06Service } from './../team06.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-make-receipt',
  templateUrl: './make-receipt.component.html',
  styleUrls: ['./make-receipt.component.css']
})
export class MakeReceiptComponent implements OnInit {
  noti: boolean;
  notimag: String;
  water: '';
  electricity: '';
  mounths: Array<any>;
  mid: '';
  clientname: Array<any>;
  cid: '';
  meterchecker: '';
  sliptid: '';
  houses: Array<any>;
  house: '';
  constructor(private data: Team06Service,private httpClient: HttpClient) {

  }

  ngOnInit() {
    this.data.ClientAll().subscribe(data => {this.clientname = data;})
    this.data.mounthAll().subscribe(data => {this.mounths = data;})
    this.data.HouseAll().subscribe(data => {this.houses = data; });

  }
  save() {
    if (this.water === undefined
    || this.electricity === undefined || this.mounths === undefined || this.clientname === undefined || this.houses === undefined
    || this.meterchecker === undefined
    || this.sliptid === undefined) {  this.noti = false;
      this.notimag = 'บันทึกไม่สำเร็จ(กรุณากรอกข้อมูลให้ครบ)'   }
    else {
       this.httpClient.post('http://localhost:8080/electricityandwater/save/'
       + this.water + '/' + this.electricity + '/' + this.mid + '/' + this.cid + '/' + this.house + '/'  + this.meterchecker
       + '/' + this.sliptid, null).subscribe(
        data => {
          console.log('PUT Code and repairs is successful', data);
          this.noti = false;
          this.notimag = 'บันทึกสำเร็จ';
            },
            error => {
                console.log('------------Error----------', error);
                //window.location.reload();
            }

     );
 }
}
}
