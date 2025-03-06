/*
NESSA CLASSE EM PADRÃO DAO TEMOS TODAS AS INTERAÇOES QUE
SERÃO REALIZADAS COM O BANCO DE DADOS
 */

package br.com.simiskraproject.processos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ContatoDAO {

    private Connection conn; //INSTANCIA CONEXÃO

    public ContatoDAO(Connection connection) {
        this.conn = connection;
    }

    //SINTAX PARA SALVA DADOS DE CONTATO
    public void salvaContato(DadosCadastroContato dadosContato) {

        String sql = "INSERT INTO contatos (nome, telefone, email, chave)" +
                "VALUES (?, ?, ?, ?)"; //Sintax de Inserção de Contato em string

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //ORGANIZA AS VARIAVEIS NA SINTAX
            preparedStatement.setString(1, dadosContato.nome()); // nome
            preparedStatement.setString (2, dadosContato.telefone()); // telefone
            preparedStatement.setString(3, dadosContato.eMail()); // email
            preparedStatement.setInt(4, dadosContato.chave()); //chave do titular do contato.

            preparedStatement.execute(); //EXECUTA QUERY
            preparedStatement.close(); //FECHA QUERY
            conn.close(); //FECHA CONEXÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Guarda valores da tabela Contatos do DB em lista para exibir posteriormente.
    public Set<Contatos> listar(Integer chave) {
        PreparedStatement ps;
        ResultSet resultSet;
        Set<Contatos> contatos = new HashSet<>();

        //SINTAX PARA ACESSAR TABELA CONTATOS
        String sql = "SELECT * FROM contatos WHERE chave = " + chave;

        try {
            ps = conn.prepareStatement(sql);
            resultSet = ps.executeQuery(); //EXECUTA QUERY

            while (resultSet.next()) {
                //GUARDA VARIAVEIS DA LINHA DA TABELA CONTATOS
                Integer id = resultSet.getInt(1); //ID
                String nome = resultSet.getString(2);//NOME
                String telefone = resultSet.getString(3);//TELEFONE
                String email = resultSet.getString(4); //EMAIL
                Integer titular = resultSet.getInt(5); //TITULAR

                //ADICIONA OS DADOS RECEBIDOS DO DB PARA LISTA CONTATOS
                contatos.add(new Contatos(id, nome, telefone, email, titular));
            }
            resultSet.close(); //FECHAR RESULTSET
            ps.close(); //FECHA PREPARESTATEMENT
            conn.close(); //FECHA CONEXÃO

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contatos; //RETORNO DA LISTA
    }

    public Contatos listarPorNome (String nome, Integer chave) { //PROCURA POR LINDA DO DB PELO NOME CO CONTATO

        //SINTAX PARA SELECIONAR A LINHA CORRESPONDENTE AO NOME
        String sql = "SELECT * FROM contatos WHERE nome = ? AND chave = ?";

        PreparedStatement ps;
        ResultSet resultSet;
        Contatos contato = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome); //NOME DO CONTATO
            ps.setInt(2, chave); //CHAVE DO USUARIO
            resultSet = ps.executeQuery();

            //GUARDA RESULTADOS ENCONTRADOS
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String nomeDoContato = resultSet.getString(2);
                String telefone = resultSet.getString(3);
                String email = resultSet.getString(4);
                Integer titular = resultSet.getInt(5);

                contato = new Contatos(id, nomeDoContato, telefone, email, titular); //AGURA OS VALORES RECEBIDO DO DB
            }
            resultSet.close(); //FECHA RESULTSET
            ps.close(); //FECHA PREPARESTATEMENT
            conn.close(); //FECHA CONEXÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contato;
    }

    public void deletar(String nome, Integer chave) { //DELETA LINHA DA TABELA CONTATOS NO DB

        //SINTAX PARA DELETAR A LINHDA DA DABELA CONTATOS
        String sql = "DELETE FROM contatos WHERE nome = ? and chave = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nome); //NOME DO CONTATO
            ps.setInt(2, chave); //ID DO USUARIO LOGADO

            ps.execute(); //FECHA RESULTSET
            ps.close(); //FECHA PREPARESTATEMENT
            conn.close(); //FECHA CONEXÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //SINTAX PARA SALVA DADOS DE CONTATO
    public void salvaCliente(DadosCadastroCliente dadosCliente) {

        String sql = "INSERT INTO usuarios (nome, email, senha)" +
                "VALUES (?, ?, ?)"; //Sintax de Inserção de Contato em string

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            //ORGANIZA AS VARIAVEIS NA SINTAX
            preparedStatement.setString(1, dadosCliente.nome()); // nome
            preparedStatement.setString (2, dadosCliente.login()); // email
            preparedStatement.setString(3, dadosCliente.senha()); // senha

            preparedStatement.execute(); //EXECUTA QUERY
            preparedStatement.close(); //FECHA QUERY
            conn.close(); //FECHA CONEXÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario listaLogin(String email, String senha) { //PROCURA POR LINDA DO DB PELO NOME CO CONTATO

        //SINTAX PARA SELECIONAR A LINHA CORRESPONDENTE AO NOME
        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";

        PreparedStatement ps;
        ResultSet resultSet;
        Usuario usuario = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, email); //NOME DO CONTATO
            ps.setString(2, senha); //CHAVE DO USUARIO
            resultSet = ps.executeQuery();

            //GUARDA RESULTADOS ENCONTRADOS
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String nomeDoUsuario = resultSet.getString(2);
                String emailDoUsuario = resultSet.getString(3);
                String senhaDoUsuario = resultSet.getString(4);

                usuario = new Usuario(id, nomeDoUsuario, emailDoUsuario, senhaDoUsuario); //AGURA OS VALORES RECEBIDO DO DB
            }
            resultSet.close(); //FECHA RESULTSET
            ps.close(); //FECHA PREPARESTATEMENT
            conn.close(); //FECHA CONEXÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
