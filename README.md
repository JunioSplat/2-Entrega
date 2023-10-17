#2-Entrega
script ustilizado para criar o BD
create database siteviagens;

use siteviagens;

CREATE TABLE usuario (
 idUsuario INT PRIMARY KEY auto_increment,  
 enderecoUsuario varchar(50) NOT null,  
 nomeUsuario varchar(40) not null,  
 emailUsuario varchar(40) not null,  
 cepUsuario varchar(8) not null  
);

CREATE TABLE pacote ( 
 idPacote INT PRIMARY KEY auto_increment not null,  
 valor double not null,  
 diarias INT not null,  
 idusuario INT,  
 FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario)
 ); 

CREATE TABLE reservaViagem 
(  
 idViagem INT PRIMARY KEY auto_increment not null,
 destino varchar (30) not null,  
 dataIda date not null,  
 dataVolta date not null,
 idUsuario int,
 idPacote int,
 FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario),
 FOREIGN KEY (idPacote) REFERENCES pacote (idPacote)
); 



alter table pacote 
 ADD destino varchar (30) not null;
