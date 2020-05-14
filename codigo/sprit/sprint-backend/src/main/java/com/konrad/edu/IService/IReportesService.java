package com.konrad.edu.IService;

import java.io.File;

public interface IReportesService {

    public String exportReport(String id, int historia);
    
    public String exportReportOcupacional(String id, int historia);
    
    public String exportReportCertificado(String id, int historia);

}
