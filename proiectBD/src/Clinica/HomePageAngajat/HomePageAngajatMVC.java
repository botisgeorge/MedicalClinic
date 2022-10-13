package Clinica.HomePageAngajat;

import javax.swing.*;

public class HomePageAngajatMVC {

    public HomePageAngajatMVC(JFrame previousView)
    {
        HomePageAngajatModel model = new HomePageAngajatModel();
        HomePageAngajatView view = new HomePageAngajatView();
        HomePageAngajatController controller = new HomePageAngajatController(model, view, previousView);

        view.setVisible(true);
    }

}
