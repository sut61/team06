import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestInternetComponent } from './request-internet.component';

describe('RequestInternetComponent', () => {
  let component: RequestInternetComponent;
  let fixture: ComponentFixture<RequestInternetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestInternetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestInternetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
