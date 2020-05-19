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

INSERT INTO hc_tipo_pregunta_historia_gym VALUES ('EMBARAZO');
INSERT INTO hc_tipo_pregunta_historia_gym VALUES ('FUMA');
INSERT INTO hc_tipo_pregunta_historia_gym VALUES ('LICOR');
INSERT INTO hc_tipo_pregunta_historia_gym VALUES ('EJERCICIO');
INSERT INTO hc_tipo_pregunta_historia_gym VALUES ('ENERGIZANTES');
INSERT INTO hc_tipo_pregunta_historia_gym VALUES ('PSICOACTIVAS');

INSERT INTO hc_tipo_cuestionario VALUES ('¿ALGUNA VEZ LE HA DIAGNOSTICADO UN MÉDICO UNA ENFERMEDAD CARDIACA, RECOMENDÁNDOLE QUE SOLO HAGA ACTIVIDAD FÍSICO SUPERVISADA POR PERSONAL SANITARIO?');
INSERT INTO hc_tipo_cuestionario VALUES ('¿TIENE DOLORES EN EL PECHO PRODUCIDOS POR LA ACTIVIDAD FÍSICA?');
INSERT INTO hc_tipo_cuestionario VALUES ('¿HA NOTADO DOLOR EN EL PECHO DURANTE EL ÚLTIMO MES?');
INSERT INTO hc_tipo_cuestionario VALUES ('¿TIENDE A PERDER EL CONOCIMIENTO, O EL EQUILIBRIO, COMO RESULTADO DE MAREOS?');
INSERT INTO hc_tipo_cuestionario VALUES ('¿ALGUNA VEZ LE HA RECETADO EL MÉDICO ALGÚN FÁRMACO PARA LA PRESIÓN ARTERIAL U OTRO PROBLEMA CARDIOCIRCULATORIO?');
INSERT INTO hc_tipo_cuestionario VALUES ('¿TIENE ALGUNA ALTERACIÓN ÓSEA O ARTICULAR (POR EJEMPLO EN ESPALDA, RODILLAS, CADERAS) QUE PODRIA AGRAVARSE POR LA ACTIVIDAD FÍSICA PROPUESTA?');
INSERT INTO hc_tipo_cuestionario VALUES ('¿TIENE CONOCIMIENTO, POR EXPERIENCIA PROPIA, O DEBIDO AL CONSEJO AL CONSEJO DE ALGÚN MÉDICO, DE CUALQUIER OTRA RAZÓN FÍSICA QUE LE IMPIDA HACER EJERCICIO SIN SUPERVISIÓN MÉDICO?');

INSERT INTO hc_condicion_gym VALUES ('PATOLOGÍA CARDIACA');
INSERT INTO hc_condicion_gym VALUES ('COLESTEROL ALTO');
INSERT INTO hc_condicion_gym VALUES ('INSUFICIENCIA RENAL');
INSERT INTO hc_condicion_gym VALUES ('HIPERTENSIÓN ARTERIAL');
INSERT INTO hc_condicion_gym VALUES ('ENFERMEDAD TIROIDEA');
INSERT INTO hc_condicion_gym VALUES ('EPILEPSIA');
INSERT INTO hc_condicion_gym VALUES ('DIABETES MELLITUS');
INSERT INTO hc_condicion_gym VALUES ('PROBLEMAS DE PESO');
INSERT INTO hc_condicion_gym VALUES ('ESQUINCES, LUXACIONES');
INSERT INTO hc_condicion_gym VALUES ('FRACTURAS');
INSERT INTO hc_condicion_gym VALUES ('ASMA');
INSERT INTO hc_condicion_gym VALUES ('CIRUGÍAS');
INSERT INTO hc_condicion_gym VALUES ('ENFERMEDADES COLUMNA');
INSERT INTO hc_condicion_gym VALUES ('OTRA');

INSERT INTO hc_familiar_gym VALUES('ENFERMEDAD CORONARIA (ANTES DE LOS 30 AÑOS)');
INSERT INTO hc_familiar_gym VALUES('DIABETES');
INSERT INTO hc_familiar_gym VALUES('HIPERTENSIÓN ARTERIAL');
INSERT INTO hc_familiar_gym VALUES('MUERTE SÚBITA (ANTES DE LOS 50 AÑOS)');
INSERT INTO hc_familiar_gym VALUES('MELLITUS');
INSERT INTO hc_familiar_gym VALUES('ACCIDENTE CEREBROVASCULAR');
INSERT INTO hc_familiar_gym VALUES('CÁNCER');
INSERT INTO hc_familiar_gym VALUES('OBESIDAD');
INSERT INTO hc_familiar_gym VALUES('HIPERTIROIDISMO, HIPOTIROIDISMO');
INSERT INTO hc_familiar_gym VALUES('OTROS');

INSERT INTO hc_tipo_usuario VALUES ('ESTUDIANTE');
INSERT INTO hc_tipo_usuario VALUES ('ADMINISTRATIVO');
INSERT INTO hc_tipo_usuario VALUES ('DOCENTE');
INSERT INTO hc_tipo_usuario VALUES ('EGRESADO');
INSERT INTO hc_tipo_usuario VALUES ('OTRO');
INSERT INTO hc_tipo_usuario VALUES ('ADMINISTRADOR');
INSERT INTO hc_tipo_usuario VALUES ('MEDICO');
INSERT INTO hc_tipo_usuario VALUES ('AUXILIAR');

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


INSERT INTO hc_perfiles (nom_usuario,password,estado) values('administrador.konrad','CWlaarcP6EE=','A');
INSERT INTO hc_permisos (crear_usuario,gestionar_usuario,descargar,crear_aux) values (1,1,1,1);
INSERT INTO hc_perfil_permisos (seq_perfil, seq_permiso) VALUES (1,1);


INSERT INTO hc_aseguradora(nom_aseguradora,tipo_aseguradora)values('Indefinido','Otro');
INSERT INTO hc_aseguradora(nom_aseguradora,tipo_aseguradora)values('Otro','Otro');


INSERT INTO hc_ciudad (seq_ciudad, cod_ciudad, cod_dpto, cod_pais, cod_poblacion, nom_ciudad) VALUES (0, '1', '1', '1', '1', 'No aplica');
INSERT INTO hc_localidad (seq_localidad,cod_localidad,nom_localidad)values (0,'otro','otro');

INSERT INTO hc_personas (nom_primer_nombre,nom_primer_apellido,numero_documento,seq_perfil) values('Administrador','konrad',12345,1);
INSERT INTO hc_rol_usuario_persona(seq_persona, tipo_usuario) values(1,6);












