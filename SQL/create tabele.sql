drop database if exists policlinica;
create database policlinica;

use policlinica;

CREATE TABLE `policlinica`.`unitate_medicala` (
  `id_unitate_medicala` INT NOT NULL AUTO_INCREMENT,
  `nume_unitate_medicala` VARCHAR(45) NULL,
  `adresa` VARCHAR(100) NULL,
  `iban` VARCHAR(45) NULL,
  `buget` DOUBLE(10,2) NULL,
  PRIMARY KEY (`id_unitate_medicala`));

CREATE TABLE `policlinica`.`orar_unitate_medicala` (
  `id_unitate_medicala` INT NOT NULL,
  `ziua` VARCHAR(45) NULL,
  `ora_incepere` INT NULL,
  `ora_final` INT NULL,
  PRIMARY KEY (`id_unitate_medicala`));

CREATE TABLE `policlinica`.`angajat` (
  `id_angajat` INT NOT NULL AUTO_INCREMENT,
  `nume` VARCHAR(45) NULL,
  `prenume` VARCHAR(45) NULL,
  `adresa` VARCHAR(100) NULL,
  `nr_telefon` VARCHAR(10) NULL,
  `email` VARCHAR(45) NULL,
  `salariu` DOUBLE(10,2) NULL,
  `functie` VARCHAR(45) NULL,
  `nr_ore` INT NULL,
  `data_angajarii` DATE NULL,
  `iban` VARCHAR(45) NULL,
  `cnp` VARCHAR(45) NULL,
  `id_unitate_medicala` INT NULL,
  `id_rol` INT NULL,
  PRIMARY KEY (`id_angajat`));

CREATE TABLE `policlinica`.`orar_angajat` (
  `id_angajat` INT NOT NULL,
  `id_unitate_medicala` INT NULL,
  `ziua` VARCHAR(45) NULL,
  `ora_incepere` INT NULL,
  `ora_final` INT NULL,
  PRIMARY KEY (`id_angajat`));

CREATE TABLE `policlinica`.`serviciu_medical` (
  `id_serviciu_medical` INT NOT NULL AUTO_INCREMENT,
  `id_medic` INT NULL,
  `nume_serviciu_medical` VARCHAR(45) NULL,
  `id_specialitate` INT NULL,
  `id_echipament` INT NULL,
  `id_analiza` INT NULL,
  `pret` DOUBLE(10,2) NULL,
  `durata` INT NULL,
  PRIMARY KEY (`id_serviciu_medical`));

CREATE TABLE `policlinica`.`raport_medical` (
  `id_raport` INT NOT NULL AUTO_INCREMENT,
  `id_analiza` INT NULL,
  `id_pacient` INT NULL,
  `id_angajat` INT NULL,
  `id_serviciu_medical` INT NULL,
  `data` DATE NULL,
  `observatii` VARCHAR(100) NULL,
  PRIMARY KEY (`id_raport`));

CREATE TABLE `policlinica`.`asistent_medical` (
  `id_angajat` INT NOT NULL AUTO_INCREMENT,
  `tip` VARCHAR(45) NULL,
  `grad` VARCHAR(45) NULL,
  PRIMARY KEY (`id_angajat`));

CREATE TABLE `policlinica`.`bon_fiscal` (
  `id_bon` INT NULL,
  `id_angajat` INT NULL,
  `id_analiza` INT NULL,
  `id_medic` INT NULL,
  `nume_analiza` VARCHAR(45) NULL,
  `pret_analiza` DOUBLE(10,2) NULL);

CREATE TABLE `policlinica`.`medic` (
  `id_angajat` INT NULL,
  `cod_parafa` VARCHAR(45) NULL,
  `titlu_stiintific` VARCHAR(45) NULL,
  `post_didactic` VARCHAR(45) NULL,
  `comision` DOUBLE(10,2) NULL,
  `id_unitate_medicala` INT NULL);

CREATE TABLE `policlinica`.`receptioner` (
  `id_angajat` INT NOT NULL,
  PRIMARY KEY (`id_angajat`));

CREATE TABLE `policlinica`.`specializare_medic` (
  `id_medic` INT NOT NULL,
  `id_specializare` INT NULL,
  `grad_medic` VARCHAR(45) NULL,
  PRIMARY KEY (`id_medic`));

CREATE TABLE `policlinica`.`concediu` (
  `id_concediu` INT NOT NULL AUTO_INCREMENT,
  `id_angajat` INT NULL,
  `data_incepere` DATE NULL,
  `data_final` DATE NULL,
  PRIMARY KEY (`id_concediu`));

CREATE TABLE `policlinica`.`cabinet` (
  `id_cabinet` INT NOT NULL AUTO_INCREMENT,
  `id_unitate_medicala` INT NULL,
  `id_specialitate` INT NULL,
  `nume_cabinet` VARCHAR(45) NULL,
  PRIMARY KEY (`id_cabinet`));

