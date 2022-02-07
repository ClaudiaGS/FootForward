/* Setting up Patient DB */
create database patientDB;
use patientDB;

CREATE TABLE IF NOT EXISTS Patient (
  ID tinyint(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(125),
  last_name VARCHAR(125),
  sex VARCHAR(10),
  date_of_birth DATE,
  address VARCHAR(125),
  phone VARCHAR(125)
)ENGINE=INNODB;

insert into Patient(first_name, last_name, sex, date_of_birth,address,phone) values('firstName1', 'lastName1','F','2000-05-04','address1','phone1');
insert into Patient(first_name, last_name, sex, date_of_birth,address,phone) values('firstName2', 'lastName2','M','1990-05-04','address2','phone2');
