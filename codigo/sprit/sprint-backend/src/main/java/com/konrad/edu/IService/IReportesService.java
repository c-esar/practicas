package com.konrad.edu.IService;

import java.io.File;

public interface IReportesService {

    public String exportReport(String id, int historia, String documentoMedico);
    
    public String exportReportOcupacional(String id, int historia, String documentoMedico);
    
    public String exportReportCertificado(String id, int historia, String documentoMedico);

}
