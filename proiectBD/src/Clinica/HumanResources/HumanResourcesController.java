package Clinica.HumanResources;

import Clinica.ClinicApplication;
import Clinica.HomePageAngajat.HomePageAngajatController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HumanResourcesController {
    private final HumanResourcesModel model;
    private final HumanResourcesView view;

    public HumanResourcesController(HumanResourcesModel model, HumanResourcesView view, JFrame previousView)
    {
        this.model = model;
        this.view = view;

        view.addBtnProgramareListener(new ButtonListener1());
        view.addBtnConcediiListener(new ButtonListener2());
        view.addBtnBackListener(new ButtonBackListener(previousView));
    }
    class ButtonListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            model.openHRprogramare(view);
        }
    }
    class ButtonListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.setVisible(false);
            model.openHRconcedii(view);
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
