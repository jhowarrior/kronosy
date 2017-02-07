package cdc.model;

/**
 *
 * @author joao
 */
public class Login {
    private int idLogin;
    private String userName;
    private String senha;

    public Login(int idLogin, String userName, String senha) {
        this.idLogin = idLogin;
        this.userName = userName;
        this.senha = senha;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
