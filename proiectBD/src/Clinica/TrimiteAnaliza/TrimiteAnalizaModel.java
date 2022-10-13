package Clinica.TrimiteAnaliza;

import Clinica.GenerareBon.GenerareBonView;
import Clinica.Login.LoginMVC;

public class TrimiteAnalizaModel {
    public void openMVC(int number, TrimiteAnalizaView view) {
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