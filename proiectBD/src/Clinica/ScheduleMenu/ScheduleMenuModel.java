package Clinica.ScheduleMenu;

import Clinica.Login.LoginMVC;
import Clinica.PacientMenu.PacientMenuMVC;

public class ScheduleMenuModel {
    public void openMVC(int number, ScheduleMenuView view) {
        switch (number) {
            case 1:
                //new HrMVC(view);
                new LoginMVC();
                break;
            case 2:
                //new FrMVC(view);
                new LoginMVC();
                break;
            case 3:
                //new MrMVC(view);
                new LoginMVC();
                break;
            case 4:
                //new FrMVC(view);
                new PacientMenuMVC(view);
                break;
            case 5:
                //new MrMVC(view);
                new PacientMenuMVC(view);
                break;
            default:
                break;
        }
    }
}