CREATE TABLE `policlinica`.`preturi` (
  `id_pret` INT NOT NULL AUTO_INCREMENT,
  `nume_serviciu` VARCHAR(45) NULL,
  PRIMARY KEY (`id_pret`));

CREATE TABLE `policlinica`.`echipament_cabinet` (
  `id_cabinet` INT NOT NULL,
  `id_echipament` INT NULL,
  PRIMARY KEY (`id_cabinet`));

CREATE TABLE `policlinica`.`echipament` (
  `id_echipament` INT NOT NULL AUTO_INCREMENT,
  `nume_echipament` VARCHAR(45) NULL,
  PRIMARY KEY (`id_echipament`));

CREATE TABLE `policlinica`.`specialitate` (
  `id_specialitate` INT NOT NULL AUTO_INCREMENT,
  `nume_specialitate` VARCHAR(45) NULL,
  PRIMARY KEY (`id_specialitate`));

CREATE TABLE `policlinica`.`programare` (
  `id_programare` INT NOT NULL AUTO_INCREMENT,
  `id_pacient` INT NULL,
  `id_specialitate` INT NULL,
  `id_receptioner` INT NULL,
  `id_medic` INT NULL,
  `data` DATE NULL,
  `ora` INT NULL,
  PRIMARY KEY (`id_programare`));

CREATE TABLE `policlinica`.`orar_medic` (
  `id_orar` INT NOT NULL AUTO_INCREMENT,
  `id_medic` INT NULL,
  `ziua` VARCHAR(45) NULL,
  `ora_incepere` INT NULL,
  `ora_final` INT NULL,
  PRIMARY KEY (`id_orar`));

CREATE TABLE `policlinica`.`analiza` (
  `id_analiza` INT NOT NULL AUTO_INCREMENT,
  `id_pacient` INT NULL,
  `diagnostic` VARCHAR(45) NULL,
  `pozitiv` INT NULL,
  `val_min` INT NULL,
  `val_max` INT NULL,
  `val_masurata` INT NULL,
  `id_asistent` INT NULL,
  `pret` DOUBLE(10,2) NULL,
  PRIMARY KEY (`id_analiza`));

CREATE TABLE `policlinica`.`pacient` (
  `id_pacient` INT NOT NULL AUTO_INCREMENT,
  `nume_pacient` VARCHAR(45) NULL,
  `prenume_pacient` VARCHAR(45) NULL,
  PRIMARY KEY (`id_pacient`));

CREATE TABLE `policlinica`.`cont_user` (
  `id_cont` INT NOT NULL AUTO_INCREMENT,
  `id_pacient` INT NULL,
  `id_angajat` INT NULL,
  `username` VARCHAR(45) NULL,
  `parola` VARCHAR(45) NULL,
  `id_rol` INT NULL,
  `cnp` VARCHAR(45) NULL,
  PRIMARY KEY (`id_cont`));

CREATE TABLE `policlinica`.`drepturi` (
  `id_drept` INT NOT NULL AUTO_INCREMENT,
  `id_rol` INT NULL,
  `nume_drept` VARCHAR(45) NULL,
  `confirmare_drept` INT NULL,
  PRIMARY KEY (`id_drept`));

CREATE TABLE `policlinica`.`rol` (
  `id_rol` INT NOT NULL AUTO_INCREMENT,
  `nume_rol` VARCHAR(45) NULL,
  PRIMARY KEY (`id_rol`));

ALTER TABLE orar_unitate_medicala
ADD CONSTRAINT fk_orar_unitate_medicala_unitate_medicala
FOREIGN KEY (id_unitate_medicala) REFERENCES unitate_medicala(id_unitate_medicala);

ALTER TABLE orar_angajat
ADD CONSTRAINT fk_orar_angajat_unitate_medicala
FOREIGN KEY (id_unitate_medicala) REFERENCES unitate_medicala(id_unitate_medicala);

ALTER TABLE cabinet
ADD CONSTRAINT fk_cabinet_unitate_medicala
FOREIGN KEY (id_unitate_medicala) REFERENCES unitate_medicala(id_unitate_medicala);

ALTER TABLE angajat
ADD CONSTRAINT fk_angajat_unitate_medicala
FOREIGN KEY (id_unitate_medicala) REFERENCES unitate_medicala(id_unitate_medicala);

ALTER TABLE medic
ADD CONSTRAINT fk_medic_unitate_medicala
FOREIGN KEY (id_unitate_medicala) REFERENCES unitate_medicala(id_unitate_medicala);

ALTER TABLE raport_medical
ADD CONSTRAINT fk_raport_medical_asistent_medical
FOREIGN KEY (id_angajat) REFERENCES asistent_medical(id_angajat);

ALTER TABLE asistent_medical
ADD CONSTRAINT fk_asistent_medical_angajat
FOREIGN KEY (id_angajat) REFERENCES angajat(id_angajat);

ALTER TABLE orar_angajat
ADD CONSTRAINT fk_orar_angajat_angajat
FOREIGN KEY (id_angajat) REFERENCES angajat(id_angajat);

