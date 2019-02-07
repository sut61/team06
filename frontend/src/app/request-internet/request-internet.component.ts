import { Component, OnInit } from '@angular/core';
import { ReqInternetService } from '../service/req-internet.service';
@Component({
  selector: 'app-request-internet',
  templateUrl: './request-internet.component.html',
  styleUrls: ['./request-internet.component.css']
})
export class RequestInternetComponent implements OnInit {
  detail: any = {};
  reqinternet: any = {};
  timeType: Array<any>;
  TypeSpeed: Array<any>;
  state1: boolean;
  state2: boolean;
  noti: boolean;
  noti2: boolean;
  notimag: String;
  // page1 01
  // page2 10
  // page3 11
  constructor(private reqnet: ReqInternetService) { }

  ngOnInit() {
     this.state1 = true;
     this.state2 = false;
     this.noti = true;
     this.noti2 = true;
     this.reqnet.getAllSpeedType().subscribe(speed => {
      this.TypeSpeed = speed;
   }, error => {
      alert('get data error');
   });
   this.reqnet.getAllTimeTypeUse().subscribe(async timeuse => {
      timeuse.forEach((element , id) => {
          timeuse[id].time = element.timeType + ' ' + element.scaleTime.typeScale;
      });
          this.timeType = await timeuse;
          console.log(timeuse);
   });

  }
  onCheck() {
    const {rentid , houseNumber} = this.reqinternet;
      console.log(this.reqinternet);
      // this.submit = true;
      this.reqnet.checkValiUser(rentid, houseNumber).subscribe(check => {
          // console.log(check);
          if (check.found) {
            this.state1 = false;
            this.state2 = true;
            this.noti = true;
            this.notimag = '';
          } else {
            this.noti = false;
            this.notimag  = 'ไม่พบการเช่าที่ระบุบ';
          }
      }, error => {
            // console.log(error);
            this.noti = false;
            this.notimag  = 'ไม่พบการเช่าที่ระบุบ';
      });
  }
  onSave() {
     // this.submit = false;
     const empid = JSON.parse(localStorage.getItem('employee')).empId;
     const  { netname, netpassword, typeSpeedId, timeTypeId, rentid } = this.reqinternet;
     this.reqnet.saveInterReq(netname, netpassword, empid , rentid , timeTypeId, typeSpeedId).subscribe(res => {
          console.log(res);
          this.state1 = true;
          this.state2 = false;
          this.noti = false;
          this.notimag = 'บันทึกการขอใช้งานสำเร็จ';
          //  setTimeout(() => {
          //       this.noti = true;
          //       this.notimag = '';
          //  }, 1500);
          this.reqinternet  =  {};

     }, error => {
          // console.log('dasd');
          this.noti = false;
          this.state1 = false;
          this.state2 = true;
          this.notimag = 'error save data';
     });

  }
  speedCheck() {
    const  { netname, netpassword, typeSpeedId, timeTypeId, rentid } = this.reqinternet;
    if (netname && netpassword && typeSpeedId && timeTypeId) {
      this.reqnet.checkSpeed(typeSpeedId).subscribe(check => {
        if ( check.have ) {
            this.state1 = true;
            this.state2 = true;
            this.detail = {
                typeSpeed: this.TypeSpeed[typeSpeedId - 1].typeSpeed,
                timeType: this.timeType[timeTypeId - 1].timeType + ' ' + this.timeType[timeTypeId - 1].scaleTime.typeScale,
                housenumber: this.reqinternet.houseNumber,
                netuser: netname,
                netpass: netpassword
            };
            // console.log(this.TypeSpeed[typeSpeedId - 1]);
            console.log('have');
        } else {
            console.log('dont-have');
        }
      }, error => {
           console.log(error);
           this.noti2 = false;
           this.notimag  = 'ความเร็วเน็ตที่ต้องการหมดเเล้ว';
          //  setTimeout(() => {
          //       this.noti2 = true;
          //       this.notimag  = '';
          //  }, 1000);
      });
    } else {
            this.noti2 = false;
            this.notimag  = 'ใส่ข้อมูลไม่ครบ';
            setTimeout(() => {
                this.noti2 = true;
                this.notimag  = '';
            }, 1000);
    }
  }
}

