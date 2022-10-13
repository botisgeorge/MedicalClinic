package Clinica.UI;

import java.awt.*;

public enum Colors {
    MAIN_COLOR(new Color(0x081748)),
    MENU_COLOR(new Color(0xFFFFFF)),
    MENU_BORDER_COLOR(new Color(0xFFFFFF)),
    BTN_DISCONNECT_COLOR(new Color(0xFD0E0E));

    private Color color;

    Colors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}