package Clinica.ContPacient;

import Clinica.ChooseCityPacient.ChooseCityPacientMVC;
import Clinica.HomePageAngajat.HomePageAngajatMVC;
import Clinica.Login.LoginMVC;
import Clinica.MedicalResources.MedicalResourcesView;
import Clinica.PacientMenu.PacientMenuMVC;

public class ContPacientModel {
    public void openPacientMVC(int number, ContPacientView view) {
        switch (number) {
            case 1:
                new PacientMenuMVC(view);
                break;
            case 2:
                new PacientMenuMVC(view);
                break;
            default:
                break;
        }
    }
}
