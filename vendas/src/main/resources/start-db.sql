INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (1, '2015-05-31', '2015-05-31', 'FINALIZADO', 140000, 1, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (1, 1, 140000, 140000, 1, 1);

INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (2, '2015-04-10', '2015-04-10', 'FINALIZADO', 75000, 1, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (2, 1, 75000, 75000, 2, 2);

INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (3, '2015-05-31', '2015-05-31', 'FINALIZADO', 60000, 2, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (3, 1, 60000, 60000, 3, 3);

INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (4, '2015-05-20', '2015-05-22', 'FINALIZADO', 75000, 3, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (4, 1, 75000, 75000, 1, 4);

INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (5, '2015-01-10', '2015-01-12', 'FINALIZADO', 75000, 3, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (5, 1, 75000, 75000, 1, 5);

INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (6, '2015-02-15', '2015-01-15', 'FINALIZADO', 16000, 3, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (6, 1, 16000, 16000, 4, 6);

INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (7, '2015-04-20', '2015-04-30', 'FINALIZADO', 500000, 4, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (7, 1, 110000, 110000, 5, 7);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (8, 2, 60000, 1200000, 6, 7);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (9, 1, 130000, 130000, 7, 7);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (10, 2, 70000, 140000, 8, 7);

INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (8, '2015-04-20', '2015-04-30', 'FINALIZADO', 514000, 5, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (11, 1, 90000, 90000, 9, 8);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (12, 1, 130000, 130000, 10, 8);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (13, 1, 95000, 95000, 11, 8);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (14, 1, 55000, 55000, 12, 8);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (15, 2, 48000, 144000, 13, 8);

INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (9, '2015-03-31', null, 'CANCELADO', 140000, 1, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (16, 1, 140000, 140000, 14, 9);

INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (10, '2015-03-31', '2015-03-31', 'FINALIZADO', 180000, 1, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (17, 1, 180000, 180000, 15, 10);

INSERT INTO pedido( id, data_criacao, data_finalizacao, situacaopedido, valor_total, id_cliente, id_usuario) VALUES (11, '2015-03-31', null, 'ABERTO', 40000, 1, 1);
INSERT INTO item_pedido(id, quantidade, valor_total, valor_unitario, id_veiculo, id_pedido) VALUES (18, 1, 40000, 40000, 16, 11);

SELECT setval('pedido_id_seq', (select max(id) from pedido));
SELECT setval('item_pedido_id_seq', (select max(id) from item_pedido));