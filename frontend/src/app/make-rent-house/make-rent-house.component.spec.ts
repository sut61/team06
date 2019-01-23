import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeRentHouseComponent } from './make-rent-house.component';

describe('MakeRentHouseComponent', () => {
  let component: MakeRentHouseComponent;
  let fixture: ComponentFixture<MakeRentHouseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeRentHouseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeRentHouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
