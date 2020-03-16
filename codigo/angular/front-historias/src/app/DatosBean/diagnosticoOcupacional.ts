export class DiagnosticoOcupacional {

  seqDiagnostico: number;
  codDiagnostico: string;
  simDiagnostico: string;
  desDiagnostico: string;
  sexo: string;
  limInferior: string;
  limSuperior: string;
  afectacionPrincipal: string;
  obserDiagnostico: string;

  constructor() {
    this.seqDiagnostico = null;
    this.codDiagnostico = null;
    this.simDiagnostico = null;
    this.desDiagnostico = null;
    this.sexo = null;
    this.limInferior = null;
    this.limSuperior = null;
    this.afectacionPrincipal = null;
    this.obserDiagnostico = null;
  }
}
