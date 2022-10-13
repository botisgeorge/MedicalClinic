USE `policlinica`;

INSERT INTO `unitate_medicala` (`nume_unitate_medicala`, `adresa`, `iban`) VALUES
	('Apollo Baia-Mare', 'str. Garii, nr. 16', 'RO25RZBR4577718653766565'),
    ('Apollo Baia-Sprie', 'str. Aleea Minerilor, nr. 24', 'RO29RZBR6571542451564256'),
	('Apollo Bucuresti', 'str. Mihai Eminescu, nr. 181', 'RO30PORL6891867233628817'),
	('Apollo Cluj-Napoca', 'str. Dunarii, nr. 57', 'RO48PORL8675477815543435'),
	('Apollo Hateg', 'str. Tudor Vladimirescu, nr. 10', 'RO50RZBR1829565815526722');
    
INSERT INTO `orar_unitate_medicala` (`id_unitate_medicala`, `ziua`, `ora_incepere`, `ora_final`) VALUES
('1', 'Luni', '0800', '2000'),
('1', 'Marți', '0800', '2000'),
('1', 'Miercuri', '0800', '2000'),
('1', 'Joi', '0800', '2000'),
('1', 'Vineri', '1000', '1800'),
('1', 'Sâmbătă', '1000', '1600'),

('2', 'Luni', '0800', '2000'),
('2', 'Marți', '0800', '2000'),
('2', 'Miercuri', '0800', '2000'),
('2', 'Joi', '0800', '2000'),
('2', 'Vineri', '0800', '2000'),

('3', 'Luni', '0700', '2000'),
('3', 'Marți', '0700', '2100'),
('3', 'Miercuri', '0700', '2100'),
('3', 'Joi', '0700', '2100'),
('3', 'Vineri', '0700', '2000'),
('3', 'Sâmbătă', '1000', '1800'),
('3', 'Duminică', '1000', '1700'),

('4', 'Luni', '0700', '2100'),
('4', 'Marți', '0700', '2100'),
('4', 'Miercuri', '0700', '2100'),
('4', 'Joi', '0700', '2100'),
('4', 'Vineri', '0700', '2100'),
('4', 'Sâmbătă', '0900', '1600'),
('4', 'Duminică', '0900', '1200'),

('5', 'Luni', '0900', '2100'),
('5', 'Marți', '0900', '2100'),
('5', 'Miercuri', '0900', '2100'),
('5', 'Joi', '0900', '2100'),
('5', 'Vineri', '1200', '2200');


INSERT INTO `cabinet` (`id_unitate_medicala`,`nume_specialitate`, `nume_cabinet`) VALUES
	('1','Dermatologie', 'Cabinet Dermatologie'),
	('1','Cardiologie', 'Cabinet Cardiologie'),
	('1','Neurologie','Cabinet Neurochirurgie'),
	('1','Pediatrie', 'Cabinet Pediatrie'),
    ('1','Chirurgie', 'Sala de operatie'), 
-- 5
	('2','Stomatologie', 'Cabinet Stomatologie'),
	('2','ORL', 'Cabinet ORL'),
	('2','Ortopedie', 'Cabinet Ortopedie'),
	('2','Endocrinologie', 'Cabinet Endocrinologie'),
    ('2','Pneumoftiziologie', 'Cabinet Probe Funcționale Respiratorii'),
-- 5
	('3','Radiologie', 'Cabinet Radiologie'),
	('3','Radiologie si imagistica', 'Cabinet RMN'),
    ('3','Chirurgie plastica', 'Cabinet Chirurgie plastica'),
	('3','Radiologie si imagistica', 'Cabinet RMN'),
	('3','Chirurgie', 'Sala de operatie'),
-- 5
    
	('4','Diabet si boli de nutritie', 'Cabinet Diabet si boli de nutritie'),
	('4','Stomatologie', 'Cabinet Stomatologie'),
	('4','ORL', 'Cabinet ORL'),
	('4','Psihologie', 'Psihologie'),
