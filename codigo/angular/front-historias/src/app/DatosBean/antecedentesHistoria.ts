import { TipoAntecedente } from './tipoAntecedente';
export class AntecedentesHistoria {
  seqAntHistorias: number;
  tipoAntecedenteEntity: TipoAntecedente;
  estadoAntecedente: string;
  despAntecedente: string;
  frecuencia: string;
  tipo: string;
  exFumador: string;
  anosHabito: string;
  planificacion: string;
  ccv: string;
  fur: Date;
  menarquia: string;
  menarquiaGestaciones: string;
  menarquiaPartos: string;
  menarquiaCesarias: string;
  menarquiaAbortos: string;
  menarquiaVivos: string;
  constructor() {
    this.seqAntHistorias = null;
    this.tipoAntecedenteEntity = new TipoAntecedente();
    this.estadoAntecedente = null;
    this.frecuencia = null;
    this.despAntecedente = null;
    this.tipo = null;
    this.exFumador = null;
    this.anosHabito = null;
    this.planificacion = null;
    this.ccv = null;
    this.fur = null;
    this.menarquiaGestaciones = null;
    this.menarquiaPartos = null;
    this.menarquiaCesarias = null;
    this.menarquiaAbortos = null;
    this.menarquiaVivos = null;
    this.menarquia = null;
  }
}
