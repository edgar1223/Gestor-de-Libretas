import {
  AfterViewInit,
  ChangeDetectorRef,
  Component,
  ElementRef,
  HostListener,
  OnInit,
  ViewChild,
} from '@angular/core';
import { LibretasService } from '../services/libretas/libretas.service';
import { Libreta } from '../models/libreta';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements AfterViewInit,OnInit {
  @ViewChild('cardsWrapper', { static: false }) cardsWrapper!: ElementRef;
  showScrollLeft = false;

  showScrollRight = false;

  apiUrl=environment.apiImg;

  libretas:Libreta[]=[]

  constructor(private cdRef: ChangeDetectorRef,private  libretaService:LibretasService) {}

  ngOnInit(): void {
   this.cargarDatos();
  }
  cargarDatos(){
    this.libretaService.getLibro().subscribe(repuesta=>{
      this.libretas=repuesta;
    },error=>{console.error(error)})
  }
  ngAfterViewInit() {
    setTimeout(() => {
      this.updateScrollButtons();
    }, 0);
  }

  scrollRight() {
    const wrapper = this.cardsWrapper.nativeElement;
    wrapper.scrollBy({ left: 300, behavior: 'smooth' });
    setTimeout(() => this.updateScrollButtons(), 500);
  }

  scrollLeft() {
    const wrapper = this.cardsWrapper.nativeElement;
    wrapper.scrollBy({ left: -300, behavior: 'smooth' });
    setTimeout(() => this.updateScrollButtons(), 500);
  }

  updateScrollButtons() {
    const wrapper = this.cardsWrapper.nativeElement;

    const maxScrollLeft = wrapper.scrollWidth - wrapper.clientWidth;

    this.showScrollRight =
      wrapper.scrollWidth > wrapper.clientWidth &&
      wrapper.scrollLeft < maxScrollLeft;

    this.showScrollLeft = wrapper.scrollLeft > 0;

    this.cdRef.detectChanges();
  }

  @HostListener('window:resize', ['$event'])
  onResize() {
    this.updateScrollButtons();
  }

}
