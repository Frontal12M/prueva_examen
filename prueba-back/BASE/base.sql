create database pruebaApi;
use pruebaApi;

  -- drop database pruebaApi;
show tables;

select * from user_s;

select * from user_info;

select * from user_type;
select * from gender;
--  Insercciones para Genero --

INSERT INTO gender
(id_gender,gender)
VALUES(1,'female');

INSERT INTO gender
(id_gender,gender)
VALUES(2,'male');
-- nsercciones para Type -- 
INSERT INTO user_type
(id_user_type, user_type)
VALUES(1,'Oper');

INSERT INTO user_type
(id_user_type, user_type)
VALUES(2,'Admin');
INSERT INTO user_type
(id_user_type, user_type)
VALUES(3,'Prueba');

--  Consultas --
select ut.* from user_type ut where user_type = "prueba2";