create database ProEagle;
use ProEagle;

create table Empresa(
idEmpresa int primary key auto_increment,
Nome varchar(45),
Email varchar(45),
CNPJ char(18),
Telefone char(15)
);

create table Filial(
idFilial int primary key auto_increment,
Setor int(4),
fkEmpresa int,
foreign key(fkEmpresa) references Empresa(idEmpresa)
);

create table Usuarios(
idUsuarios int primary key auto_increment,
NomeCompleto varchar(45),
Email varchar(45),
Senha varchar(45),
Cargo varchar(45),
TelefoneCelular char(15),
FotoPerfil TEXT,
fkFilial int,
foreign key(fkFilial) references Filial(idFilial),
fkSupervisor int,
foreign key(fkSupervisor) references Usuarios(idUsuarios)
);

create table Maquina(
idMaquina int primary key auto_increment,
SistemasOperacionais varchar(25),
RAM decimal(3),
Processador varchar(25),
Arquitetura int(2),
fkUsuarios int,
foreign key(fkUsuarios) references Usuarios(idUsuarios)
);

create table InfoHardware(
idInfoHardware int primary key auto_increment,
CPU int(3),
Memoria decimal(10),
Disco decimal(10),
DataHora DATETIME,
fkMaquina int,
foreign key(fkMaquina) references Maquina(idMaquina)
);