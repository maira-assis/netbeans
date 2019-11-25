/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 277703
 */
public class ConexaoSQL {
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/bancoGEART.qbquery";
    private final String USER = "root";
    private final String PASS = "";
    
    private Connection conn;
    
    public ConexaoSQL()throws ClassNotFoundException, SQLException {
    
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URL, USER, PASS);
            conn.setAutoCommit(false);
            System.out.println("Conexão criada com SGBD com sucesso!");
        }
        
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException e){
            throw new ClassNotFoundException("O Driver não foi localizado e "  
            + "adicionado.Talvez a biblioteca JDBC não foi adicionado "
            + "ao projeto.\n"+ e.getMessage());
        }
           
        catch (SQLException e) {
            throw new SQLException("Deu erro na conexão com a fonte de dados.\n"
                    + e.getMessage());
        }
        }
}

