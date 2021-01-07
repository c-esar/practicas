package com.konrad.edu.IService;

public interface IConstantes {

	// desarrollo
	public static final String RUTA = "http://localhost:" + IConstantes.PUERTO;
	public static final String PUERTO = "4200";
	public static final String JDBC_REPORTE = "jdbc:sqlserver://192.168.0.42;databaseName=HC_Historia";
	public static final String USER_DB = "sa";
	public static final String PASS_DB = "12345";

//	produccion
//	public static final String RUTA = "http://localhost:"+IConstantes.PUERTO;
//	public static final String PUERTO = "4200";
//	public static final String JDBC_REPORTE = "jdbc:sqlserver://192.168.0.42;databaseName=HC_Historiass";
//	public static final String USER_DB = "sa";
//	public static final String PASS_DB = "12345";

	// separadores
	public static final String SEPARADOR_PRINCIPAL = "HISTORIA CLÍNICA OCUPACIONAL";
	public static final String SEPARADOR_EVALUACION = "TIPO DE EVALUACIÓN";

	public static final String ESTADO_PERDIDA_CONEXION = "FALLO";
	public static final String ESTADO_SESION_ACTIVO = "ACTIVO";
	public static final String ESTADO_SESION_INACTIVO = "INACTIVO";
	public static final String LABEL_PRIMER_NOMBRE = "PRIMER NOMBRE";
	public static final String LABEL_SEGUNDO_NOMBRE = "SEGUNDO NOMBRE";
	public static final String LABEL_PRIMER_APELLIDO = "PRIMER APELLIDO";
	public static final String LABEL_SEGUNDO_APELLIDO = "SEGUNDO APELLIDO";
	public static final String LABEL_EDAD = "EDAD";
	public static final String LABEL_NODOCUMENTO = "NO DOCUMENTO";
	public static final String LABEL_TIPO_DOCUMENTO = "TIPO DOCUMENTO";
	public static final String LABEL_GENERO = "GÉNERO";
	public static final String LABEL_FECHA_NACIMIENTO = "FECHA DE NACIMIENTO";
	public static final String LABEL_LUGAR_DENACIMIENTO = "LUGAR DE NACIMIENTO";
	public static final String LABEL_ESTADO_CIVIL = "ESTADO CIVIL";
	public static final String LABEL_ESCOLARIDAD = "ESCOLARIDAD";
	public static final String LABEL_CARGO_DEPENDENCIA = "CARGO DEPENDENCIA";
	public static final String LABEL_DIRECCION_CASA = "DIRECCIÓN DOMICILIO";
	public static final String LABEL_TELEFONO = "TELÉFONO";
	public static final String LABEL_ASEGURADORA = "EPS";
	public static final String LABEL_AFP = "AFP";
	public static final String LABEL_ARL = "ARL";
	public static final String LABEL_SI = "SI";
	public static final String LABEL_NO = "NO";

	public static final String LABEL_CIUDAD = "CIUDAD";
	public static final String LABEL_DEPARTAMENTO = "DEPARTAMENTO";
	public static final String LABEL_FECHA_HISTORIACLINICA = "FECHA HISTORIA CLÍNICA";
	public static final String LABEL_INGRESO = "INGRESO";
	public static final String LABEL_PERIODICO = "PERIÓDICO";
	public static final String LABEL_EGRESO = "EGRESO";
	public static final String LABEL_OTRO_EVALUACION = "¿OTRO, CÚAL?";

	public static final String MENU_OCUPACIONAL_DATOSPRINCIPALES = "DATOS PRINCIPALES";

