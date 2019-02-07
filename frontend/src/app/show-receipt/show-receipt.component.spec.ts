import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowReceiptComponent } from './show-receipt.component';

describe('ShowReceiptComponent', () => {
  let component: ShowReceiptComponent;
  let fixture: ComponentFixture<ShowReceiptComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowReceiptComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowReceiptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
