package Clinica.PacientMenu;

import Clinica.ChooseSpecialityPacient.ChooseSpecialityPacientMVC;
import Clinica.ContPacient.ContPacientMVC;
import Clinica.Login.LoginMVC;
import Clinica.PacientMenu.ShowDoctors.ShowDoctorsMVC;
import Clinica.PacientMenu.ShowPrices.ShowPricesMVC;

public class PacientMenuModel {
    public void openMVC(int number, PacientMenuView view) {
        switch (number) {
            case 1:
                //new HrMVC(view);
                new LoginMVC();
                break;
            case 2:
                //new FrMVC(view);
                new ShowDoctorsMVC(view);
                break;
            case 3:
                //new MrMVC(view);
                new LoginMVC();
                break;
            case 4:
                //new HrMVC(view);
                new ShowPricesMVC(view);
                break;
            case 5:
                //new FrMVC(view);
                new ChooseSpecialityPacientMVC(view);
                break;
            case 6:
                //new MrMVC(view);
                new ContPacientMVC(view);
                break;
            case 7:
                //new FrMVC(view);
                new LoginMVC();
                break;
            case 8:
                //new MrMVC(view);
                new LoginMVC();
                break;
            default:
                break;
        }
    }
}