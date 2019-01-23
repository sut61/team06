import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagePackageMainComponent } from './manage-package-main.component';

describe('ManagePackageMainComponent', () => {
  let component: ManagePackageMainComponent;
  let fixture: ComponentFixture<ManagePackageMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagePackageMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagePackageMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