-- 4
	('5','Endocrinologie', 'Cabinet Endocrinologie'),
	('5','Psihiatrie', 'Cabinet Psihiatrie'),
	('5','ORL', 'Cabinet ORL'),
    ('5','Cardiologie', 'Cabinet Cardiologie');
-- 4


INSERT INTO `echipament` (`nume_echipament`) VALUES
	('Computer tomograf'),
	('RMN'),
	('EKG'),
	('TMS NEURO MS/D'),
	('Aparat radiologie'),
	('Dermatoscop Digital'),
	('Lampa UV'),
	('Ecograf'),
	('Scaun stomatologic'),
	('Unitate de diagnosticare ORL'),
	('Camera endoscopica ORL'),
	('Ecograf'), 
	('Sistem chirurgical'),
	('Electrocauter'),
	('Instalatie radiologica'),
    ('Aspirator chirurgical'),
   ('Glucometru');
-- 17
-- DELETE FROM `equipments`;

INSERT INTO `echipament_cabinet` (`id_cabinet`, `id_echipament`) VALUES
    ('1', '6'),
    
	('2', '2'),
	('2', '7'),
    ('2', '15'),
	('2', '3'),
    
    ('3', '2'),
	('3', '7'),
	('3', '8'),
    
	('4', '9'),
    
    ('5', '9'),
    
	('6', '10'),
	('6', '11'),
    -- 7 e cabinet nou nu are nimic teapa
	('8', '14'),
	('8', '8'),
    
	('9', '5'),
	('9', '12'),
    
	('10', '1'),
	('10', '2'),
    
	('11', '5'),
	('11', '15'),
    
	('12', '2'),
	('12', '3'),

	('13', '16'),
	('13', '14'),
	('13', '13'),
    
	('14', '2'),
	('14', '3'),
    
	('15', '13'),
	('15', '16'),
	('15', '13'),
    
	('16', '17'),
    
    
	('17', '7'),
	('17', '9'),
    
	('18', '10'),
    ('18', '11'),
    
	('19', '4'),

	('20', '5'),
	('20', '12'),
    
	('21', '4'),
    
    ('22', '10'),
    ('22', '11'),
    
     ('23', '7'),
    ('23', '15'),
	('23', '2');
    
--     INSERT INTO `rol` (`nume`) VALUES
-- 	('pacient'--0),
-- 	('receptioner'),
-- 	('resurse_umane'--3),
-- 	('asistent_medical' --2),
-- 	('medic'--1),
-- 	('contabil'--4),
-- 	('administrator'--5),;   --- de la 1 in sus e angajat
    
    
	INSERT INTO `asistent_medical` (`tip`,`grad`) VALUES
	('generalist','principal'),
	('laborant','secundar'),
	('radiologie','principal'),
	('generalist','principal');
    
    INSERT INTO `orar_angajat` (`id_angajat`, `id_unitate_medicala`, `ziua`, `ora_incepere`, `ora_final`) VALUES
('40','1', 'Luni', '0900', '1600'),
('41','1', 'Marți', '0900', '1800'),
('42','1', 'Miercuri', '1100', '2100'),
('43','1', 'Joi', '0900', '2100'),
('40','1', 'Vineri', '0900', '2100'),
('41','1', 'Sâmbătă', '0900', '2100'),

('10','2', 'Luni', '0900', '2100'),
('11','2', 'Marți', '0900', '2100'),
('13','2', 'Miercuri', '0900', '2100'),
('14','2', 'Joi', '1500', '2100'),
('15','2', 'Vineri', '1500', '2100'),

