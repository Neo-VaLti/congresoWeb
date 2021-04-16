create database congreso;

use congreso;
DROP TABLE alumnos;
DROP TABLE ponencias;

create table alumnos(
clave varchar(10) not null default '',
nombre varchar(35) not null default '',
email varchar(35) default '',
carrera varchar(35) not null default '',
PRIMARY KEY(clave)
)ENGINE = InnoDB;
create table ponencias(
clave varchar(10) not null default '',
titulo varchar(35) not null default '',
fecha date default null,
hora int(2) not null default '0',
cvePonente varchar(10) default '',
estado varchar(10) not null default '',
PRIMARY KEY(clave),
INDEX(cvePonente),
FOREIGN KEY(cvePonente)
REFERENCES alumnos(clave)
ON UPDATE CASCADE ON DELETE RESTRICT
)ENGINE = InnoDB;

INSERT INTO ponencias VALUES ('PON0003','PruebaTitulo3','2019-05-13',
5,'APO0003','valido');

INSERT INTO alumnos VALUES ('APO0001','Fernando','fer3sierras@gmail.com', 'Ing.Software');


select * from alumnos;

select * from ponencias;

delete from alumnos;