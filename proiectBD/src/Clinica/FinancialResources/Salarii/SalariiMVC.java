package Clinica.FinancialResources.Salarii;

import javax.swing.*;

public class SalariiMVC {
    public SalariiMVC(JFrame previousFrame)
    {
        SalariiModel model = new SalariiModel();
        SalariiView view = new SalariiView(model);
        SalariiController controller = new SalariiController(model,view, previousFrame);

        view.setVisible(true);
    }
}
