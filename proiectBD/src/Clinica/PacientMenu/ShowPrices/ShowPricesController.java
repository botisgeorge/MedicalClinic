package Clinica.PacientMenu.ShowPrices;

import Clinica.ClinicApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowPricesController {
    private final ShowPricesModel model;
    private final ShowPricesView view;

    private final ClinicApplication.Account account;
    public ShowPricesController(ShowPricesModel model, ShowPricesView view, JFrame previousView)
    {
        this.model = model;
        this.view = view;

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
