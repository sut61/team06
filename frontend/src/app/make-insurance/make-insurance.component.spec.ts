import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeInsuranceComponent } from './make-insurance.component';

describe('MakeInsuranceComponent', () => {
  let component: MakeInsuranceComponent;
  let fixture: ComponentFixture<MakeInsuranceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeInsuranceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeInsuranceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
