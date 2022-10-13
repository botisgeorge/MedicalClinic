package Clinica.ChooseSpecialityPacient;

import Clinica.ContPacient.ContPacientMVC;
import Clinica.Login.LoginMVC;
import Clinica.ScheduleMenu.ScheduleMenuMVC;

import javax.swing.*;

public class ChooseSpecialityModel {
    public void openProgramarePacient(JFrame previousView) {new ScheduleMenuMVC(previousView);}
}
