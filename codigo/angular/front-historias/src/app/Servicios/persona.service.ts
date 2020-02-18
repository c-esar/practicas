import { Injectable } from '@angular/core';
import { Persona } from '../DatosBean/persona';
import { personas } from '../lista-personas/personas.json';
import { of, Observable} from 'rxjs';
import{ HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private url: string = 'http://localhost:8080/persona/listPersonas';

  constructor(
    private http: HttpClient
  ) { }

  getPersonas():Observable<Persona[]>{
    //return of(personas);
    console.log(this.http.get<Persona[]>(this.url));
    return this.http.get<Persona[]>(this.url);
  }
}
