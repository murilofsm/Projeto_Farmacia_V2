package controllers.ControlVendas;

import controllers.ControlProducts.ControleProdutos;
import model.ModelVendas.ItemVenda;
import util.Input;
import java.util.ArrayList;

public class ControleItensVenda {
    protected static ArrayList<ItemVenda> carrinhoDeProdutos = new ArrayList<>();

    public static void menuControleCarrinho(){
        boolean travaTela = true;

        do{
            System.out.println(" ===========Carrinho===========");
            System.out.println(" | 1 - Adicionar ao Carrinho  |");
            System.out.println(" | 2 - Imprimir Carrinho      |");
            System.out.println(" | 3 - Limpar Carrinho        |");
            System.out.println(" | 4 - Ir para Venda          |");
            System.out.println(" | 0 - Voltar                 |");
            System.out.println("===============================");
            System.out.print("Resposta: ");
            int op = Input.nextInt();
            switch (op){
                case 1 -> adicionarCarrinho();
                case 2 -> listarCarrinhoDeProdutos();
                case 3 -> carrinhoDeProdutos = new ArrayList<>();
                case 4 -> ControleVenda.iniciarVenda(carrinhoDeProdutos);
                case 0 -> travaTela = false;
                default -> System.out.println("\nOpção incorreta, tente novamente.\n");
            }

        }while(travaTela);
    }
    protected static void adicionarCarrinho(){
        ItemVenda item = new ItemVenda();

        System.out.print("Insira o Código do Produto que quer adquirir: ");
        int codigoProduto = Input.nextInt();

        if(ControleProdutos.buscarProduto(codigoProduto) != null){
            item.setProduto(ControleProdutos.buscarProduto(codigoProduto));
            System.out.print("Insira a quantidade: ");
            item.setQuantidade(Input.nextInt());

            item.setValorUnidade(item.getProduto().getValor());
            item.setValorTotal(item.getValorUnidade() * item.getQuantidade());
            carrinhoDeProdutos.add(item);
        }else{
            System.out.println("\nProduto não encontrado\n");
        }

    }

    protected static void listarCarrinhoDeProdutos(){

        if(carrinhoDeProdutos.size() == 0){
            System.out.println("O carrinho está vazio.");
        }else{
            for (ItemVenda carrinhoDeProduto : carrinhoDeProdutos) {
                System.out.println(carrinhoDeProduto.exibirDadosItemVenda());
            }
        }

    }
}
