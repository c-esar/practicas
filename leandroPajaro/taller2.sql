create table gravedad( 
seq_gravedad int primary key,
nom_gravedad varchar(100)
);
create table concesion( 
seq_concesion int primary key,
nom_concesion varchar(100)
);
create table empresa( 
seq_empresa int primary key,
nom_empresa varchar(100)
);
create table tipo_servicio( 
seq_tipo_servicio int primary key,
nom_tipo_servicio varchar(100)
);
create table afectacion( 
seq_afectacion int primary key,
nom_afectacion varchar(100)
);
create table tipo_accidente( 
seq_tipo_accidente int primary key,
Tipo varchar(100)
);
create table vehiculo( 
placa varchar(10) primary key,
fecha date,
modelo varchar(100), 
marca varchar(100), 
tipologia varchar(100),
opera varchar(2),
no_opera varchar(2)
);
create table fecha( 
seq_fecha int primary key,
instante date, 
ano varchar(10),
mes varchar (20),
dia varchar(20)
);

create table accidentalidad( 
Id_accidentalidad int primary key,
seq_fecha int,
franja_horaria varchar(20),
r_franja varchar(20),
seq_tipo_accidente int,
seq_afectación int,
seq_tipo_servicio int,
seq_empresa_operadora int,
concesion int,
linea varchar(10),
ruta varchar(20),
coordenada_X varchar(20),
coordenada_Y varchar(20),
desp_suceso varchar(5000),
num_lesionados_valorados int,
num_lesionados_trasladados int,
num_víctimas_fatales int,
gravedad_afectados int,
conciliación varchar(5),
placa varchar(10),
inmovilizado varchar(20),
sentido varchar(20)
);


alter table accidentalidad add foreign key (seq_fecha) references fecha(seq_fecha);

alter table accidentalidad add foreign key (seq_tipo_accidente) references tipo_accidente(seq_tipo_accidente);

alter table accidentalidad add foreign key (seq_afectacion) references afectacion(seq_afectacion);

alter table accidentalidad add foreign key (concesion) references concesion(seq_concesion);

alter table accidentalidad add foreign key (placa) references vehiculo(placa);

alter table accidentalidad add foreign key (gravedad_afectados) references gravedad(seq_gravedad);

alter table accidentalidad add foreign key(seq_empresa_operadora) references empresa(seq_empresa);

alter table accidentalidad add foreign key (seq_tipo_servicio) references tipo_servicio(seq_tipo_servicio);