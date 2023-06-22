package controllers.ControlPerson;

import model.ModelPerson.Cliente;
import model.ModelPerson.Funcionario;
import model.ModelPerson.Pessoa;
import util.Input;
import java.util.ArrayList;

public class ControlePessoas {
    protected static ArrayList<Cliente> listaClientes = new ArrayList<>();
    protected static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    public static void menuControlePessoa(){
        boolean travaTela = true;

        do{
            System.out.println("======Menu Controle Pessoa======");
            System.out.println("| 1 - Menu Cadastrar Cli/Func  |");
            System.out.println("| 2 - Buscar/listar            |");
            System.out.println("| 0 - Voltar                   |");
            System.out.println("================================");
            System.out.print("Resposta: ");
            int op = Input.nextInt();
            switch (op){
                case 1 -> CadastrosPessoa.menuCadastroPessoa();
                case 2 -> ImprimirPessoas.menuImprimirPessoa();
                case 0 -> travaTela = false;
                default -> System.out.println("\nOpção incorreta, tente novamente.\n");
            }
        }while(travaTela);
    }

    private static void setarDadosPessoa(Pessoa p){
        System.out.print("Insira o nome: ");
        p.setNome(Input.nextLine());
        System.out.print("Insira o cpf: ");
        p.setCpf(Input.nextLine());
        System.out.print("Insira a data de nascimento: ");
        p.setDataNascimento(Input.nextLocalDate());
    }

    protected static void setarDadosCliente(Cliente cli){
        setarDadosPessoa(cli);
        int cod;
        System.out.print("Insira o email: ");
        cli.setEmail(Input.nextLine());
        cod = geradorCodigo("cliente");
        cli.setCodigo(cod);
    }
    protected static void setarDadosFuncionario(Funcionario fun){
        setarDadosPessoa(fun);
        int cod;
        System.out.print("Insira o CTPS: ");
        fun.setCtps(Input.nextLine());
        cod = geradorCodigo("funcionario");
        fun.setCodigo(cod);
    }

    private static int geradorCodigo(String tipo){
        int cod = 1;

            if(tipo.equals("cliente")){
                while(autenticadorCodigoCliente(cod)){
                    cod++;
                    autenticadorCodigoCliente(cod);
                }
            }
            if(tipo.equals("funcionario")){
                while(autenticadorCodigoFuncionario(cod)){
                    cod++;
                    autenticadorCodigoFuncionario(cod);
                }
            }

        return cod;
    }
    private static boolean autenticadorCodigoCliente(int cod){

        if(listaClientes.size() == 0){
            return false;
        }
        for (Cliente listaCliente : listaClientes) {
            if (listaCliente.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }

    private static boolean autenticadorCodigoFuncionario(int cod){

        if(listaFuncionarios.size() == 0){
            return false;
        }

        for (Funcionario listaFuncionario : listaFuncionarios) {
            if (listaFuncionario.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }

    public static Funcionario autenticadorFuncionario(int codFuncionario){
        for (Funcionario listaFuncionario : listaFuncionarios) {
            if (listaFuncionario.getCodigo() == codFuncionario) {
                return listaFuncionario;
            }
        }
        System.out.println("\nFuncionario não encontrado, digite novamente\n");
        return null;
    }
    public static Cliente autenticadorCliente(int codCliente){
        for (Cliente listaCliente : listaClientes) {
            if (listaCliente.getCodigo() == codCliente) {
                return listaCliente;
            }
        }
        System.out.println("\nCliente não encontrado, digite novamente\n");
        return null;
    }

}
