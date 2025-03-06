/*
PADRAO DE DADOS
*/


package br.com.simiskraproject.processos;

public record DadosCadastroContato(String nome,
                                   String telefone,
                                   String eMail,
                                   Integer chave) {
}
