package controllers.ControlVendas;

import controllers.ControlPerson.ControlePessoas;
import model.ModelVendas.ItemVenda;
import model.ModelVendas.Venda;
import util.Input;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ControleVenda {
    protected static ArrayList<Venda> listaDeVendas = new ArrayList<>();

      public static void menuControleVendas(){
         boolean travaTela = true;
          do{
              System.out.println("=========Menu Venda=======");
              System.out.println("| 1 - Listar Vendas      |");
              System.out.println("| 2 - Buscar Venda       |");
              System.out.println("| 0 - Voltar             |");
              System.out.println("==========================");
              System.out.print("Resposta: ");
              int op = Input.nextInt();
              switch (op){
                  case 1 -> imprimirVendas();
                  case 2 -> buscarVenda();
                  case 0 -> travaTela = false;
                  default -> System.out.println("Opção incorreta, tente novamente.");
              }

          }while(travaTela);
      }

    public static void iniciarVenda(ArrayList<ItemVenda> carrinhoDeProdutos){
        Venda venda = new Venda();
        int cod;
        int numMax = 1;

        venda.setCodigo(geradorCodigo());// automatizei o código para não dar problema de ficar repetido
        boolean travaFunc = true;
        do{
            numMax++;
            System.out.print("Insira o id do Funcionário: ");
            cod = Input.nextInt();
            if(ControlePessoas.autenticadorFuncionario(cod) != null){
                venda.setFuncionario(ControlePessoas.autenticadorFuncionario(cod));
                travaFunc = false;

            }
            if(numMax == 3){
                return;
            }
        }while(travaFunc);
        numMax = 0;
        boolean travaCli = true;
        do{
            numMax++;
            System.out.print("Insira o id do Cliente: ");
            cod = Input.nextInt();
            if(ControlePessoas.autenticadorCliente(cod) != null){
                venda.setCliente(ControlePessoas.autenticadorCliente(cod));
                travaCli = false;
            }
            if(numMax == 3){
                return;
            }
        }while(travaCli);

        venda.setData(LocalDate.now());

        venda.setValorProdutos(somaValorProdutos(carrinhoDeProdutos));
        venda.setDesconto(calculaDesconto(carrinhoDeProdutos,calculoIdade(venda.getCliente().getDataNascimento())));
        venda.setValorTotal(venda.getValorProdutos() - venda.getDesconto());

        venda.setItens(carrinhoDeProdutos);
        listaDeVendas.add(venda);
        System.out.println("\nVenda realizada com sucesso !!\n");
    }

    private static void buscarVenda(){
            if(listaDeVendas.size() == 0){
                System.out.println("\n Não há itens.\n");

            }else{
                ArrayList<ItemVenda> itensVendas = null;
                System.out.print("Insira o código da venda que deseja buscar: ");
                int codBusca = Input.nextInt();
                if(autenticadorCodigoVenda(codBusca)){
                    for (Venda listaDeVenda : listaDeVendas) {
                        if (listaDeVenda.getCodigo() == codBusca) {
                            System.out.println(listaDeVenda.exibirDadosVendaBusca());
                            itensVendas = listaDeVenda.getItens();
                        }
                    }
                    assert itensVendas != null;
                    for (ItemVenda itensVenda : itensVendas) {
                        System.out.println(itensVenda.exibirDadosItemVenda());
                    }
                }else{
                    System.out.println("\nVenda não encontrada.\n");
                }
            }
    }




    private static int calculoIdade(LocalDate dataNascimento){
        LocalDate dataAtual = LocalDate.now();
        return Period.between(dataNascimento, dataAtual).getYears();
    }


    private static double calculaDesconto(ArrayList<ItemVenda> carrinhoDeProdutos, int idadeCliente){
        double somaDesconto = 0;

        double somaCompra = somaValorProdutos(carrinhoDeProdutos);

        for (ItemVenda carrinhoDeProduto : carrinhoDeProdutos) {
            somaDesconto += (carrinhoDeProduto.getValorTotal() * carrinhoDeProduto.getProduto().desconto());
        }
        if(idadeCliente > 60 && somaCompra > 100){
            somaDesconto += 10;
        }
        return somaDesconto;
    }
    private static double somaValorProdutos(ArrayList<ItemVenda> carrinhoDeProdutos){
        double soma = 0;
        for (ItemVenda carrinhoDeProduto : carrinhoDeProdutos) {
            soma += carrinhoDeProduto.getValorTotal();
        }
        return soma;
    }
    private static int geradorCodigo(){
        int codVenda = 1;
        while(autenticadorCodigoVenda(codVenda)) {
            codVenda++;
            autenticadorCodigoVenda(codVenda);
        }
        return codVenda;
    }

        private static boolean autenticadorCodigoVenda(int cod){
        for (Venda listaDeVenda : listaDeVendas) {
            if (listaDeVenda.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }

    private static void imprimirVendas(){
          if(listaDeVendas.size() > 0){
              for (Venda listaDeVenda : listaDeVendas) {
                  System.out.println(listaDeVenda.exibirDadosVenda());
              }
              return;
          }
          System.out.println("\nNão há itens.\n");
    }
}
