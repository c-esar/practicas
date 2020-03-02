package com.konrad.edu.entity;

import java.io.Serializable;

import com.konrad.edu.IService.IConstantes;

public class LabelConstantes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String labelPrimerNombre;
	private String labelSegundoNombre;
	private String labelPrimerApellido;
	private String labelSegundoApellido;
	private String labeledad;
	private String labelNoDocumento;
	private String labelTipoDocumento;
	private String labelGenero;
	private String labelFechaNacimiento;
	private String labelLugarDeNacimiento;
	private String labelEstadoCivil;
	private String labelEscolaridad;
	private String labelCargoDependencia;
	private String labelDireccionCasa;
	private String labelTelefono;
	private String labelAseguradora;
	private String labelAFP;
	private String labelARL;

	private String labelCuidad;
	private String labelDepartamento;
	private String labelFechaHistoriaClinica;
	private String labelIngreso;
	private String labelPeriodico;
	private String labelEgreso;
	private String labelOtroEvaluacion;
	private String menuOcupacionalDatosPrincipales;
	private String menuOcupacionalHistoriaLaboral;
	private String menusubmenuOcupacionalHistoriaLTrabajoAC;

	// historia laboral
	private String labelNombreEmpresa;
	private String labelActividadEconomica;
	private String labelFechaIngreso;
	private String labelAntiguo;
	private String labelCargo;
	private String labelDescripcionTareasFuncion;
	private String menusubmenuOcupacionalHistoriaLTrabajoPre;
	private String tablaTrabajoPreLabelEmpresa;
	private String tablaTrabajoPreLabelCargOficina;
	private String tablaTrabajoPreLabelTimepo;
	private String menusubmenuOcupacionalHistoriaLAntecedentesTrabajo;
	private String labelSNaccidentesTrabajo;
	private String tablaEnfermedadesFecha;
	private String tablaEnfermedadesEmpresa;
	private String tablaEnfermedadesCausa;
	private String tablaEnfermedadesTipoLesion;
	private String tablaEnfermedadesIncapacidad;
	private String tablaEnfermedadesSecuelas  ;
	private String labelTieneEnfermedad  ;
	private String tablaEnfermedadesDiagnostico  ;
	private String tablaEnfermedadesRecomendaciones;
	private String tablaEnfermedadesIndemnizacion;
	private String labelSI;
	private String labelNO;
	private String tablaFactoresFactoresRiesgo;
	private String tablaFactoresTiempo;
	private String tablaFactoresMedidasControl  ;
	private String labelMotivacionDeConsulta;
	private String labelAntecedentes;
	private String menuSubmenuOcupacionalHistoriaLaboralFactoresRiesgo;

	public LabelConstantes() {
		this.labelPrimerNombre = IConstantes.LABEL_PRIMER_NOMBRE;
		this.labelSegundoNombre = IConstantes.LABEL_SEGUNDO_NOMBRE;
		this.labelPrimerApellido = IConstantes.LABEL_PRIMER_APELLIDO;
		this.labelSegundoApellido = IConstantes.LABEL_SEGUNDO_APELLIDO;
		this.labeledad = IConstantes.LABEL_EDAD;
		this.labelNoDocumento = IConstantes.LABEL_NODOCUMENTO;
		this.labelTipoDocumento = IConstantes.LABEL_TIPO_DOCUMENTO;
		this.labelGenero = IConstantes.LABEL_GENERO;
		this.labelFechaNacimiento = IConstantes.LABEL_FECHA_NACIMIENTO;
		this.labelLugarDeNacimiento = IConstantes.LABEL_LUGAR_DENACIMIENTO;
		this.labelEstadoCivil = IConstantes.LABEL_ESTADO_CIVIL;
		this.labelEscolaridad = IConstantes.LABEL_ESCOLARIDAD;
		this.labelCargoDependencia = IConstantes.LABEL_CARGO_DEPENDENCIA;
		this.labelDireccionCasa = IConstantes.LABEL_DIRECCION_CASA;
		this.labelTelefono = IConstantes.LABEL_TELEFONO;
		this.labelAseguradora = IConstantes.LABEL_ASEGURADORA;
		this.labelAFP = IConstantes.LABEL_AFP;
		this.labelARL = IConstantes.LABEL_ARL;
		this.labelCuidad = IConstantes.LABEL_CIUDAD;
		this.labelDepartamento = IConstantes.LABEL_DEPARTAMENTO;
		this.labelFechaHistoriaClinica = IConstantes.LABEL_FECHA_HISTORIACLINICA;
		this.labelIngreso = IConstantes.LABEL_INGRESO;
		this.labelPeriodico = IConstantes.LABEL_PERIODICO;
		this.labelEgreso = IConstantes.LABEL_EGRESO;
		this.labelOtroEvaluacion = IConstantes.LABEL_OTRO_EVALUACION;
		this.menuOcupacionalDatosPrincipales = IConstantes.MENU_OCUPACIONAL_DATOSPRINCIPALES;
		this.menuOcupacionalHistoriaLaboral = IConstantes.MENU_OCUPACIONAL_HISTORIA_LABORAL;
		this.menusubmenuOcupacionalHistoriaLTrabajoAC = IConstantes.MENU_SUBMENU_OCUPACIONAL_HISTORIA_LABORAL_TRABAJOAC;
		this.labelNombreEmpresa = IConstantes.LABEL_NOMBRE_EMPRESA;
		this.labelActividadEconomica = IConstantes.LABEL_ACTIVIDAD_ECONOMICA;
		this.labelFechaIngreso = IConstantes.LABEL_FECHA_INGRESO;
		this.labelAntiguo = IConstantes.LABEL_ANTIGUO;
		this.labelCargo = IConstantes.LABEL_CARGO;
		this.labelDescripcionTareasFuncion = IConstantes.LABEL_DESCRIPCION_TAREAS_FUNCION;
		this.menusubmenuOcupacionalHistoriaLTrabajoPre = IConstantes.MENU_SUBMENU_OCUPACIONAL_HISTORIA_LABORAL_TRABAJOPRE;
		this.tablaTrabajoPreLabelEmpresa = IConstantes.TABLA_TRABAJOPRE_LABEL_EMPRESA;
		this.tablaTrabajoPreLabelCargOficina = IConstantes.TABLA_TRABAJOPRE_LABEL_CARGOOFICINA;
		this.tablaTrabajoPreLabelTimepo = IConstantes.TABLA_TRABAJOPRE_LABEL_TIEMPO;
		this.menusubmenuOcupacionalHistoriaLAntecedentesTrabajo = IConstantes.MENU_SUBMENU_OCUPACIONAL_HISTORIA_LABORAL_ANTECEDENTES_TRABAJO;
		this.labelSNaccidentesTrabajo = IConstantes.LABEL_SN_ACCIDENTES_TRABAJO;
		this.tablaEnfermedadesFecha = IConstantes.TABLA_ENFERMEDADES_FECHA;
		this.tablaEnfermedadesEmpresa = IConstantes.TABLA_ENFERMEDADES_EMPRESA;
		this.tablaEnfermedadesCausa = IConstantes.TABLA_ENFERMEDADES_CAUSA;
		this.tablaEnfermedadesTipoLesion = IConstantes.TABLA_ENFERMEDADES_TIPO_LESION;
		this.tablaEnfermedadesIncapacidad = IConstantes.TABLA_ENFERMEDADES_INCAPACIDAD;
		this.tablaEnfermedadesSecuelas  = IConstantes.TABLA_ENFERMEDADES_SECUELAS;
		this.labelTieneEnfermedad = IConstantes.LABEL_TIENE_ENFERMEDAD ;
		this.tablaEnfermedadesDiagnostico = IConstantes.TABLA_ENFERMEDADES_DIAGNOSTICO ;
		this.tablaEnfermedadesRecomendaciones = IConstantes.TABLA_ENFERMEDADES_RECOMENDACIONES;
		this.tablaEnfermedadesIndemnizacion = IConstantes.TABLA_ENFERMEDADES_INDEMNIZACION;
		this.labelSI = IConstantes.LABEL_SI;
		this.labelNO = IConstantes.LABEL_NO;
		this.tablaFactoresFactoresRiesgo = IConstantes.TABLA_FACTORES_FACTORES_RIESGO;
		this.tablaFactoresTiempo = IConstantes.TABLA_FACTORES_TIEMPO;
		this.tablaFactoresMedidasControl = IConstantes.TABLA_FACTORES_MEDIDAS_CONTROL ;
		this.labelMotivacionDeConsulta = IConstantes.LABEL_MOTIVACION_DE_CONSULTA;
		this.labelAntecedentes = IConstantes.LABEL_ANTECEDENTES;
		this.menuSubmenuOcupacionalHistoriaLaboralFactoresRiesgo = IConstantes.MENU_SUBMENU_OCUPACIONAL_HISTORIA_LABORAL_FACTORES_RIESGO;
	}

	public String getLabelPrimerNombre() {
		return labelPrimerNombre;
	}

	public void setLabelPrimerNombre(String labelPrimerNombre) {
		this.labelPrimerNombre = labelPrimerNombre;
	}

	public String getLabelSegundoNombre() {
		return labelSegundoNombre;
	}

	public void setLabelSegundoNombre(String labelSegundoNombre) {
		this.labelSegundoNombre = labelSegundoNombre;
	}

	public String getLabelPrimerApellido() {
		return labelPrimerApellido;
	}

	public void setLabelPrimerApellido(String labelPrimerApellido) {
		this.labelPrimerApellido = labelPrimerApellido;
	}

	public String getLabelSegundoApellido() {
		return labelSegundoApellido;
	}

	public void setLabelSegundoApellido(String labelSegundoApellido) {
		this.labelSegundoApellido = labelSegundoApellido;
	}

	public String getLabeledad() {
		return labeledad;
	}

	public void setLabeledad(String labeledad) {
		this.labeledad = labeledad;
	}

	public String getLabelNoDocumento() {
		return labelNoDocumento;
	}

	public void setLabelNoDocumento(String labelNoDocumento) {
		this.labelNoDocumento = labelNoDocumento;
	}

	public String getLabelTipoDocumento() {
		return labelTipoDocumento;
	}

	public void setLabelTipoDocumento(String labelTipoDocumento) {
		this.labelTipoDocumento = labelTipoDocumento;
	}

	public String getLabelGenero() {
		return labelGenero;
	}

	public void setLabelGenero(String labelGenero) {
		this.labelGenero = labelGenero;
	}

	public String getLabelFechaNacimiento() {
		return labelFechaNacimiento;
	}

	public void setLabelFechaNacimiento(String labelFechaNacimiento) {
		this.labelFechaNacimiento = labelFechaNacimiento;
	}

	public String getLabelLugarDeNacimiento() {
		return labelLugarDeNacimiento;
	}

	public void setLabelLugarDeNacimiento(String labelLugarDeNacimiento) {
		this.labelLugarDeNacimiento = labelLugarDeNacimiento;
	}

	public String getLabelEstadoCivil() {
		return labelEstadoCivil;
	}

	public void setLabelEstadoCivil(String labelEstadoCivil) {
		this.labelEstadoCivil = labelEstadoCivil;
	}

	public String getLabelEscolaridad() {
		return labelEscolaridad;
	}

	public void setLabelEscolaridad(String labelEscolaridad) {
		this.labelEscolaridad = labelEscolaridad;
	}

	public String getLabelCargoDependencia() {
		return labelCargoDependencia;
	}

	public void setLabelCargoDependencia(String labelCargoDependencia) {
		this.labelCargoDependencia = labelCargoDependencia;
	}

	public String getLabelDireccionCasa() {
		return labelDireccionCasa;
	}

	public void setLabelDireccionCasa(String labelDireccionCasa) {
		this.labelDireccionCasa = labelDireccionCasa;
	}

	public String getLabelTelefono() {
		return labelTelefono;
	}

	public void setLabelTelefono(String labelTelefono) {
		this.labelTelefono = labelTelefono;
	}

	public String getLabelAseguradora() {
		return labelAseguradora;
	}

	public void setLabelAseguradora(String labelAseguradora) {
		this.labelAseguradora = labelAseguradora;
	}

	public String getLabelAFP() {
		return labelAFP;
	}

	public void setLabelAFP(String labelAFP) {
		this.labelAFP = labelAFP;
	}

	public String getLabelARL() {
		return labelARL;
	}

	public void setLabelARL(String labelARL) {
		this.labelARL = labelARL;
	}

	public String getLabelCuidad() {
		return labelCuidad;
	}

	public void setLabelCuidad(String labelCuidad) {
		this.labelCuidad = labelCuidad;
	}

	public String getLabelDepartamento() {
		return labelDepartamento;
	}

	public void setLabelDepartamento(String labelDepartamento) {
		this.labelDepartamento = labelDepartamento;
	}

	public String getLabelFechaHistoriaClinica() {
		return labelFechaHistoriaClinica;
	}

	public void setLabelFechaHistoriaClinica(String labelFechaHistoriaClinica) {
		this.labelFechaHistoriaClinica = labelFechaHistoriaClinica;
	}

	public String getLabelIngreso() {
		return labelIngreso;
	}

	public void setLabelIngreso(String labelIngreso) {
		this.labelIngreso = labelIngreso;
	}

	public String getLabelPeriodico() {
		return labelPeriodico;
	}

	public void setLabelPeriodico(String labelPeriodico) {
		this.labelPeriodico = labelPeriodico;
	}

	public String getLabelEgreso() {
		return labelEgreso;
	}

	public void setLabelEgreso(String labelEgreso) {
		this.labelEgreso = labelEgreso;
	}

	public String getLabelOtroEvaluacion() {
		return labelOtroEvaluacion;
	}

	public void setLabelOtroEvaluacion(String labelOtroEvaluacion) {
		this.labelOtroEvaluacion = labelOtroEvaluacion;
	}

	public String getMenuOcupacionalDatosPrincipales() {
		return menuOcupacionalDatosPrincipales;
	}

	public void setMenuOcupacionalDatosPrincipales(String menuOcupacionalDatosPrincipales) {
		this.menuOcupacionalDatosPrincipales = menuOcupacionalDatosPrincipales;
	}

	public String getMenuOcupacionalHistoriaLaboral() {
		return menuOcupacionalHistoriaLaboral;
	}

	public void setMenuOcupacionalHistoriaLaboral(String menuOcupacionalHistoriaLaboral) {
		this.menuOcupacionalHistoriaLaboral = menuOcupacionalHistoriaLaboral;
	}

	public String getMenusubmenuOcupacionalHistoriaLTrabajoAC() {
		return menusubmenuOcupacionalHistoriaLTrabajoAC;
	}

	public void setMenusubmenuOcupacionalHistoriaLTrabajoAC(String menusubmenuOcupacionalHistoriaLTrabajoAC) {
		this.menusubmenuOcupacionalHistoriaLTrabajoAC = menusubmenuOcupacionalHistoriaLTrabajoAC;
	}

	public String getLabelNombreEmpresa() {
		return labelNombreEmpresa;
	}

	public void setLabelNombreEmpresa(String labelNombreEmpresa) {
		this.labelNombreEmpresa = labelNombreEmpresa;
	}

	public String getLabelActividadEconomica() {
		return labelActividadEconomica;
	}

	public void setLabelActividadEconomica(String labelActividadEconomica) {
		this.labelActividadEconomica = labelActividadEconomica;
	}

	public String getLabelFechaIngreso() {
		return labelFechaIngreso;
	}

	public void setLabelFechaIngreso(String labelFechaIngreso) {
		this.labelFechaIngreso = labelFechaIngreso;
	}

	public String getLabelAntiguo() {
		return labelAntiguo;
	}

	public void setLabelAntiguo(String labelAntiguo) {
		this.labelAntiguo = labelAntiguo;
	}

	public String getLabelCargo() {
		return labelCargo;
	}

	public void setLabelCargo(String labelCargo) {
		this.labelCargo = labelCargo;
	}

	public String getLabelDescripcionTareasFuncion() {
		return labelDescripcionTareasFuncion;
	}

	public void setLabelDescripcionTareasFuncion(String labelDescripcionTareasFuncion) {
		this.labelDescripcionTareasFuncion = labelDescripcionTareasFuncion;
	}

	public String getMenusubmenuOcupacionalHistoriaLTrabajoPre() {
		return menusubmenuOcupacionalHistoriaLTrabajoPre;
	}

	public void setMenusubmenuOcupacionalHistoriaLTrabajoPre(String menusubmenuOcupacionalHistoriaLTrabajoPre) {
		this.menusubmenuOcupacionalHistoriaLTrabajoPre = menusubmenuOcupacionalHistoriaLTrabajoPre;
	}

	public String getTablaTrabajoPreLabelEmpresa() {
		return tablaTrabajoPreLabelEmpresa;
	}

	public void setTablaTrabajoPreLabelEmpresa(String tablaTrabajoPreLabelEmpresa) {
		this.tablaTrabajoPreLabelEmpresa = tablaTrabajoPreLabelEmpresa;
	}

	public String getTablaTrabajoPreLabelCargOficina() {
		return tablaTrabajoPreLabelCargOficina;
	}

	public void setTablaTrabajoPreLabelCargOficina(String tablaTrabajoPreLabelCargOficina) {
		this.tablaTrabajoPreLabelCargOficina = tablaTrabajoPreLabelCargOficina;
	}

	public String getTablaTrabajoPreLabelTimepo() {
		return tablaTrabajoPreLabelTimepo;
	}

	public void setTablaTrabajoPreLabelTimepo(String tablaTrabajoPreLabelTimepo) {
		this.tablaTrabajoPreLabelTimepo = tablaTrabajoPreLabelTimepo;
	}

	public String getMenusubmenuOcupacionalHistoriaLAntecedentesTrabajo() {
		return menusubmenuOcupacionalHistoriaLAntecedentesTrabajo;
	}

	public void setMenusubmenuOcupacionalHistoriaLAntecedentesTrabajo(
			String menusubmenuOcupacionalHistoriaLAntecedentesTrabajo) {
		this.menusubmenuOcupacionalHistoriaLAntecedentesTrabajo = menusubmenuOcupacionalHistoriaLAntecedentesTrabajo;
	}

	
	public String getLabelSNaccidentesTrabajo() {
		return labelSNaccidentesTrabajo;
	}

	public void setLabelSNaccidentesTrabajo(String labelSNaccidentesTrabajo) {
		this.labelSNaccidentesTrabajo = labelSNaccidentesTrabajo;
	}

	public String getTablaEnfermedadesFecha() {
		return tablaEnfermedadesFecha;
	}

	public void setTablaEnfermedadesFecha(String tablaEnfermedadesFecha) {
		this.tablaEnfermedadesFecha = tablaEnfermedadesFecha;
	}

	public String getTablaEnfermedadesEmpresa() {
		return tablaEnfermedadesEmpresa;
	}

	public void setTablaEnfermedadesEmpresa(String tablaEnfermedadesEmpresa) {
		this.tablaEnfermedadesEmpresa = tablaEnfermedadesEmpresa;
	}

	public String getTablaEnfermedadesCausa() {
		return tablaEnfermedadesCausa;
	}

	public void setTablaEnfermedadesCausa(String tablaEnfermedadesCausa) {
		this.tablaEnfermedadesCausa = tablaEnfermedadesCausa;
	}

	public String getTablaEnfermedadesTipoLesion() {
		return tablaEnfermedadesTipoLesion;
	}

	public void setTablaEnfermedadesTipoLesion(String tablaEnfermedadesTipoLesion) {
		this.tablaEnfermedadesTipoLesion = tablaEnfermedadesTipoLesion;
	}

	public String getTablaEnfermedadesIncapacidad() {
		return tablaEnfermedadesIncapacidad;
	}

	public void setTablaEnfermedadesIncapacidad(String tablaEnfermedadesIncapacidad) {
		this.tablaEnfermedadesIncapacidad = tablaEnfermedadesIncapacidad;
	}

	public String getTablaEnfermedadesSecuelas() {
		return tablaEnfermedadesSecuelas;
	}

	public void setTablaEnfermedadesSecuelas(String tablaEnfermedadesSecuelas) {
		this.tablaEnfermedadesSecuelas = tablaEnfermedadesSecuelas;
	}

	public String getLabelTieneEnfermedad() {
		return labelTieneEnfermedad;
	}

	public void setLabelTieneEnfermedad(String labelTieneEnfermedad) {
		this.labelTieneEnfermedad = labelTieneEnfermedad;
	}

	public String getTablaEnfermedadesDiagnostico() {
		return tablaEnfermedadesDiagnostico;
	}

	public void setTablaEnfermedadesDiagnostico(String tablaEnfermedadesDiagnostico) {
		this.tablaEnfermedadesDiagnostico = tablaEnfermedadesDiagnostico;
	}

	public String getTablaEnfermedadesRecomendaciones() {
		return tablaEnfermedadesRecomendaciones;
	}

	public void setTablaEnfermedadesRecomendaciones(String tablaEnfermedadesRecomendaciones) {
		this.tablaEnfermedadesRecomendaciones = tablaEnfermedadesRecomendaciones;
	}

	public String getTablaEnfermedadesIndemnizacion() {
		return tablaEnfermedadesIndemnizacion;
	}

	public void setTablaEnfermedadesIndemnizacion(String tablaEnfermedadesIndemnizacion) {
		this.tablaEnfermedadesIndemnizacion = tablaEnfermedadesIndemnizacion;
	}

	
	public String getLabelSI() {
		return labelSI;
	}

	public void setLabelSI(String labelSI) {
		this.labelSI = labelSI;
	}

	public String getLabelNO() {
		return labelNO;
	}

	public void setLabelNO(String labelNO) {
		this.labelNO = labelNO;
	}

	
	public String getTablaFactoresFactoresRiesgo() {
		return tablaFactoresFactoresRiesgo;
	}

	public void setTablaFactoresFactoresRiesgo(String tablaFactoresFactoresRiesgo) {
		this.tablaFactoresFactoresRiesgo = tablaFactoresFactoresRiesgo;
	}

	public String getTablaFactoresTiempo() {
		return tablaFactoresTiempo;
	}

	public void setTablaFactoresTiempo(String tablaFactoresTiempo) {
		this.tablaFactoresTiempo = tablaFactoresTiempo;
	}

	public String getTablaFactoresMedidasControl() {
		return tablaFactoresMedidasControl;
	}

	public void setTablaFactoresMedidasControl(String tablaFactoresMedidasControl) {
		this.tablaFactoresMedidasControl = tablaFactoresMedidasControl;
	}

	public String getLabelMotivacionDeConsulta() {
		return labelMotivacionDeConsulta;
	}

	public void setLabelMotivacionDeConsulta(String labelMotivacionDeConsulta) {
		this.labelMotivacionDeConsulta = labelMotivacionDeConsulta;
	}

	public String getLabelAntecedentes() {
		return labelAntecedentes;
	}

	public void setLabelAntecedentes(String labelAntecedentes) {
		this.labelAntecedentes = labelAntecedentes;
	}

	@Override
	public String toString() {
		return "LabelConstantes [labelPrimerNombre=" + labelPrimerNombre + ", labelSegundoNombre=" + labelSegundoNombre
				+ ", labelPrimerApellido=" + labelPrimerApellido + ", labelSegundoApellido=" + labelSegundoApellido
				+ ", labeledad=" + labeledad + ", labelNoDocumento=" + labelNoDocumento + ", labelTipoDocumento="
				+ labelTipoDocumento + ", labelGenero=" + labelGenero + ", labelFechaNacimiento=" + labelFechaNacimiento
				+ ", labelLugarDeNacimiento=" + labelLugarDeNacimiento + ", labelEstadoCivil=" + labelEstadoCivil
				+ ", labelEscolaridad=" + labelEscolaridad + ", labelCargoDependencia=" + labelCargoDependencia
				+ ", labelDireccionCasa=" + labelDireccionCasa + ", labelTelefono=" + labelTelefono
				+ ", labelAseguradora=" + labelAseguradora + ", labelAFP=" + labelAFP + ", labelARL=" + labelARL
				+ ", labelCuidad=" + labelCuidad + ", labelDepartamento=" + labelDepartamento
				+ ", labelFechaHistoriaClinica=" + labelFechaHistoriaClinica + ", labelIngreso=" + labelIngreso
				+ ", labelPeriodico=" + labelPeriodico + ", labelEgreso=" + labelEgreso + ", labelOtroEvaluacion="
				+ labelOtroEvaluacion + ", menuOcupacionalDatosPrincipales=" + menuOcupacionalDatosPrincipales
				+ ", menuOcupacionalHistoriaLaboral=" + menuOcupacionalHistoriaLaboral
				+ ", menusubmenuOcupacionalHistoriaLTrabajoAC=" + menusubmenuOcupacionalHistoriaLTrabajoAC
				+ ", labelNombreEmpresa=" + labelNombreEmpresa + ", labelActividadEconomica=" + labelActividadEconomica
				+ ", labelFechaIngreso=" + labelFechaIngreso + ", labelAntiguo=" + labelAntiguo + ", labelCargo="
				+ labelCargo + ", labelDescripcionTareasFuncion=" + labelDescripcionTareasFuncion
				+ ", menusubmenuOcupacionalHistoriaLTrabajoPre=" + menusubmenuOcupacionalHistoriaLTrabajoPre
				+ ", tablaTrabajoPreLabelEmpresa=" + tablaTrabajoPreLabelEmpresa + ", tablaTrabajoPreLabelCargOficina="
				+ tablaTrabajoPreLabelCargOficina + ", tablaTrabajoPreLabelTimepo=" + tablaTrabajoPreLabelTimepo
				+ ", menusubmenuOcupacionalHistoriaLAntecedentesTrabajo="
				+ menusubmenuOcupacionalHistoriaLAntecedentesTrabajo + ", labelSNaccidentesTrabajo="
				+ labelSNaccidentesTrabajo + ", tablaEnfermedadesFecha=" + tablaEnfermedadesFecha
				+ ", tablaEnfermedadesEmpresa=" + tablaEnfermedadesEmpresa + ", tablaEnfermedadesCausa="
				+ tablaEnfermedadesCausa + ", tablaEnfermedadesTipoLesion=" + tablaEnfermedadesTipoLesion
				+ ", tablaEnfermedadesIncapacidad=" + tablaEnfermedadesIncapacidad + ", tablaEnfermedadesSecuelas="
				+ tablaEnfermedadesSecuelas + ", labelTieneEnfermedad=" + labelTieneEnfermedad
				+ ", tablaEnfermedadesDiagnostico=" + tablaEnfermedadesDiagnostico
				+ ", tablaEnfermedadesRecomendaciones=" + tablaEnfermedadesRecomendaciones
				+ ", tablaEnfermedadesIndemnizacion=" + tablaEnfermedadesIndemnizacion + "]";
	}



}
