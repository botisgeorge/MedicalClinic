package Clinica.ScheduleMenu;

import javax.swing.*;

public class ScheduleMenuMVC {
    public ScheduleMenuMVC(JFrame previousView)
    {
        ScheduleMenuModel model = new ScheduleMenuModel();
        ScheduleMenuView view = new ScheduleMenuView();
        ScheduleMenuController controller = new ScheduleMenuController(model, view, previousView);

        view.setVisible(true);
    }
}