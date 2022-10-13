package Clinica.PacientMenu.ShowDoctors;

import Clinica.ClinicApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowDoctorsController {
    private final ShowDoctorsModel model;
    private final ShowDoctorsView view;

    private final ClinicApplication.Account account;
    public ShowDoctorsController(ShowDoctorsModel model, ShowDoctorsView view, JFrame previousView)
    {
        this.model = model;
        this.view = view;

        account = ClinicApplication.getUser();

        view.addBtnDisconnectListener(new ShowDoctorsController.ButtonDisconnectListener(previousView));
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
