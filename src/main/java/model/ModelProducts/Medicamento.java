package model.ModelProducts;

public class Medicamento extends Produto{
    private int numRegistro;
    private String composicao;
    private double dosagem;
    public Medicamento() {

    }
    public double desconto(){
        return 0.1;
    }
    public int getNumRegistro() {
        return numRegistro;
    }

    public void setNumRegistro(int numRegistro) {
        this.numRegistro = numRegistro;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public double getDosagem() {
        return dosagem;
    }

    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }

    public String exibirDadosMedicamento() {
        return exibirDadosMedicamento() +
                "\nNúmero registro Anvisa: " + getNumRegistro() +
                "\nComposição: " + getComposicao() +
                "\nDosagem: " + getDosagem();
    }
}
