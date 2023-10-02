CREATE TABLE pastelaria.pastel(

    id text unique PRIMARY KEY NOT NULL,
    sabor text NOT NULL,
    ingredientes text[] NOT NULL,
    tamanho text NOT NULL,
    tipo text NOT NULL,
    valor real NOT NULL,
    quantidade integer NOT NULL

);