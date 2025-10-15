insert into usuario (
    data_atualizacao,
    data_criacao,
    email,
    login,
    nome,
    senha,
    tipo_usuario,
    endereco_id
) values (
                     CURRENT_TIMESTAMP,
                     CURRENT_TIMESTAMP,
                     'admin@exemplo.com',
                     'admin',
                     'Administrador',
                     '$2a$10$T/4yRHnsBqXaA9/Phxlax.qkY1Z25hmA4rW6SMWR8RZ5sDZM6GeH.',
                     'ADMIN',
                     null
         );
