package Clinica.ContPacient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContPacientController {

    private final ContPacientModel model;
    private final ContPacientView view;

    public ContPacientController(ContPacientModel model, ContPacientView view, JFrame previousFrame)
    {
        this.model=model;
        this.view=view;
        view.addBtnBackListener(new ButtonListener(1));
        view.addBtnOkListener(new ButtonListener(2));
    }
    class ButtonListener implements ActionListener {
        private int number = 1; // care pagina deschide
        public ButtonListener (int number) {this.number = number;}
        public void actionPerformed(ActionEvent e)
        {
            view.setVisible(false);
            model.openPacientMVC(number, view);
            JTextField nume = view.getTfNume();
            JTextField prenume = view.getTfPrenume();
            JTextField adresa = view.getTfAdresa();
            JTextField nrTelefon = view.getTfNrTelefon();
            JTextField email = view.getTfEmail();
            view.clear();
        }
    }

}
