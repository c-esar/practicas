package com.konrad.edu.IService;

import java.io.File;

public interface IReportesService {

    public String exportReport(String id, int historia);
    
    public File exportReportOcupacional(String id, int historia);
    
    public String exportReportCertificado(String id, int historia);

}
