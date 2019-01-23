import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagePackageDetailComponent } from './manage-package-detail.component';

describe('ManagePackageDetailComponent', () => {
  let component: ManagePackageDetailComponent;
  let fixture: ComponentFixture<ManagePackageDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagePackageDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagePackageDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
