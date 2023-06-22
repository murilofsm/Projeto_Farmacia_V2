package model.ModelPerson;

public class Cliente extends Pessoa{

    private String email;
    public Cliente() {

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String exibirDadosCliente() {
        return exibirDadosPessoa() +
                "\nEmail:" + getEmail();
    }
}
