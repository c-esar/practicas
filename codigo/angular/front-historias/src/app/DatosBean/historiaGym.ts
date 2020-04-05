import { HistoriaPreguntaGym } from './historiapreguntagym';
import { Ciudad } from './ciudad';
import { ExamenFisico } from './examenFisico';
import { TipoHistoria } from './tipoHistoria';
import { DiagnosticoOcupacional } from './diagnosticoOcupacional';
export class HistoriaGym {
    seqHistoriaGym: number;
    seqTipoHistoria: TipoHistoria;
    examenFisico: ExamenFisico;
    ciudadHistoria: Ciudad;
    historiaPreguntasGyms: HistoriaPreguntaGym[];
    diagnosticoOcupacionalEntity: DiagnosticoOcupacional[];
    diaHistoriaGym: Date;
    observacionesHistoria: string;
    otraCondicion: string;
    conducta: string;

    constructor() {
        this.seqHistoriaGym = null;
        this.seqTipoHistoria = new TipoHistoria();
        this.examenFisico = new ExamenFisico();
        this.ciudadHistoria = new Ciudad();
        this.historiaPreguntasGyms = new Array<HistoriaPreguntaGym>();
        this.diagnosticoOcupacionalEntity = new Array<DiagnosticoOcupacional>();
        this.diaHistoriaGym = new Date();
        this.observacionesHistoria = null;
        this.otraCondicion = null;
        this.conducta = null;
    }
}