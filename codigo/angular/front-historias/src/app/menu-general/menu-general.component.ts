import { Component, OnInit } from '@angular/core';
import { DatosSingleton } from '../DatosBean/datosSingleton';

@Component({
  selector: 'app-menu-general',
  templateUrl: './menu-general.component.html',
  styleUrls: ['./menu-general.component.css']
})
export class MenuGeneralComponent implements OnInit {

  public datosSingleton: DatosSingleton;
  titulo = 'hola';


  constructor() { }

  ngOnInit(): void {
//    this.datosSingleton = {
//      usuario: 'Cesar Chacon',
//      tipoUsuario: 'Administrador'

//    };

}
}
