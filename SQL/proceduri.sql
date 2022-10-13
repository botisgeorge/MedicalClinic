DROP PROCEDURE IF EXISTS verificare_date_logare;
DELIMITER //
CREATE PROCEDURE verificare_date_logare(IN `username` VARCHAR(45), IN `parola` VARCHAR(45), OUT `confirmare` INT)
BEGIN
	SET `confirmare` = -1;
	IF ((SELECT COUNT(*) FROM `cont_user` C WHERE C.`username`=`username` AND C.`parola`=`parola`) = 1) THEN
		IF ((SELECT `id_rol` FROM `cont_user` C WHERE C.`username`=`username` AND C.`parola`=`parola`) = 0) THEN
			SET `confirmare` = 0;
		END IF;
		IF ((SELECT `id_rol` FROM `cont_user` C WHERE C.`username`=`username` AND C.`parola`=`parola`) = 1) THEN
			SET `confirmare` = 1;
		END IF;
        IF ((SELECT `id_rol` FROM `cont_user` C WHERE C.`username`=`username` AND C.`parola`=`parola`) = 2) THEN
			SET `confirmare` = 2;
		END IF;
        IF ((SELECT `id_rol` FROM `cont_user` C WHERE C.`username`=`username` AND C.`parola`=`parola`) = 3) THEN
			SET `confirmare` = 3;
		END IF;
        IF ((SELECT `id_rol` FROM `cont_user` C WHERE C.`username`=`username` AND C.`parola`=`parola`) = 4) THEN
			SET `confirmare` = 4;
		END IF;
        IF ((SELECT `id_rol` FROM `cont_user` C WHERE C.`username`=`username` AND C.`parola`=`parola`) = 5) THEN
			SET `confirmare` = 5;
		END IF;
	END IF;
END;
// DELIMITER ;

drop procedure if exists stergere_orar_angajat;
delimiter //
create procedure stergere_orar_angajat(in `_id_angajat` int, in `_id_unitate_medicala` int, in `_ziua` varchar(45), out `confirmare` int)
begin
	if((select count(*) from `orar_angajat` where `id_angajat` = `_id_angajat` and `id_unitate_medicala` = `_id_unitate_medicala` and `ziua` like `_ziua`) >= 1) then
		if((select `functie` from `angajat` where `id_angajat` = `_id_angajat`) not like 'Medic'
        or(select count(*) from `programare` where `id_medic` = `_id_angajat` and dayname(`data`) like `_ziua`) = 0) THEN
        
        delete from `orar_angajat` where `id_angajat` = `_id_angajat` and `id_unitate_medicala` = `_id_unitate_medicala` and `ziua` like `_ziua`;
        set `confirmare` = 1; # ok
	else
        set `confirmare` = 0; # not ok
	end if;
	else
        set `confirmare` = 2; # given data not found
	end if;
end;
// DELIMITER ;

drop procedure if exists profit_per_unitate;
delimiter //
create procedure profit_per_unitate(in `_id_unitate_medicala` int, out `profit` double(10,2))
begin
	set @income = 0, @outcome = 0;
		select IFNULL(SUM(`pret`), 0) into @income from `serviciu_medical` where `id_unitate_medicala` = `_id_unitate_medicala`;
        select IFNULL(SUM(`salariu`), 0) into @outcome from `angajat` where `id_unitate_medicala` = `_id_unitate_nedicala`;
	set profit = income - outcome;
end;
// delimiter ;

drop procedure if exists actualizare_orar_angajat
delimiter //
create PROCEDURE actualizare_orar_angajat(in `_id_angajat` int, in `_id_unitate_medicala` int,in `_ora_incepere` int, in `_ora_final` int, in `_ziua` varchar(45), out `confirmare` int)
begin
	set `confirmare` = 0; # not ok
	if((select count(*) from `orar_angajat` where `id_angajat` = `_id_angajat` and `id_unitate_medicala` = `_id_unitate_medicala` and `ziua` like `_ziua`) >= 1) then
		if((select `functie` from `angajat` where `id_angajat` = `_id_angajat`) not like 'Medic'
        or(select count(*) from `programare` where `id_medic` = `_id_angajat` and dayname(`data`) like `_ziua`) = 0) THEN
        
        update `orar_angajat` set `id_angajat` = `_id_angajat`, `ora_incepere` = `_ora_incepere`, `ora_final` = `_ora_final`, `ziua` = `_ziua` where `id_angajat` = `_id_angajat` and `id_unitate_medicala` = `_id_unitate_medicala`;
        set `confirmare` = 1; # ok
	end if;
end if;
end
// delimiter ;

