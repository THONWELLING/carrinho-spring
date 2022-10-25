INSERT INTO restaurant(id, cep, complement, name) VALUES(1L, '1', 'Complemento Endereço Restaurante 1', 'Restaurante 1');
INSERT INTO restaurant(id, cep, complement, name) VALUES(2L, '2', 'Complemento Endereço Restaurante 2', 'Restaurante 2');

INSERT INTO client (id, cep, complement, name) VALUES(1L, '1', 'Complemento Endereço Cliente 1', 'Cliente 1');

INSERT INTO product (id, available, name, unity_value, restaurant_id) VALUES(1L, true, 'Produto 1', 5.0, 1L);
INSERT INTO product (id, available, name, unity_value, restaurant_id) VALUES(2L, true, 'Produto 2', 6.0, 1L);
INSERT INTO product (id, available, name, unity_value, restaurant_id) VALUES(3L, true, 'Produto 3', 7.0, 2L);

INSERT INTO carrinho (id, Payment_form, closed, total, client_id) VALUES(1L, 0, false, 0.0, 1L);