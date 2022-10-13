package Clinica.FinancialResources;

import Clinica.ClinicApplication;
import Clinica.Database;
import Clinica.FinancialResources.Salarii.SalariiMVC;
import Clinica.FinancialResources.Salarii.SalariiModel;
import Clinica.FinancialResources.Salarii.SalariiView;
import Clinica.Login.LoginMVC;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinancialResourcesModel {

    private final Database database;

    public FinancialResourcesModel() {
        database = ClinicApplication.getDatabase();
    }

    public void openFRsalarii(JFrame previousView) {new SalariiMVC(previousView);}
    public void openFRistoric(JFrame previousView) {new LoginMVC();}
}