('21','3', 'Luni', '0900', '1400'),
('22','3', 'Marți', '0900', '1500'),
('23','3', 'Miercuri', '1500', '2100'),
('21','3', 'Joi', '0900', '2100'),
('24','3', 'Vineri', '0900', '2100'),
('22','3', 'Sâmbătă', '1500', '2100'),
('23','3', 'Duminică', '0900', '2100'),
('25','3', 'Luni', '0900', '1400'),
('21','3', 'Marți', '0900', '1500'),
('25','3', 'Miercuri', '1500', '2100'),
('22','3', 'Joi', '0900', '2100'),
('26','3', 'Vineri', '0900', '2100'),
('26','3', 'Sâmbătă', '1500', '2100'),
('27','3', 'Duminică', '0900', '2100'),


('1','4', 'Luni', '0900', '2100'),
('1','4', 'Marți', '0900', '2100'),
('2','4', 'Miercuri', '0900', '2100'),
('3','4', 'Joi', '0900', '2100'),
('3','4', 'Vineri', '0900', '2100'),
('2','4', 'Sâmbătă', '0900', '2100'),
('4','4', 'Duminică', '0900', '2100'),

('30','5', 'Luni', '0900', '2100'),
('31','5', 'Marți', '0900', '2100'),
('32','5', 'Miercuri', '0900', '2100'),
('33','5', 'Joi', '0900', '1800'),
('34','5', 'Vineri', '0900', '1400'),
('31','5', 'Luni', '0900', '2100'),
('32','5', 'Marți', '0900', '2100'),
('33','5', 'Miercuri', '0900', '2100'),
('34','5', 'Joi', '0900', '1800'),
('35','5', 'Vineri', '0900', '1400');




INSERT INTO `specialitate` (`nume_specialitate`) VALUES
	('Cardiologie'),
	('Dermatologie si venerologie'),
	('Chirurgie'),
	('Chirurgie plastica'),
	('Radiologie si imagistica'),
	('Pneumoftiziologie'),
	('Radiologie'),
	('Stomatologie'),
	('ORL'),
	('Ortopedie'),
	('Pediatrie'),
	('Diabet si boli de nutritie'),
	('Oftalmologie'),
    ('Neurologie'),
	('Endocrinologie'),
    ('Psihologie'),
    ('Psihiatrie'),
    ('Urologie');

    
    
    INSERT INTO `pacient`( `nume_pacient`, `prenume_pacient` , `nr_telefon`, `email`,  `adresa`) VALUES
( 'Ionescu','Oana','0745634674','ionescu_oana49@gmail.com','Str. Fructelor,18,Cluj-Napoca'),
( 'Dragos','Ilie','0702024663','dragos_ilie23@gmail.com','Str. Feroviarilor nr. 14-T,19,Cluj-Napoca' ),
    
('Sala','Nicolae','0707422975','sala_nicolae67@gmail.com','Str. Vidu Ion nr. 16-T,35,Baia Mare'),
( 'Cojoc','Silvia','0702005164','cojoc_silvia51@gmail.com','Bd. Republicii nr. 27-35,35,Baia Mare' ),
( 'Codreanu','Dragomir','0749200518','codreanu_dragomir59@gmail.com','Str. Luntrei nr. 1-T,22,Baia Mare'),
('Toma','Alex','0702018425','toma_alex44@gmail.com','Str. Fabricii nr. 2-4,35,Baia Mare'),
    
('Dumitrescu','Teadora','0705702268','dumitrescu_teadora07@gmail.com','Str. Eternitatii nr. 21-T; 22-T,26,Bucuresti'),
('Torje','Artur','0799758561','torje_artur92@gmail.com','Str. Garibaldi Giuseppe,25,Bucuresti'),
('Cornea','Aurelia','0702045929','cornea_aurelia58@gmail.com','Bd. Mihalache Ion nr. 128-138,32,Bucuresti'),
('Cojocaru','Viorica','0705393461','cojocaru_viorica96@gmail.com','Str. Lascar Vasile nr. 31-57,10,Bucuresti'),

