package Clinica.PacientMenu.ShowPrices;

import Clinica.ClinicApplication;
import Clinica.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowPricesModel {

    private final Database database;

    public ShowPricesModel() {
        database = ClinicApplication.getDatabase();
    }

    public String AfiseazaPreturi()
    {
        int k=0;
        String sql = "select `nume_serviciu`,`pret` from preturi";
        String listaPreturi="";
        String preturi[]={"0","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test","test"};
        try{
            PreparedStatement statement = database.preparedStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                preturi[k+1]=result.getString(1)+" "+result.getString(2)+"\n";
                k++;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        preturi[0]=Integer.toString(k);
        for(int i=1;i<k+1;i++)
            listaPreturi=listaPreturi+preturi[i];
        return listaPreturi;
    }
}
