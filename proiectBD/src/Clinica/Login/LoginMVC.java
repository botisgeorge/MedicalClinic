package Clinica.Login;

public class LoginMVC{
    public LoginMVC()
    {
        LoginModel model = new LoginModel();
        LoginView view = new LoginView();
        new LoginController(model,view);

        view.setVisible(true);
    }
}