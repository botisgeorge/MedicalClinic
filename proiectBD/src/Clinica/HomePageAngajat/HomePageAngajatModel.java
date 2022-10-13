package Clinica.HomePageAngajat;

import Clinica.FinancialResources.FinancialResourcesMVC;
import Clinica.HumanResources.HumanResourcesMVC;
import Clinica.Login.LoginMVC;
import Clinica.MedicalResources.MedicalResourcesMVC;

public class HomePageAngajatModel {
    public void openMVC(int number, HomePageAngajatView view) {
        switch (number) {
            case 1:
                new HumanResourcesMVC(view);
                break;
            case 2:
                new FinancialResourcesMVC(view);
                break;
            case 3:
                new MedicalResourcesMVC(view);
                break;
            default:
                break;
        }
    }
    public void openLogin()
    {
        new LoginMVC();
    }
}
