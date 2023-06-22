package model.ModelVendas;

import model.ModelProducts.Produto;

public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double valorUnidade;
    private double valorTotal;

    public ItemVenda(){}


    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String exibirDadosItemVenda() {
        return "\nProduto: " + getProduto().getDescricao() +
                "\nQuantidade: " + getQuantidade() +
                "\nValor Unidade: " + getValorUnidade() +
                "\nValor Total: " + getValorTotal();
    }
}
