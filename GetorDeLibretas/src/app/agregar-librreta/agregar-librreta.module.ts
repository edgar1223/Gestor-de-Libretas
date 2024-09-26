import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AgregarLibrretaPageRoutingModule } from './agregar-librreta-routing.module';

import { AgregarLibrretaPage } from './agregar-librreta.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AgregarLibrretaPageRoutingModule
  ],
  declarations: [AgregarLibrretaPage]
})
export class AgregarLibrretaPageModule {}
