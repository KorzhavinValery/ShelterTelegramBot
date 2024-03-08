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