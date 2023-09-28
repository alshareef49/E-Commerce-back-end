DROP DATABASE if exists ECart;
CREATE DATABASE ECart;
USE ECart;

CREATE TABLE CUSTOMER (
    EMAIL_ID VARCHAR(50),
    NAME VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(70) NOT NULL,
    PHONE_NUMBER VARCHAR(10) NOT NULL UNIQUE,
    ADDRESS VARCHAR(500),
    CONSTRAINT CUSTOMER_EMAIL_ID_PK PRIMARY KEY (EMAIL_ID)
);

INSERT INTO CUSTOMER (EMAIL_ID,NAME,PASSWORD,PHONE_NUMBER,ADDRESS) VALUES ("shareef@gmail.com","Shareef","Shareef@123","7217687625","New Delhi,INDIA");


CREATE TABLE customer(
    email_id VARCHAR(50),
    name VARCHAR(50) NOT NULL,
    password VARCHAR(70) NOT NULL,
    phone_number VARCHAR(10) NOT NULL UNIQUE,
    address VARCHAR(500),
    CONSTRAINT customer_email_id_pk PRIMARY KEY (email_id)
);

INSERT INTO customer (email_id,name,password,phone_number,address) VALUES ("shareef@gmail.com","Shareef","Shareef@123","7217687625","New Delhi,INDIA");