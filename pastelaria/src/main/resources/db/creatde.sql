CREATE TABLE pastelaria.pasteis(
    id text unique PRIMARY KEY NOT NULL,
    sabor text NOT NULL,
    ingrediente text NOT NULL,
     tamanho text NOT NULL,
    tipo text NOT NULL,
    valor real NOT NULL,
    quantidade integer NOT NULL

    
);