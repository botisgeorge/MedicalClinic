package Clinica.Login;

import Clinica.UI.Colors;
import Clinica.UI.StyledJButton;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class    LoginView extends JFrame{

    private final JTextField tfUtilizator = new JTextField(20);
    private final JPasswordField pfParola = new JPasswordField(20);
    private final JButton btnLogin = new StyledJButton("Log in").getButton();

    public LoginView()
    {
        JPanel panelLogin = new JPanel(new GridLayout(2,1));
        panelLogin.add(new JLabel("Utilizator"));
        panelLogin.add(tfUtilizator);
        panelLogin.add(new JLabel("Parola"));
        panelLogin.add(pfParola);
        panelLogin.setBorder(new EmptyBorder(0, 0, 20, 0));

        JPanel content = new JPanel(new BorderLayout());
        content.add(loadLogo(), BorderLayout.NORTH);
        content.add(panelLogin,BorderLayout.CENTER);
        content.add(btnLogin, BorderLayout.SOUTH);
        btnLogin.setBackground(Colors.MAIN_COLOR.getColor());
        content.setBorder(new EmptyBorder(5,5,5,5));

        this.setContentPane(content);
        this.pack();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width / 2 - this.getSize().width / 2, dimension.height / 2 - this.getSize().height / 2);

        this.setTitle("Apollo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JLabel loadLogo() {
        try {
            JLabel jLabel = new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("logo.png")).getScaledInstance(130, 130, Image.SCALE_SMOOTH)));
            jLabel.setBorder(new EmptyBorder(0, 10, 10, 0));
            return jLabel;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void clear() {
        tfUtilizator.setText("");
        pfParola.setText("");
    }
    public void sendError(String message) {JOptionPane.showMessageDialog(this,message,"Eroare",0);}
    public void addBtnLoginListener(ActionListener actionListener) {btnLogin.addActionListener(actionListener);}
    public JTextField getTfUtilizator() {return tfUtilizator;}
    public JPasswordField getPfParola() {return pfParola;}
}