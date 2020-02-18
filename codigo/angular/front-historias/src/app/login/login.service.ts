import { Injectable } from '@angular/core';
import { Login } from './login';
import { of, Observable} from 'rxjs';
import { HttpClient } from '@angular/common/http';
import {map } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class LoginService {

private url:string = 'http://localhost:';
  constructor(private http: HttpClient) { }

  getLogin(): Observable<Login> {
    return this.http.get(this.url).pipe(
      map( response => response as Login)
    );
  }
}
