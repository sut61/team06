import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class MangagePackageService {
  public API = '//localhost:8080/api';
  authenticatedemp = false;
  authenticatedclient = false;
  user: any;
  public name: any = '';
  public auth: boolean;
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
  getPackageIn(humeid: String, rentid: String): Observable<any>  {
      return this.http.get(this.API + '/manapackagein/'  + humeid + '/' + rentid);
  }
  savePackageOut(empid: String, recive: String, mpInId: String): Observable<any> {
      return this.http.post(this.API + '/packageout/'  + recive + '/' + empid + '/' + mpInId, {});
  }
  empLogin(username: String, password: String): Observable<any> {
     return this.http.post(this.API + '/employee/auth/' + username + '/' + password , {});
  }
  clientLogin(username: String, password: String): Observable<any> {
    return this.http.post(this.API + '/elient/auth/' + username + '/' + password , {});
 }
 getPackageInbyId(mpInid: any): Observable<any> {
    return this.http.get(this.API + '/managein/' + mpInid);
 }
 getRentHouseByHouseNumber(housenum: String): Observable<any> {
     return this.http.get(this.API + '/renthouses/' + housenum );
 }


}
