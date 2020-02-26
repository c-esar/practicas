import { Injectable } from '@angular/core';
import { Persona } from '../DatosBean/persona';
import { TipoDocumento } from '../DatosBean/tipoDocumento';
import { Ciudad } from '../DatosBean/ciudad';
import { Aseguradora } from '../DatosBean/aseguradora';
//import { personas } from '../lista-personas/personas.json';
import { of, Observable} from 'rxjs';
import{ HttpClient, HttpHeaders  } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private url: string = 'http://localhost:8080/';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(
    private http: HttpClient
  ) { }

  getPersonas():Observable<Persona[]>{
    //return of(personas);
    console.log(this.http.get<Persona[]>(this.url));
    return this.http.get<Persona[]>(this.url);
  }


  getTipoDocumento():Observable<TipoDocumento[]>{
    console.log(this.http.get<TipoDocumento[]>(this.url+"tipoDocumento/listTipoDocumento"));
    return this.http.get<TipoDocumento[]>(this.url+"tipoDocumento/listTipoDocumento");
  }

  getAseguradora():Observable<Aseguradora[]>{
    console.log(this.http.get<Aseguradora[]>(this.url+"aseguradora/listAseguradora"));
    return this.http.get<Aseguradora[]>(this.url+"aseguradora/listAseguradora");
  }

  getCiudad():Observable<Ciudad[]>{
    console.log(this.http.get<Ciudad[]>(this.url+"ciudad/listCiudad"));
    return this.http.get<Ciudad[]>(this.url+"ciudad/listCiudad");
  }

  create(persona: Persona):Observable<Persona>{
    return this.http.post<Persona>(this.url+"persona/crearPersona",persona,{headers: this.httpHeaders});
  }
}
