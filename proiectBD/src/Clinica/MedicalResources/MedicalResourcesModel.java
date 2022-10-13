package Clinica.MedicalResources;

import Clinica.HomePageAngajat.HomePageAngajatMVC;
import Clinica.HomePageAngajat.HomePageAngajatView;
import Clinica.Login.LoginMVC;
import Clinica.MedicalResourcesMenu.MedicalResourcesMenuMVC;

import javax.swing.*;

public class MedicalResourcesModel {
    public void openMVC(int number, MedicalResourcesView view) {
        switch (number) {
            case 1:
                new HomePageAngajatMVC(view);
                break;
            case 2:
                new MedicalResourcesMenuMVC(view);
                break;
            default:
                break;
        }
    }
}
