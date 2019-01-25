import { Component, OnInit } from '@angular/core';
import { Team06Service } from './../team06.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-make-insurance',
  templateUrl: './make-insurance.component.html',
  styleUrls: ['./make-insurance.component.css']
})
export class MakeInsuranceComponent implements OnInit {
  clientname: Array<any>;
  insuname: '';
  insu: Array<any>;
  insuprice: Array<any>;
  name: '';
  type: '';
  price: '';
  cid: '';
  constructor(private data: Team06Service,private httpClient: HttpClient) { }

  ngOnInit() {
    this.data.insuranceTypeAll().subscribe(data => {this.insu = data;})
    this.data.ClientAll().subscribe(data => {this.clientname = data;})
    console.log(this.type);
  }
  onSave() {
    console.log(this.type);
  }
  selectChange() {
    console.log(this.type);

    this.data.InsurancePriceSelectAll(this.type).subscribe(data => {this.insuprice = data;
       console.log(data);
    })
  }
  save(){
    this.cid = JSON.parse(localStorage.getItem('client')).cid;
    if (this.insuname === undefined ||this.clientname === undefined || this.insu === undefined
       || this.insuprice === undefined) {   alert('กรุณากรอกข้อมูลให้ครบถ้วน');   }
    else{
        this.httpClient.post('http://localhost:8080/insurance/save/'
        + this.cid + '/' + this.type + '/' + this.price + '/' + this.insuname, null).subscribe(
        data => {
                console.log('PUT Code and renthouse is successful', data);
            },
            error => {
                console.log('------------Error----------', error);
                window.location.reload();
            }

      );
  }
  }
}
