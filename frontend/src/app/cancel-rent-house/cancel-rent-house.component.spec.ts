import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelRentHouseComponent } from './cancel-rent-house.component';

describe('CancelRentHouseComponent', () => {
  let component: CancelRentHouseComponent;
  let fixture: ComponentFixture<CancelRentHouseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelRentHouseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelRentHouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
