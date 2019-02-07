import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
@Injectable({
  providedIn: 'root'
})
export class ReqInternetService {
   public API = '//localhost:8080/api';
   constructor(private http: HttpClient) { }
   getAllSpeedType(): Observable<any> {
      return this.http.get(this.API + '/typespeed');
   }
   getAllTimeTypeUse(): Observable<any> {
      return this.http.get(this.API + '/typeusenet');
   }
   checkValiUser(rentid: String, huusenum: String): Observable<any> {
     return this.http.get(this.API + '/checkrent/' +  rentid.trim() + '/' + huusenum.trim());
   }
   saveInterReq(netuser: String,
                netpass: String,
                empid: String,
                rentid: String,
                timetypeid: String,
                speedid: String
    ): Observable<any> {
     const url = '/requsetsave/' + netuser.trim() + '/' + netpass.trim() + '/' + empid + '/' + rentid + '/' + timetypeid + '/' + speedid;
     return this.http.post(this.API + url, {});
   }
   checkSpeed(typespeedid: String): Observable<any> {
      return this.http.get(this.API + '/checkspeed/' + typespeedid);
   }
}
