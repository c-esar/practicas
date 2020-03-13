import { HistoriaLaboral } from './historiaLaboral';
import { TipoEvaluacion } from './tipoEvaluacion';
import { Ciudad } from './ciudad';
import { AntecedentesHistoria } from './antecedentesHistoria';
import { ExamenFisico } from './examenFisico';
import { TipoHistoria } from './tipoHistoria';
import { Paraclinicos } from './paraclinicos';
export class Historias {
  seqHistoria: number;
  historiaLaboral: HistoriaLaboral;
  examenFisico: ExamenFisico;
  antecedentesHistoriaEntity: AntecedentesHistoria[];
  paraclinicos: Paraclinicos[];
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