	// parte historia laboral
	public static final String MENU_OCUPACIONAL_HISTORIA_LABORAL = "HISTORIA LABORAL";
	public static final String MENU_SUBMENU_OCUPACIONAL_HISTORIA_LABORAL_TRABAJOAC = "3.1 CONDICIONES DE TRABAJO ACTUAL";
	public static final String LABEL_NOMBRE_EMPRESA = "NOMBRE DE LA EMPRESA";
	public static final String LABEL_ACTIVIDAD_ECONOMICA = "ACTIVIDAD ECONÓMICA";
	public static final String LABEL_FECHA_INGRESO = "FECHA DE INGRESO";
	public static final String LABEL_ANTIGUO = "ANTIGÜEDAD";
	public static final String LABEL_CARGO = "CARGO";
	public static final String LABEL_DESCRIPCION_TAREAS_FUNCION = "DESCRIPCIÓN DE TAREAS O FUNCIONES DEL CARGO";
	public static final String MENU_SUBMENU_OCUPACIONAL_HISTORIA_LABORAL_TRABAJOPRE = "3.2 CONDICIONES DE TRABAJOS PREVIOS";
	public static final String TABLA_TRABAJOPRE_LABEL_EMPRESA = "EMPRESA";
	public static final String TABLA_TRABAJOPRE_LABEL_CARGOOFICINA = "CARGO FUNCIONES";
	public static final String TABLA_TRABAJOPRE_LABEL_TIEMPO = "TIEMPO";
	public static final String MENU_SUBMENU_OCUPACIONAL_HISTORIA_LABORAL_ANTECEDENTES_TRABAJO = " 3.3 ANTECEDENTES DE ACCIDENTES DE TRABAJO O ENFERMEDADES LABORALES";
	public static final String LABEL_SN_ACCIDENTES_TRABAJO = "HA SUFRIDO ACCIDENTES DE TRABAJO?";
	public static final String TABLA_ENFERMEDADES_FECHA = "FECHA";
	public static final String TABLA_ENFERMEDADES_EMPRESA = "EMPRESA";
	public static final String TABLA_ENFERMEDADES_CAUSA = "CAUSA";
	public static final String TABLA_ENFERMEDADES_TIPO_LESION = "TIPO DE LESIÓN-PARTE AFECTADA";
	public static final String TABLA_ENFERMEDADES_INCAPACIDAD = "INCAPACIDAD";
	public static final String TABLA_ENFERMEDADES_SECUELAS = "SECUELAS";
	public static final String LABEL_TIENE_ENFERMEDAD = "TIENE ALGUNA ENFERMEDAD LABORAL?";
	public static final String TABLA_ENFERMEDADES_DIAGNOSTICO = "DIAGNÓSTICO";
	public static final String TABLA_ENFERMEDADES_RECOMENDACIONES = "RECOMENDACIONES-REUBICACIÓN";
	public static final String TABLA_ENFERMEDADES_INDEMNIZACION = "INDEMNIZACIÓN";
	public static final String MENU_SUBMENU_OCUPACIONAL_HISTORIA_LABORAL_FACTORES_RIESGO = "3.4 EXPOSICIÓN A FACTORES DE RIESGO";
	public static final String TABLA_FACTORES_FACTORES_RIESGO = "FACTORES DE RIESGO";
	public static final String TABLA_FACTORES_TIEMPO = "TIEMPO";
	public static final String TABLA_FACTORES_MEDIDAS_CONTROL = "MEDIDAS DE CONTROL";

	// tercera fase ocupacional
	public static final String LABEL_MOTIVACION_DE_CONSULTA = "4. MOTIVO DE CONSULTA Y ENFERMEDAD ACTUAL";
	public static final String LABEL_ANTECEDENTES = "5. ANTECEDENTES";
	public static final String MENU_MOTIVO_CONSULTA = "ANAMNESIS";
	public static final String LABEL_ANTECEDENTES_PERSONALES = "5.1 PERSONALES";
	public static final String LABEL_CUAL_ES = "CUÁL (ES) ?";
	public static final String LABEL_PATOLOGICOS = "A. PATOLÓGICOS";
	public static final String LABEL_QUIRURGICOS = "B. QUIRÚRGICOS";
	public static final String LABEL_FARMACOLOGICOS = "C. FARMACOLÓGICOS";
	public static final String LABEL_ALERGICOS = "D. ALÉRGICOS";
	public static final String LABEL_TRAUMATICOS = "E. TRAUMÁTICOS";
	public static final String LABEL_TOXICOS = "F. TÓXICOS";
	public static final String LABEL_HOSPITALARIOS = "G. HOSPITALARIOS";
	public static final String LABEL_INMUNOLOGICOS = "H. INMUNOLÓGICOS";
	public static final String LABEL_MENARQUIA = "I. GINECO-OSTETRICO";
	public static final String LABEL_FUR = "FECHA ÚLTIMA MENSTRUACIÓN";
	public static final String LABEL_PLANIFICACION = "PLANIFICACIÓN";
	public static final String LABEL_CCV = "FECHA ÚLTIMA CITOLOGÍA Y RESULTADO";
	public static final String LABEL_FAMILIARES = "5.2 FAMILIARES";
	public static final String LABEL_ESTILOS_VIDA = "5.3 ESTILOS DE VIDA";
	public static final String LABEL_TABAQUISMO = "A. TABAQUISMO";
	public static final String LABEL_FRECUENCIA = "FRECUENCIA";
	public static final String LABEL_HABITO = "AÑOS DE HÁBITOS";
	public static final String LABEL_EXFUMADOR = "EXFUMADOR";
	public static final String LABEL_CONSUMO_ALCOHOL = "B. CONSUMO DE ALCOHOL";
	public static final String LABEL_ACTIVIDAD_FISICA = "C. REALIZACIÓN DE ACTIVIDAD FÍSICA";
	public static final String LABEL_TIPO = "TIPO";
	public static final String LABEL_ACTIVIDADES_ESTRA = "D. ACTIVIDADES EXTRALABORALES";
	public static final String LABEL_REVISION_SISTEMAS = "REVISIÓN POR SISTEMAS";

