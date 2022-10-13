package Clinica.PacientMenu;

import Clinica.ClinicApplication;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PacientMenuController {
    private final PacientMenuModel model;
    private final PacientMenuView view;

    private final ClinicApplication.Account account;

    public PacientMenuController(PacientMenuModel model, PacientMenuView view, JFrame previousView)
    {
        this.model = model;
        this.view = view;

        account = ClinicApplication.getUser();

        view.addBtnRAPListener(new PacientMenuController.ButtonListener(1));
        view.addBtnMEDListener(new PacientMenuController.ButtonListener(2));
        view.addBtnCABListener(new PacientMenuController.ButtonListener(3));
        view.addBtnPretListener(new PacientMenuController.ButtonListener(4));
        view.addBtnProgListener(new PacientMenuController.ButtonListener(5));
        view.addBtnContListener(new PacientMenuController.ButtonListener(6));
        view.addBtnFacturiListener(new PacientMenuController.ButtonListener(7));
        view.addBtnDisconnectListener(new PacientMenuController.ButtonDisconnectListener(previousView));
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