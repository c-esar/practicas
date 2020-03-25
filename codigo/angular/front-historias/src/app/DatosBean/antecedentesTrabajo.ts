export class AntecedentesTrabajo {
  seqAnt: number;
  fechaAnt: Date;
  nomEmpresa: string;
  despCaus: string;
  tipoLesion: string;
  parteAfectada: string;
  despIncapacidad: string;
  despSecuelas: string;

  constructor(){
    this.seqAnt = null;
    this.fechaAnt = null;
    this.nomEmpresa= null;
    this.despCaus= null;
    this.tipoLesion= null;
    this.parteAfectada= null;
    this.despIncapacidad= null;
    this.despSecuelas= null;
  }
}
