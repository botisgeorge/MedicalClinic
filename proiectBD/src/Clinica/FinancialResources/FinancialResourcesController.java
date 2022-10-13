package Clinica.FinancialResources;

import Clinica.ClinicApplication;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancialResourcesController {
    private final FinancialResourcesView view;
    private final FinancialResourcesModel model;

    public FinancialResourcesController(FinancialResourcesModel model, FinancialResourcesView view, JFrame previousView)
    {
        this.model = model;
        this.view = view;

        view.addBtnSalariiListener(new ButtonListener1());
        view.addBtnIstoricListener(new ButtonListener2());
        view.addBtnBackListener(new ButtonBackListener(previousView));
    }
    class ButtonListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            model.openFRsalarii(view);
        }
    }
    class ButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            model.openFRistoric(view);
        }
    }
    class ButtonBackListener implements ActionListener {
        private final JFrame previousView;

        public ButtonBackListener(JFrame previousView) {
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
