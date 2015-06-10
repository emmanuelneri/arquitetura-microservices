--Insere os módulos
insert into modulo (id, nome, url, chave) values (1, 'Portal', 'http://localhost:8080/portal/token/', 'P0RT4LL');
insert into modulo (id, nome, url, chave) values (2, 'Vendas', 'http://localhost:8080/vendas/auth/', 'SACRSC1234');
insert into modulo (id, nome, url, chave) values (3, 'Relatórios', 'http://localhost:8080/relatorios/auth/', 'R3L4T0R10$');

--Insere usuário e seus módulos
insert into usuario (id, email, nome, senha, version) values (1, 'teste@gmail.com', 'Usuario 1', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 1);
insert into usuario_modulo(id_usuario, id_modulo) values (1, 1);
insert into usuario_modulo(id_usuario, id_modulo) values (1, 2);

insert into usuario (id, email, nome, senha, version) values (2, 'ws@gmail.com', 'WS', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 1);

--Insere configuração
INSERT INTO configuracao(id, nome_projeto) VALUES (1, 'Portal');
INSERT INTO configuracao_modulo(id_configuracao, id_modulo) VALUES (1,1);
INSERT INTO configuracao_modulo(id_configuracao, id_modulo) VALUES (1,2);

SELECT setval('modulo_id_seq', (select max(id) from modulo));
SELECT setval('usuario_id_seq', (select max(id) from usuario));
SELECT setval('configuracao_id_seq', (select max(id) from configuracao));

