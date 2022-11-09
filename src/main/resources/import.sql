INSERT INTO restaurant(id, cep, complement, name) VALUES(1L, '07097-420', 'Av. Bartolomeu de Carlos, 230 PISO G1', 'Coco Bambu Guarulhos');
INSERT INTO restaurant(id, cep, complement, name) VALUES(2L, '07061-002', 'Av. Dr. Timóteo Penteado, 3757', 'Cantina Giovanni');

INSERT INTO client (id, cep, complement, name) VALUES(1L, '02124-000', 'Av. das Cerejeiras, 1156', 'Fulano de Tal');

INSERT INTO product (id, available, name, unity_value, restaurant_id) VALUES(1L, true, 'Filé à Brasileira', 76.50, 2L);
INSERT INTO product (id, available, name, unity_value, restaurant_id) VALUES(2L, true, 'Romanesca', 67.80, 2L);
INSERT INTO product (id, available, name, unity_value, restaurant_id) VALUES(3L, true, 'Bacalhau à Lagareiro ', 132.00, 1L);

INSERT INTO carrinho (id, Payment_form, closed, total, client_id) VALUES(1L, 0, false, 0.0, 1L);