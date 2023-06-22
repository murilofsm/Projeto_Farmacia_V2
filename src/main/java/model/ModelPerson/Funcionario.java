package model.ModelPerson;
public class Funcionario extends Pessoa {

    private String ctps;

    public Funcionario() {

    }
    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String exibirDadosFuncionario() {
        return exibirDadosPessoa() + "\nCTPS:" + getCtps();
    }
}
