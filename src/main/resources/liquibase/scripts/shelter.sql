-- liquibase formatted sql

-- changeset vyacheslav:1

CREATE TABLE Animal_shelter (
    name_shelter VARCHAR(30) PRIMARY KEY,
    type_animal VARCHAR(10),
    general_information VARCHAR(255),
    contact_information VARCHAR(255),
    ordering_a_pass VARCHAR(255),
    safety_rules VARCHAR(255)
);
--changeset valery:2
-- Если сделана и заполнена выполнить DROP TABLE IF EXISTS *;
--DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id                LONG PRIMARY KEY,
    name              VARCHAR(30) NOT NULL,
    name_shelter        VARCHAR(30),
    FOREIGN KEY (name_shelter) REFERENCES Animal_shelter (name_shelter)
);
INSERT INTO users(id, name, name_shelter)
VALUES (1, 'User1', 'DOG'),
       (2, 'User2', 'CAT');

--changeset valery:3
-- Если сделана и заполнена выполнить DROP TABLE IF EXISTS *;
--DROP TABLE IF EXISTS message_to_volunteer;
CREATE TABLE message_to_volunteer
(
    id            INTEGER PRIMARY KEY AUTO_INCREMENT,
    user_id       LONG,
    question_time DATETIME,
    question      TEXT,
    answer_time   DATETIME,
    answer        TEXT,
    FOREIGN KEY (user_id) REFERENCES users (id)
);