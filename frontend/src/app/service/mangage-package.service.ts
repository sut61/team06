import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class MangagePackageService {
  public API = '//localhost:8080/api';
  constructor(private http: HttpClient) { }
  getHouseById(houseid: String): Observable<any> {
    return this.http.get(this.API + '/house/' + houseid);
  }
  getRentHouseById(renthouseid: String): Observable<any> {
    return this.http.get(this.API + '/renthouse/' + renthouseid);
  }
  getEmployeeById(empid: String): Observable<any> {
    return this.http.get(this.API + '/employee/' + empid);
  }
  getDeliverComById(delivercomid: String): Observable<any> {
    return this.http.get(this.API + '/delivercom/' + delivercomid);
  }
  getDeliverComAll(): Observable<any> {
    return this.http.get(this.API + '/delivercom');
  }
  savePackageIn(empid: String, packageid: String, delivercom: String, house: String): Observable<any> {
    return this.http.post(this.API + '/packagein/' + 1 + '/' + packageid + '/' + delivercom + '/' + house, {} );
  }
  getManageAll(): Observable<any> {
     return this.http.get(this.API + '/managepackinall' );
  }
  checkPackeIn(mpOut: String): Observable<any> {
      return this.http.get(this.API + '/manageout/' + mpOut);
  }
  getPackageIn(humeid: String): Observable<any>  {
      return this.http.get(this.API + '/manapackagein/'  + humeid);
  }
  savePackageOut(empid: String, recive: String, mpInId: String): Observable<any> {
      return this.http.post(this.API + '/packageout/'  + recive + '/' + empid + '/' + mpInId, {});
  }

}
