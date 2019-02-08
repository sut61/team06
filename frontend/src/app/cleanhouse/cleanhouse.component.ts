import { Component, OnInit } from '@angular/core';
import { Team06Service } from '../team06.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-cleanhouse',
  templateUrl: './cleanhouse.component.html',
  styleUrls: ['./cleanhouse.component.css']
})
export class CleanHouseComponent implements OnInit {
  cleanhouse: Array<any>;
  cleanhouseType: Array<any>;
  

  houseid: number;
  renthouseid: number;
  
  constructor(private data: Team06Service,private httpClient: HttpClient) { }

  ngOnInit() {
    this.data.HouseAll().subscribe(data => {this.cleanhouse = data;})
    this.data.RentHouseAll().subscribe(data => {this.cleanhouseType = data;})
    
  }

  save(){
    if (this.houseid === undefined || this.renthouseid === undefined
        ) {   alert('กรุณากรอกข้อมูลให้ครบถ้วน');   }
    else{
        this.httpClient.post('http://localhost:8080/api/repair/save/'
        + this.houseid + '/' + this.renthouseid + '/' ,null).subscribe(
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
