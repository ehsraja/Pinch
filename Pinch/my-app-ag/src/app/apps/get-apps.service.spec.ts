import { TestBed, inject } from '@angular/core/testing';

import { GetAppsService } from './get-apps.service';

describe('GetAppsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GetAppsService]
    });
  });

  it('should be created', inject([GetAppsService], (service: GetAppsService) => {
    expect(service).toBeTruthy();
  }));
});