	// cuarta fase ocupacional
	public static final String MENU_EXAMEN_FISICO = "EXAMEN FÍSICO";
	public static final String LABEL_TENSION_ARTERIAL = "TENSIÓN ARTERIAL (mm/hg)";
	public static final String LABEL_FRECUENCIA_CARDIACA = "FRECUENCIA CARDIACA (lpm)";
	public static final String LABEL_SAT02 = "SAT02 (%)";
	public static final String LABEL_FRECUENCIA_RESPIRATORIA = " FRECUENCIA RESPIRATORIA (rpm)";
	public static final String LABEL_PESO = "PESO (kg)";
	public static final String LABEL_TALLA = "TALLA (metros)";
	public static final String LABEL_IMC = "IMC (kg/m^2)";
	public static final String LABEL_LATERALIDAD = "LATERALIDAD";
	public static final String LABEL_CABEZA_CUELLO = "CABEZA Y CUELLO";
	public static final String LABEL_TORAX = "TÓRAX";
	public static final String LABEL_ABDOMEN = "ABDOMEN";
	public static final String LABEL_GENITOURINARIO = "GENITOURINARIO";
	public static final String LABEL_COLUMNA = "COLUMNA";
	public static final String LABEL_MIEMBROS_SUPERIORES_INFERIORES = "MIEMBROS SUPERIORES E INFERIORES";
	public static final String LABEL_OSTEOMUSCULAR = "OSTEOMUSCULAR";
	public static final String LABEL_NEUROLOGICO = "NEUROLÓGICO";
	public static final String LABEL_PIEL_FANERAS = "PIEL Y FANERAS";
	public static final String MENU_PARACLINICOS = "PARACLÍNICOS";
	public static final String LABEL_EXAMEN = "EXAMEN";
	public static final String LABEL_FECHA = "FECHA";
	public static final String LABEL_RESULTADO = "RESULTADO";

	// parte final
	public static final String MENU_IMPRESION_DIAGNOSTICO = "IMPRESIÓN DIAGNÓSTICA";
	public static final String MENU_CONCEPTO = "CONCEPTO";
	public static final String MENU_RECOMENDACIONES = "RECOMENDACIONES";
	public static final String LABEL_NUEVO = "NUEVO";
	public static final String LABEL_CERRAR = "CERRAR";
	public static final String LABEL_MODALTRABAJO = "TRABAJOS PREVIOS";
	public static final String LABEL_MODALACCIDENTE = "ACCIDENTES TRABAJO";
	public static final String LABEL_MODALENFERMEDADES = "ENFERMEDADES LABORALES";
	public static final String LABEL_ELIMINAR = "ELIMINAR";
	public static final String LABEL_RECOMENDACIONES_MEDICAS = "RECOMENDACIONES MÉDICAS (REMISIONES, TRATAMIENTOS)";
	public static final String LABEL_RECOMENDACIONES_OCUPACIONALES = "RECOMENDACIONES OCUPACIONALES (USO DE EPP, INGRESO A SVE,RECOMEDACIONES, REUBICACIONES)";
	public static final String LABEL_HABITOS = "HÁBITOS Y ESTILOS DE VIDA SALUDABLES";

	// constantes front
	public static final String ACTIVIDAD_FISICA = "ACTIVIDAD FÍSICA";
	public static final String MENSAJE_BAR_PROGRESS = "GUARDANDO INFORMACIÓN ESPERE UN MOMENTO";

