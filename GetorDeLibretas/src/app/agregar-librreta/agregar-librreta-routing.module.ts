import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AgregarLibrretaPage } from './agregar-librreta.page';

const routes: Routes = [
  {
    path: '',
    component: AgregarLibrretaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AgregarLibrretaPageRoutingModule {}
