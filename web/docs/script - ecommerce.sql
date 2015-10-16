
CREATE TABLE cliente (
                clicodigo INT NOT NULL,
                nome VARCHAR(100) NOT NULL,
                cpf VARCHAR(12) NOT NULL,
                cnpj VARCHAR(20) NOT NULL,
                estado VARCHAR(100) NOT NULL,
                cidade VARCHAR(100) NOT NULL,
                bairro VARCHAR(100) NOT NULL,
                rua VARCHAR(40) NOT NULL,
                telefone VARCHAR(20) NOT NULL,
                PRIMARY KEY (clicodigo)
);


CREATE TABLE pedido (
                pedcodigo INT NOT NULL,
                clicodigo INT NOT NULL,
                emissao VARCHAR(100) NOT NULL,
                entrega VARCHAR(100) NOT NULL,
                PRIMARY KEY (pedcodigo)
);


CREATE TABLE PRODUTO (
                procodigo INT NOT NULL,
                descricao VARCHAR(100) NOT NULL,
                preco DECIMAL(10,2) NOT NULL,
                categoria VARCHAR(100) NOT NULL,
                estoque VARCHAR(100) NOT NULL,
                PRIMARY KEY (procodigo)
);


CREATE TABLE item_pedido (
                itecodigo INT NOT NULL,
                procodigo INT NOT NULL,
                pedcodigo INT NOT NULL,
                totalpedido VARCHAR(100) NOT NULL,
                desconto VARCHAR(100) NOT NULL,
                quantidade VARCHAR(100) NOT NULL,
                PRIMARY KEY (itecodigo)
);


ALTER TABLE pedido ADD CONSTRAINT cliente_pedido_fk
FOREIGN KEY (clicodigo)
REFERENCES cliente (clicodigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE item_pedido ADD CONSTRAINT pedido_item_pedido_fk
FOREIGN KEY (pedcodigo)
REFERENCES pedido (pedcodigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE item_pedido ADD CONSTRAINT produto_item_pedido_fk
FOREIGN KEY (procodigo)
REFERENCES PRODUTO (procodigo)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
