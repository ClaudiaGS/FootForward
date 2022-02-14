/* Setting up Patient DB */
create database patientDB;
use patientDB;
drop table patient;

CREATE TABLE IF NOT EXISTS Patient (
  ID tinyint(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(125),
  last_name VARCHAR(125),
  sex VARCHAR(10),
  date_of_birth DATE,
  address VARCHAR(125),
  phone VARCHAR(125)
)ENGINE=INNODB;

--insert into Patient(first_name, last_name, sex, date_of_birth,address,phone) values('firstName1', 'lastName1','F','2000-05-04','address1','phone1');
--insert into Patient(first_name, last_name, sex, date_of_birth,address,phone) values('firstName2', 'lastName2','M','1990-05-04','address2','phone2');
insert into Patient(last_name,first_name, date_of_birth,sex, address,phone) values ('Ferguson',	'Lucas', '1968-06-22','M','2 Warren Street','387-866-1399');
insert into Patient(last_name,first_name, date_of_birth,sex, address,phone) values ('Rees','Pippa',	'1952-09-27','F','745 West Valley Farms Drive','628-423-0993');
insert into Patient(last_name,first_name, date_of_birth,sex, address,phone) values ('Arnold','Edward','1952-11-11','M','599 East Garden Ave','123-727-2779');
insert into Patient(last_name,first_name, date_of_birth,sex, address,phone) values ('Sharp','Anthony',	'1946-11-26','M','894 Hall Street',	'451-761-8383');
insert into Patient(last_name,first_name, date_of_birth,sex, address,phone) values ('Ince', 'Wendy','1958-06-29','F','4 Southampton Road','802-911-9975');
insert into Patient(last_name,first_name, date_of_birth,sex, address,phone) values ('Ross','Tracey','1949-12-07','F','40 Sulphur Springs Dr','131-396-5049');
insert into Patient(last_name,first_name, date_of_birth,sex, address,phone) values ('Wilson','Claire','1966-12-31','F','12 Cobblestone St','300-452-1091');
insert into Patient(last_name,first_name, date_of_birth,sex, address,phone) values ('Buckland','Max','1945-06-24','M','193 Vale St','833-534-0864');
insert into Patient(last_name,first_name, date_of_birth,sex, address,phone) values ('Clark','Natalie','1964-06-18','F','12 Beechwood Road','241-467-9197');
insert into Patient(last_name,first_name, date_of_birth,sex, address,phone) values ('Bailey','Piers','1959-06-28','M','1202 Bumble Dr','747-815-0557');


