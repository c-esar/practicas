import { EmpresaLaboral } from './empresaLaboral';
import { AntecedentesTrabajo } from './antecedentesTrabajo';
import { EnfermedadesLaboral } from './enfermedadesLaboral';
import { FactoresRiesgo } from './factoresRiesgo';
export class HistoriaLaboral{
  seqHistoriaLaboral:number;
  nomEmpresa:string;
  actEconomica:string;
  fechaIngreso:Date;
  antiguedad:string;
  cargo:string;
  desp_funciones_cargo:string;
  empresaLaboral: EmpresaLaboral[];
  antecedentesTrabajo: AntecedentesTrabajo[];
  enfermedadesLaboral: EnfermedadesLaboral[];
  factoresRiesgo: FactoresRiesgo[];

  constructor(){
    this.seqHistoriaLaboral = null;
    this.nomEmpresa = null;
    this.actEconomica = null;
    this.fechaIngreso = new Date();
    this.antiguedad = null;
    this.cargo = null;
    this.desp_funciones_cargo = null;
    this.empresaLaboral = new Array<EmpresaLaboral>();
    this.antecedentesTrabajo = new Array<AntecedentesTrabajo>();
    this.enfermedadesLaboral = new Array<EnfermedadesLaboral>();
    this.factoresRiesgo = new Array<FactoresRiesgo>();
  }
}
