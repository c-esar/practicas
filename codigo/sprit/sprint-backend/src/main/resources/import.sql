INSERT INTO hc_tipo_antecedente values('PATOLOGICOS');
INSERT INTO hc_tipo_antecedente values('QUIRURGICOS');
INSERT INTO hc_tipo_antecedente values('ALERGICOS');
INSERT INTO hc_tipo_antecedente values('FARMACOLOGICOS');
INSERT INTO hc_tipo_antecedente values('TRAUMATICOS');
INSERT INTO hc_tipo_antecedente values('TOXICOS');
INSERT INTO hc_tipo_antecedente values('INMUNOLOGICOS');
INSERT INTO hc_tipo_antecedente values('MENARQUIA');
INSERT INTO hc_tipo_antecedente values('HOSPITALARIOS');
INSERT INTO hc_tipo_antecedente values('FAMILIARES');
INSERT INTO hc_tipo_antecedente values('TABAQUISMO');
INSERT INTO hc_tipo_antecedente values('CONSUMO ALCOHOL');
INSERT INTO hc_tipo_antecedente values('ACTIVIDAD FÍSICA');
INSERT INTO hc_tipo_antecedente values('ACTIVIDAD EXTRA LABORAL');

INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('SIN RESTRICCIONES','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('CON RESTRICCIONES QUE INTERFIEREN EN LA LABOR','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('CON RESTRICCIONES QUE NO INTERFIEREN EN LA LABOR','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('APLAZADO','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('APTO PARA TRABAJO EN ALTURAS','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('NO APTO PARA TRABAJO EN ALTURAS','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('APTO PARA MANIPULACIÓN DE ALIMENTOS','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('NO APTO PARA MANIPULACIÓN DE ALIMENTOS','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('APTO PARA MANIPULACIÓN DE SUSTANCIAS QUÍMICAS','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('NO APTO PARA MANIPULACIÓN DE SUSTANCIAS QUÍMICAS','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('APTO PARA CONDUCIR','INGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('NO APTO PARA CONDUCIR','INGRESO');

INSERT INTO hc_tipo_evaluacion (nom_eval) values('INGRESO');
INSERT INTO hc_tipo_evaluacion (nom_eval) values('PERIÓDICO');
INSERT INTO hc_tipo_evaluacion (nom_eval) values('EGRESO');
INSERT INTO hc_tipo_evaluacion (nom_eval) values('OTRO');

INSERT INTO hc_tipo_historia (nom_tipo_historia) values ('OCUPACIONAL');
INSERT INTO hc_tipo_historia (nom_tipo_historia) values ('GYM');

INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('CON HALLAZGOS QUE GENERAN RECOMENDACIONES','PERIODICOS');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('SIN HALLAZGOS QUE GENERAN RECOMENDACIONES','PERIODICOS');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('APTO PARA TRABAJO EN ALTURAS','PERIODICOS');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('NO APTO PARA TRABAJO EN ALTURAS','PERIODICOS');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('APTO PARA MANIPULACIÓN DE ALIMENTOS','PERIODICOS');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('NO APTO PARA MANIPULACIÓN DE ALIMENTOS','PERIODICOS');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('APTO PARA MANIPULACIÓN DE SUSTANCIAS QUÍMICAS','PERIODICOS');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('NO APTO PARA MANIPULACIÓN DE SUSTANCIAS QUÍMICAS','PERIODICOS');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('APTO PARA CONDUCIR','PERIODICOS');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('NO APTO PARA CONDUCIR','PERIODICOS');

INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('CON HALLAZGOS QUE GENERAN RECOMENDACIONES','EGRESO');
INSERT INTO hc_concepto (nom_concepto,tipo_concepto) values('SIN HALLAZGOS QUE GENERAN RECOMENDACIONES.','EGRESO');

INSERT INTO hc_tipo_documento(cod_documento,sigla_documento,nom_documento)values('C','CC','Cédula de Ciudadanía');
INSERT INTO hc_tipo_documento(cod_documento,sigla_documento,nom_documento)values('I','TI','Tarjeta de Identidad');
INSERT INTO hc_tipo_documento(cod_documento,sigla_documento,nom_documento)values('E','CE','Cédula de Extranjería');
INSERT INTO hc_tipo_documento(cod_documento,sigla_documento,nom_documento)values('R','RC','Registro Civil');
INSERT INTO hc_tipo_documento(cod_documento,sigla_documento,nom_documento)values('P','PS','Pasaporte');
INSERT INTO hc_tipo_documento(cod_documento,sigla_documento,nom_documento)values('O','OT','Otro');

INSERT INTO hc_perfiles (nom_usuario,password,estado,nom_perfil) values('cesar','12345','A','admin');
INSERT INTO hc_perfiles (nom_usuario,password,estado,nom_perfil) values('carlos','12345','A','aux');

INSERT INTO hc_personas (nom_primer_nombre,nom_primer_apellido,numero_documento,rol_usuario,seq_tipo_documento,seq_perfil) values('Cesar','Diaz','1030691234','Administrador','1',1);
INSERT INTO hc_personas (nom_primer_nombre,nom_primer_apellido,numero_documento,rol_usuario,seq_tipo_documento,seq_perfil) values('Carlos','Chacon','1010','Paciente',3,2);

INSERT INTO hc_permisos (crear_usuario,gestionar_usuario,descargar,crear_aux) values (1,1,1,0);
INSERT INTO hc_permisos (crear_usuario,gestionar_usuario,descargar,crear_aux) values (0,0,0,1);

INSERT INTO hc_perfil_permisos (seq_perfil, seq_permiso) VALUES (1,1);
INSERT INTO hc_perfil_permisos (seq_perfil, seq_permiso) VALUES (2,2);

INSERT INTO hc_aseguradora(nom_aseguradora,tipo_aseguradora)values('Otro','Otro');
INSERT INTO hc_ciudad (seq_ciudad, cod_ciudad, cod_dpto, cod_pais, cod_poblacion, nom_ciudad) VALUES (0, '1', '1', '1', '1', 'prueba');
INSERT INTO hc_localidad (seq_localidad,cod_localidad,nom_localidad)values (0,'otro','otro');