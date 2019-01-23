import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagePackageInComponent } from './manage-package-in.component';

describe('ManagePackageInComponent', () => {
  let component: ManagePackageInComponent;
  let fixture: ComponentFixture<ManagePackageInComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagePackageInComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagePackageInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
