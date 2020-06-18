import { HistoriaGym } from './historiaGym';
import { TipoEvaluacionFisica } from './TipoEvaluacionFisicaEntity';
export class CertificadoGym {
    seqCertificado: number;
    datFechaCertificado: Date;
    nombre: string;
    numero: string;
    tipoRestriccionLimitacion: string;
    recomendaciones: string;
    tipoEvaluacionFisicaEntity: TipoEvaluacionFisica;
    seqHistoria: HistoriaGym;

    constructor() {
        this.seqCertificado = null;
        this.datFechaCertificado = new Date();
        this.nombre = null;
        this.numero = null;
        this.tipoRestriccionLimitacion = null;
        this.recomendaciones = null;
        this.seqHistoria = new HistoriaGym();
        this.tipoEvaluacionFisicaEntity = new TipoEvaluacionFisica();
    }
}