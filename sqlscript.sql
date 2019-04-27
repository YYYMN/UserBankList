

CREATE TABLE user (
user_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(45),
surname VARCHAR(45)
);

INSERT INTO user(name, surname, account_id)
VALUES 
('Максим','Иванов', 1),
('Денис', 'Петров', 2),
('Александр', 'Жнай', 3),
('Сергей', 'Бабицкий', 4),
('Иван', 'Кирсанов', 5),
('Александр', 'Тарасевич', 6),
('Кристина', 'Чепорук', 7),
('Ольга', 'Жарикова', 8),
('Игорь', 'Семенов', 9),
('Евгений', 'Чеканович', 10);



CREATE TABLE account (
account_id INT PRIMARY KEY AUTO_INCREMENT,
account INT,
user_id INT,
FOREIGN KEY (user_id) REFERENCES user (user_id));

INSERT INTO account(account)
VALUES 
(1000),
(2000),
(3000),
(1000),
(15600),
(3000),
(1000),
(15600),
(3000),
(4000);
