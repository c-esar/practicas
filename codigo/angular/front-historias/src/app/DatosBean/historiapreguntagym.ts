import { TipoPreguntaHistoriaGym } from './tipopreguntahistoriagym';
export class HistoriaPreguntaGym {
    seqHistoriasPreguntasGym: number;
    tipoPreguntaHistoriaGymEntity: TipoPreguntaHistoriaGym;
    estadoPregunta: string;
    cantidad: number;
    tiempoFumando: string;
    despCuales: string;

    constructor() {
        this.seqHistoriasPreguntasGym = null;
        this.tipoPreguntaHistoriaGymEntity = new TipoPreguntaHistoriaGym();
        this.estadoPregunta = null;
        this.cantidad = null;
        this.tiempoFumando = null;
        this.despCuales = null;
    }
}