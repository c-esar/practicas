package com.konrad.edu.IService;

import java.io.FileNotFoundException;

import net.sf.jasperreports.engine.JRException;

public interface IReportesService {

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException;

}