('Bunea','Sorina','0702047606','bunea_sorina35@gmail.com','Str. Staruintei,27,Hateg'),
('Stan','Costel','0702039056','stan_costel80@gmail.com','Str. Doicescu Octav nr. 6-8,19,Hateg'),
('Nicu','Dinu','0700819095','nicu_dinu19@gmail.com','Str. Radulescu Ion Heliade,19,Hateg'),

('Lupu','Jeni','0736485769','lupu_jeni73@gmail.com','Str. Zamfirescu George Mihail nr. 41-T,12,Baia Sprie'),
('Nica','Tara','0787751020','nica_tara99@gmail.com','Str. Oituz,6,Baia Sprie');

    
    
    
INSERT INTO `angajat` (`nume`,`prenume`,`adresa`,`nr_telefon`,`email`,`salariu`,`functie`,`nr_ore`,`data_angajarii`,`iban`, `cnp`,`id_unitate_medicala`, `id_cont`) VALUES
('Ionut','Lazar','Str. Foisorului nr. 73-127,31,Cluj-Napoca','0712503790','ionut_lazar11@gmail.com','6400','medic','120','2016-04-15','RO93RZBR3122799664785376','5000413084011','4', 1),
('Ciodaru','Rotaru','Str. Udriste Nasturel,23,Cluj-Napoca','0702052954','ciodaru_rotaru29@gmail.com','3700','asistent medical','120','2019-10-12','RO38PORL3856673948613484','5030607090529','4',2),
('Petre','Matei','Str. Chisinau nr. 12-T,19,Cluj-Napoca','0707093322','petre_matei02@gmail.com','1900','receptioner','120','2015-08-07','RO17RZBR4826495171881361','5010903236502','4',6),
('Florin','Babes','Str. Pata Rat,23,Cluj-Napoca','0711334637','florin_babes66@gmail.com','3100','hr','120','2017-05-16','RO68PORL3836766213133211','1961010182466','4', 3),
('Ionut','Maria','Str. Foisorului nr. 73-127,31,Cluj-Napoca','0712503740','maria_lazar11@gmail.com','6400','medic','120','2017-04-15','RO93RZBR3122799664785556','2000413084011','4', 1),
('Florea','Alex','Str. Parang,1,Cluj-Napoca','0743334637','florea_alex66@gmail.com','3100','fr','120','2017-05-16','RO68PORL3834766214133211','1961089182466','4', 4),
('Poroc','Anca','Str.Hasdeu,22,Cluj-Napoca','0742334637','poroc_anca6@gmail.com','3100','ceo','120','2017-05-16','RO68PORL3836767813123211','1961670182466','4', 5),
('Ionut','Misu','Str. Foisorului nr. 73-127,45,Cluj-Napoca','0712503790','ionut_misu1@gmail.com','6400','ceo','120','2016-04-15','RO93RZBR3122799664785376','5000413084011','4', 5),
('Dinu','Lazar','Str. Aurel Vlaicu nr. 73-127,78,Cluj-Napoca','0712503790','dinu_lazar11@gmail.com','6400','medic','120','2016-04-15','RO93RZBR3122799664785376','5000413084011','4', 1),
('Sas','Mihaela','Str. Proscup nr. 73-127,989,Cluj-Napoca','0712503790','sas_mihaela11@gmail.com','6400','medic','120','2016-04-15','RO93RZBR3122799664785376','5000413084011','4', 1),

 ('Sala','Marioara','Str. Radu Negru,5,Baia Mare','0702056777','sala_marioara88@gmail.com','5800','medic','120','2021-09-15','RO97RZBR7173964876965628','2880225135788','1', 1),
 ('Horatiu','Gusa','Str. Davila Alexandru,16,Baia Mare','0799061735','horatiu_gusa42@gmail.com','5900','medic','120','2020-09-15','RO03RZBR8157132874615498','1960106098842','1', 1 ),
