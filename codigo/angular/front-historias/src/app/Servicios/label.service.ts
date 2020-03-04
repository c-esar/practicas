import { Injectable } from '@angular/core';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { of, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import {ConstantesService} from './constantes.service';
@Injectable({
  providedIn: 'root'
})
export class LabelService {

  private url: string = this.constante.url;
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private httpClient: HttpClient, private router: Router,
  private constante: ConstantesService) {

   }

   getLabel(): Observable<DatosSingleton> {
     return this.httpClient.get<DatosSingleton>(`${this.url+"login/labels"}`);
   }
}
