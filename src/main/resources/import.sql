INSERT INTO user (first_name, last_name, email) VALUES ('Ola', 'Adel', 'ola@gmail.com');
INSERT INTO user (first_name, last_name, email) VALUES ('Ahmed', 'Mohamed', 'ahmed@gmail.com');
INSERT INTO user (first_name, last_name, email) VALUES ('Amr', 'Mohamed', 'amr@gmail.com');
INSERT INTO user (first_name, last_name, email) VALUES ('Mohamed', 'Mohamed', 'mohamed@gmail.com');
INSERT INTO user (first_name, last_name, email) VALUES ('Mostafa', 'Mohamed', 'mostafa@gmail.com');

INSERT INTO product (name, amount, is_available) VALUES ('dress', 400, true);
INSERT INTO product (name, amount, is_available) VALUES ('shirt', 300, false);
INSERT INTO product (name, amount, is_available) VALUES ('t-shirt', 250, true);
INSERT INTO product (name, amount, is_available) VALUES ('sweet-shirt', 500, true);
INSERT INTO product (name, amount, is_available) VALUES ('hair-clips', 20, true);
INSERT INTO product (name, amount, is_available) VALUES ('pants', 350, true);
INSERT INTO product (name, amount, is_available) VALUES ('blouse', 200, false);


INSERT INTO basket (user_id, payment_status, amount) VALUES (select id from user where email = 'ola@gmail.com', 'UN_PAID', 40);
INSERT INTO basket (user_id, payment_status, amount) VALUES (select id from user where email = 'ahmed@gmail.com', 'UN_PAID', 1600);
INSERT INTO basket (user_id, payment_status, amount) VALUES (select id from user where email = 'amr@gmail.com', 'UN_PAID', 620);
INSERT INTO basket (user_id, payment_status, amount) VALUES (select id from user where email = 'mohamed@gmail.com', 'UN_PAID', 1790);
INSERT INTO basket (user_id, payment_status, amount) VALUES (select id from user where email = 'mostafa@gmail.com', 'UN_PAID', 1390);



INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'shirt', select id from basket where user_id = (select id from user where email = 'amr@gmail.com'), 2);
INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'hair-clips', select id from basket where user_id = (select id from user where email = 'amr@gmail.com'), 1)


INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'hair-clips', select id from basket where user_id = (select id from user where email = 'ola@gmail.com'), 2);


INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'sweet-shirt', select id from basket where user_id = (select id from user where email = 'ahmed@gmail.com'), 2);
INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'pants', select id from basket where user_id = (select id from user where email = 'ahmed@gmail.com'), 1);	
INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 't-shirt', select id from basket where user_id = (select id from user where email = 'ahmed@gmail.com'), 1);


INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'hair-clips', select id from basket where user_id = (select id from user where email = 'mohamed@gmail.com'), 2);
INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'sweet-shirt', select id from basket where user_id = (select id from user where email = 'mohamed@gmail.com'), 2);
INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'pants', select id from basket where user_id = (select id from user where email = 'mohamed@gmail.com'), 1);	
INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'blouse', select id from basket where user_id = (select id from user where email = 'mohamed@gmail.com'), 2);

INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'hair-clips', select id from basket where user_id = (select id from user where email = 'mostafa@gmail.com'), 2);
INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'sweet-shirt', select id from basket where user_id = (select id from user where email = 'mostafa@gmail.com'), 2);
INSERT INTO BASKET_ITEM (product_id, basket_id, quantity) VALUES (select id from product where name = 'pants', select id from basket where user_id = (select id from user where email = 'mostafa@gmail.com'), 1);


