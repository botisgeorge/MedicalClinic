package Clinica.PacientMenu;


import javax.swing.*;

public class PacientMenuMVC {
    public PacientMenuMVC(JFrame previousView)
    {
        PacientMenuModel model = new PacientMenuModel();
        PacientMenuView view = new PacientMenuView();
        PacientMenuController controller = new PacientMenuController(model, view, previousView);

        view.setVisible(true);
    }
}