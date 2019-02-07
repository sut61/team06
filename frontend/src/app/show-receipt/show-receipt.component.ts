import { Team06Service } from './../team06.service';
import { Component, OnInit } from '@angular/core';
import { Observable, from } from 'rxjs';

@Component({
  selector: 'app-show-receipt',
  templateUrl: './show-receipt.component.html',
  styleUrls: ['./show-receipt.component.css']
})
export class ShowReceiptComponent implements OnInit {
  receipts: Array<any>;
  constructor(private data: Team06Service) {

  }

  ngOnInit() {
    this.data.ElectricityAndWaterReceiptAll().subscribe(data => {this.receipts = data;})


  }

}