	// GYM
	public static final String LABEL_CODIGO = "CÓDIGO";
	public static final String LABEL_GRUPO_SANGUUINEO = "GRUPO SANGUÍNEO";
	public static final String LABEL_CONTACTO_EMERGENCIA = "CONTACTO EN CASO DE EMERGENCIA";
	public static final String LABEL_PARENTESCO = "PARENTESCO";
	public static final String MENU_PERSONAL = "HISTORIA PERSONAL";
	public static final String DESP_MENU_PERSONAL = "¿ HA PADECIDO O PADECE ALGUNA DE LAS SIGUIENTES CONDICIONES? "
			+ "(SELECCIONE Y EN OBSERVACIONES ESPECIFIQUE SI TIENE ALGÚN TRATAMIENTO ACTUALMENTE Y EN CIRUGÍA ESPECIFIQUE TIPO Y FECHA)";
	public static final String LABEL_OBSERVACIONES = "OBSERVACIONES";
	public static final String LABEL_PREGUNTA_EMBARAZO = "¿SI ES MUJER, ESTÁ EMBARAZADA?";
	public static final String LABEL_PREGUNTA_FUMA = "¿ACTUALMENTE FUMA";
	public static final String LABEL_PREGUNTA_FUMA_CUANTOS = "CUANTOS CIGARRILLOS DÍA";
	public static final String LABEL_PREGUNTA_FUMA_TIEMPO = "TIEMPO FUMANDO";
	public static final String LABEL_PREGUNTA_LICOR = "¿CONSUME LICOR?";
	public static final String LABEL_PREGUNTA_LICOR_CUANTAS = "CUANTAS VECES AL MES";
	public static final String LABEL_PREGUNTA_EJERCICIO = "¿REALIZA EJERCICIO FÍSICO?";
	public static final String LABEL_PREGUNTA_EJERCICIO_CUAL = "CÚAL(ES)";
	public static final String LABEL_PREGUNTA_EJERCICIO_CUANTAS = "CUANTAS VECES POR SEMANA";
	public static final String LABEL_PREGUNTA_ENERGIZANTES = "¿CONSUME BEBIDAS ENERGIZANTES?";
	public static final String LABEL_PREGUNTA_ENERGIZANTE_CUANTAS = "¿CUANTAS A LA SEMANA?";
	public static final String LABEL_PREGUNTA_SUSTANCIAS = "¿CONSUME SUSTANCIAS PSICOACTIVAS?";
	public static final String LABEL_PREGUNTA_SUSTANCIAS_CUALES = "¿CUÁLES?";
	public static final String LABEL_MENU_FAMILIAR = "HISTORIA FAMILIAR";
	public static final String DESP_MENU_FAMILIAR = "ALGUNO DE SUS FAMILIARES (PADRES, TIOS, ABUELOS O HERMANOS) PADECE O HA PADECIDO UNA O VARIAS DE LAS "
			+ "SIGUIENTES ENFERMEDADES:";
	public static final String MENU_CUESTIONARIO = "CUESTIONARIO DE APTITUD PARA EL EJERCICIO FÍSICO";
	public static final String DESP_MENU_CUESTIONARIO = "POR FAVOR, LEA LAS SIGUIENTES PREGUNTAS CUIDADOSAMENTE Y SELECCIONE "
			+ "EL CUADRO CORRESPONDIENTE A AQUELLAS PREGUNTAS QUE SEAN CIERTAS EN SU CASO";
	public static final String PARTE_FINAL = "YO HE SIDO CUESTIONADO SOBRE MIS ANTECEDENTES MÉDICOS FAMILIARES Y PERSONALES QUE PUEDEN "
			+ "OCASIONAR RIESGO PARA MI SALUD CON LA PRÁCTICA DEL EJERCICIO. NOTIFICO QUE TODA LA INFORMACIÓN HA SIDO "
			+ "VERAZ Y COMPLEJA, POR LA CUAL ME HAGO RESPONSABLE Y FIRMA EN EVALUADO.";
	public static final String ULTIMA_PARTE_GYM = "DIAGNÓSTICO CONDUCTA";
	public static final String ULTIMA_PARTE_OCUPACIONAL = "CONCEPTO-RECOMENDACIONES";
	public static final String LABEL_RH = "RH";
	public static final String TIPO_USUARIO = "TIPO USUARIO";
	public static final String LABEL_CONDUCTA = "CONDUCTA";
	public static final String LABEL_ITEM = "ÍTEM";
	public static final String LABEL_SI_NO = "SI / NO";
	public static final String LABEL_CANCER = "CÁNCER";
	public static final String LABEL_TIPO_CANCER = "TIPO CÁNCER";
	
	//nuevos campos
	public static final String LABEL_NOMBRE_ACOMPANANTE = "NOMBRE COMPLETO ACOMPAÑANTE";
	public static final String LABEL_TELEFONO_ACOMPANANTE = "TELÉFONO ACOMPAÑANTE";
	public static final String LABEL_NOMBRE_PERSONA_RESPONSABLE = "NOMBRE COMPLETO PERSONA RESPONSABLE";
	public static final String LABEL_TELEFONO_PERSONA_RESPONSABLE = "TELÉFONO PERSONA RESPONSABLE";
	public static final String LABEL_PARENTESCO_RESPONSABLE = "PARENTESCO PERSONA RESPONSABLE" ;
	public static final String LABEL_TIPO_VINVULACION = "TIPO VINCULACIÓN" ;
	public static final String LABEL_LOCALIDAD = "LOCALIDAD";
	public static final String LABEL_MUNICIPIO_RESIDENCIA = "MUNICIPIO RESIDENCIA";
	public static final String LABEL_CELULAR = "CELULAR";

}
