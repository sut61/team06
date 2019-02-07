import { TestBed } from '@angular/core/testing';

import { ReqInternetService } from './req-internet.service';

describe('ReqInternetService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ReqInternetService = TestBed.get(ReqInternetService);
    expect(service).toBeTruthy();
  });
});
