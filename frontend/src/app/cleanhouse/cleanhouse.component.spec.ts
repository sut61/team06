import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CleanHouseComponent } from './cleanhouse.component';

describe('CleanhouseComponent', () => {
  let component: CleanHouseComponent;
  let fixture: ComponentFixture<CleanHouseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CleanHouseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CleanHouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
