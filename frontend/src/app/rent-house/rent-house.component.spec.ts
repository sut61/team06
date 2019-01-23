import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentHouseComponent } from './rent-house.component';

describe('RentHouseComponent', () => {
  let component: RentHouseComponent;
  let fixture: ComponentFixture<RentHouseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentHouseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentHouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
