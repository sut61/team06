import { TestBed } from '@angular/core/testing';

import { Team06Service } from './team06.service';

describe('Team06Service', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Team06Service = TestBed.get(Team06Service);
    expect(service).toBeTruthy();
  });
});
