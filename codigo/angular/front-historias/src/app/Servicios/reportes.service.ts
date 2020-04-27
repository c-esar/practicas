import { Injectable } from '@angular/core';
//import { personas } from '../lista-personas/personas.json';
import { of, Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConstantesService } from './constantes.service';
import Swal from 'sweetalert2';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ReportesService {

  private url: string = this.constante.url;
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(
    private http: HttpClient, private constante: ConstantesService
  ) { }

  onReporteHistoriasGym(id: String): Observable<any> {
    return this.http.get(this.url + "reportes/historiaGym");
  }
}
