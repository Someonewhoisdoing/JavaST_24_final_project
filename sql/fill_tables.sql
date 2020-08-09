
INSERT INTO users(login, password, name, surname, phone, role)
values
('admin', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Alex', 'Cold', '+375339991317',1),
('user', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Alexey', 'hot', '+375444722956',2),
('user1', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Masha', 'Average', '+37544472296',2);

INSERT INTO ADDRESS(street, house, flat, user_id)
values
( 'Lenina', 4, 45, 1),
('Orlovskaya', 8, 8, 2),
('Bedi', 12, 4, 3);

INSERT INTO orders
(user_id, date)
VALUES
(2, '2020-01-3'),
(2, '2010-30-3'),
(2, '2012-02-3'),
(3, '2013-17-3'),
(3, '2013-14-3'),
(3, '2014-07-3'),
(3, '2015-26-3'),
(3, '2016-22-3'),
(2, '2019-13-3');

INSERT INTO items(order_id, name , weight, cost)
values
(1,'Americano', 50, 2),
(1,'Americano', 100, 4),
(1,'Cappuccino', 250, 3),
(2,'Cappuccino', 350, 5),
(2,'Latte', 250, 3),
(3,'Latte', 350, 5),
(4,'Macchiato', 250, 3),
(4,'Macchiato', 350, 5),
(5,'Americano', 50, 2),
(5,'Americano', 100, 4),
(5,'Cappuccino', 250, 3),
(6,'Cappuccino', 350, 5),
(7,'Latte', 250, 3),
(8,'Latte', 350, 5),
(8,'Macchiato', 250, 3),
(9,'Macchiato', 350, 5);


INSERT INTO basket_items(user_id, item_id)
values
(1,3),
(1,2),
(1,5),
(3,5),
(2,5),
(1,6),
(3,6),
(2,6),
(1,7),
(3,7),
(2,7),
(1,8),
(3,8),
(2,8);
