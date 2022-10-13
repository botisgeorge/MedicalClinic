package Clinica.MedicalResourcesMenu;

import Clinica.GenerareBon.GenerareBonMVC;
import Clinica.Login.LoginMVC;
import Clinica.TrimiteAnaliza.TrimiteAnalizaMVC;

public class MedicalResourcesMenuModel {
    public void openMVC(int number, MedicalResourcesMenuView view) {
        switch (number) {
            case 1:
                //new HrMVC(view);
                new GenerareBonMVC(view);
                break;
            case 2:
                //new FrMVC(view);
                new TrimiteAnalizaMVC(view);
                break;
            default:
                break;
        }
    }
}