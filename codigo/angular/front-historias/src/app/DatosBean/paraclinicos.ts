export class Paraclinicos{

  seqParaclinicos:number;
  despExamen:string;
  fecha:Date;
  despResultado:string;

  constructor(){
    this.seqParaclinicos = null;
    this.despExamen = null;
    this.fecha = new Date();
    this.despResultado = null;
  }

}