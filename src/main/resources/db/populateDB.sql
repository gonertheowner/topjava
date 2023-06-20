DELETE
FROM user_role;
DELETE
FROM users;
DELETE
FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100002);

INSERT INTO meals (datetime, description, calories, user_id)
VALUES ('2020-02-12 10:00:00', 'description', 1000, 100000),
       ('2020-02-12 13:00:00', 'another description', 500, 100000),
       ('2020-03-16 20:00:00', 'guest meal', 700, 100002),
       ('2020-02-11 15:30:00', 'another guest meal', 400, 100002);