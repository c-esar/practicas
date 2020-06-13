import { Historias } from './historias';
export class Certificado {
    seqCertificado: number;
    datFechaCertificado: Date;
    nombre: string;
    numero: string;
    exaRealizados: string;
    medicoCertifica: string;
    tipoRestriccionLimitacion: string;
    recomendaciones: string;
    controlEpidemiologica: string;
    tipoEvaluacionEntity: string;
    otroEvaluacion: string;
    seqHistoria: Historias;

    constructor() {
        this.seqCertificado = null;
        this.datFechaCertificado = new Date();
        this.nombre = null;
        this.numero = null;
        this.exaRealizados = null;
        this.medicoCertifica = null;
        this.tipoRestriccionLimitacion = null;
        this.recomendaciones = null;
        this.controlEpidemiologica = null;
        this.seqHistoria = new Historias();
        this.tipoEvaluacionEntity = null;
        this.otroEvaluacion = null;
    }

}