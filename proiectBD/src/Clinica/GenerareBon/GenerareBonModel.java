package Clinica.GenerareBon;

import Clinica.Login.LoginMVC;

public class GenerareBonModel {
    public void openMVC(int number, GenerareBonView view) {
        switch (number) {
            case 1:
                //new HrMVC(view);
                new LoginMVC();
                break;
            case 2:
                //new FrMVC(view);
                new LoginMVC();
                break;
            default:
                break;
        }
    }
}