import { Injectable } from '@angular/core';
import { Persona } from '../DatosBean/persona';
import { TipoDocumento } from '../DatosBean/tipoDocumento';
import { Ciudad } from '../DatosBean/ciudad';
import { Aseguradora } from '../DatosBean/aseguradora';
//import { personas } from '../lista-personas/personas.json';
import { of, Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConstantesService } from './constantes.service';
import Swal from 'sweetalert2';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private url: string = this.constante.url;
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(
    private http: HttpClient, private constante: ConstantesService
  ) { }

  getPersonas(): Observable<Persona[]> {
    //return of(personas);
    console.log(this.http.get<Persona[]>(this.url));
    return this.http.get<Persona[]>(this.url);
  }


  getTipoDocumento(): Observable<TipoDocumento[]> {
    return this.http.get<TipoDocumento[]>(this.url + "tipoDocumento/listTipoDocumento");
  }

  getAseguradora(): Observable<Aseguradora[]> {
    return this.http.get<Aseguradora[]>(this.url + "aseguradora/listAseguradora");
  }

  getCiudad(): Observable<Ciudad[]> {
    return this.http.get<Ciudad[]>(this.url + "ciudad/listCiudad");
  }

  create(persona: Persona): Observable<Persona> {
    return this.http.post<Persona>(this.url + "persona/crearPersona", persona, { headers: this.httpHeaders }).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error al crear la persona', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }



  update(persona: Persona): Observable<Persona> {
    return this.http.put<Persona>(this.url + "persona/actualizarPersonaDatos", persona, { headers: this.httpHeaders }).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error al crear la persona', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  onBuscarDocumento(persona: Persona): Observable<Persona> {
    return this.http.get<Persona>(`${this.url + "persona/buscarDocumento"}/${persona.numeroDocumento}`, { headers: this.httpHeaders }).pipe(
      catchError(e => {
        debugger
        console.error(e.error.mensaje);
        Swal.fire('Error', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  onInformePersonas(id: String): Observable<Persona[]> {
    return this.http.get<Persona[]>(`${this.url + "persona/listPersonas/informe/"}/${id}`, { headers: this.httpHeaders }).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }
}
