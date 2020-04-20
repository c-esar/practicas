export class ArchivosFileHistoria {
    nombre: string;
    apellido: string;
    tipoDocumento: string;
    documento: string;
    tipoHistoria: string;
    FechaCita: Date;

    constructor(nombre, apellido, documento, tipoDocumento, tipoHistoria, fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.tipoHistoria = tipoHistoria;
        this.FechaCita = fecha;
    }
}