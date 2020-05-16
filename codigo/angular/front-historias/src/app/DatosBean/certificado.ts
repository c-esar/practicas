import { Historias } from './historias';
export class Aseguradora {
    seqCertificado: number;
    datFechaCertificado: Date;
    nombre: string;
    numero: string;
    exaRealizados: string;
    medicoCertifica: string;
    tipoRestriccionLimitacion: string;
    Recomendaciones: string;
    controlEpidemiologica: string;
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
    }

}