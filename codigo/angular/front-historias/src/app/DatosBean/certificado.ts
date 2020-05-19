import { Historias } from './historias';
import { TipoEvaluacion } from './tipoEvaluacion';
export class Certificado {
    seqCertificado: number;
    datFechaCertificado: Date;
    nombre: string;
    numero: string;
    exaRealizados: string;
    medicoCertifica: string;
    tipoRestriccionLimitacion: string;
    Recomendaciones: string;
    controlEpidemiologica: string;
    tipoEvaluacionEntity: TipoEvaluacion;
    otroEvaluacion: string;
    historiaOcupacionalEntity: Historias[];

    constructor() {
        this.seqCertificado = null;
        this.datFechaCertificado = new Date();
        this.nombre = null;
        this.numero = null;
        this.exaRealizados = null;
        this.medicoCertifica = null;
        this.tipoRestriccionLimitacion = null;
        this.Recomendaciones = null;
        this.controlEpidemiologica = null;
        this.historiaOcupacionalEntity = new Array<Historias>();
        this.tipoEvaluacionEntity = new TipoEvaluacion();
        this.otroEvaluacion = null;
    }

}