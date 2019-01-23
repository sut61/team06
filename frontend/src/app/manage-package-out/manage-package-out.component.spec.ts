import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagePackageOutComponent } from './manage-package-out.component';

describe('ManagePackageOutComponent', () => {
  let component: ManagePackageOutComponent;
  let fixture: ComponentFixture<ManagePackageOutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagePackageOutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagePackageOutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
