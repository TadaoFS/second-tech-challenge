-- V3__add_foreign_keys.sql

-- Chaves Estrangeiras para a tabela prato
ALTER TABLE prato
    ADD CONSTRAINT FK_prato_restaurante FOREIGN KEY (restaurante_id) REFERENCES restaurante (id);

-- Chaves Estrangeiras para a tabela restaurante
ALTER TABLE restaurante
    ADD CONSTRAINT FK_restaurante_endereco FOREIGN KEY (endereco_id) REFERENCES endereco (id);

ALTER TABLE restaurante
    ADD CONSTRAINT FK_restaurante_horario_funcionamento FOREIGN KEY (horario_funcionamento_id) REFERENCES horario_funcionamento (id);

ALTER TABLE restaurante
    ADD CONSTRAINT FK_restaurante_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id);

-- Chave Estrangeira para a tabela usuario
ALTER TABLE usuario
    ADD CONSTRAINT FK_usuario_endereco FOREIGN KEY (endereco_id) REFERENCES endereco (id);