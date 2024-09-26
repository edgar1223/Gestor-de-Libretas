import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-card-libreta',
  templateUrl: './card-libreta.component.html',
  styleUrls: ['./card-libreta.component.scss'],
})
export class CardLibretaComponent  implements OnInit {

  @Input() imageUrl!: string;
  @Input() title!: string;
  @Input() subtitle!: string;
  constructor() { }
  ngOnInit(): void {
    console.log("hola")
  }

}
