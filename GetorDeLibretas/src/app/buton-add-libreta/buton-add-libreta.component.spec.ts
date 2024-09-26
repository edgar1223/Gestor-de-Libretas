import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ButonAddLibretaComponent } from './buton-add-libreta.component';

describe('ButonAddLibretaComponent', () => {
  let component: ButonAddLibretaComponent;
  let fixture: ComponentFixture<ButonAddLibretaComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ButonAddLibretaComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(ButonAddLibretaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