('Stanescu','Emilia','Bd. Dacia nr. 31-35,33,Baia Mare','0702004244','stanescu_emilia84@gmail.com','5200','medic','120','2015-11-12','RO02RZBR4165328793298867','6001213178484','1', 1),
('Voicu','Tatiana','Str. Caragiale Ion Luca bl. 3-7,2,Baia Mare','0702011700','voicu_tatiana79@gmail.com','5300','medic','120','2016-12-16','RO85RZBR5775612859298652','2860420298279','1', 1),
('Crin','Izabela',' str. Petru Maior 29-19,Baia Mare','0762523572','crin_iza_1024@gmail.com','5600','medic','120','2013-01-30','RO11PORL9649944214969712','2701867345247','1', 1),
 ('Grigorescu','Matei','str. Calea Floresti 12,Baia Mare','0762521172','grigore.matei124@gmail.com','2700','hr','120','1996-08-30','RO11PORL9647744214969712','2801204117104','1', 3),
  ('Baran','Ileana','str. Nicolae Iorga nr. 13,Baia Mare','0762520072','baran_maria_ileana@gmail.com','2600','fr','120','2011-07-10','RO11PORL9647748814969712','1801204117104', '1', 4),
 ('Bitoleanu','Alexandra Ioana',' str. Lacul Rosu,Baia Mare','0745537474','bitoleanu_ale2@yahoo.com','2400','receptioner','120','2019-12-20','RO35RZBR8945177663379578','2931204115436','1', 6),
 ('Darie','Emanuel',' str. Mihai Viteazu nr. 2,Baia Mare','0723626386','darie.emanuel5@gmail.com','3400','asistent medical','120','2001-09-23','RO83RZBR6275958249175962','1971204466262','1', 2),
	


('Miruna','Lungu','Str. Batiste nr. 2-12,30,Bucuresti','0702038087','miruna_lungu45@gmail.com','5100','medic','120','2020-11-11','RO09RZBR6853317416147249','2921217430545','3',1),
('Sandra','Roman','Str. Inotesti,30,Bucuresti','0790387691','sandra_roman44@gmail.com','5700','medic','120','2021-12-07','RO10PORL4613854393643751','2880729281844','3',1),
('Petronela','Stanca','Str. Retezat,23,Bucuresti','0710290516','petronela_stanca18@gmail.com','5600','medic','120','2016-05-27','RO59RZBR2668511518458575','2930820349718','3', 1),
('Lupei','Teo','Bd. Independentei nr. 2-4,22,Bucuresti','0790908011','lupei_teo05@gmail.com','4900','medic','120','2017-09-05','RO69PORL4361589377548137','1961225260805','3', 1),
('Ungureanu','Sabina','Str. Romana nr. 25-63; 30-68,24,Bucuresti','0702055540','ungureanu_sabina96@gmail.com','5900','medic','120','2015-04-05','RO37RZBR1561772137985117','6020123454096','3', 1),
('Pop','Sergiu','Str. 1 Decembrie 1918 nr. 111-T,21,Bucuresti','0738126926','pop_sergiu16@gmail.com','3500','asistent medical','120','2020-10-15','RO11PORL2359321781187899','5010119271716','3', 2),
('Cristescu','George','str. Avram Iancu, Bucuresti','0729406749','crist_george10@yahoo.com','2200','hr','120','2011-10-12','RO51RZBR1936331687954251','5031223325965','3', 3),
('Matei','Ana Irina',' str. 1 Mai, Bucuresti','0767493068','matei_anairina@gmail.com','2500','fr','120','2017-05-19','RO51RZBR6517927994782623','2961201037997','3', 4),
('Stancu','Ioan Mihail',' str. Craiovei nr. 3, Bucuresti','0748692056','ioan.mihail.st@gmail.com','2300','receptioner','120','2016-10-07','RO40RZBR179875475936971','1830121466921','3', 6),


