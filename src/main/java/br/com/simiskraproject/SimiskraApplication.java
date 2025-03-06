/*
Bem vindo ao projeto Simiskra (do Islandes "Lista Telefonica").
Esse projeto limplementa um sistema de lista telefone onde
o usuario pode adicionar, consultar e excluir dados de seus contato
diretamente em um banco de dados local utilizando MySQL.

Antes de rodar o programa no terminal certifique-se de ler o arquivo READ ME,
o arquivo contem as instruções para inserir os dados de login e senha MySQL
de seu acesso local para que o sistema rode em sua maquina.
 */

package br.com.simiskraproject;

import br.com.simiskraproject.processos.DadosCadastroCliente;
import br.com.simiskraproject.processos.DadosCadastroContato;
import br.com.simiskraproject.processos.Service;

import java.util.Scanner;

public class SimiskraApplication {

    private static final Service service = new Service(); //Instancia de serviço
    private static final Scanner entrada = new Scanner(System.in).useDelimiter("\n");//Instancia de entrada do usuario

    public static void main(String[] args) {
        boasVindas(); //Exibe mensagem de boa vindas ao sistema Simiskra, a função foi declarada a baixo
        var opcao = menuInicio(); //Varial recebe enbtrada do usuario requisitado pela função.


        while (opcao != 3) { //Looping do Menu inicial, persiste até digitar opação 3 (SAIR)
            try{
                switch (opcao) {
                    case 1 : //Login
                        Autentica(); //REALIZA AUTENTICAÇÃO COM DB
                        break;
                    case 2 : // Cadastro
                        cadastroCliente();
                        break;
                }
            } catch (Exception e) { //tratamento de erro na entrada do usuario
                System.out.println("Erro: " +e.getMessage());
                System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu");
                entrada.next();
            }
            opcao = menuInicio(); // Chama novamente entrada do usuario com exibição do menu inicial
        }

        System.out.println("Finalizando a aplicação."); //Fim do Programa
    }

    private static void boasVindas() { //Menu de boas vindas.
        System.out.println("""
                **********************************
                *             SIMISKRA           *
                *         Lista Telefonica       *
                **********************************
               
                Bem vindo app de lista telefinica Simiskra!
  
               """);
    }

    private static int menuInicio(){ //Exibe menu inicial e retorna entrada do teclado.
        System.out.println("""
                SIMISKRA - ESCOLHA UMA OPÇÃO:
                1 - Login
                2 - Cadastro
                3 - Sair
                """);
        return entrada.nextInt(); //ENTRADA
    }

    private static void menuLogado(Integer id){ //Exibe Menu pos Login, com Switch de opções das funcionalidade do sistema.
        var opcao2 = 0;//Inicia Variavel para opção do Menu Logado
        do {
            //Exibe Menu de opções no terminal.
            System.out.println(""" 
                * SIMISKRA *
                Olá, escolha uma opção:
                1 - Ver Lista de Contatos
                2 - Procurar Contato
                3 - Salvar Novo Contato
                4 - Deletar Contato
                5 - Voltar
                """);
            try{//
                opcao2 = entrada.nextInt(); //ENTRADA DO TECLADO
                switch (opcao2) {//METODOS UTILIZADOS ESTÃO DECLARADOS A BAIXO
                    case 1 : //VER LISTA COMPLETA DOS CONTATOS CADASTRADOS
                        listarContatos(id);
                        break;
                    case 2 : //PROCURA CONTATO EXPECIFICO
                        procurarContato(id);
                        break;
                    case 3 : //CADASTRA NOVO CONTATO
                        cadastrarContato(id);
                        break;
                    case 4: //DELETA CONTATO EXISTENTE
                        deletarContato(id);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " +e.getMessage());
                System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu");
                entrada.next();//USUARIO DEVE INSERIR QUALQUER VALOR PARA RETORNAR AO MENU
            }
        } while (opcao2 !=5); //PERSISTE NO LOOPING ATÉ SER DIGITADO OPÇÃO 5(VOLTAR) E RETORNA PARA MENU DE LOGIN
    }
    private static void listarContatos(Integer id){//REALIZA IMPRESSAO DE DADOS DA TABELA CONTATO
        System.out.println("Contatos cadastrados: ");
        var contatos = service.listarContatoDoID(id);//SERVICO DECLARADO NA CLASSE SERVICE
        contatos.stream().forEach(System.out::println);

        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        entrada.next();//USUARIO DEVE INSERIR QUALQUER VALOR PARA RETORNAR AO MENU
    }

    private static void cadastrarContato(Integer id) { //CADASTRA NOVO CONTATO
        System.out.println("Digite o nome do Contato:");
        var nome = entrada.next();//ENTRADA DO NOME

        System.out.println("Digite o telefone do Contato:");
        var telefone = entrada.next(); //ENTRADA DO TELEFONE

        System.out.println("Digite o email do Contato:");
        var email = entrada.next();//ENTRADA DO E-MAIL

        //SERVICO DECLARADO NA CLASSE SERVICE
        service.cadastrarContatos(new DadosCadastroContato(nome, telefone, email, id));

        System.out.println("Contato cadastrado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        entrada.next();//USUARIO DEVE INSERIR QUALQUER VALOR PARA RETORNAR AO MENU
    }

    private static void deletarContato(Integer id){ //DELETA CONTATO EXISTE NA TABELA CONTATOS DO DB
        System.out.println("Digite o nome do contato:");
        var nomeDoContato = entrada.next(); //ENTRADA DO NOME DO CONTATO PARA IDENTIFICAR NO DB

        service.deletaContato(nomeDoContato, id); //SERVIÇO DECLARADO NA CLASSE SERVICE

        System.out.println("Contato deletado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        entrada.next();//USUARIO DEVE INSERIR QUALQUER VALOR PARA RETORNAR AO MENU

    }

    private static void procurarContato(Integer id) { //PROCURA E EXIBE CONTATO EXPECIFICO NA TABELA CONTATO
        System.out.println("Digite o nome do contato:");
        var nomeDoContato = entrada.next(); //ENTRADA DO NOME DO CONTATO

        System.out.println("Resultado da Busca: ");
            service.procuraPorNome(nomeDoContato, id); //SERVIÇO DECLARADO NA CLASSE SERVICE
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        entrada.next(); //USUARIO DEVE INSERIR QUALQUER VALOR PARA RETORNAR AO MENU
    }

    private static void cadastroCliente(){
        System.out.println("Digite seu nome:");
        var nome = entrada.next();//ENTRADA DO NOME

        System.out.println("Digite seu E-mail");
        var email = entrada.next();//ENTRADA DO E-MAIL

        System.out.println("Digite sua senha: ");
        var senha = entrada.next(); //ENTRADA DO TELEFONE

        service.cadastraCliente(new DadosCadastroCliente(nome, email, senha));

        System.out.println("Cadastrado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        entrada.next();//USUARIO DEVE INSERIR QUALQUER VALOR PARA RETORNAR AO MENU
    }

    private static void Autentica(){

        try {
            System.out.println("Digite seu e-mail: ");
            var login = entrada.next();

            System.out.println("Digite sua senha: ");
            var senha = entrada.next();

            var usuarioLogado = service.logar(login, senha);
            Integer id = usuarioLogado.getId();
            System.out.println("Login realizado com sucesso!");


            menuLogado(id);// inicia Menu de opção pós login, função declarada a baixo


            System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
            entrada.next();//USUARIO DEVE INSERIR QUALQUER VALOR PARA RETORNAR AO MENU
        } catch (Exception e) {
            throw new RuntimeException("Login ou senha Incorretos");
        }
    }
}
