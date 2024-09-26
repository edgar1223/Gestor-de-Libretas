import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import { FormsModule } from '@angular/forms';
import { HomePage } from './home.page';

import { HomePageRoutingModule } from './home-routing.module';
import { MenuComponent } from '../menu/menu.component';
import { CardLibretaComponent } from '../card-libreta/card-libreta.component';
import { ButonAddLibretaComponent } from '../buton-add-libreta/buton-add-libreta.component';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HomePageRoutingModule
  ],
  declarations: [
    HomePage,
    MenuComponent,
    CardLibretaComponent,
    ButonAddLibretaComponent
  ]
})
export class HomePageModule {}
