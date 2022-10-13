package Clinica.FinancialResources.Salarii;

import Clinica.ClinicApplication;
import Clinica.PacientMenu.ShowDoctors.ShowDoctorsController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalariiController {
    private final SalariiModel model;
    private final SalariiView view;

    private final ClinicApplication.Account account;

    public SalariiController(SalariiModel model, SalariiView view, JFrame previousView)
    {
        this.model=model;
        this.view=view;
        account = ClinicApplication.getUser();
        view.addBtnDisconnectListener(new ButtonDisconnectListener(previousView));
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
