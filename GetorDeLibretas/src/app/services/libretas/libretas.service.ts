import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Libreta } from 'src/app/models/libreta';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class LibretasService {
  private apiUrl=environment.apiUrl;
  constructor(private http: HttpClient) { }
  
  getLibro():Observable<Libreta []>{
    return this.http.get<Libreta []>( `${this.apiUrl}libretas/1`)
  }
}
