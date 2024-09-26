import { Component, OnInit } from '@angular/core';
import { addIcons } from 'ionicons';
import { heart, logoApple, settingsSharp, star } from 'ionicons/icons';

@Component({
  selector: 'app-buton-add-libreta',
  templateUrl: './buton-add-libreta.component.html',
  styleUrls: ['./buton-add-libreta.component.scss'],
})
export class ButonAddLibretaComponent  implements OnInit {

  ngOnInit() {
    console.log("hola")
  }
  constructor() {
    /**
     * Any icons you want to use in your application
     * can be registered in app.component.ts and then
     * referenced by name anywhere in your application.
     */
    addIcons({ heart, logoApple, settingsSharp, star });
  }

}
