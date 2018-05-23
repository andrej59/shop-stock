--
-- Data for table stock.sp_color (OID = 115769) (LIMIT 0,5)
--
INSERT INTO sp_color (id, name, ident) VALUES (1, 'Белый', 'WHITE');

INSERT INTO sp_color (id, name, ident) VALUES (2, 'Cиний', 'BLUE');

INSERT INTO sp_color (id, name, ident) VALUES (3, 'Красный', 'RED');

INSERT INTO sp_color (id, name, ident) VALUES (4, 'Зелёный', 'GREEN');

INSERT INTO sp_color (id, name, ident) VALUES (5, 'Чёрный', 'BLACK');

--
-- Data for table stock.sp_product_status (OID = 115776) (LIMIT 0,2)
--
INSERT INTO sp_product_status (id, name, ident) VALUES (1, 'Магазин', 'SHOP');

INSERT INTO sp_product_status (id, name, ident) VALUES (2, 'Склад', 'STOCK');

--
-- Data for table stock.sp_product_type (OID = 115783) (LIMIT 0,1)
--
INSERT INTO sp_product_type (id, name) VALUES (1, 'Одежда');

--
-- Data for table stock.sp_tog_kind (OID = 115788) (LIMIT 0,5)
--
INSERT INTO sp_tog_kind (id, name) VALUES (1, 'Платье');

INSERT INTO sp_tog_kind (id, name) VALUES (2, 'Брюки');

INSERT INTO sp_tog_kind (id, name) VALUES (3, 'Юбка');

INSERT INTO sp_tog_kind (id, name) VALUES (4, 'Жилетка');

INSERT INTO sp_tog_kind (id, name) VALUES (5, 'Рубашка');

COMMIT; 
