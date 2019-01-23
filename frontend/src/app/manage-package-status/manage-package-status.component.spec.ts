import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagePackageStatusComponent } from './manage-package-status.component';

describe('ManagePackageStatusComponent', () => {
  let component: ManagePackageStatusComponent;
  let fixture: ComponentFixture<ManagePackageStatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagePackageStatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagePackageStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
