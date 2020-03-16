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
  paraclinicos: Paraclinicos[];
  concepto: Concepto[];
  diagnosticoOcupacional: DiagnosticoOcupacional[];
  tipoEvaluacionEntity: TipoEvaluacion;
  ciudadHistoria: Ciudad;
  diaHistoria = new Date();
  despMotivoConsulta: string;
  revisionSistemas: string;
  recomMedicas: string;
  recomOcupacionales: string;
  recomHabitos: string;
  tipoHistoria: TipoHistoria;
  constructor() {
    this.historiaLaboral = new HistoriaLaboral();
    this.examenFisico = new ExamenFisico();
    this.antecedentesHistoriaEntity = new Array<AntecedentesHistoria>();
    this.paraclinicos = new Array<Paraclinicos>();
    this.concepto = new Array<Concepto>();
    this.diagnosticoOcupacional = new Array<DiagnosticoOcupacional>();
    this.tipoEvaluacionEntity = new TipoEvaluacion();
    this.ciudadHistoria = new Ciudad();
    this.diaHistoria = new Date();
    this.tipoHistoria = new TipoHistoria();
    this.despMotivoConsulta = null;
    this.revisionSistemas = null;
    this.recomMedicas = null;
    this.recomOcupacionales = null;
    this.recomHabitos = null;
  }
}
