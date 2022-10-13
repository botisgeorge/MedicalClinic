package Clinica.FinancialResources.Salarii;

import Clinica.ClinicApplication;
import Clinica.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalariiModel {

    private final Database database;

    public SalariiModel()
    {
        database = ClinicApplication.getDatabase();
    }
    public String afiseazaSalarii()
    {
        int k=0;
        String sql = "select `nume`,`prenume`,`salariu` from angajat";
        String listaSalarii="";
        String salarii[]={"0","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test"};

        try{
            PreparedStatement statement = database.preparedStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                salarii[k+1]=result.getString(1)+" "+result.getString(2)+":"+result.getString(3)+"\n";
                k++;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        salarii[0]=Integer.toString(k);
        for(int i=1;i<k+1;i++)
            listaSalarii=listaSalarii+salarii[i];
        return listaSalarii;
    }
}
