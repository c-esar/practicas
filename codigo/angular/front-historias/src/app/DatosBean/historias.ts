import { HistoriaLaboral } from './historiaLaboral';
export class Historias{
  	seqHistoria:number;
	  historiaLaboral: HistoriaLaboral;
    constructor(){
      this.seqHistoria = 0;
      this.historiaLaboral = new HistoriaLaboral();
    }
}
