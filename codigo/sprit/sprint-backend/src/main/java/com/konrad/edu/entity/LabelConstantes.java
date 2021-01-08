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

	private String labelCiudad;
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
	private String tablaEnfermedadesSecuelas;
	private String labelTieneEnfermedad;
	private String tablaEnfermedadesDiagnostico;
	private String tablaEnfermedadesRecomendaciones;
	private String tablaEnfermedadesIndemnizacion;
	private String labelSI;
	private String labelNO;
	private String tablaFactoresFactoresRiesgo;
	private String tablaFactoresTiempo;
	private String tablaFactoresMedidasControl;
	private String labelMotivacionDeConsulta;

	// PARTE 3
	private String labelAntecedentes;
	private String menuSubmenuOcupacionalHistoriaLaboralFactoresRiesgo;
	private String menuMotivoConsulta;
	private String labelAntecednetesPersonales;
	private String labelCualEs;
	private String labelPatologicos;
	private String labelQuirurgicos;
	private String labelFarmacologicos;
	private String labelAlergicos;
	private String labelTramauticos;
	private String labelToxicos;
	private String labelHospitalarios;
	private String lableInmunologicos;
	private String lableFamiliares;
	private String lableEstilosVida;
	private String lableTabaquismo;
	private String lableFrecuencia;
	private String lableHabito;
	private String lableExfumador;
	private String lableConsumoAlcohol;
	private String lableActividadFisica;
	private String lableTipo;
	private String lableActividadesExtra;
	private String lableRevisionSistemas;
	private String labelMenarquia;
	private String labelFur;
	private String labelPlanificacion;
	private String labelCcv;

	// parte 4
	private String menuExamenFisico;
	private String labelTesionArterial;
	private String labelFrecuenciaCardiaca;
	private String labelSat02;
	private String labelFrecuenciaRespiratoria;
	private String labelPeso;
	private String labelTalla;
	private String labelImc;
	private String labelLateralidad;
	private String labelCabezaCuello;
	private String labelTorax;
	private String labelAbdomen;
	private String labelGenitourinario;
	private String labelColumna;
	private String labelMiembrosSuperioresInferiores;
	private String labelOsteomuscular;
	private String labelNeurologico;
	private String labelPielFaneras;
	private String menuParaclinicos;
	private String labelExamen;
	private String labelFecha;
	private String labelResultado;

	// ULTIMA PARTE
	private String menuImpresionDiagnostico;
	private String menuConcepto;
	private String menuRecomendaciones;
	private String labelNuevo;
	private String lableCerrar;
	private String labelModaltrabajo;
	private String label_Modalaccidente;
	private String label_Modalenfermedades;
	private String label_eliminar;
	private String labelRecomendacionesMedicas;
	private String labelRecomendacinesOcupacionales;
	private String labelHabitos;

	// CONSTANTES
	private String actividadFisica;
	private String mensajeBarProgress;

	// separadores
	private String separadorPrincipal;
	private String separadorEvaluacion;

	// gym
	private String labelCodigo;
	private String labelGrupoSanguuineo;
	private String labelContactoEmergencia;
	private String labelParentesco;
	private String menuPersonal;
	private String despMenuPersonal;
	private String labelObservaciones;
	private String labelPreguntaEmbarazo;
	private String labelPreguntaFuma;
	private String labelPreguntaFumaCuantos;
	private String labelPreguntaFumaTiempo;
	private String labelPreguntaLicor;
	private String labelPreguntaLicorCuantas;
	private String labelPreguntaEjercicio;
	private String labelPreguntaEjercicioCual;
	private String labelPreguntaEjercicioCuantas;
	private String labelPreguntaEnergizantes;
	private String labelPreguntaEnergizanteCuantas;
	private String labelPreguntaSustancias;
	private String labelPreguntaSustanciasCuales;
	private String labelMenuFamiliar;
	private String despMenuFamiliar;
	private String menuCuestionario;
	private String despMenuCuestionario;
	private String parteFinal;
	private String ultimaParteGym;
	private String ultimaParteOcupacional;
	private String labelRh;
	private String tipoUsuario;
	private String labelConducta;
	private String labelItem;
	private String labelSiNo;
	private String labelCancer;
	private String labelTipoCancer;

	private String labelNombreAcompanante;
	private String labelTelefonoAcompanante;
	private String labelNombrePersonaResponsable;
	private String labelTelefonoPersonaResponsable;
	private String labelParentescoResponsable;
	private String labelTipoVinculacion;
	private String labelLocalidad;
	private String labelMunicipioResidencia;
	private String labelCelular;

	public LabelConstantes() {
		this.labelCelular = IConstantes.LABEL_CELULAR;
		this.labelNombreAcompanante = IConstantes.LABEL_NOMBRE_ACOMPANANTE;
		this.labelTelefonoAcompanante = IConstantes.LABEL_TELEFONO_ACOMPANANTE;
		this.labelNombrePersonaResponsable = IConstantes.LABEL_NOMBRE_PERSONA_RESPONSABLE;
		this.labelTelefonoPersonaResponsable = IConstantes.LABEL_TELEFONO_PERSONA_RESPONSABLE;
		this.labelParentescoResponsable = IConstantes.LABEL_PARENTESCO_RESPONSABLE;
		this.labelTipoVinculacion = IConstantes.LABEL_TIPO_VINVULACION;
		this.labelLocalidad = IConstantes.LABEL_LOCALIDAD;
		this.labelMunicipioResidencia = IConstantes.LABEL_MUNICIPIO_RESIDENCIA;

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
		this.labelCiudad = IConstantes.LABEL_CIUDAD;
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
		this.tablaEnfermedadesSecuelas = IConstantes.TABLA_ENFERMEDADES_SECUELAS;
		this.labelTieneEnfermedad = IConstantes.LABEL_TIENE_ENFERMEDAD;
		this.tablaEnfermedadesDiagnostico = IConstantes.TABLA_ENFERMEDADES_DIAGNOSTICO;
		this.tablaEnfermedadesRecomendaciones = IConstantes.TABLA_ENFERMEDADES_RECOMENDACIONES;
		this.tablaEnfermedadesIndemnizacion = IConstantes.TABLA_ENFERMEDADES_INDEMNIZACION;
		this.labelSI = IConstantes.LABEL_SI;
		this.labelNO = IConstantes.LABEL_NO;
		this.tablaFactoresFactoresRiesgo = IConstantes.TABLA_FACTORES_FACTORES_RIESGO;
		this.tablaFactoresTiempo = IConstantes.TABLA_FACTORES_TIEMPO;
		this.tablaFactoresMedidasControl = IConstantes.TABLA_FACTORES_MEDIDAS_CONTROL;
		this.labelMotivacionDeConsulta = IConstantes.LABEL_MOTIVACION_DE_CONSULTA;
		this.labelAntecedentes = IConstantes.LABEL_ANTECEDENTES;
		this.menuSubmenuOcupacionalHistoriaLaboralFactoresRiesgo = IConstantes.MENU_SUBMENU_OCUPACIONAL_HISTORIA_LABORAL_FACTORES_RIESGO;
		this.menuMotivoConsulta = IConstantes.MENU_MOTIVO_CONSULTA;
		this.labelAntecednetesPersonales = IConstantes.LABEL_ANTECEDENTES_PERSONALES;
		this.labelCualEs = IConstantes.LABEL_CUAL_ES;
		this.labelPatologicos = IConstantes.LABEL_PATOLOGICOS;
		this.labelQuirurgicos = IConstantes.LABEL_QUIRURGICOS;
		this.labelFarmacologicos = IConstantes.LABEL_FARMACOLOGICOS;
		this.labelAlergicos = IConstantes.LABEL_ALERGICOS;
		this.labelTramauticos = IConstantes.LABEL_TRAUMATICOS;
		this.labelToxicos = IConstantes.LABEL_TOXICOS;
		this.labelHospitalarios = IConstantes.LABEL_HOSPITALARIOS;
		this.lableInmunologicos = IConstantes.LABEL_INMUNOLOGICOS;
		this.lableFamiliares = IConstantes.LABEL_FAMILIARES;
		this.lableEstilosVida = IConstantes.LABEL_ESTILOS_VIDA;
		this.lableTabaquismo = IConstantes.LABEL_TABAQUISMO;
		this.lableFrecuencia = IConstantes.LABEL_FRECUENCIA;
		this.lableHabito = IConstantes.LABEL_HABITO;
		this.lableExfumador = IConstantes.LABEL_EXFUMADOR;
		this.lableConsumoAlcohol = IConstantes.LABEL_CONSUMO_ALCOHOL;
		this.lableActividadFisica = IConstantes.LABEL_ACTIVIDAD_FISICA;
		this.lableTipo = IConstantes.LABEL_TIPO;
		this.lableActividadesExtra = IConstantes.LABEL_ACTIVIDADES_ESTRA;
		this.lableRevisionSistemas = IConstantes.LABEL_REVISION_SISTEMAS;
		this.menuExamenFisico = IConstantes.MENU_EXAMEN_FISICO;
		this.labelTesionArterial = IConstantes.LABEL_TENSION_ARTERIAL;
		this.labelFrecuenciaCardiaca = IConstantes.LABEL_FRECUENCIA_CARDIACA;
		this.labelSat02 = IConstantes.LABEL_SAT02;
		this.labelFrecuenciaRespiratoria = IConstantes.LABEL_FRECUENCIA_RESPIRATORIA;
		this.labelPeso = IConstantes.LABEL_PESO;
		this.labelTalla = IConstantes.LABEL_TALLA;
		this.labelImc = IConstantes.LABEL_IMC;
		this.labelLateralidad = IConstantes.LABEL_LATERALIDAD;
		this.labelCabezaCuello = IConstantes.LABEL_CABEZA_CUELLO;
		this.labelTorax = IConstantes.LABEL_TORAX;
		this.labelAbdomen = IConstantes.LABEL_ABDOMEN;
		this.labelGenitourinario = IConstantes.LABEL_GENITOURINARIO;
		this.labelColumna = IConstantes.LABEL_COLUMNA;
		this.labelMiembrosSuperioresInferiores = IConstantes.LABEL_MIEMBROS_SUPERIORES_INFERIORES;
		this.labelOsteomuscular = IConstantes.LABEL_OSTEOMUSCULAR;
		this.labelNeurologico = IConstantes.LABEL_NEUROLOGICO;
		this.labelPielFaneras = IConstantes.LABEL_PIEL_FANERAS;
		this.menuParaclinicos = IConstantes.MENU_PARACLINICOS;
		this.labelExamen = IConstantes.LABEL_EXAMEN;
		this.labelFecha = IConstantes.LABEL_FECHA;
		this.labelResultado = IConstantes.LABEL_RESULTADO;
		this.menuImpresionDiagnostico = IConstantes.MENU_IMPRESION_DIAGNOSTICO;
		this.menuConcepto = IConstantes.MENU_CONCEPTO;
		this.menuRecomendaciones = IConstantes.MENU_RECOMENDACIONES;
		this.labelNuevo = IConstantes.LABEL_NUEVO;
		this.lableCerrar = IConstantes.LABEL_CERRAR;
		this.labelModaltrabajo = IConstantes.LABEL_MODALTRABAJO;
		this.label_Modalaccidente = IConstantes.LABEL_MODALACCIDENTE;
		this.label_Modalenfermedades = IConstantes.LABEL_MODALENFERMEDADES;
		this.label_eliminar = IConstantes.LABEL_ELIMINAR;
		this.labelMenarquia = IConstantes.LABEL_MENARQUIA;
		this.labelFur = IConstantes.LABEL_FUR;
		this.labelPlanificacion = IConstantes.LABEL_PLANIFICACION;
		this.labelCcv = IConstantes.LABEL_CCV;
		this.labelRecomendacionesMedicas = IConstantes.LABEL_RECOMENDACIONES_MEDICAS;
		this.labelRecomendacinesOcupacionales = IConstantes.LABEL_RECOMENDACIONES_OCUPACIONALES;
		this.labelHabitos = IConstantes.LABEL_HABITOS;
		this.actividadFisica = IConstantes.ACTIVIDAD_FISICA;
		this.separadorPrincipal = IConstantes.SEPARADOR_PRINCIPAL;
		this.separadorEvaluacion = IConstantes.SEPARADOR_EVALUACION;
		this.mensajeBarProgress = IConstantes.MENSAJE_BAR_PROGRESS;
		this.labelCodigo = IConstantes.LABEL_CODIGO;
		this.labelGrupoSanguuineo = IConstantes.LABEL_GRUPO_SANGUUINEO;
		this.labelContactoEmergencia = IConstantes.LABEL_CONTACTO_EMERGENCIA;
		this.labelParentesco = IConstantes.LABEL_PARENTESCO;
		this.menuPersonal = IConstantes.MENU_PERSONAL;
		this.despMenuPersonal = IConstantes.DESP_MENU_PERSONAL;
		this.labelObservaciones = IConstantes.LABEL_OBSERVACIONES;
		this.labelPreguntaEmbarazo = IConstantes.LABEL_PREGUNTA_EMBARAZO;
		this.labelPreguntaFuma = IConstantes.LABEL_PREGUNTA_FUMA;
		this.labelPreguntaFumaCuantos = IConstantes.LABEL_PREGUNTA_FUMA_CUANTOS;
		this.labelPreguntaFumaTiempo = IConstantes.LABEL_PREGUNTA_FUMA_TIEMPO;
		this.labelPreguntaLicor = IConstantes.LABEL_PREGUNTA_LICOR;
		this.labelPreguntaLicorCuantas = IConstantes.LABEL_PREGUNTA_LICOR_CUANTAS;
		this.labelPreguntaEjercicio = IConstantes.LABEL_PREGUNTA_EJERCICIO;
		this.labelPreguntaEjercicioCual = IConstantes.LABEL_PREGUNTA_EJERCICIO_CUAL;
		this.labelPreguntaEjercicioCuantas = IConstantes.LABEL_PREGUNTA_EJERCICIO_CUANTAS;
		this.labelPreguntaEnergizantes = IConstantes.LABEL_PREGUNTA_ENERGIZANTES;
		this.labelPreguntaEnergizanteCuantas = IConstantes.LABEL_PREGUNTA_ENERGIZANTE_CUANTAS;
		this.labelPreguntaSustancias = IConstantes.LABEL_PREGUNTA_SUSTANCIAS;
		this.labelPreguntaSustanciasCuales = IConstantes.LABEL_PREGUNTA_SUSTANCIAS_CUALES;
		this.labelMenuFamiliar = IConstantes.LABEL_MENU_FAMILIAR;
		this.despMenuFamiliar = IConstantes.DESP_MENU_FAMILIAR;
		this.menuCuestionario = IConstantes.MENU_CUESTIONARIO;
		this.despMenuCuestionario = IConstantes.DESP_MENU_CUESTIONARIO;
		this.parteFinal = IConstantes.PARTE_FINAL;
		this.ultimaParteGym = IConstantes.ULTIMA_PARTE_GYM;
		this.ultimaParteOcupacional = IConstantes.ULTIMA_PARTE_OCUPACIONAL;
		this.labelRh = IConstantes.LABEL_RH;
		this.tipoUsuario = IConstantes.TIPO_USUARIO;
		this.labelConducta = IConstantes.LABEL_CONDUCTA;
		this.labelItem = IConstantes.LABEL_ITEM;
		this.labelSiNo = IConstantes.LABEL_SI_NO;
		this.labelCancer = IConstantes.LABEL_CANCER;
		this.labelTipoCancer = IConstantes.LABEL_TIPO_CANCER;
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

	public String getMenuSubmenuOcupacionalHistoriaLaboralFactoresRiesgo() {
		return menuSubmenuOcupacionalHistoriaLaboralFactoresRiesgo;
	}

	public void setMenuSubmenuOcupacionalHistoriaLaboralFactoresRiesgo(
			String menuSubmenuOcupacionalHistoriaLaboralFactoresRiesgo) {
		this.menuSubmenuOcupacionalHistoriaLaboralFactoresRiesgo = menuSubmenuOcupacionalHistoriaLaboralFactoresRiesgo;
	}

	public String getMenuMotivoConsulta() {
		return menuMotivoConsulta;
	}

	public void setMenuMotivoConsulta(String menuMotivoConsulta) {
		this.menuMotivoConsulta = menuMotivoConsulta;
	}

	public String getLabelAntecednetesPersonales() {
		return labelAntecednetesPersonales;
	}

	public void setLabelAntecednetesPersonales(String labelAntecednetesPersonales) {
		this.labelAntecednetesPersonales = labelAntecednetesPersonales;
	}

	public String getLabelCualEs() {
		return labelCualEs;
	}

	public void setLabelCualEs(String labelCualEs) {
		this.labelCualEs = labelCualEs;
	}

	public String getLabelPatologicos() {
		return labelPatologicos;
	}

	public void setLabelPatologicos(String labelPatologicos) {
		this.labelPatologicos = labelPatologicos;
	}

	public String getLabelQuirurgicos() {
		return labelQuirurgicos;
	}

	public void setLabelQuirurgicos(String labelQuirurgicos) {
		this.labelQuirurgicos = labelQuirurgicos;
	}

	public String getLabelFarmacologicos() {
		return labelFarmacologicos;
	}

	public void setLabelFarmacologicos(String labelFarmacologicos) {
		this.labelFarmacologicos = labelFarmacologicos;
	}

	public String getLabelAlergicos() {
		return labelAlergicos;
	}

	public void setLabelAlergicos(String labelAlergicos) {
		this.labelAlergicos = labelAlergicos;
	}

	public String getLabelTramauticos() {
		return labelTramauticos;
	}

	public void setLabelTramauticos(String labelTramauticos) {
		this.labelTramauticos = labelTramauticos;
	}

	public String getLabelToxicos() {
		return labelToxicos;
	}

	public void setLabelToxicos(String labelToxicos) {
		this.labelToxicos = labelToxicos;
	}

	public String getLabelHospitalarios() {
		return labelHospitalarios;
	}

	public void setLabelHospitalarios(String labelHospitalarios) {
		this.labelHospitalarios = labelHospitalarios;
	}

	public String getLableInmunologicos() {
		return lableInmunologicos;
	}

	public void setLableInmunologicos(String lableInmunologicos) {
		this.lableInmunologicos = lableInmunologicos;
	}

	public String getLableFamiliares() {
		return lableFamiliares;
	}

	public void setLableFamiliares(String lableFamiliares) {
		this.lableFamiliares = lableFamiliares;
	}

	public String getLableEstilosVida() {
		return lableEstilosVida;
	}

	public void setLableEstilosVida(String lableEstilosVida) {
		this.lableEstilosVida = lableEstilosVida;
	}

	public String getLableTabaquismo() {
		return lableTabaquismo;
	}

	public void setLableTabaquismo(String lableTabaquismo) {
		this.lableTabaquismo = lableTabaquismo;
	}

	public String getLableFrecuencia() {
		return lableFrecuencia;
	}

	public void setLableFrecuencia(String lableFrecuencia) {
		this.lableFrecuencia = lableFrecuencia;
	}

	public String getLableHabito() {
		return lableHabito;
	}

	public void setLableHabito(String lableHabito) {
		this.lableHabito = lableHabito;
	}

	public String getLableExfumador() {
		return lableExfumador;
	}

	public void setLableExfumador(String lableExfumador) {
		this.lableExfumador = lableExfumador;
	}

	public String getLableConsumoAlcohol() {
		return lableConsumoAlcohol;
	}

	public void setLableConsumoAlcohol(String lableConsumoAlcohol) {
		this.lableConsumoAlcohol = lableConsumoAlcohol;
	}

	public String getLableActividadFisica() {
		return lableActividadFisica;
	}

	public void setLableActividadFisica(String lableActividadFisica) {
		this.lableActividadFisica = lableActividadFisica;
	}

	public String getLableTipo() {
		return lableTipo;
	}

	public void setLableTipo(String lableTipo) {
		this.lableTipo = lableTipo;
	}

	public String getLableActividadesExtra() {
		return lableActividadesExtra;
	}

	public void setLableActividadesExtra(String lableActividadesExtra) {
		this.lableActividadesExtra = lableActividadesExtra;
	}

	public String getLableRevisionSistemas() {
		return lableRevisionSistemas;
	}

	public void setLableRevisionSistemas(String lableRevisionSistemas) {
		this.lableRevisionSistemas = lableRevisionSistemas;
	}

	public String getMenuExamenFisico() {
		return menuExamenFisico;
	}

	public void setMenuExamenFisico(String menuExamenFisico) {
		this.menuExamenFisico = menuExamenFisico;
	}

	public String getLabelTesionArterial() {
		return labelTesionArterial;
	}

	public void setLabelTesionArterial(String labelTesionArterial) {
		this.labelTesionArterial = labelTesionArterial;
	}

	public String getLabelFrecuenciaCardiaca() {
		return labelFrecuenciaCardiaca;
	}

	public void setLabelFrecuenciaCardiaca(String labelFrecuenciaCardiaca) {
		this.labelFrecuenciaCardiaca = labelFrecuenciaCardiaca;
	}

	public String getLabelSat02() {
		return labelSat02;
	}

	public void setLabelSat02(String labelSat02) {
		this.labelSat02 = labelSat02;
	}

	public String getLabelFrecuenciaRespiratoria() {
		return labelFrecuenciaRespiratoria;
	}

	public void setLabelFrecuenciaRespiratoria(String labelFrecuenciaRespiratoria) {
		this.labelFrecuenciaRespiratoria = labelFrecuenciaRespiratoria;
	}

	public String getLabelPeso() {
		return labelPeso;
	}

	public void setLabelPeso(String labelPeso) {
		this.labelPeso = labelPeso;
	}

	public String getLabelTalla() {
		return labelTalla;
	}

	public void setLabelTalla(String labelTalla) {
		this.labelTalla = labelTalla;
	}

	public String getLabelImc() {
		return labelImc;
	}

	public void setLabelImc(String labelImc) {
		this.labelImc = labelImc;
	}

	public String getLabelLateralidad() {
		return labelLateralidad;
	}

	public void setLabelLateralidad(String labelLateralidad) {
		this.labelLateralidad = labelLateralidad;
	}

	public String getLabelCabezaCuello() {
		return labelCabezaCuello;
	}

	public void setLabelCabezaCuello(String labelCabezaCuello) {
		this.labelCabezaCuello = labelCabezaCuello;
	}

	public String getLabelTorax() {
		return labelTorax;
	}

	public void setLabelTorax(String labelTorax) {
		this.labelTorax = labelTorax;
	}

	public String getLabelAbdomen() {
		return labelAbdomen;
	}

	public void setLabelAbdomen(String labelAbdomen) {
		this.labelAbdomen = labelAbdomen;
	}

	public String getLabelGenitourinario() {
		return labelGenitourinario;
	}

	public void setLabelGenitourinario(String labelGenitourinario) {
		this.labelGenitourinario = labelGenitourinario;
	}

	public String getLabelColumna() {
		return labelColumna;
	}

	public void setLabelColumna(String labelColumna) {
		this.labelColumna = labelColumna;
	}

	public String getLabelMiembrosSuperioresInferiores() {
		return labelMiembrosSuperioresInferiores;
	}

	public void setLabelMiembrosSuperioresInferiores(String labelMiembrosSuperioresInferiores) {
		this.labelMiembrosSuperioresInferiores = labelMiembrosSuperioresInferiores;
	}

	public String getLabelOsteomuscular() {
		return labelOsteomuscular;
	}

	public void setLabelOsteomuscular(String labelOsteomuscular) {
		this.labelOsteomuscular = labelOsteomuscular;
	}

	public String getLabelNeurologico() {
		return labelNeurologico;
	}

	public void setLabelNeurologico(String labelNeurologico) {
		this.labelNeurologico = labelNeurologico;
	}

	public String getLabelPielFaneras() {
		return labelPielFaneras;
	}

	public void setLabelPielFaneras(String labelPielFaneras) {
		this.labelPielFaneras = labelPielFaneras;
	}

	public String getMenuParaclinicos() {
		return menuParaclinicos;
	}

	public void setMenuParaclinicos(String menuParaclinicos) {
		this.menuParaclinicos = menuParaclinicos;
	}

	public String getLabelExamen() {
		return labelExamen;
	}

	public void setLabelExamen(String labelExamen) {
		this.labelExamen = labelExamen;
	}

	public String getLabelFecha() {
		return labelFecha;
	}

	public void setLabelFecha(String labelFecha) {
		this.labelFecha = labelFecha;
	}

	public String getLabelResultado() {
		return labelResultado;
	}

	public void setLabelResultado(String labelResultado) {
		this.labelResultado = labelResultado;
	}

	public String getMenuImpresionDiagnostico() {
		return menuImpresionDiagnostico;
	}

	public void setMenuImpresionDiagnostico(String menuImpresionDiagnostico) {
		this.menuImpresionDiagnostico = menuImpresionDiagnostico;
	}

	public String getMenuConcepto() {
		return menuConcepto;
	}

	public void setMenuConcepto(String menuConcepto) {
		this.menuConcepto = menuConcepto;
	}

	public String getMenuRecomendaciones() {
		return menuRecomendaciones;
	}

	public void setMenuRecomendaciones(String menuRecomendaciones) {
		this.menuRecomendaciones = menuRecomendaciones;
	}

	public String getLabelCiudad() {
		return labelCiudad;
	}

	public void setLabelCiudad(String labelCiudad) {
		this.labelCiudad = labelCiudad;
	}

	public String getLabelNuevo() {
		return labelNuevo;
	}

	public void setLabelNuevo(String labelNuevo) {
		this.labelNuevo = labelNuevo;
	}

	public String getLableCerrar() {
		return lableCerrar;
	}

	public void setLableCerrar(String lableCerrar) {
		this.lableCerrar = lableCerrar;
	}

	public String getLabelModaltrabajo() {
		return labelModaltrabajo;
	}

	public void setLabelModaltrabajo(String labelModaltrabajo) {
		this.labelModaltrabajo = labelModaltrabajo;
	}

	public String getLabel_Modalaccidente() {
		return label_Modalaccidente;
	}

	public void setLabel_Modalaccidente(String label_Modalaccidente) {
		this.label_Modalaccidente = label_Modalaccidente;
	}

	public String getLabel_Modalenfermedades() {
		return label_Modalenfermedades;
	}

	public void setLabel_Modalenfermedades(String label_Modalenfermedades) {
		this.label_Modalenfermedades = label_Modalenfermedades;
	}

	public String getLabel_eliminar() {
		return label_eliminar;
	}

	public void setLabel_eliminar(String label_eliminar) {
		this.label_eliminar = label_eliminar;
	}

	public String getLabelMenarquia() {
		return labelMenarquia;
	}

	public void setLabelMenarquia(String labelMenarquia) {
		this.labelMenarquia = labelMenarquia;
	}

	public String getLabelFur() {
		return labelFur;
	}

	public void setLabelFur(String labelFur) {
		this.labelFur = labelFur;
	}

	public String getLabelPlanificacion() {
		return labelPlanificacion;
	}

	public void setLabelPlanificacion(String labelPlanificacion) {
		this.labelPlanificacion = labelPlanificacion;
	}

	public String getLabelCcv() {
		return labelCcv;
	}

	public void setLabelCcv(String labelCcv) {
		this.labelCcv = labelCcv;
	}

	public String getLabelRecomendacionesMedicas() {
		return labelRecomendacionesMedicas;
	}

	public void setLabelRecomendacionesMedicas(String labelRecomendacionesMedicas) {
		this.labelRecomendacionesMedicas = labelRecomendacionesMedicas;
	}

	public String getLabelRecomendacinesOcupacionales() {
		return labelRecomendacinesOcupacionales;
	}

	public void setLabelRecomendacinesOcupacionales(String labelRecomendacinesOcupacionales) {
		this.labelRecomendacinesOcupacionales = labelRecomendacinesOcupacionales;
	}

	public String getLabelHabitos() {
		return labelHabitos;
	}

	public void setLabelHabitos(String labelHabitos) {
		this.labelHabitos = labelHabitos;
	}

	public String getActividadFisica() {
		return actividadFisica;
	}

	public void setActividadFisica(String actividadFisica) {
		this.actividadFisica = actividadFisica;
	}

	public String getSeparadorPrincipal() {
		return separadorPrincipal;
	}

	public void setSeparadorPrincipal(String separadorPrincipal) {
		this.separadorPrincipal = separadorPrincipal;
	}

	public String getSeparadorEvaluacion() {
		return separadorEvaluacion;
	}

	public void setSeparadorEvaluacion(String separadorEvaluacion) {
		this.separadorEvaluacion = separadorEvaluacion;
	}

	public String getMensajeBarProgress() {
		return mensajeBarProgress;
	}

	public void setMensajeBarProgress(String mensajeBarProgress) {
		this.mensajeBarProgress = mensajeBarProgress;
	}

	public String getLabelCodigo() {
		return labelCodigo;
	}

	public void setLabelCodigo(String labelCodigo) {
		this.labelCodigo = labelCodigo;
	}

	public String getLabelGrupoSanguuineo() {
		return labelGrupoSanguuineo;
	}

	public void setLabelGrupoSanguuineo(String labelGrupoSanguuineo) {
		this.labelGrupoSanguuineo = labelGrupoSanguuineo;
	}

	public String getLabelContactoEmergencia() {
		return labelContactoEmergencia;
	}

	public void setLabelContactoEmergencia(String labelContactoEmergencia) {
		this.labelContactoEmergencia = labelContactoEmergencia;
	}

	public String getLabelParentesco() {
		return labelParentesco;
	}

	public void setLabelParentesco(String labelParentesco) {
		this.labelParentesco = labelParentesco;
	}

	public String getMenuPersonal() {
		return menuPersonal;
	}

	public void setMenuPersonal(String menuPersonal) {
		this.menuPersonal = menuPersonal;
	}

	public String getDespMenuPersonal() {
		return despMenuPersonal;
	}

	public void setDespMenuPersonal(String despMenuPersonal) {
		this.despMenuPersonal = despMenuPersonal;
	}

	public String getLabelObservaciones() {
		return labelObservaciones;
	}

	public void setLabelObservaciones(String labelObservaciones) {
		this.labelObservaciones = labelObservaciones;
	}

	public String getLabelPreguntaEmbarazo() {
		return labelPreguntaEmbarazo;
	}

	public void setLabelPreguntaEmbarazo(String labelPreguntaEmbarazo) {
		this.labelPreguntaEmbarazo = labelPreguntaEmbarazo;
	}

	public String getLabelPreguntaFuma() {
		return labelPreguntaFuma;
	}

	public void setLabelPreguntaFuma(String labelPreguntaFuma) {
		this.labelPreguntaFuma = labelPreguntaFuma;
	}

	public String getLabelPreguntaFumaCuantos() {
		return labelPreguntaFumaCuantos;
	}

	public void setLabelPreguntaFumaCuantos(String labelPreguntaFumaCuantos) {
		this.labelPreguntaFumaCuantos = labelPreguntaFumaCuantos;
	}

	public String getLabelPreguntaFumaTiempo() {
		return labelPreguntaFumaTiempo;
	}

	public void setLabelPreguntaFumaTiempo(String labelPreguntaFumaTiempo) {
		this.labelPreguntaFumaTiempo = labelPreguntaFumaTiempo;
	}

	public String getLabelPreguntaLicor() {
		return labelPreguntaLicor;
	}

	public void setLabelPreguntaLicor(String labelPreguntaLicor) {
		this.labelPreguntaLicor = labelPreguntaLicor;
	}

	public String getLabelPreguntaLicorCuantas() {
		return labelPreguntaLicorCuantas;
	}

	public void setLabelPreguntaLicorCuantas(String labelPreguntaLicorCuantas) {
		this.labelPreguntaLicorCuantas = labelPreguntaLicorCuantas;
	}

	public String getLabelPreguntaEjercicio() {
		return labelPreguntaEjercicio;
	}

	public void setLabelPreguntaEjercicio(String labelPreguntaEjercicio) {
		this.labelPreguntaEjercicio = labelPreguntaEjercicio;
	}

	public String getLabelPreguntaEjercicioCual() {
		return labelPreguntaEjercicioCual;
	}

	public void setLabelPreguntaEjercicioCual(String labelPreguntaEjercicioCual) {
		this.labelPreguntaEjercicioCual = labelPreguntaEjercicioCual;
	}

	public String getLabelPreguntaEjercicioCuantas() {
		return labelPreguntaEjercicioCuantas;
	}

	public void setLabelPreguntaEjercicioCuantas(String labelPreguntaEjercicioCuantas) {
		this.labelPreguntaEjercicioCuantas = labelPreguntaEjercicioCuantas;
	}

	public String getLabelPreguntaEnergizantes() {
		return labelPreguntaEnergizantes;
	}

	public void setLabelPreguntaEnergizantes(String labelPreguntaEnergizantes) {
		this.labelPreguntaEnergizantes = labelPreguntaEnergizantes;
	}

	public String getLabelPreguntaEnergizanteCuantas() {
		return labelPreguntaEnergizanteCuantas;
	}

	public void setLabelPreguntaEnergizanteCuantas(String labelPreguntaEnergizanteCuantas) {
		this.labelPreguntaEnergizanteCuantas = labelPreguntaEnergizanteCuantas;
	}

	public String getLabelPreguntaSustancias() {
		return labelPreguntaSustancias;
	}

	public void setLabelPreguntaSustancias(String labelPreguntaSustancias) {
		this.labelPreguntaSustancias = labelPreguntaSustancias;
	}

	public String getLabelPreguntaSustanciasCuales() {
		return labelPreguntaSustanciasCuales;
	}

	public void setLabelPreguntaSustanciasCuales(String labelPreguntaSustanciasCuales) {
		this.labelPreguntaSustanciasCuales = labelPreguntaSustanciasCuales;
	}

	public String getLabelMenuFamiliar() {
		return labelMenuFamiliar;
	}

	public void setLabelMenuFamiliar(String labelMenuFamiliar) {
		this.labelMenuFamiliar = labelMenuFamiliar;
	}

	public String getDespMenuFamiliar() {
		return despMenuFamiliar;
	}

	public void setDespMenuFamiliar(String despMenuFamiliar) {
		this.despMenuFamiliar = despMenuFamiliar;
	}

	public String getMenuCuestionario() {
		return menuCuestionario;
	}

	public void setMenuCuestionario(String menuCuestionario) {
		this.menuCuestionario = menuCuestionario;
	}

	public String getDespMenuCuestionario() {
		return despMenuCuestionario;
	}

	public void setDespMenuCuestionario(String despMenuCuestionario) {
		this.despMenuCuestionario = despMenuCuestionario;
	}

	public String getParteFinal() {
		return parteFinal;
	}

	public void setParteFinal(String parteFinal) {
		this.parteFinal = parteFinal;
	}

	public String getLabelRh() {
		return labelRh;
	}

	public void setLabelRh(String labelRh) {
		this.labelRh = labelRh;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getLabelConducta() {
		return labelConducta;
	}

	public void setLabelConducta(String labelConducta) {
		this.labelConducta = labelConducta;
	}

	public String getLabelItem() {
		return labelItem;
	}

	public void setLabelItem(String labelItem) {
		this.labelItem = labelItem;
	}

	public String getLabelSiNo() {
		return labelSiNo;
	}

	public void setLabelSiNo(String labelSiNo) {
		this.labelSiNo = labelSiNo;
	}

	public String getLabelCancer() {
		return labelCancer;
	}

	public void setLabelCancer(String labelCancer) {
		this.labelCancer = labelCancer;
	}

	public String getLabelTipoCancer() {
		return labelTipoCancer;
	}

	public void setLabelTipoCancer(String labelTipoCancer) {
		this.labelTipoCancer = labelTipoCancer;
	}

	public String getUltimaParteGym() {
		return ultimaParteGym;
	}

	public void setUltimaParteGym(String ultimaParteGym) {
		this.ultimaParteGym = ultimaParteGym;
	}

	public String getUltimaParteOcupacional() {
		return ultimaParteOcupacional;
	}

	public void setUltimaParteOcupacional(String ultimaParteOcupacional) {
		this.ultimaParteOcupacional = ultimaParteOcupacional;
	}

	public String getLabelNombreAcompanante() {
		return labelNombreAcompanante;
	}

	public void setLabelNombreAcompanante(String labelNombreAcompanante) {
		this.labelNombreAcompanante = labelNombreAcompanante;
	}

	public String getLabelTelefonoAcompanante() {
		return labelTelefonoAcompanante;
	}

	public void setLabelTelefonoAcompanante(String labelTelefonoAcompanante) {
		this.labelTelefonoAcompanante = labelTelefonoAcompanante;
	}

	public String getLabelNombrePersonaResponsable() {
		return labelNombrePersonaResponsable;
	}

	public void setLabelNombrePersonaResponsable(String labelNombrePersonaResponsable) {
		this.labelNombrePersonaResponsable = labelNombrePersonaResponsable;
	}

	public String getLabelTelefonoPersonaResponsable() {
		return labelTelefonoPersonaResponsable;
	}

	public void setLabelTelefonoPersonaResponsable(String labelTelefonoPersonaResponsable) {
		this.labelTelefonoPersonaResponsable = labelTelefonoPersonaResponsable;
	}

	public String getLabelParentescoResponsable() {
		return labelParentescoResponsable;
	}

	public void setLabelParentescoResponsable(String labelParentescoResponsable) {
		this.labelParentescoResponsable = labelParentescoResponsable;
	}

	public String getLabelTipoVinculacion() {
		return labelTipoVinculacion;
	}

	public void setLabelTipoVinculacion(String labelTipoVinculacion) {
		this.labelTipoVinculacion = labelTipoVinculacion;
	}

	public String getLabelLocalidad() {
		return labelLocalidad;
	}

	public void setLabelLocalidad(String labelLocalidad) {
		this.labelLocalidad = labelLocalidad;
	}

	public String getLabelMunicipioResidencia() {
		return labelMunicipioResidencia;
	}

	public void setLabelMunicipioResidencia(String labelMunicipioResidencia) {
		this.labelMunicipioResidencia = labelMunicipioResidencia;
	}

	public String getLabelCelular() {
		return labelCelular;
	}

	public void setLabelCelular(String labelCelular) {
		this.labelCelular = labelCelular;
	}

}
