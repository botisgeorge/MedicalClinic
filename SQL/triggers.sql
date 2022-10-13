drop trigger if exists stergere_orar_medic
delimiter //
create trigger  stergere_orar_medic before delete on `orar_medic` for each row
begin
	if ((select `functie` from `angajat` where `id_angajat` = old.`id_medic`) like 'Medic') then
		delete from `programare` P where P.`id_medic`=old.`id_medic` and dayname(P.`data`)=old.`ziua` and old.`ora_incepere` >= P.`ora` and old.`ora_final` <= P.`ora`;
	end if;
end;
//delimiter ;

drop trigger if exists editare_orar_medic
delimiter //
create trigger  editare_orar_medic before update on `orar_medic` for each row
begin
	if ((select `functie` from `angajat` where `id_angajat` = old.`id_medic`) like 'Medic') then
		delete from `programare` P where P.`id_medic`=old.`id_medic` and dayname(P.`data`)=old.`ziua` and `ora_incepere` >= P.`ora` and `ora_final` <= P.`ora`;
	end if;
end;
//delimiter ;

drop trigger if exists introducere_concediu
delimiter //
create trigger introducere_concediu after insert on `concediu` for each row
begin
	if((select `functie` from `angajat` where `id_angajat` = new.`id_angajat`) like 'medic') then
    delete from `programare` P where P.`id_medic` = new.`id_angajat` and P.`data` >= new.`data_incepere` and P.`data` <= new.`data_final`;
end if;
end;
// delimiter ;

drop trigger if exists inserare_angajat
delimiter //
create trigger inserare_angajat after insert on `angajat` for each row
begin
	set @id_rol = 0;
    if(new.`functie` like 'Medic') then #100 ore
    set @id_rol = 1;
    end if;
    if(new.`functie` like 'Asistent Medical') then #150 ore
    set @id_rol = 2;
    end if;
    if(new.`functie` like 'Receptioner') then #120
    set @id_rol = 3;
    end if;
    if(new.`functie` like 'Inspector Resurse Umane') then #120
    set @id_rol = 4;
    end if;
    if(new.`functie` like 'Expert Financiar Contabil') then #50
    set @id_rol = 5;
	end if;
    
end;
    // delimiter ;

drop trigger if exists stergere_angajat
delimiter //
create trigger stergere_angajat before delete on `angajat` for each row
begin
	delete from `orar_angajati` where `id_angajat` = old.`id_angajat`;
    delete from `cont_user` where `id_angajat` = old.`id_angajat`;
	delete from `raport_medical` where `id_angajat` = old.`id_angajat`;
    delete from `receptioner` where `id_angajat` = old.`id_angajat`;
    delete from `bon_fiscal` where `id_angajat` = old.`id_angajat`;
    delete from `concediu` where `id_angajat` = old.`id_angajat`;
    delete from `asistent_medical` where `id_angajat` = old.`id_angajat`;
    delete from `medic` where `id_angajat` = old.`id_angajat`;
end;
// delimiter ;

drop trigger if exists stergere_pacient
delimiter //
create trigger stergere_pacient before delete on `pacient` for each row
begin
	delete from `analiza` where `id_pacient` = old.`id_pacient`;
    delete from `programare` where `id_pacient` = old.`id_pacient`;
    delete from `raport_medical` where `id_pacient` = old.`id_pacient`;
    delete from `cont_user` where `id_pacient` = old.`id_pacient`;
end;
// delimiter ;