import { Injectable } from '@angular/core';
import { DatosSingleton } from '../DatosBean/datosSingleton';
import { of, Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { ConstantesService } from './constantes.service';
import { HistoriaLaboral } from '../DatosBean/historiaLaboral';
import { Historias } from '../DatosBean/historias';
import { Certificado } from '../DatosBean/certificado';
import { CertificadoGym } from '../DatosBean/certificadogym';
import { EmpresaLaboral } from '../DatosBean/empresaLaboral';
import { AntecedentesTrabajo } from '../DatosBean/antecedentesTrabajo';
import { EnfermedadesLaboral } from '../DatosBean/enfermedadesLaboral';
import { FactoresRiesgo } from '../DatosBean/factoresRiesgo';
import { TipoAntecedente } from '../DatosBean/tipoAntecedente';
import { TipoEvaluacion } from '../DatosBean/tipoEvaluacion';
import { TipoHistoria } from '../DatosBean/tipoHistoria';
import { Concepto } from '../DatosBean/concepto';
import { TipoPreguntaHistoriaGym } from '../DatosBean/tipopreguntahistoriagym';
import { DiagnosticoOcupacional } from '../DatosBean/diagnosticoOcupacional';
import { TipoUsuario } from '../DatosBean/tipoUsuario';
import { TipoCuestionario } from '../DatosBean/tipoCuestionario';
import { CondicionGym } from '../DatosBean/condiciongym';
import { familiarGym } from '../DatosBean/familiargym';
import Swal from 'sweetalert2';
import { catchError } from 'rxjs/operators';
import { HistoriaGym } from '../DatosBean/historiaGym';
import { TipoEvaluacionFisica } from '../DatosBean/TipoEvaluacionFisicaEntity';
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
    return this.http.post<Historias>(this.url + "historiaPaciente/crearHistoriaOcupacional", historias, { headers: this.httpHeaders });
  }

  getTipoAntecedente(): Observable<TipoAntecedente[]> {
    return this.http.get<TipoAntecedente[]>(this.url + "historiaLaboral/listTipoAntecedentes");
  }

  getConcepto(): Observable<Concepto[]> {
    return this.http.get<Concepto[]>(this.url + "historiaPaciente/listConcepto");
  }

  getImpresionDiagnostica(): Observable<DiagnosticoOcupacional[]> {
    return this.http.get<DiagnosticoOcupacional[]>(this.url + "historiaPaciente/listImpresionDiagnostica");
  }

  getTipoEvaluacion(): Observable<TipoEvaluacion[]> {
    return this.http.get<TipoEvaluacion[]>(this.url + "historiaPaciente/listTipoEvaluacion");
  }

  getTipoEvaluacionFisica(): Observable<TipoEvaluacionFisica[]> {
    return this.http.get<TipoEvaluacionFisica[]>(this.url + "historiaPaciente/listTipoEvaluacionFisica");
  }

  getTipoHistorias(): Observable<TipoHistoria[]> {
    return this.http.get<TipoHistoria[]>(this.url + "historiaPaciente/listTipoHistoria");
  }

  getTipoUsuario(): Observable<TipoUsuario[]> {
    return this.http.get<TipoUsuario[]>(this.url + "historiaPaciente/listTipoUsuario");
  }

  getTipoPreguntaHistoriaGym(): Observable<TipoPreguntaHistoriaGym[]> {
    return this.http.get<TipoPreguntaHistoriaGym[]>(this.url + "historiaPaciente/listTipoPreguntaHistoriaGym");
  }

  getTipoCuestionarioGym(): Observable<TipoCuestionario[]> {
    return this.http.get<TipoCuestionario[]>(this.url + "historiaPaciente/listTipoCuestionario");
  }

  getCondicionGym(): Observable<CondicionGym[]> {
    return this.http.get<CondicionGym[]>(this.url + "historiaPaciente/listCondicionGym");
  }

  getFamiliarGym(): Observable<familiarGym[]> {
    return this.http.get<familiarGym[]>(this.url + "historiaPaciente/listFamiliarGym");
  }

  createOcupacional(historia: Historias): Observable<Historias> {
    return this.http.post<Historias>(this.url + "historiaPaciente/crearHistoriaOcupacional", historia, { headers: this.httpHeaders }).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error al crear la persona', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  // crear certificado ocupacional
  createCertificado(certificado: Certificado): Observable<number> {
    return this.http.post<number>(this.url + "historiaPaciente/crearCertificado", certificado, { headers: this.httpHeaders }).pipe(
      map((resp: any) => resp as number)
      , catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error al crear Certificado', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  // buscar certificado ocupacional
  buscarCertificado(id: number): Observable<Certificado> {
    return this.http.get<Certificado>(`${this.url + "historiaPaciente/buscarCertificado"}/${id}`, { headers: this.httpHeaders }).pipe(
      map((resp: any) => resp.certificado as Certificado)
      ,catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error', 'no tiene certificado la historia', 'error');
        return throwError(e);
      })
    );
  }



    // crear certificado gym
    createCertificadoGym(certificado: CertificadoGym): Observable<number> {
      return this.http.post<number>(this.url + "historiaPaciente/crearCertificadoGym", certificado, { headers: this.httpHeaders }).pipe(
        map((resp: any) => resp as number)
        , catchError(e => {
          console.error(e.error.mensaje);
          Swal.fire('Error al crear Certificado', e.error.mensaje, 'error');
          return throwError(e);
        })
      );
    }
  
    // buscar certificado gym
    buscarCertificadoGym(id: number): Observable<CertificadoGym> {
      return this.http.get<CertificadoGym>(`${this.url + "historiaPaciente/buscarCertificadoGym"}/${id}`, { headers: this.httpHeaders }).pipe(
        map((resp: any) => resp.certificado as CertificadoGym)
        ,catchError(e => {
          console.error(e.error.mensaje);
          Swal.fire('Error', 'no tiene certificado la historia', 'error');
          return throwError(e);
        })
      );
    }
  createGym(historia: HistoriaGym): Observable<HistoriaGym> {
    return this.http.post<HistoriaGym>(this.url + "historiaPaciente/crearHistoriaGym", historia, { headers: this.httpHeaders }).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error al crear la persona', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  onBuscarPersonaPorHistoria(historia: number): Observable<Historias> {
    return this.http.get<Historias>(`${this.url + "historiaPaciente/buscarHistoriaPersona"}/${historia}`, { headers: this.httpHeaders }).pipe(
      map((resp: any) => resp.historia as Historias)
      , catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error', 'Error al obtener persona', 'error');
        return throwError(e);
      })
    );
  }
}