drop procedure if exists inserare_concediu;
delimiter //
create procedure inserare_concediu(in `_id_angajat` int, in `_data_incepere` date, in `_data_final` date, out `confirmare` int)
begin
	if((select count(*) from `concediu` where `id_angajat` = `_id_angajat` and ((`data_incepere`>=`_data_incepere` AND `data_incepere`<=`_data_final`) OR (`data_final`>=`_data_incepere` AND `data_final`<=`_data_final`) OR (`data_incepere`<`_data_incepere` AND `data_final`>`_data_final`))) = 0) THEN
		if((select `functie` from `angajat` where `id_angajat` = `_id_angajat`) not like 'Medic') then
			insert into `concediu` (`id_angajat`, `data_incepere`, `data_final`) values (`_id_angajat`, `_data_incepere`, `_data_final`);
			set `confirmare` = 1; #n-a fost nevoie de stergere
		else
		if((select count(*) from `programare` where `id_medic` = `_id_angajat` and `data` >= `_data_incepere` and `data` <= `_data_final`) > 0) then
			delete from `programare` where `id_medic` = `_id_angajat` and `data` >= `_data_incepere` and `data` <= `_data_final`;
            set `confirmare` = 2; #programari sterse
		end if;
	end if;
	else
		set `confirmare` = 0; #datele introduse nu au fost gasite
	end if;
end
// delimiter ;

drop procedure if exists adaugare_angajat;
delimiter //
create procedure adaugare_angajat(in `_id_angajat` int, in `_nume` varchar(45), in `_prenume` varchar(45), in `_adresa` varchar(100), in `_nr_telefon` varchar(10), in `_email` varchar(45), in `_salariu` double(10,2), in `_functie` varchar(45), in `_nr_ore` int, in `_data_angajarii` date, in `_iban` varchar(45), in `_cnp` varchar(45), in `_id_unitate_medicala` int, in `_id_rol` int, OUT `confirmare` INT)
begin
	if((select count(*) from `angajat` where `id_angajat`=`_id_angajat`) =0) then
		insert into `angajat` (`nume`,`prenume`,`adresa`,`nr_telefon`,`email`,`salariu`,`functie`,`nr_ore`,`data_angajarii`,`iban`,`cnp`,`id_unitate_medicala`,`id_rol`) values (`_nume`,`_prenume`,`_adresa`,`_nr_telefon`,`_email`,`_salariu`,`_functie`,`_nr_ore`,`_data_angajarii`,`_iban`,`_cnp`,`_id_unitate_medicala`,`_id_rol`);
        set `confirmare` = 1;
	else
		set `confirmare` = 0; #id_angajat already exists
	end if;
end;
// delimiter ;

drop procedure if exists adaugare_doctor;
delimiter //
create procedure adaugare_doctor(in  `_id_angajat` int, in `_cod_parafa` varchar(45), in `_titlu_stiintific` varchar(45), in `_post_didactic`  varchar(45), in `_comision` double(10,2), in `_id_unitate_medicala` int, out `confirmare` int)
begin
	set `confirmare` = 0;
    if(select count(*) from `medic` where `id_angajat` = `_id_angajat`)>0 then
		update `medic` set `cod_parafa` = `_cod_parafa`, `titlu_stiintific`=`_titlu_stiintific`,`post_didactic`=`_post_didactic`,`comision`=`_comision`,`id_unitate_medicala`=`_id_unitate_medicala` where `id_angajat` = `_id_angajat`;
        set `confirmare` = 2; # id-ul medicului exista deja, a fost editat medicul cu noile date de intrare
	else
	if(select count(*) from `angajat` where `id_angajat` = `_id_angajat`)>0 then #trebuie prima data sa fie in angajat
		insert into `medic` (`cod_parafa`,`titlu_stiintific`,`post_didactic`,`comision`,`id_unitate_medicala`) values (`_cod_parafa`,`_titlu_stiintific`,`_post_didactic`,`_comision`,`_id_unitate_medicala`);
	set `confirmare` = 1;
    end if;
end if;
end;
// delimiter ;

drop procedure if exists stergere_angajat;
delimiter //
create procedure stergere_angajat(in `_id_angajat` int, out `confirmare` int)
begin
	set `confirmare` = 0;
    if((select count(*) from `angajat` where `id_angajat` = `_id_angajat`) = 1) then
		delete from `angajat` where `id_angajat` = `_id_angajat`;
		set `confirmare` = 1;
	end if;
end;
// delimiter ;

drop procedure if exists actualizare_angajat;
delimiter //
create procedure actualizare_angajat(in `_id_angajat` int, in `_nume` varchar(45), in `_prenume` varchar(45), in `_adresa` varchar(100), in `_nr_telefon` varchar(10), in `_email` varchar(45), in `_salariu` double(10,2), in `_functie` varchar(45), in `_nr_ore` int, in `_data_angajarii` date, in `_iban` varchar(45), in `_cnp` varchar(45), in `_id_unitate_medicala` int, in `_id_rol` int, OUT `confirmare` INT)
begin
	if((select count(*) from `angajat` where `id_angajat` = `_id_angajat`) =1) then
		update `angajat` set `nume`=`_nume`, `prenume`=`_prenume`,`adresa`=`_adresa`,`nr_telefon`=`_nr_telefon`,`email`=`_email`,`salariu`=`_salariu`,`functie`=`_functie`,`nr_ore`=`_nr_ore`,`data_angajarii`=`_data_angajarii`,`iban`=`_iban`,`cnp`=`_cnp`,`id_unitate_medicala`=`_id_unitate_medicala`,`id_rol`=`_id_rol` where `id_angajat` = `_id_angajat`;
        set `confirmare` = 1;
	else
		set `confirmare` = 0;
	end if;
