import { TestBed } from '@angular/core/testing';

import { WorldServiceService } from './world-service.service';

describe('WorldServiceService', () => {
  let service: WorldServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(WorldServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
