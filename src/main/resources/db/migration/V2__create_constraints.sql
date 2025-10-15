-- V2__add_unique_constraints.sql

-- Restrições UNIQUE para a tabela restaurante
ALTER TABLE restaurante
    ADD CONSTRAINT UK_restaurante_endereco UNIQUE (endereco_id);

ALTER TABLE restaurante
    ADD CONSTRAINT UK_restaurante_horario UNIQUE (horario_funcionamento_id);

ALTER TABLE restaurante
    ADD CONSTRAINT UK_restaurante_usuario UNIQUE (usuario_id);

-- Restrição UNIQUE para a tabela usuario
ALTER TABLE usuario
    ADD CONSTRAINT UK_usuario_endereco UNIQUE (endereco_id);