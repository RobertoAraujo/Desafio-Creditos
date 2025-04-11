-- usuario
CREATE TABLE usuario (
                         id bigserial NOT NULL,
                         email varchar(255) NULL,
                         nome varchar(255) NULL,
                         senha varchar(255) NULL,
                         CONSTRAINT usuario_pkey PRIMARY KEY (id)
);

-- credito
CREATE TABLE credito (
                         id bigserial NOT NULL,
                         aliquota numeric(19, 2) NULL,
                         base_calculo numeric(19, 2) NULL,
                         data_constituicao date NULL,
                         numero_credito varchar(255) NULL,
                         numero_nfse varchar(255) NULL,
                         simples_nacional bool NOT NULL,
                         tipo_credito varchar(255) NULL,
                         valor_deducao numeric(19, 2) NULL,
                         valor_faturado numeric(19, 2) NULL,
                         valor_issqn numeric(19, 2) NULL,
                         usuario_id int8 NULL,
                         CONSTRAINT credito_pkey PRIMARY KEY (id),
                         CONSTRAINT fk8lmssky790mimegfbq5u28bow FOREIGN KEY (usuario_id) REFERENCES public.usuario(id)
);


INSERT INTO usuario (nome, email,senha)
VALUES ('Roberto Moraes', 'roberto@email.com','senha');

-- Supondo que o ID do usuário acima seja 1:
INSERT INTO credito (
    numero_credito, numero_nfse, data_constituicao,
    valor_issqn, tipo_credito, simples_nacional,
    aliquota, valor_faturado, valor_deducao,
    base_calculo, usuario_id
) VALUES (
             '123456', '7891011', '2024-02-25',
             1500.75, 'ISSQN', true,
             5.0, 30000.00, 5000.00,
             25000.00, 1
         );