#2-Entrega
____________________________________________________________________________________________________________________
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
____________________________________________________________________________________________________________________

 # O que foi solicitado #
 
Olá, Estudante! 

Nesta atividade, vamos dar continuidade à criação do site para a agência de viagens (melhorar o layout do modelo anterior). Nesta entrega, contemple uma estrutura de layout com um menu horizontal na parte superior de todas as páginas: HOME, DESTINOS, PROMOCOES, CONTATO usando <tags> semânticas e deixando o site totalmente responsivo usando Bootstrap. Vamos dar início a modelagem de nosso banco de dados e a estrutura de classes de nosso sistema usando UML e JAVA.  Não esqueça que está atividade deve ser realizada individualmente.  
Atente-se às seguintes orientações: 
 
Modelagem de dados 
 
Criar o modelo conceitual e lógico do banco de dados, usando uma ferramenta de modelagem de dados (BRmodelo) 
Criar as relações e cardinalidades entre as tabelas do modelo do banco
Criar o modelo físico (tabelas e relações) usando SQL
Criar o modelo do sistema (Classes) em UML e Java 
 
Back-end 
 
Usando os conceitos da orientação a objetos em Java, criar um projeto do tipo console da agencia de viagens, aplicando o CRUD (Create, Read, Update, Delete) para todas as tabelas de seu modelo de banco de dados 
Para a atividade vamos usar classes Java, JDBC e MySql 
 

Front-end 

 
Atualizar a versão anterior do site, refatorando se preciso as páginas: Home, Destino, Promoções, Contato e as demais de acordo com seu modelo de dados usando HTML, CSS Bootstrap. 
Faça as formatações de acordo com a paleta de cores escolhida. 
 