('Leonte','Paula','Str. Campinei,31,Hateg','0732893212','leonte_paula61@gmail.com','5600','medic','120','2009-10-21','RO04PORL5446143369392485','2950221295461','5', 1),
('Musat','Gheorghe','Str. Enescu George bl. A1-A13,32,Hateg','0702091862','musat_gheorghe25@gmail.com','5400','medic','120','2015-12-21','RO63RZBR5764749273268761','5011023169125','5', 1),
('Cernea','Carol','Str. Ispirescu Petre,6,Hateg','0702081152','cernea_carol10@gmail.com','5900','medic','120','2017-01-07','RO60PORL2167155984268851','1880430276510','5', 1),
('Poenaru','Iulian','Str. Eroilor,13,Hateg','0712919307','poenaru_iulian31@gmail.com','5100','medic','120','2019-02-07','RO59RZBR5944172381533197','1900406295231','5', 1),
('Pop','Mihai','Str. 1 Decembrie 1918 nr. 11-T,21,Hateg','0738126926','pop_mihai116@gmail.com','3500','asistent medical','120','2020-11-15','RO11PORL2459324481187899','5010459271716','5', 2),
('Muresanu','Mihai','Str. Coanda Henry nr. 18,Baia Sprie','0702004857','muresanu_mihai65@gmail.com','2200','hr','120','2011-10-12','RO51RZBR1936331258114451','5031222222965','5', 3),
('Nicoara','Marusea Ioana',' str. Rosca Daniela nr. 8, Baia Sprie','0745859753','nicoara_marusea7@gmail.com','2500','fr','120','2017-05-19','RO51RZBR6517447994292623','2944304194007','5', 4),
('Varga','Clara','Str. Racovita Emil nr. 25,Baia Sprie','0710170583','varga_clara81@gmail.com','2300','ceo','120','2016-10-07','RO40RZBR179449175936971','6077027324581','5', 5),

('Muresanu','Tudor','Str. Coanda Henry nr. 34,Baia Sprie','0702004857','muresanu_tudor65@gmail.com','2200','hr','120','2011-10-12','RO51RZBR1936331254414251','5031553325965','2', 3),
('Lupu','Cecilia','Str. Poienii,2,Baia Sprie','0723290641','lupu_cecilia07@gmail.com','2500','fr','120','2017-05-19','RO51RZBR4417927994292623','2920554194007','2', 4),
('Balitiu','Clara','Str. Racovita Emil nr. 2-6,Baia Sprie','0710170583','balitiu_clara81@gmail.com','2300','asistent medical','120','2016-10-07','RO40RZBR179645575936971','6021027355581','2', 2),
('Crivat','Paula','Str. Campinei,31,Baia Sprie','0732893212','crivat_paula61@gmail.com','5600','medic','120','2009-10-21','RO04PORL5446143369392485','2950221295461','2', 1),
('Voievod','Stefan','Str. Enescu George bl. 13,32,Baia Sprie','0702091862','voievod_stefan25@gmail.com','5400','medic','120','2015-12-21','RO63RZBR5764749273268761','5011023169125','2', 1),
('Cerneala','Carol','Str. Ispirescu Petre,6,Baia Sprie','0702081152','cerneala_carol10@gmail.com','5900','medic','120','2017-01-07','RO60PORL2167155984268851','1880430276510','2', 1),
('Pop','Iulian','Str. Eroilor,14,Baia Sprie','0712919307','pop_iulian31@gmail.com','5100','medic','120','2019-02-07','RO59RZBR5944172381533197','1900406295231','2', 1);

