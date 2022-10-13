package Clinica.ScheduleMenu;

import Clinica.ClinicApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScheduleMenuController {
    private final ScheduleMenuModel model;
    private final ScheduleMenuView view;

    private final ClinicApplication.Account account;

    public ScheduleMenuController(ScheduleMenuModel model, ScheduleMenuView view, JFrame previousView)
    {
        this.model = model;
        this.view = view;

        account = ClinicApplication.getUser();

        view.addBtnMEDListener(new ScheduleMenuController.ButtonListener(1));
        view.addBtnDataListener(new ScheduleMenuController.ButtonListener(2));
        view.addBtnOraListener(new ScheduleMenuController.ButtonListener(3));
        view.addBtnOKListener(new ScheduleMenuController.ButtonListener(4));
        view.addBtnDisconnectListener(new ScheduleMenuController.ButtonDisconnectListener(previousView));
    }

    class ButtonListener implements ActionListener {
        private int number = 1; // care pagina deschide



        public ButtonListener(int number) {
            this.number = number;
        }
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            model.openMVC(number, view);
        }
    }
    class ButtonDisconnectListener implements ActionListener {
        private final JFrame previousView;

        public ButtonDisconnectListener(JFrame previousView) {
            this.previousView = previousView;
        }

        public void actionPerformed(ActionEvent e) {
            ClinicApplication.disconnectUser();
            previousView.setVisible(true);
            view.setVisible(false);
            view.dispose();
        }
    }
}