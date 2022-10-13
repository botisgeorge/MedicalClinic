package Clinica.GenerareBon;

import Clinica.ClinicApplication;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerareBonController {
    private final GenerareBonModel model;
    private final GenerareBonView view;

    private final ClinicApplication.Account account;

    public GenerareBonController(GenerareBonModel model, GenerareBonView view, JFrame previousView)
    {
        this.model = model;
        this.view = view;

        account = ClinicApplication.getUser();

        view.addBtnBonListener(new GenerareBonController.ButtonListener(1));
        view.addBtnDisconnectListener(new GenerareBonController.ButtonDisconnectListener(previousView));
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