end;
// delimiter ;

drop procedure if exists adaugare_pacient;
delimiter //
create procedure adaugare_pacient(in `_nume_pacient` varchar(45), in `_prenume_pacient` varchar(45), in `_email` varchar(45), in `_adresa` varchar(100), in `nr_telefon` varchar(10))
begin
	insert into `pacient` (`nume_pacient`,`prenume_pacient`,`email`,`adresa`,`nr_telefon`) values (`_nume_pacient`,`_prenume_pacient`,`_email`,`_adresa`,`_nr_telefon`);
end;
// delimiter ;

drop procedure if exists adaugare_raport_medical;
delimiter //
create procedure adaugare_raport_medical(in `_id_raport` int, in `_id_analiza` int, in `_id_pacient` int, in `_id_angajat` int, in `_id_serviciu_medical` int, in `_data` DATE, in `_observatii` varchar(100))
begin
	insert into `raport_medical` (`id_raport`,`id_analiza`,`id_pacient`,`id_angajat`,`id_serviciu_medical`,`data`,`observatii`) values (`_id_raport`,`_id_analiza`,`_id_pacient`,`_id_angajat`,`_id_serviciu_medical`,`_data`,`_observatii`);
end;
// delimiter ;

drop procedure if exists actualizare_raport_medical;
delimiter //
create procedure actualizare_raport_medical(in `_id_raport` int, in `_id_analiza` int, in `_id_pacient` int, in `_id_angajat` int, in `_id_serviciu_medical` int, in `_data` DATE, in `_observatii` varchar(100), out `confirmare` int)
begin
	set `confirmare`=0;
    if((select count(*) from `raport_medical` where `id_raport` = `_id_raport`)>0) then
    update `raport_medical` set `id_analiza`=`_id_analiza`,`id_pacient`=`_id_pacient`,`id_angajat`=`_id_angajat`,`id_serviciu_medical`=`_id_serviciu_medical`,`data`=`_data`,`observatii`=`_observatii`;
    set `confirmare`=1;
	end if;
end;
// delimiter ;

drop procedure if exists confirmare_raport_medical;
delimiter //
create procedure confirmare_raport_medical(in `_id_raport` int, in `_cod_parafa` varchar(45), out `confirmare` int)
begin
	if((select count(*) from `raport_medical` where `id_raport` = `_id_raport`)>0 and (select count(*) from `medic` where `cod_parafa`=`_cod_parafa`)>0 ) then
    update `raport_medical` set `parafa`=`_cod_parafa` where `id_raport`=`_id_raport`;
    set `confirmare`=1;
    else
    set `confirmare`=0;
	end if;
end;
// delimiter ;

drop procedure if exists adaugare_analiza;
delimiter //
create procedure adaugare_analiza(in `_id_pacient` int, in `_diagnostic` varchar(45),in `_val_min` int, in `_val_max` int, in `_val_masurata` int , in `_id_asistent` int, in `_pret` double(10,2))
begin
	insert into `analiza` (`id_pacient`,`diagnostic`,`val_min`,`val_max`,`val_masurata`,`id_asistent`,`pret`) values (`_id_pacient`,`_diagnostic`,`_val_min`,`_val_max`,`_val_masurata`,`_id_asistent`,`_pret`);
    if(val_min>val_masurata or val_max<val_masurata) then
    update `analiza` set `pozitiv`= 1 where id_analiza=(select max(id_analiza) from `analiza`);
    else
    update `analiza` set `pozitiv`= 0 where id_analiza=(select max(id_analiza) from `analiza`);
    end if;
end;
// delimiter ;

drop procedure if exists adaugare_programare;
delimiter //
create procedure adaugare_programare(in `_id_pacient` int, in `_id_specialitate` int, in `_id_receptioner` int, in `_id_medic` int, in `_data` date, in `_ora` int, out `confirmare` int)
begin
	if((select count(*) from `medic` where `id_angajat` = `_id_medic`) = 1 
    and (select count(*) from `pacient` where `id_pacient` = `_id_pacient`) = 1
    and (select count(*) from `specialitati` where `id_specialitate` = `_id_specialitate`) = 1) then
    
    insert into `programare`(`id_pacient`,`id_specialitate`,`id_receptioner`,`id_medic`,`data`,`ora`) values (`_id_pacient`,`_id_specialitate`,`_id_receptioner`,`_id_medic`,`_data`,`_ora`);
    set `confirmare` = 1;
    else
    set `confirmare` = 0;
    end if;
end;
// delimiter ;
drop procedure if exists stergere_programare;
delimiter //
create procedure stergere_programare(in `_id_programare` int , out `confirmare` int)
begin
	if((select count(*) from `programare` where `id_programare` = `_id_programare`) >0 ) then
    delete from `programare` where `id_programare` = `_id_programare`;
    set `confirmare` = 1;
    else
    set `confirmare` = 0;
    end if;
end;
// delimiter ;