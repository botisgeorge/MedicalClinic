package Clinica.Login;

import Clinica.ChooseCityPacient.ChooseCityPacientMVC;
import Clinica.ClinicApplication;
import Clinica.Database;
import Clinica.HomePageAngajat.HomePageAngajatMVC;


import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginModel{

    private final Database database;

    public LoginModel() {
        database = ClinicApplication.getDatabase();
    }

    public int checkCreditentials(String username, String password) {
        try {
            CallableStatement callableStatement = database.callableStatement("CALL verificare_date_logare(?, ?, ?)");
            callableStatement.setString(1, username);
            callableStatement.setString(2, password);
            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.executeQuery();

            int result = callableStatement.getInt(3);
            callableStatement.close();

            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public void loadUserData(String username) {
        int id_rol=-1;
        int id_angajat=-1;
        int id_pacient=-1;
        int id_unitate_medicala=-1;
        try {
            PreparedStatement preparedStatement = database.preparedStatement("SELECT `id_rol` FROM `cont_user` WHERE `username` LIKE ?;");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id_rol = resultSet.getInt(1);
            }

            PreparedStatement preparedStatement1 = database.preparedStatement("SELECT `id_pacient` FROM `cont_user` WHERE `username` LIKE ?;");
            preparedStatement1.setString(1, username);
            ResultSet resultSet1 = preparedStatement1.executeQuery();

            if (resultSet1.next()) {
                id_pacient = resultSet1.getInt(1);
            }

            PreparedStatement preparedStatement2 = database.preparedStatement("SELECT `id_angajat` FROM `cont_user` WHERE `username` LIKE ?;");
            preparedStatement2.setString(1, username);
            ResultSet resultSet2 = preparedStatement2.executeQuery();

            if(resultSet2.next()){
                id_angajat=resultSet2.getInt(1);
            }

            PreparedStatement preparedStatement3 = database.preparedStatement("SELECT `id_unitate_medicala` FROM `cont_user` WHERE `username` LIKE ?;");
            preparedStatement3.setString(1,username);
            ResultSet resultSet3 = preparedStatement3.executeQuery();

            if(resultSet3.next()){
                id_unitate_medicala=resultSet3.getInt(1);
            }
            System.out.println(id_angajat+" "+id_pacient+" "+id_rol+" "+id_unitate_medicala);
            ClinicApplication.setUser(id_angajat,id_pacient,id_rol,id_unitate_medicala);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void openChooseCityPacient(JFrame previousView) { new ChooseCityPacientMVC(previousView);}
    public void openHomePageAngajat(JFrame previousView) { new HomePageAngajatMVC(previousView);}
}