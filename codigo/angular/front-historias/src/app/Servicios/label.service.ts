import { Injectable } from '@angular/core';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { of, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LabelService {

  private url: string = 'http://localhost:8080/';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private httpClient: HttpClient, private router: Router) {

   }

   getLabel(): Observable<DatosSingleton> {
     return this.httpClient.get<DatosSingleton>(`${this.url}/login/labels`);
   }
}
