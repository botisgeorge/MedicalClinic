package Clinica.HomePageAngajat;

import Clinica.ClinicApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageAngajatController {

    private final HomePageAngajatModel model;
    private final HomePageAngajatView view;

    private final ClinicApplication.Account account;

    public HomePageAngajatController(HomePageAngajatModel model, HomePageAngajatView view, JFrame previousView)
    {
        this.model = model;
        this.view = view;

        account = ClinicApplication.getUser();

        view.addBtnHRListener(new ButtonListener(1,3));
        view.addBtnFRListener(new ButtonListener(2,4));
        view.addBtnMRListener(new ButtonListener(3,1));
        view.addBtnDisconnectListener(new ButtonDisconnectListener(previousView));
    }

    class ButtonListener implements ActionListener {

        private int number = 1; // care pagina deschide
        private final int rol;

        public ButtonListener(int number, int rol) {this.number = number; this.rol=rol;}

        public void actionPerformed(ActionEvent e) {
            if(ClinicApplication.getUser().hasPermission(rol))
            {
                view.setVisible(false);
                model.openMVC(number, view);
            }
            else
            {
                view.sendError("Nu ai permisiunea de a vedea aceasta categorie!");
                return;
            }
        }
    }
    class ButtonDisconnectListener implements ActionListener {
        private final JFrame previousView;

        public ButtonDisconnectListener(JFrame previousView) {
            this.previousView = previousView;
        }

        public void actionPerformed(ActionEvent e) {
            ClinicApplication.disconnectUser();
            view.setVisible(false);
            view.dispose();
            model.openLogin();
        }
    }
}
