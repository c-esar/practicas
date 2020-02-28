export class EnfermedadesLaboral{
  seqEnfermedadesLab: number;
	fechaAnt: Date;
	nomEmpresa:string;
	despDiagnostico:string;
	despRecomendaciones:string;
	despIndemnizar:string;

  constructor(){
    this.seqEnfermedadesLab =null;
    this.fechaAnt= new Date();
    this.nomEmpresa=null;
    this.despDiagnostico=null;
    this.despRecomendaciones=null;
    this.despIndemnizar=null;
  }
}
