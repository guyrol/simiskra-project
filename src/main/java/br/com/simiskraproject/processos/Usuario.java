/*
NESSA CLASSE DECLARAMOS O USUARIO, ASSIM COMO SUAS VARIEIS, GETTERS E SETTERS.
 */

package br.com.simiskraproject.processos;

import java.util.Objects;

public class Usuario {

    private String nome; //NOME DO USUARIO
    private String login; //LOGIN DO USUARIO
    private String senha; //SENHA DO USUARIO
    private Integer id; //ID DO USUARIO

    public Usuario(Integer id, String nome, String login, String senha) { //SET DE DADOS DE INSTANCIA
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) { //VERIFICA IGUALDADE DE OBJETO
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario cliente = (Usuario) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() { //GERA CODIGO HASH
        return Objects.hash(id);
    }

    @Override
    public String toString() {// CONFIGURA EXIBIÇÃO DO OBJETO EM STRING
        return " || ID " + id +
                " || Usuario: " + nome  +
                " || E-Mail: " + login;
    }


    //GETTERS DAS VARIAVEIS DO OBJETO.
    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Integer getId() {
        return id;
    }
}

