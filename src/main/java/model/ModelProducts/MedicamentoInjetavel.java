package model.ModelProducts;

public class MedicamentoInjetavel extends Medicamento{

    public MedicamentoInjetavel(){

    }
    public double desconto(){
        return 0;
    }
    public String exibirDadosMedicamentoInjetavel() {
        return exibirDadosMedicamento();
    }
}
