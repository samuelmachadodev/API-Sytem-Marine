create table barco (
    id bigint not null auto_increment,
    nome varchar(100) not null,
    proprietario varchar(100) not null,
    marinheiro varchar(100),
    modelo varchar(100),
    tamanho varchar(50),
    registro varchar(50) not null,
    observacoes varchar(500),
    vaga int not null,
    
    primary key (id),
    unique (registro)
);