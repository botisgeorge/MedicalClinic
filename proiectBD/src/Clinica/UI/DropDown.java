package Clinica.UI;

import javax.swing.*;

public class DropDown {
    public DropDown(){
        String[] optionsToChoose = {"Baia Mare", "Baia Sprie", "Bucuresti", "Cluj-Napoca", "Hateg"};

        String getLocalitate = (String) JOptionPane.showInputDialog(null,
                "Alege cea mai apropiata localitate",
                "Alege localitate",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsToChoose,
                optionsToChoose[3]);
    }
}