import { Component, OnInit } from '@angular/core';
import { Team06Service } from './../team06.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-make-receipt',
  templateUrl: './make-receipt.component.html',
  styleUrls: ['./make-receipt.component.css']
})
export class MakeReceiptComponent implements OnInit {
  notimag: String;
  water: '';
  elec: '';
  mounth: Array<any>;
  clientname: Array<any>;
  meterchecker: '';
  slipt: '';
  constructor(private data: Team06Service,private httpClient: HttpClient) {
    this.data.ClientAll().subscribe(data => {this.clientname = data;})
    this.data.mounthAll().subscribe(data => {this.mounth = data;})
  }

  ngOnInit() {

  }
  save(){
  //    this.cid = JSON.parse(localStorage.getItem('client')).cid;
  //   if (this.water === undefined || this.elec === undefined
  //      || this.mounth === undefined || this.clientname === undefined || this.meterchecker === undefined
  //      || this.slipt === undefined) {  this.noti = false;
  //       this.notimag = 'บันทึกไม่สำเร็จ(กรุณากรอกข้อมูลให้ครบ)'   }
  //   else{
  //       this.httpClient.post('http://localhost:8080/insurance/save/'
  //       + this.cid + '/' + this.type + '/' + this.price + '/' + this.insuname, null).subscribe(
  //       data => {
  //         console.log('PUT Code and repairs is successful', data);
  //         this.noti = false;
  //         this.notimag = 'บันทึกสำเร็จ';
  //           },
  //           error => {
  //               console.log('------------Error----------', error);
  //               //window.location.reload();
  //           }

  //     );
  // }
  }
}
