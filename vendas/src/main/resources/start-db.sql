insert into modulo (id, nome, url, chave) values (1, 'Portal', 'http://localhost:8080/portal/token/', 'P0RT4LL');
insert into modulo (id, nome, url, chave) values (2, 'Cadastros', 'http://localhost:8080/cadastros/auth/', 'C4D4$TR0S');
insert into modulo (id, nome, url, chave) values (3, 'Pedidos', 'http://localhost:8080/pedidos/auth/', 'SACRSC1234');
insert into modulo (id, nome, url, chave) values (4, 'Relatórios', 'http://localhost:8080/relatorios/auth/', 'R3L4T0R10$');

SELECT setval('modulo_id_seq', (select max(id) from modulo));