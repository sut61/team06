import { TestBed } from '@angular/core/testing';

import { MangagePackageService } from './mangage-package.service';

describe('MangagePackageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MangagePackageService = TestBed.get(MangagePackageService);
    expect(service).toBeTruthy();
  });
});
