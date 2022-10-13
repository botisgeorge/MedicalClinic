package Clinica;

import java.util.List;

import Clinica.Login.LoginMVC;

public class ClinicApplication {
    private static Database database;

    private static Account user;

    public static void main(String[] args) { //default 3306
        database = new Database("localhost", 3306, "policlinica2", "root", "parola12");

        new LoginMVC();
    }

    public static Database getDatabase() {
        return database;
    }

    public static Account getUser() {
        return user;
    }

    public static void disconnectUser() {
        user = null;
    }

    public static int getId() { return user.getId(); }

    public static int getIdRol() {return user.getId_rol(); }

    public static void setUser(int id_angajat, int id_pacient, int id_rol, int id_unitate_medicala) {
        user = new Account(id_angajat, id_pacient, id_rol, id_unitate_medicala);
    }

    public static class Account {
        private int id_angajat;
        private int id_pacient;
        private int id_rol; /**0-pacient, 1-medic 2-asistent 3-hr 4-fr 5-ceo **/
        private int id_unitate_medicala;
        public Account(int id_angajat, int id_pacient, int id_rol, int id_unitate_medicala)
        {
            this.id_unitate_medicala=id_unitate_medicala;
            this.id_rol=id_rol;
            this.id_angajat=id_angajat;
            this.id_pacient=id_pacient;
        }
        public int getId() {
            if(this.id_rol==0)
                return id_pacient;
            else
                return id_angajat;
        }
        public int getId_pacient()
        {
            return id_pacient;
        }
        public int getId_angajat()
        {
            return id_angajat;
        }
        public int getIdUnitateMedicala() {
            return id_unitate_medicala;
        }
        public boolean hasPermission(int number) {
            return (id_rol==5 || id_rol==number);
        }
        public int getId_rol() {
            return id_rol;
        }
    }
}
