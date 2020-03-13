import {Persona} from './persona';
import {Permiso} from './permiso';
 export class Login{
  seqPerfil: number;
  nomUsuario: string;
  password: string;
  nomPerfil: string;
  estado: string;
  persona: Persona[];
  permisos: Permiso;

  constructor(){
    this.seqPerfil = null;
    this.nomUsuario= null;
    this.password= null;
    this.nomPerfil= null;
    this.estado= null;
    this.permisos = new Permiso();
    this.persona = new Array<Persona>();
  }

}
