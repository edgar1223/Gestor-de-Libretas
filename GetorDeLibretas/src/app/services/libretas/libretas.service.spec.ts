import { TestBed } from '@angular/core/testing';

import { LibretasService } from './libretas.service';

describe('LibretasService', () => {
  let service: LibretasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LibretasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