INSERT INTO `policlinica`.`medic` (`id_angajat`, `cod_parafa`, `comision`, `titlu_stiintific`, `post_didactic`) VALUES
	('1','98824','0.2',NULL,'profesor'),
	('5','80690','0.2','doctorand','lector'),
	('9','24173','0.3',NULL,'asistent'),
	('10','67323','0.2',NULL,'conferential'),
	('11','76895','0.3',NULL,'preparator'),
	('12','67441','0.2','doctorand','profesor'),
	('13','50662','0.3',NULL,NULL),
	('14','40885','0.3','doctor stiinte medicale','conferential'),
	('15','39003','0.2','doctorand',NULL),
	('20','47894','0.3','doctor stiinte medicale','conferential'),
	('21','75336','0.3',NULL,NULL),
    ('22','19857','0.5','doctorand','lector'),
    ('23','38967','0.4','doctor stiinte medicale','profesor'),
    ('24','35738','0.4','doctorand','lector'),
	('29','50112','0.2',NULL,NULL),
	('30','40875','0.3','doctor stiinte medicale',NULL),
	('31','48546','0.2','doctorand',NULL),
	('32','75283','0.3','doctor stiinte medicale','profesor'),
	('40','10928','0.2',NULL,NULL),
    ('41','16757','0.5','doctorand','profesor'),
    ('42','95384','0.4','doctor stiinte medicale','lector'),
    ('43','17645','0.4',NULL,'lector');
    
    INSERT INTO `policlinica`.`specializare_medic` (`id_medic`, `id_specialitate`, `grad_medic`) values
	('1',2,'specialist'),
	('5',1,'specialist'),
	('9',14,'primar'),
	('10',11,'specialist'),
	('11',3,'primar'),
	('12',8,'primar'),
	('13',9,'specialist'),
	('14',10,'specialist'),
	('15',15,'primar'),
	('20',6,'specialist'),
    ('21',7,'specialist'),
    ('22',5, 'primar'),
    ('23',4, 'specialist'),
    ('24',5,'primar'),
    ('29',3,'specialist'),
	('30',12,'primar'),
	('31',8,'specialist'),
    ('32',9,'specialist'),
    ('40',16, 'primar'),
    ('41',15, 'specialist'),
    ('42',17,'primar'),
    ('43',9,'specialist');

INSERT INTO `analiza` (`nume_analiza`,`id_pacient` ,`val_min`,`val_max`,`val_masurata`, `pret`) VALUES
	("Leucocite",1,3,10,11,150),
	("Trombocite",2,150,450,250,100),
	("Glicemia",1,70,110,120,200),
	("Trigliceride",2,50,150,70,90),
	("Colesterol",3,0,200,260,120),
	("Fibrinogen",4,200,400,220,100),
	("Sodiu",4,135,145,136,40),
	("Calciu",5,8,10,9,40),
	("Magneziu",1,1,2,3,40),
	("Calciu ionic seric",2,3,5,4,40),
	("Hemoglobina glicozilata",7,4,5,5,50),
	("Lipide",7,500,800,600,40),
	("VLDL",8,2,38,30,60),
	("Imunoglobulina A",8,90,450,300,70);
    
    
    INSERT INTO `concediu` (`id_angajat`, `data_incepere`, `data_final`) VALUES
	('1', '2020-11-08', '2020-11-13'),
	('10', '2021-12-10', '2021-12-15'),
	('5', '2021-12-15', '2021-12-17'),
	('3', '2021-10-10', '2021-10-15'),
    ('7', '2021-12-02', '2020-12-03'),
	('33', '2021-12-20', '2021-12-26'),
	('39', '2020-12-02', '2020-12-03'),
	('23', '2021-01-10', '2021-01-15');
    
    INSERT INTO `programare` (`id_pacient`, `id_specialitate`, `id_medic`, `data`, `ora`) VALUES
	(1, 1, 1, '2020-12-14', 1500),
	(2, 2, 5, '2020-12-14', 1430),
	(3, 3, 20, '2020-12-14' ,1000),
	(4, 4, 40, '2020-12-16', 1000),
	(1, 6, 24, '2020-12-16', 1100),
    (2, 5, 31, '2020-11-07', 1030),
    (5, 8, 32, '2020-11-07', 1230),
    (6, 9, 42, '2020-11-07' ,1430);
    

    