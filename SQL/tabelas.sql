 CREATE TABLE Utilizadores (
      idUtilizador      number(7) NOT NULL,
      nomeUtilizador    varchar2(50) NOT NULL UNIQUE,
      nome              varchar2(200) NOT NULL, 
      email             varchar2(70) NOT NULL UNIQUE, 
      password          varchar2(50) NOT NULL, 
      localidade        varchar2(50) NOT NULL, 
      dataRegisto       timestamp(7) DEFAULT CURRENT_TIMESTAMP NOT NULL, 
      avatar            BLOB, 
      sobreMim          varchar2(300), 
      nrAvaliacoes      number(4) DEFAULT 0 NOT NULL, 
      avaliacao         number(3,2) DEFAULT 0 NOT NULL, /*de 0 a 100*/
      dadosCompletos    number(1) DEFAULT 0 NOT NULL, 
      apagado           number(1) DEFAULT 0 NOT NULL,
      PRIMARY KEY (idUtilizador, nomeUtilizador));


    CREATE TABLE Receitas (
      idReceita       number(7) NOT NULL,
      nome            varchar2(100) NOT NULL,
      nomeUtilizador  varchar2(50) NOT NULL,
      data            timestamp(7) DEFAULT CURRENT_TIMESTAMP NOT NULL,
      nrImagens       number(2) DEFAULT 0 NOT NULL,
      categoria       varchar2(50) NOT NULL,
      preparacao      varchar2(1000) NOT NULL,
      nrAvaliacoes    number(4) DEFAULT 0 NOT NULL, 
      avaliacao       number(3,2) DEFAULT 0 NOT NULL, /*de 0 a 100*/
      tempoPrepMin    number(3) DEFAULT 0,
      nrPessoas       number(2) DEFAULT 0,
      custoPax        number(2,2) DEFAULT 0, /*por exemplo, 55.63€*/
      apagado         number(1) DEFAULT 0 NOT NULL,
      PRIMARY KEY (idReceita));


    CREATE TABLE Ingredientes (
     idIngrediente    number(7) NOT NULL,
     nomeIng          varchar2(50) NOT NULL,
     valorCalorico    number() DEFAULT 0 NOT NULL,
     factorAlergico   number(1) DEFAULT 0 NOT NULL, /*boolean para alergias*/
     PRIMARY KEY (idIngrediente));


    CREATE TABLE IngRec (
     idIngrediente   number(7) NOT NULL,
     idReceita       number(7) NOT NULL,
     PRIMARY KEY (idIngrediente, idReceita));
     )


    CREATE TABLE Categorias (
     nome varchar2(50) NOT NULL, 
     PRIMARY KEY (nome));


    CREATE TABLE Fotos (
     idFoto        number(7) NOT NULL,
     idReceita     number(7) NOT NULL, 
     foto          BLOB, 
     descricao     varchar2(300) NOT NULL, 
     PRIMARY KEY (idFoto, idReceita));


    CREATE TABLE ChefsSeguidos (
      idUtilizador   number(7) NOT NULL, 
      idUtilizador   number(7) NOT NULL, 
      PRIMARY KEY (idUtilizador));


    CREATE TABLE ReceitasFavoritas (
      idUtilizador number(7) NOT NULL, 
      idReceita    number(7) NOT NULL, 
      PRIMARY KEY (idUtilizador, idReceita));


    CREATE TABLE MinhasReceitas (
     idUtilizador number(7) NOT NULL, 
     idReceita    number(7) NOT NULL, 
     PRIMARY KEY (idUtilizador, idReceita));


    CREATE TABLE Administradores (
      nomeAdmin    varchar2(50) NOT NULL,
      password varchar2(70) NOT NULL, 
      PRIMARY KEY (nomeAdmin)); 