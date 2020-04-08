import { HistoriaPreguntaGym } from './historiapreguntagym';
import { Ciudad } from './ciudad';
import { ExamenFisico } from './examenFisico';
import { TipoHistoria } from './tipoHistoria';
import { DiagnosticoOcupacional } from './diagnosticoOcupacional';
import { CuestionarioGym } from './cuestionariogym';
import { CondicionGym } from './condiciongym';
import { familiarGym } from './familiargym';
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
    tipoCancer: string;
    otraFamiliar: string;
    conducta: string;
    cuestionarioGymEntity: CuestionarioGym[];
    condicionGymEntity: CondicionGym[];
    familiarGymEntity: familiarGym[];


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
        this.cuestionarioGymEntity = new Array<CuestionarioGym>();
        this.condicionGymEntity = new Array<CondicionGym>();
        this.familiarGymEntity = new Array<familiarGym>();
        this.tipoCancer = null;
        this.otraFamiliar = null;
    }
}