import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class Team06Service {

  constructor(private http: HttpClient) { }
  public API = '//localhost:8080';

  RentHouseAll(): Observable<any> {
    return this.http.get('//localhost:8080/renthouse');
  }

  RentHouseTypeAll(): Observable<any> {
    return this.http.get('//localhost:8080/renthousetype');
  }

  ClientAll(): Observable<any> {
    return this.http.get('//localhost:8080/client');
  }

  EmployeeAll(): Observable<any> {
    return this.http.get('//localhost:8080/employee');
  }

  HouseAll(): Observable<any> {
    return this.http.get('//localhost:8080/house');
  }
  FoodListAll(): Observable<any> {
    return this.http.get('//localhost:8080/FoodList');
  }


  EquipmentAll(): Observable<any> {
    return this.http.get('//localhost:8080/api/equipment');
  }

  FoodOrderAll(): Observable<any> {
    return this.http.get('//localhost:8080/FoodOrder');
  }


  insuranceTypeAll(): Observable<any> {
    return this.http.get('//localhost:8080/InsuranceType');
  }
  insurancePriceAll(): Observable<any> {
    return this.http.get('//localhost:8080/InsurancePrice');
  }
  InsurancePriceSelectAll(tid: String): Observable<any> {
    return this.http.get('//localhost:8080/InsurancePriceSelect/' + tid);
  }
  mounthAll(): Observable<any> {
    return this.http.get('//localhost:8080/Mounth');
  }
  canceltypeAll(): Observable<any> {
    return this.http.get('//localhost:8080/canceltype');
  }
  ElectricityAndWaterReceiptAll(): Observable<any> {
    return this.http.get('//localhost:8080/ElectricityAndWaterReceipt');
  }
  cancelrenthouseAll(): Observable<any> {
    return this.http.get('//localhost:8080/cancelrenthouse');
  }
  TransportationCarAll(): Observable<any> {
    return this.http.get('//localhost:8080/TransportationCar');
  }
  CarAll(): Observable<any> {
    return this.http.get('//localhost:8080/Car');
  }
  getTypeKeeperAll(): Observable<any> {
    return this.http.get('//localhost:8080/api/house-keeper-type');
 }

}
