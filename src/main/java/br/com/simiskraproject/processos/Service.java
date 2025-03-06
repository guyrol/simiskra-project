/*
NESSA CLASSE ENCONTRAMOS TODOS OS METODOS DE PADRAO SERVIÇO A
SEREM UTILIZADOS NO PROJETO
 */

package br.com.simiskraproject.processos;

import br.com.simiskraproject.ConnectionDBFactory;
import java.sql.Connection;
import java.util.Set;

public class Service {

    private ConnectionDBFactory connection; //INSTANCIA CONECÃO COM SERVIDOR

    public Service(){
        this.connection = new ConnectionDBFactory(); //DECLARA CONEXÃO
    }

    public Set<Contatos> listarContatoDoID(Integer chave){ //REALIZA UMA LISTA DOS DADOS DO DB
        Connection conn = connection.recuperarConexao();
        return new ContatoDAO(conn).listar(chave); //METODO DECLARADA NA CLASSE ContatoDAO
    }

    public void cadastrarContatos(DadosCadastroContato dadosDoContato) { //REALIZA CADASTRO NO BANCO DE DADOS
        Connection conn = connection.recuperarConexao();
        new ContatoDAO(conn).salvaContato(dadosDoContato);//METODO DECLARADA NA CLASSE ContatoDAO
    }

    public void deletaContato(String nomeDoContato, Integer chave) {//DELETA LINDA NA TABELA CONTATOS
        //GUARDA RESULTADO DO METODO
        var contato = buscarContatoPorNome(nomeDoContato, chave);//METODO DECLARADO A BAIXO

        if (contato.contatoExist(nomeDoContato)) {
            throw new RuntimeException("Não existe");
        } else {
            Connection conn = connection.recuperarConexao();

            new ContatoDAO(conn).deletar(nomeDoContato, chave);//METODO DECLARADA NA CLASSE ContatoDAO
        }
    }

    private Contatos buscarContatoPorNome (String nome, Integer chave) {//REALIZA BUSTA E RETONAR LINHA DO DB
        Connection conn = connection.recuperarConexao();
        Contatos contato = new ContatoDAO(conn).listarPorNome(nome, chave); //METODO DECLARADA NA CLASSE ContatoDAO

        System.out.println(contato); //EXIBE LINHA DO DB

        if(contato != null) {
            return contato; //RETORNO
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
    }


    public Contatos procuraPorNome (String nome, Integer chave) { //PROCURA POR LINHA DE DADOS PELO NOME CADASTRADO
        var contato = buscarContatoPorNome(nome, chave);//METODO DECLARADO A BAIXO

        if(contato.contatoExist(nome)) {
            throw new RuntimeException("erro procurapornome");
        }
        return contato;//RETORNO
    }

    public void cadastraCliente(DadosCadastroCliente dadosDoCliente) { //REALIZA CADASTRO NO BANCO DE DADOS
        Connection conn = connection.recuperarConexao();
        new ContatoDAO(conn).salvaCliente(dadosDoCliente);//METODO DECLARADA NA CLASSE ContatoDAO
    }

    public Usuario logar(String email, String senha) {
        var logando = buscaUsuario(email, senha);

        return logando;
    }

    private  Usuario buscaUsuario (String email, String senha){
        Connection conn = connection.recuperarConexao();
        Usuario logado = new ContatoDAO(conn).listaLogin(email, senha);

        System.out.println(logado);

        if(logado != null) {
            return logado; //RETORNO
        } else {
            throw new RuntimeException("Contato não encontrado");
        }
    }
}
