import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TransportCarComponent } from './transport-car.component';

describe('TransportCarComponent', () => {
  let component: TransportCarComponent;
  let fixture: ComponentFixture<TransportCarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TransportCarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TransportCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
