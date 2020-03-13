import { TipoAntecedente } from './tipoAntecedente';
export class AntecedentesHistoria {
  seqAntHistorias: number;
  tipoAntecedenteEntity: TipoAntecedente;
  estadoAntecedente: string;
  despAntecedente: string;
  frecuencia: string;
  tipo: string;
  exFumador: string;
  anosHabito: number;

  constructor(){
    this.seqAntHistorias = null;
    this.tipoAntecedenteEntity= new TipoAntecedente();
    this.estadoAntecedente= null;
    this.frecuencia= null;
    this.despAntecedente= null;
    this.tipo= null;
    this.exFumador= null;
    this.anosHabito= null;
  }
}
