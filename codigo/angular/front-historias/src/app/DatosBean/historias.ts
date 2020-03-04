import { HistoriaLaboral } from './historiaLaboral';
import { TipoEvaluacion } from './tipoEvaluacion';
import { Ciudad } from './ciudad';
import { AntecedentesHistoria } from './antecedentesHistoria';
import { ExamenFisico } from './examenFisico';
export class Historias {
  seqHistoria: number;
  historiaLaboral: HistoriaLaboral;
  examenFisico: ExamenFisico;
  antecedentesHistoriaEntity: AntecedentesHistoria[];
  tipoEvaluacionEntity: TipoEvaluacion;
  ciudadHistoria: Ciudad;
  diaHistoria = new Date();
  despMotivoConsulta: string;
  revisionSistemas: string;
  recomMedicas: string;
  recomOcupacionales: string;
  recomHabitos: string;
  constructor() {
    this.historiaLaboral = new HistoriaLaboral();
    this.examenFisico = new ExamenFisico();
    this.antecedentesHistoriaEntity = new Array<AntecedentesHistoria>();
    this.tipoEvaluacionEntity = new TipoEvaluacion();
    this.ciudadHistoria = new Ciudad();
    this.diaHistoria = new Date();
    this.despMotivoConsulta = null;
    this.revisionSistemas = null;
    this.recomMedicas = null;
    this.recomOcupacionales = null;
    this.recomHabitos = null;
  }
}
