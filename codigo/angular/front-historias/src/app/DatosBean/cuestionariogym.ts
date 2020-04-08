import { TipoCuestionario } from './tipoCuestionario';
export class CuestionarioGym {
    seqCuestionarioGym: number;
    tipoCuestionarioEntity: TipoCuestionario;
    estadoCuestionario: string;

    constructor() {
        this.seqCuestionarioGym = null;
        this.tipoCuestionarioEntity = new TipoCuestionario();
        this.estadoCuestionario = null;
    }
}