import { Injectable } from '@angular/core';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { of, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ConstantesService {

  public url: string = 'http://localhost:8080/'; //desarrollo
  //public url: string = 'http://localhost:8080/'; produccion
  constructor() { }
}
