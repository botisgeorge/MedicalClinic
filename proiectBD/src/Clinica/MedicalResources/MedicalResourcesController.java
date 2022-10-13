package Clinica.MedicalResources;

import Clinica.Login.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedicalResourcesController {

    private final MedicalResourcesModel model;
    private final MedicalResourcesView view;

    public MedicalResourcesController(MedicalResourcesModel model, MedicalResourcesView view, JFrame previousView)
    {
        this.model=model;
        this.view=view;
        view.addBtnBackListener(new ButtonListener(1));
        view.addBtnOkListener(new ButtonListener(2));
    }

    class ButtonListener implements ActionListener{
        private int number = 1; // care pagina deschide
        public ButtonListener (int number) {this.number = number;}
        public void actionPerformed(ActionEvent e)
        {
            view.setVisible(false);
            model.openMVC(number, view);
            JTextField nume = view.getTfNume();
            JTextField prenume = view.getTfPrenume();
            JTextField cnp = view.getTfCNP();

            view.clear();
        }
    }
}
