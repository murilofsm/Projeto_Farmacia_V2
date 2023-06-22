package main;
import controllers.ControlPerson.ControlePessoas;
import controllers.ControlProducts.ControleProdutos;
import controllers.ControlVendas.ControleItensVenda;
import controllers.ControlVendas.ControleVenda;
import util.Input;

public class Main {
    public static void main(String[] args){
        menuPrincipal();
    }

    public static void menuPrincipal() {
        boolean travaTela = true;

        do{
            System.out.println("======Menu Principal======");
            System.out.println("| 1 - Controle Pessoa    |"); // cadastro de funcionario, cliente além de buscar e imprimir eles
            System.out.println("| 2 - Controle Produto   |"); // cadastro de produtos, e imprimir os produtos
            System.out.println("| 3 - Realizar Venda     |");// aonde adiciona os produtos no carrinho para criar uma nova venda
            System.out.println("| 4 - Controle Venda     |");// aonde vai para imprimir as vendas e buscar
            System.out.println("| 0 - SAIR               |");
            System.out.println("==========================");
            System.out.print("Resposta: ");
            int op = Input.nextInt();
            switch (op){
                case 1 -> ControlePessoas.menuControlePessoa();
                case 2 -> ControleProdutos.menuControleProduto();
                case 3 -> ControleItensVenda.menuControleCarrinho();
                case 4 -> ControleVenda.menuControleVendas();
                case 0 -> travaTela = false;
                default -> System.out.println("Opção incorreta, tente novamente.");
            }
        }while(travaTela);
        System.out.println("Até mais !!!");
    }
}
