package model.ModelProducts;


public class MedicamentoControlado extends Medicamento{

    public MedicamentoControlado(){

    }

    public double desconto(){
        return 0.03;
    }
    public String exibirDadosMedicamentoControlado() {
        return exibirDadosMedicamento();
    }
}
