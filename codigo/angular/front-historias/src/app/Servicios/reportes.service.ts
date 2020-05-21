import { Injectable } from '@angular/core';
//import { personas } from '../lista-personas/personas.json';
import { of, Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConstantesService } from './constantes.service';
import Swal from 'sweetalert2';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ReportesService {

  private url: string = this.constante.url;
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(
    private http: HttpClient, private constante: ConstantesService
  ) { }

  onReporteHistoriasGym(id: String, historia: number): Observable<String> {
    return this.http.get<String>(`${this.url + "reportes/historiaGym"}/${id}/${historia}`, { headers: this.httpHeaders }).pipe(
      map( (resp: any) => resp.persona  as String),
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  onReporteHistoriasOcupacional(id: String,historia: number): Observable<String> {
    return this.http.get<String>(`${this.url + "reportes/historiaOcupacional"}/${id}/${historia}`, { headers: this.httpHeaders }).pipe(
      map( (resp: any) => resp.persona  as String)
      ,catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  onReporteHistoriasCertificado(id: number): Observable<String> {
    return this.http.get<String>(`${this.url + "reportes/certificado"}/${id}`, { headers: this.httpHeaders }).pipe(
      map( (resp: any) => resp.persona  as String)
      ,catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }
}
