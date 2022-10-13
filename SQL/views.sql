DROP VIEW IF EXISTS `policlinica`.`vedere_raport_medical`;
CREATE VIEW `policlinica`.`vedere_raport_medical` AS
	SELECT * FROM `raport_medical`;


DROP VIEW IF EXISTS `policlinica`.`vedere_cabinet`;
CREATE VIEW `policlinica`.`vedere_cabinet` AS
	SELECT * FROM `cabinet`;


DROP VIEW IF EXISTS `policlinica`.`vedere_preturi`;
CREATE VIEW `policlinica`.`vedere_preturi` AS
	SELECT * FROM `preturi`;


DROP VIEW IF EXISTS `policlinica`.`vedere_medic`;
CREATE VIEW `policlinica`.`vedere_medic` AS
	SELECT * FROM `medic`;


DROP VIEW IF EXISTS `policlinica`.`vedere_programare`;
CREATE VIEW `policlinica`.`vedere_programare` AS
	SELECT * FROM `programare`;


DROP VIEW IF EXISTS `policlinica`.`vedere_concediu`;
CREATE VIEW `policlinica`.`vedere_concediu` AS
	SELECT * FROM `concediu`;


DROP VIEW IF EXISTS `policlinica`.`vedere_angajat`;
CREATE VIEW `policlinica`.`vedere_angajat` AS
	SELECT * FROM `angajat`;


DROP VIEW IF EXISTS `policlinica`.`vedere_serviciu_medical`;
CREATE VIEW `policlinica`.`vedere_serviciu_medical` AS
	SELECT `pret`, `id_unitate_medicala`, `id_medic` FROM `serviciu_medical`;


DROP VIEW IF EXISTS `policlinica`.`vedere_analiza`;
CREATE VIEW `policlinica`.`vedere_analiza` AS
	SELECT * FROM `analiza`;


DROP VIEW IF EXISTS `policlinica`.`vedere_angajat`;
CREATE VIEW `policlinica`.`vedere_angajat` AS
	SELECT * FROM `angajat`;

