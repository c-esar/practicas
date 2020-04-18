import { Injectable } from '@angular/core';
import { Login } from '../DatosBean/login';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Permiso } from '../DatosBean/permiso';
import { of, Observable, throwError } from 'rxjs';
import { ConstantesService } from './constantes.service';
import Swal from 'sweetalert2';
import { catchError } from 'rxjs/operators';
import { Persona } from '../DatosBean/persona';
@Injectable({
  providedIn: 'root'
})
export class LoginService implements CanActivate {

  private localStorageService: any;
  private currentSession: Login;
  private url: string = this.constante.url;
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  public isLogin: boolean;
  public login: Login;

  constructor(private httpClient: HttpClient, private router: Router,
    private constante: ConstantesService) {
    this.localStorageService = localStorage;
    this.currentSession = this.loadSessionData();
    this.login = new Login();
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    console.log("Valor CanActivate" + this.isAutorization());
    if (!this.isAutorization()) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }

  getLoginSesion(login: Login): Observable<Login> {
    return this.httpClient.get<Login>(`${this.url + "login/sesion"}/${login.nomUsuario}/${login.password}`, { headers: this.httpHeaders }).pipe(
      map((respuesta: any) => respuesta.persona as Login),
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error al obtener la persona', e.error.mensaje, 'error');
        return throwError(e);
      })
    );;
  }


  getObtenerPersona(id: String): Observable<Login> {
    debugger
    return this.httpClient.get(`${this.url + "login/obtenerPersona"}/${id}`, { headers: this.httpHeaders }).pipe(
      map( (respuesta: any) => respuesta.persona as Login),
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error al obtener la persona', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  create(persona: Login): Observable<Login> {
    return this.httpClient.post<Login>(this.url + "login/creacionUsuario", persona, { headers: this.httpHeaders }).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        Swal.fire('Error al crear la persona', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  obtenerPerfilSesion(): Login {
    this.login.permisos = new Array<Permiso>();
    this.login.permisos.push(new Permiso())
    this.login.persona = new Array<Persona>();
    this.login.persona.push(new Persona());
    this.login.nomUsuario = this.currentSession.nomUsuario
    this.login.estado = this.currentSession.estado
    this.login.persona = this.currentSession.persona;
    this.login.permisos[0].crearAux = this.currentSession.permisos[0].crearAux;
    this.login.permisos[0].crearUsuario = this.currentSession.permisos[0].crearUsuario;
    this.login.permisos[0].gestionarUsuario = this.currentSession.permisos[0].gestionarUsuario;
    this.login.permisos[0].descargar = this.currentSession.permisos[0].descargar;
    return this.login;
  }

  private isNotAutorizado(e): boolean {
    if (e.status == 401 || e.status == 404) {
      this.router.navigate(['/login']);
      return true;
    }
    return false;
  }


  public logOut(): void {
    this.removeCurrentSession();
  }

  loadSessionData(): Login {
    var sessionStr = this.localStorageService.getItem('currentUser');
    return (sessionStr) ? <Login>JSON.parse(sessionStr) : null;
  }

  setCurrentSession(session: Login): void {
    debugger
    this.currentSession = session;
    this.localStorageService.setItem('currentUser', JSON.stringify(session));
  }

  public isAutorization(): boolean {
    if (this.getCurrentSession() != null && this.getCurrentSession().nomUsuario != "" && this.getCurrentSession().nomUsuario != null) {
      return true;
    } else {
      return false;
    }
  }
  private getCurrentSession(): Login {
    return this.currentSession;
  }

  public correctLogin(data: Login) {
    this.setCurrentSession(data);
  }

  private removeCurrentSession(): void {
    console.log("remover entre")
    this.localStorageService.removeItem('currentUser');
    this.currentSession = null;
    debugger
  }

}
