import { Injectable } from '@angular/core';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { of, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { ConstantesService } from './constantes.service';
import { HistoriaLaboral } from '../DatosBean/historiaLaboral';
import { Historias } from '../DatosBean/historias';
import { EmpresaLaboral } from '../DatosBean/empresaLaboral';
import { AntecedentesTrabajo } from '../DatosBean/antecedentesTrabajo';
import { EnfermedadesLaboral } from '../DatosBean/enfermedadesLaboral';
import { FactoresRiesgo } from '../DatosBean/factoresRiesgo';
import { TipoAntecedente} from '../DatosBean/tipoAntecedente';
import { Concepto} from '../DatosBean/concepto';
@Injectable({
  providedIn: 'root'
})
export class HistoriasService {

  private url: string = this.constante.url;
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient,
    private router: Router,
    private constante: ConstantesService) { }

  createEmpresa(empresaLaboral: EmpresaLaboral): Observable<EmpresaLaboral> {
    return this.http.post<EmpresaLaboral>(this.url + "historiaLaboral/createEmpresa", empresaLaboral, { headers: this.httpHeaders });
  }

  createAntecedentes(antecedentesTrabajo: AntecedentesTrabajo): Observable<AntecedentesTrabajo> {
    return this.http.post<AntecedentesTrabajo>(this.url + "historiaLaboral/createAntecedente", antecedentesTrabajo, { headers: this.httpHeaders });
  }

  createEnfermedades(enfermedadesLaboral: EnfermedadesLaboral): Observable<EnfermedadesLaboral> {
    return this.http.post<EnfermedadesLaboral>(this.url + "historiaLaboral/createEnfermedades", enfermedadesLaboral, { headers: this.httpHeaders });
  }

  createFactoresRiesgo(factoresRiesgo: FactoresRiesgo): Observable<FactoresRiesgo> {
    return this.http.post<FactoresRiesgo>(this.url + "historiaLaboral/createFactoresRiesgo", factoresRiesgo, { headers: this.httpHeaders });
  }

  createHistoriaLaboral(historiaLaboral: HistoriaLaboral): Observable<HistoriaLaboral> {
    return this.http.post<HistoriaLaboral>(this.url + "historiaLaboral/createHistoriaLaboral", historiaLaboral, { headers: this.httpHeaders });
  }

  createHistoria(historias: Historias): Observable<Historias> {
    return this.http.post<Historias>(this.url + "historiaPaciente/createHistoria", historias, { headers: this.httpHeaders });
  }

  getTipoAntecedente():Observable<TipoAntecedente[]>{
    return this.http.get<TipoAntecedente[]>(this.url+"historiaLaboral/listTipoAntecedentes");
  }

  getConcepto():Observable<Concepto[]>{
    return this.http.get<Concepto[]>(this.url+"historiaPaciente/listConcepto");
  }
}
