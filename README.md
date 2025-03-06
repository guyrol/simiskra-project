# simiskra-project
Projeto Simiskra - Lista Telefonica


OLÁ!

Bem vindo ao projeto Simiskra - Lista Telefonica o/

O nome é estranho, eu sei! Mas é original... Simiskra significa Lista Telefonica
em Islandes (Quanta Originalidade!).





////////////////////////////////////////////

Esse Projeto trata-se de uma aplicação desenvolvida em JAVA que utiliza SQL via
JDBC para realizar Queries diretamente no banco de dados no MySQL. 

Também utilizamos HikariDB no Maven para ter maior eficiencia nas conexões
estabelecidas no decorrer do programa(Obs: O Hikari retorna um erro no momento da primeira
conexão com DataBase, trata-se de uma Exception do Hikari avisando que é possivel passar um parametro
para login no HikariDB, esse erro ainda não foi tratado. O corre apenas uma vez durante a execução do
programa, mas ele está lá!).





************************

PREPARE SEU AMBIENTE!

Projeto está sendo desenvolvido na IDEA IntelliJ, sugiro utilizar essa mesma IDEA para o programa.     

O Java SE 23.0.2 é a versão mais atualizada do JAVA atualmente, atualize seu JAVA!

Atualize também seu MySQL para versão mais atual.

É necessário executar o Script SQL fornecido neste repositorio para o completo funcionamento
do sistema juntamente com o MySQL.

************************




Rodamos tudo através do terminal de comando!

Ao iniciar o programa você será impactado com a mensagem de boas vindas e logo em seguinda
o menu inicial.

            **********************************                    
            *             SIMISKRA           *
            *         Lista Telefonica       *
            **********************************
            
            Bem vindo app de lista telefinica Simiskra!


            SIMISKRA - ESCOLHA UMA OPÇÃO:
            1 - Login
            2 - Cadastro
            3 - Sair


1 - Realiza o login de um cadastro existente no bando de dados, o sistema vai solicitar
login(formato E-mail) e senha.

Temos um cadastro admin por padrão (login: admin@admin.com, senha: 1234).

Não foi implementado hierarquia no sitema de Cadastro/Login, apenas uma verificação simples no banco de dados.

Cada Usuario só pode interagir com os respectivos catatos cadastrados que possuiem sua 
assinatura de usurario. Dessa forma nenhum usuario pode interferir nos contatos um do outro.

--

2 - Cadastra novo Usuario e insere diretamente em nossa tabela usuario do banco de dados.
Sistema irá solicitar nome do cliente, e-mail e senha.

--

3 - Finaliza aplicação.



Ao realizar o login o usuario é impactado com o menu do usuario.

                * SIMISKRA *
                Olá, escolha uma opção:
                1 - Ver Lista de Contatos
                2 - Procurar Contato
                3 - Salvar Novo Contato
                4 - Deletar Contato
                5 - Voltar


1 - Essa opção visualista todos os contatos cadastrado atualmente que possui a assinatura de ID do usuario logado.

2 - Procura por contato especifico, a função irá solicitar que informe o nome exato do contato. Caso o
nome informado esteja cadastrado o usuario irá visualizar as informações do contato.

3 - Salva um novo contato em nossa tabela contatos do banco de dados. O sistema vai
solicitar nome, e-mail e telefone do novo contato.

4 - Deleta contato em nossa tabela contatos do banco de dados. O sistema irá solicitar que informe o nome
exato do contato e caso esteja contido em nossa tabela contatos o sistema ira deletar a linha da tabela
depois informará quais dados foram excluidos.

5 - retorna ao menu inicial (Login/cadastro).









