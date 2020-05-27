import { TipoDocumento } from './tipoDocumento';
import { Ciudad } from './ciudad';
import { Aseguradora } from './aseguradora';
import { Localidad } from './localidad';
import { Historias } from './historias';
import { HistoriaGym } from './historiaGym';
import { TipoUsuario } from './tipoUsuario';
import { Login } from './login';
export class Persona {
  seqPersona: number;
  nomPrimerNombre: string;
  nomPrimerApellido: string;
  nomSegundoNombre: string;
  nomSegundoApellido: string;
  tipoDocumento: TipoDocumento;
  numeroDocumento: string;
  edad: number;
  direccion: string;
  telefono: string;
  correo: string;
  celular: string;
  fechaCreacion: Date;
  genero: string;
  estadoCivil: string;
  fechaNacimiento: string;
  lugarNacimiento: Ciudad;
  barrio: string;
  lugarDeResidencia: Ciudad;
  escolaridad: string;
  nomCargoDep: string;
  afp: string;
  arl: string;
  grupoSanguineo: string;
  rh: string;
  telEmergencia: string;
  nomEmergencia: string;
  parentescoEmergencia: string;
  aseguradora: Aseguradora;
  localidad: Localidad;
  historias: Historias[];
  historiaGym: HistoriaGym[];
  historiasGym: HistoriaGym[];
  rolUsuario: TipoUsuario[];
  codigo: string;
  nuevorolUsuario: string;
  imagen: string;
  historiaGymEncriptacion: HistoriaGym[];
  historiasEncriptacion: Historias[];
  licenciaSalud: string;
  perfil: Login;
  constructor() {
    this.seqPersona = null;
    this.nomPrimerNombre = null;
    this.nomPrimerApellido = null;
    this.nomSegundoNombre = null;
    this.nomSegundoApellido = null;
    this.numeroDocumento = null;
    this.edad = null;
    this.direccion = null;
    this.telefono = null;
    this.correo = null;
    this.celular = null;
    this.genero = null;
    this.estadoCivil = null;
    this.fechaNacimiento = null;
    this.barrio = null;
    this.escolaridad = null;
    this.nomCargoDep = null;
    this.afp = null;
    this.arl = null;
    this.grupoSanguineo = null;
    this.rh = null;
    this.telEmergencia = null;
    this.nomEmergencia = null;
    this.parentescoEmergencia = null;
    this.rolUsuario = new Array<TipoUsuario>();
    this.fechaCreacion = new Date();
    this.aseguradora = new Aseguradora();
    this.localidad = new Localidad();
    this.lugarNacimiento = new Ciudad();
    this.lugarDeResidencia = new Ciudad();
    this.tipoDocumento = new TipoDocumento();
    this.historias = new Array<Historias>();
    this.historiasGym = new Array<HistoriaGym>();
    this.historiaGym = new Array<HistoriaGym>();
    this.codigo = null;
    this.nuevorolUsuario = null;
    this.imagen = null;
    this.historiaGymEncriptacion = new Array<HistoriaGym>();
    this.historiasEncriptacion = new Array<Historias>();
    this.licenciaSalud = null;
    this.perfil = new Login();
  }
}
