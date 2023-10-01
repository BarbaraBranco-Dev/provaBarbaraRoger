CREATE TABLE pastelaria.pedido(
    id text unique PRIMARY KEY NOT NULL,
    nome text NOT NULL,
    cpf text NOT NULL,
    telefone integer NOT NULL,
    tipodepaagmento text NOT NULL,
    id_pastel text NOT NULL,

    CONSTRAINT fk_pastel_id FOREIGN KEY(pastel_id) REFERENCES pastelaria.pastel(id)
);


