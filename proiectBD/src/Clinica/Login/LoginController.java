package Clinica.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Clinica.ClinicApplication;
import Clinica.Database;

public class LoginController{

    private final LoginModel model;
    private final LoginView view;

    public LoginController(LoginModel model, LoginView view)
    {
        this.model=model;
        this.view=view;

        view.addBtnLoginListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JTextField utilizator = view.getTfUtilizator();
            JPasswordField parola = view.getPfParola();

            if(model.checkCreditentials(utilizator.getText(), String.valueOf(parola.getPassword()))==0)
            {
                view.setVisible(false);
                model.openChooseCityPacient(view);
                model.loadUserData(utilizator.getText());
            }
            else if(model.checkCreditentials(utilizator.getText(), String.valueOf(parola.getPassword()))>0)
            {
                view.setVisible(false);
                model.openHomePageAngajat(view);
                model.loadUserData(utilizator.getText());
                System.out.println(utilizator.getText());
            }
            else{view.sendError("User sau parola gresite.");}
            view.clear();
        }
    }
}