ALTER TABLE concediu
ADD CONSTRAINT fk_concediu_angajat
FOREIGN KEY (id_angajat) REFERENCES angajat(id_angajat);

ALTER TABLE medic
ADD CONSTRAINT fk_medic_angajat
FOREIGN KEY (id_angajat) REFERENCES angajat(id_angajat);

ALTER TABLE receptioner
ADD CONSTRAINT fk_receptioner_angajat
FOREIGN KEY (id_angajat) REFERENCES angajat(id_angajat);

ALTER TABLE cont_user
ADD CONSTRAINT fk_cont_user_angajat
FOREIGN KEY (id_angajat) REFERENCES angajat(id_angajat);

ALTER TABLE specializare_medic
ADD CONSTRAINT fk_specializare_medic_medic
FOREIGN KEY (id_medic) REFERENCES medic(id_angajat);

ALTER TABLE echipament_cabinet
ADD CONSTRAINT fk_echipament_cabinet_cabinet
FOREIGN KEY (id_cabinet) REFERENCES cabinet(id_cabinet);

ALTER TABLE echipament_cabinet
ADD CONSTRAINT fk_echipament_cabinet_echipament
FOREIGN KEY (id_echipament) REFERENCES echipament(id_echipament);

ALTER TABLE serviciu_medical
ADD CONSTRAINT fk_serviciu_medical_echipament
FOREIGN KEY (id_echipament) REFERENCES echipament(id_echipament);

ALTER TABLE cabinet
ADD CONSTRAINT fk_cabinet_specialitate
FOREIGN KEY (id_specialitate) REFERENCES specialitate(id_specialitate);

ALTER TABLE programare
ADD CONSTRAINT fk_programare_specialitate
FOREIGN KEY (id_specialitate) REFERENCES specialitate(id_specialitate);

ALTER TABLE medic
ADD CONSTRAINT fk_medic_cabinet
FOREIGN KEY (id_unitate_medicala) REFERENCES cabinet(id_unitate_medicala);

ALTER TABLE bon_fiscal
ADD CONSTRAINT fk_bon_fiscal_receptioner
FOREIGN KEY (id_angajat) REFERENCES receptioner(id_angajat);

ALTER TABLE programare
ADD CONSTRAINT fk_programare_receptioner
FOREIGN KEY (id_receptioner) REFERENCES receptioner(id_angajat);

ALTER TABLE programare
ADD CONSTRAINT fk_programare_pacient
FOREIGN KEY (id_pacient) REFERENCES pacient(id_pacient);

ALTER TABLE cont_user
ADD CONSTRAINT fk_cont_user_rol
FOREIGN KEY (id_rol) REFERENCES rol(id_rol);

ALTER TABLE drepturi
ADD CONSTRAINT fk_drepturi_rol
FOREIGN KEY (id_rol) REFERENCES rol(id_rol);

ALTER TABLE orar_medic
ADD CONSTRAINT fk_orar_medic_medic
FOREIGN KEY (id_medic) REFERENCES medic(id_angajat);

ALTER TABLE cont_user
ADD CONSTRAINT fk_cont_user_pacient
FOREIGN KEY (id_pacient) REFERENCES pacient(id_pacient);

ALTER TABLE analiza
ADD CONSTRAINT fk_analiza_pacient
FOREIGN KEY (id_pacient) REFERENCES pacient(id_pacient);

ALTER TABLE bon_fiscal
ADD CONSTRAINT fk_bon_fiscal_analiza
FOREIGN KEY (id_analiza) REFERENCES analiza(id_analiza);

ALTER TABLE bon_fiscal
ADD CONSTRAINT fk_bon_fiscal_medic
FOREIGN KEY (id_medic) REFERENCES medic(id_angajat);

ALTER TABLE serviciu_medical
ADD CONSTRAINT fk_medical_medic_serviciu
FOREIGN KEY (id_medic) REFERENCES medic(id_angajat);

ALTER TABLE serviciu_medical
ADD CONSTRAINT fk_serviciu_medical_analiza
FOREIGN KEY (id_analiza) REFERENCES analiza(id_analiza);

ALTER TABLE serviciu_medical
ADD id_unitate_medicala INT;

ALTER TABLE serviciu_medical
ADD CONSTRAINT fk_serviciu_medical_unitate_medicala
FOREIGN KEY (id_unitate_medicala) REFERENCES unitate_medicala(id_unitate_medicala);

alter table pacient
add nr_telefon varchar(10);

alter table pacient
add email varchar(45);

alter table pacient
add adresa varchar(100);

alter table bon_fiscal
add id_pacient int;

ALTER TABLE bon_fiscal
ADD CONSTRAINT fk_bon_fiscal_pacient
FOREIGN KEY (id_pacient) REFERENCES pacient(id_pacient);

ALTER TABLE `policlinica`.`raport_medical` 
CHANGE COLUMN `id_raport` `id_raport` INT NOT NULL ,
DROP PRIMARY KEY;

alter table raport_medical
add parafa varchar(45);
