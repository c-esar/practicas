import { Injectable } from '@angular/core';
import { Persona } from '../DatosBean/persona';
import { TipoDocumento } from '../DatosBean/tipoDocumento';
import { Ciudad } from '../DatosBean/ciudad';
import { Aseguradora } from '../DatosBean/aseguradora';
//import { personas } from '../lista-personas/personas.json';
import { of, Observable} from 'rxjs';
import{ HttpClient, HttpHeaders  } from '@angular/common/http';
import {ConstantesService} from './constantes.service';
@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private url: string = this.constante.url;
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(
    private http: HttpClient,private constante: ConstantesService
  ) { }

  getPersonas():Observable<Persona[]>{
    //return of(personas);
    console.log(this.http.get<Persona[]>(this.url));
    return this.http.get<Persona[]>(this.url);
  }


  getTipoDocumento():Observable<TipoDocumento[]>{
    return this.http.get<TipoDocumento[]>(this.url+"tipoDocumento/listTipoDocumento");
  }

  getAseguradora():Observable<Aseguradora[]>{
    return this.http.get<Aseguradora[]>(this.url+"aseguradora/listAseguradora");
  }

  getCiudad():Observable<Ciudad[]>{
    return this.http.get<Ciudad[]>(this.url+"ciudad/listCiudad");
  }

  create(persona: Persona):Observable<Persona>{
    return this.http.post<Persona>(this.url+"persona/crearPersona",persona,{headers: this.httpHeaders});
  }

  onBuscarDocumento(persona: Persona): Observable<Persona> {
    return this.http.get<Persona>(`${this.url+"persona/buscarDocumento"}/${persona.numeroDocumento}`, { headers: this.httpHeaders });
  }
}
