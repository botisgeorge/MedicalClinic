package Clinica.PacientMenu.ShowDoctors;

import Clinica.ClinicApplication;
import Clinica.Database;
import Clinica.Doctor;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowDoctorsModel {

    private final Database database;

    public ShowDoctorsModel() {
        database = ClinicApplication.getDatabase();
    }
    public String AfiseazaDoctori()
    {
        int k=0;
        String listaMedic="";
        String medici[]={"0","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test"};
        String sql = "select `nume`,`prenume`,`id_specialitate` from medic";
        try{
            PreparedStatement statement = database.preparedStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next())
            {

                medici[k+1]=result.getString(1)+" "+result.getString(2)+" | "+result.getString(3)+"\n";
                k++;
                //System.out.println(medici[0]);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        medici[0]=Integer.toString(k);
        for(int i=1;i<k+1;i++)
            listaMedic=listaMedic+medici[i];
        return listaMedic;
    }
}
