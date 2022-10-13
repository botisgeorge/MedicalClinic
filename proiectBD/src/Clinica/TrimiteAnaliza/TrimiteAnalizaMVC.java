package Clinica.TrimiteAnaliza;


import javax.swing.*;

public class TrimiteAnalizaMVC {
    public TrimiteAnalizaMVC(JFrame previousView)
    {
        TrimiteAnalizaModel model = new TrimiteAnalizaModel();
        TrimiteAnalizaView view = new TrimiteAnalizaView();
        TrimiteAnalizaController controller = new TrimiteAnalizaController(model, view, previousView);

        view.setVisible(true);
    }
}