import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MakeReceiptComponent } from './make-receipt.component';

describe('MakeReceiptComponent', () => {
  let component: MakeReceiptComponent;
  let fixture: ComponentFixture<MakeReceiptComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MakeReceiptComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MakeReceiptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
