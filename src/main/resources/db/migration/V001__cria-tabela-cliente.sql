create table cliente (

    id bigint not null auto_increment,
    nome varchar(60) not null,
    email varchar(25) not null,
    fone varchar(20) not null,
    
    primary key(id)
  
);