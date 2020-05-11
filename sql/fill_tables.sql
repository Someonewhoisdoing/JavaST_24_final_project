INSERT INTO USER(login, password, name, surname, phone, role)
values('admin', '666666', 'Alex', 'Cold', '+375339991317',1);

INSERT INTO USER(login, password, name, surname, phone, role)
values('savage', '12345', 'Max', 'Wrong', '+375299998877',2);

INSERT INTO USER(login, password, name, surname, phone, role)
values('node', '123', 'Lora', 'Ford', '+375299998899',2);

INSERT INTO ADDRESS(city, street, house, flat, user_id)
values('Minsk', 'Lenina', 4, 45, 1);

INSERT INTO ADDRESS(city, street, house, flat, user_id)
values('Minsk', 'Orlovskaya', 8, 8, 2);

INSERT INTO INGREDIENT(id, name_list) values(1, 'water espresso');
INSERT INTO INGREDIENT(id, name_list) values(2, 'espresso milk');
INSERT INTO INGREDIENT(id, name_list) values(3, 'short pulled espresso');

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

INSERT INTO RECEIPT(number, date, user_id)
values(1, '2020-04-02', 2);
INSERT INTO RECEIPT(number, date, user_id)
values(2, '2020-04-02', 3);

INSERT INTO ORDER_ITEM(name, price, menu_item_id)
values('Americano', 2, 1);

-- SELECT
-- *
-- FROM
-- vehicles
-- INNER JOIN users ON vehicles.car_owner = users.user_id