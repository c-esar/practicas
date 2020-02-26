INSERT INTO hc_personas (nom_primer_nombre,nom_primer_apellido) values('Cesar','Diaz');
INSERT INTO hc_personas (nom_primer_nombre,nom_primer_apellido) values('Carlos','Chacon');
INSERT INTO hc_perfiles (nom_usuario,password,estado,nom_perfil,seq_persona) values('cesar','12345','activo','admin',1);
INSERT INTO hc_permisos (crear_usuario,gestionar_usuario,descargar,crear_aux) values (1,1,1,1);
INSERT INTO hc_perfil_permisos (seq_perfil, seq_permiso) VALUES (1,1);


INSERT INTO hc_tipodocumento(cod_documento,sigla_documento,nom_documento)values('C','CC','Cédula de Ciudadanía');
INSERT INTO hc_tipodocumento(cod_documento,sigla_documento,nom_documento)values('I','TI','Tarjeta de Identidad');
INSERT INTO hc_tipodocumento(cod_documento,sigla_documento,nom_documento)values('E','CE','Cédula de Extranjería');
INSERT INTO hc_tipodocumento(cod_documento,sigla_documento,nom_documento)values('R','RC','Registro Civil');
INSERT INTO hc_tipodocumento(cod_documento,sigla_documento,nom_documento)values('P','PS','Pasaporte');
INSERT INTO hc_tipodocumento(cod_documento,sigla_documento,nom_documento)values('O','OT','Otro');

INSERT INTO hc_aseguradora(nom_aseguradora,tipo_aseguradora)values('Otro','Otro');
INSERT INTO hc_ciudad (seq_ciudad, cod_ciudad, cod_dpto, cod_pais, cod_poblacion, nom_ciudad) VALUES (0, '1', '1', '1', '1', 'prueba');
INSERT INTO hc_localidad (seq_localidad,cod_localidad,nom_localidad)values (0,'otro','otro');