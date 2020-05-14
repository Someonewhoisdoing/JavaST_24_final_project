--user
INSERT INTO USER(login, password, name, surname, phone, role)
values('admin', '666666', 'Alex', 'Cold', '+375339991317',1);

INSERT INTO USER(login, password, name, surname, phone, role)
values('savage', '12345', 'Max', 'Wrong', '+375299998877',2);

INSERT INTO USER(login, password, name, surname, phone, role)
values('node', '123', 'Lora', 'Ford', '+375299998899',2);


--address
INSERT INTO ADDRESS(city, street, house, flat, user_id)
values('Minsk', 'Lenina', 4, 45, 1);

INSERT INTO ADDRESS(city, street, house, flat, user_id)
values('Minsk', 'Orlovskaya', 8, 8, 2);


--ingredient
INSERT INTO INGREDIENT(id, name_list) values(1, 'water espresso');

INSERT INTO INGREDIENT(id, name_list) values(2, 'espresso milk');

INSERT INTO INGREDIENT(id, name_list) values(3, 'short pulled espresso');


--menu_item;
INSERT INTO MENU_ITEM(name, weight, cost, ingredient_id)
values('Americano', 50, 2, 1);

INSERT INTO MENU_ITEM(name, weight, cost, ingredient_id)
values('Americano', 100, 4, 1);

INSERT INTO MENU_ITEM(name, weight, cost, ingredient_id)
values('Cappuccino', 250, 3, 2);

INSERT INTO MENU_ITEM(name, weight, cost, ingredient_id)
values('Cappuccino', 350, 5, 2);

INSERT INTO MENU_ITEM(name, weight, cost, ingredient_id)
values('Latte', 250, 3, 2);

INSERT INTO MENU_ITEM(name, weight, cost, ingredient_id)
values('Latte', 350, 5, 2);

INSERT INTO MENU_ITEM(name, weight, cost, ingredient_id)
values('Macchiato', 250, 3, 2);

INSERT INTO MENU_ITEM(name, weight, cost, ingredient_id)
values('Macchiato', 350, 5, 2);


--order_item
INSERT INTO order_item(name, price, menu_item_id) VALUES('Americano', 2, 1);


--order_info
INSERT INTO ORDER_INFO(date, user_id, address_id, order_item_id)
values('2020-05-14', 2, 2, 1);




