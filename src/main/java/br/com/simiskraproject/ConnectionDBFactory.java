/*
Nesta classe temos um metodo Factory para realizar uma conexão com o dada base local
TAMBÉM UTILZIAMOS O HIKARIDS PARA MELHORAR A EFICIENCIA DE CONEXÕES COM O DATA BASE

PARA CONFIGUAR O AMBIENTE EM SUA MAQUINA
É NECESSÁRIO QUE ALTERE AS LINHAS 31 e 32 PARA RESPECTIVAMENTE SEU USUARIO DO
LOCAL HOST MySQL E SENHA DO LOCAL HOST
 */

package br.com.simiskraproject;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

//Realiza a conexão com o banco de dados.
public class ConnectionDBFactory { //

    public Connection recuperarConexao() {
        try{
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private HikariDataSource createDataSource() { // UTILIZA O HIKARI PARA TER UMA CONEXÃO MAIS EFICIENTE
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/simiskradb");
        config.setUsername("root");
        config.setPassword("MySQL@dx54kzp3!");
        config.setMaximumPoolSize(10);//MAXIMO POOL DE CONEXÃO SIMULTANEAS

        return new HikariDataSource(config);
    }
}

//"jdbc:mysql://localhost:3306/simiskradb?user=root&password=MySQL@dx54kzp3!"