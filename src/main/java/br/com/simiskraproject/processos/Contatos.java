/*
NESSA CLASSE DECLARAMOS O CONTATOS, ASSIM COMO SUAS VARIEIS, GETTERS E SETTERS.
*/

package br.com.simiskraproject.processos;

import java.util.Objects;

public class Contatos {

    private Integer id; //ID DOS CONTATO
    private String nome; //NOME DO CONTATO
    private String telefone; //TELEFONE DO CONTATO
    private String eMail; //EMAIL DO CONTATO
    private Integer titular; //ID DO TITULAR DO CONTATO

    //SETTERS DAS VARIAVEIS
    public Contatos(Integer id,
                    String nome,
                    String telefone,
                    String eMail,
                    Integer chave) {
        this.telefone = telefone;
        this.nome = nome;
        this.eMail = eMail;
        this.titular = chave;
        this.id = id;
    }

    public boolean contatoExist(String nomeDoContato){//COMPARA EXISTENCIA DO CONTATO
        return this.nome.compareTo(nomeDoContato) != 0;
    }

    @Override
    public boolean equals(Object o) { //VERIFICA EQUIDADE ENTRE CONTATOS
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contatos contato = (Contatos) o;
        return id.equals(contato.id);
    }

    @Override
    public int hashCode() { //GERA CODIGO HASH
        return Objects.hash(id);
    }

    @Override
    public String toString() {  // CONFIGURA EXIBIÇÃO DO OBJETO EM STRING
        return " || nome: " + nome +
                " || Telefone: " + telefone +
                " || E-mail: " + eMail +
                " **";
    }

    //GETTES DAS VARIAVEIS
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String geteMail() {
        return eMail;
    }

    public Integer getTitular() {
        return titular;
    }

    public Integer getId() {
        return id;
    }
}

