package com.konrad.edu.IService;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;

public interface IReportesService {

    public String exportReport(String id);
    
    public String exportReportOcupacional(String id);

}
