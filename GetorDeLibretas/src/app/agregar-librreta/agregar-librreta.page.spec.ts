import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AgregarLibrretaPage } from './agregar-librreta.page';

describe('AgregarLibrretaPage', () => {
  let component: AgregarLibrretaPage;
  let fixture: ComponentFixture<AgregarLibrretaPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(AgregarLibrretaPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
