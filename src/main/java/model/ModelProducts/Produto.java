package model.ModelProducts;

import java.time.LocalDate;

public class Produto {

    private int codigo;
    private String descricao;
    private String marca;
    private String lote;
    private LocalDate dataFabricacao;
    private LocalDate dataVencimento;
    private String codigoBarras;
    private double valor;


    public Produto() {
    }

    public double desconto(){
        return 0.05;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String exibirDadosProduto() {
        return "\nCodigo: " + getCodigo() +
                "\nDescrição: " + getDescricao() +
                "\nMarca: " + getMarca() +
                "\nLote: " + getLote() +
                "\nData de Fabricacao: " + getDataFabricacao() +
                "\nData de Vencimento: " + getDataVencimento() +
                "\nCódigo de Barras: " + getCodigoBarras() +
                "\nValor: R$" + getValor();
    }
}
