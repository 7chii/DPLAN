/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dplan;
import com.mysql.jdbc.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

public class TestaConexao {
    private static final String USUARIO = "root"; 

    private static final String SENHA = ""; 

    private static final String URL = "jdbc:mysql://localhost:3306/cliente"; 

    public static Connection conectar()throws SQLException, ClassNotFoundException { 

        DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 

        Connection conexao = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA); 

        return conexao; 

    } 

    public static void main(String[] args) throws ClassNotFoundException{ 

        try { 

            Connection conexao = TestaConexao.conectar(); 

            System.out.println("Conexão ao Banco realizada com sucesso"); 

        } catch (SQLException ex) { 

            ex.printStackTrace(); 

            System.out.println("Conexão ao Banco falhou"); 

        } 

    } 
}
