export class ArchivosFileHistoria {
    nombre: string;
    apellido: string;
    tipoDocumento: string;
    documento: string;
    tipoHistoria: string;
    FechaCita: Date;
    numeroHistoria: number;

    constructor(nombre, apellido, documento, tipoDocumento, tipoHistoria, fecha, numeroHistoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.tipoHistoria = tipoHistoria;
        this.FechaCita = fecha;
        this.numeroHistoria = numeroHistoria;
    }
}