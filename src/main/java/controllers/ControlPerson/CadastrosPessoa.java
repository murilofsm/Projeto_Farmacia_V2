package controllers.ControlPerson;

import model.ModelPerson.Cliente;
import model.ModelPerson.Funcionario;
import util.Input;


public class CadastrosPessoa {

    protected static void menuCadastroPessoa(){
        boolean travaTela = true;

        do{
            System.out.println("=====Menu Cadastro Pessoa=====");
            System.out.println("| 1 - Cadastrar Cliente       |");
            System.out.println("| 2 - Cadastrar Funcionário   |");
            System.out.println("| 0 - Voltar                  |");
            System.out.println("===============================");
            System.out.print("Resposta: ");
            int op = Input.nextInt();
            switch (op){
                case 1 -> cadastrarCliente();
                case 2 -> cadastrarFuncionario();
                case 0 -> travaTela = false;
                default -> System.out.println("\nOpção incorreta, tente novamente.\n");
            }
        }while(travaTela);
    }

    private static void cadastrarCliente(){
        Cliente cli = new Cliente();
        ControlePessoas.setarDadosCliente(cli);
        ControlePessoas.listaClientes.add(cli);
        System.out.println("\nCliente com o código "+ cli.getCodigo() + " cadastrado com sucesso !!!\n");
    }

    private static void cadastrarFuncionario(){
        Funcionario fun = new Funcionario();
        ControlePessoas.setarDadosFuncionario(fun);
        ControlePessoas.listaFuncionarios.add(fun);
        System.out.println("\nFuncionario com o código " + fun.getCodigo() + " cadastrado com sucesso !!!\n");
    }
}
