import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsuranceTableComponent } from './insurance-table.component';

describe('InsuranceTableComponent', () => {
  let component: InsuranceTableComponent;
  let fixture: ComponentFixture<InsuranceTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsuranceTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsuranceTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
