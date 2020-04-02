import { HistoriaLaboral } from './historiaLaboral';
import { TipoEvaluacion } from './tipoEvaluacion';
import { Ciudad } from './ciudad';
import { AntecedentesHistoria } from './antecedentesHistoria';
import { ExamenFisico } from './examenFisico';
import { TipoHistoria } from './tipoHistoria';
import { Paraclinicos } from './paraclinicos';
import { Concepto } from './concepto';
import { DiagnosticoOcupacional} from'./diagnosticoOcupacional';
export class Historias {
  seqHistoria: number;
  historiaLaboral: HistoriaLaboral;
  examenFisico: ExamenFisico;
  antecedentesHistoriaEntity: AntecedentesHistoria[];
  paraclinicosEntity: Paraclinicos[];
  conceptoConcepto: Concepto[];
  diagnosticoOcupacionalEntity: DiagnosticoOcupacional[];
  tipoEvaluacionEntity: TipoEvaluacion;
  ciudadHistoria: Ciudad;
  diaHistoria = new Date();
  despMotivoConsulta: string;
  revisionSistemas: string;
  recomMedicas: string;
  recomOcupacionales: string;
  recomHabitos: string;
  seqTipoHistoria: TipoHistoria;
  otroEvaluacion: string;
  constructor() {
    this.seqHistoria = null;
    this.historiaLaboral = new HistoriaLaboral();
    this.examenFisico = new ExamenFisico();
    this.antecedentesHistoriaEntity = new Array<AntecedentesHistoria>();
    this.paraclinicosEntity = new Array<Paraclinicos>();
    this.conceptoConcepto = new Array<Concepto>();
    this.diagnosticoOcupacionalEntity = new Array<DiagnosticoOcupacional>();
    this.tipoEvaluacionEntity = new TipoEvaluacion();
    this.ciudadHistoria = new Ciudad();
    this.diaHistoria = new Date();
    this.seqTipoHistoria = new TipoHistoria();
    this.despMotivoConsulta = null;
    this.revisionSistemas = null;
    this.recomMedicas = null;
    this.recomOcupacionales = null;
    this.recomHabitos = null;
    this.otroEvaluacion= null;
  }
}
