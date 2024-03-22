
package dplan;

import java.awt.HeadlessException;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maria
 */
public class IdDietasClientesDAO {
    //INSERIR
    public void inserirRotina(DietaCliente obj) throws ClassNotFoundException
    {
    String  sql = "INSERT INTO iddietas(MATRICULA, SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO)VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    Connection conn = null; 

        PreparedStatement pstm = null; 
       
        try{ 

            conn = Conexao.getConnection(); 

            pstm = (PreparedStatement) conn.prepareStatement(sql); 
            
            pstm.setString(1,obj.getMAT());
                    
            pstm.setString(2, obj.getSEG());        

            pstm.setString(3, obj.getTER()); 
            
            pstm.setString(4, obj.getQUA());
            
            pstm.setString(5, obj.getQUI()); 
            
            pstm.setString(6, obj.getSEX()); 
            
            pstm.setString(7, obj.getSAB());
            
            pstm.setString(8, obj.getDOM());


            pstm.execute(); 
            

        }catch(SQLException e) { 

            JOptionPane.showConfirmDialog(null, "Erro ao salvar dados "+ e.toString()); 

            //System.out.println("Erro ao salvar dados "+ e.getMessage().toLowerCase()); 

        }finally { 

            try { 

                if(pstm!=null) { 

                    JOptionPane.showMessageDialog(null, "Registro gravado com sucesso!!!"); 

                    pstm.close(); 

                } 

                if(conn!=null) { 

                    conn.close(); 

                } 

            }catch (HeadlessException | SQLException e) { 

                System.out.println("Erro ao salvar dados "+ e.getMessage().toLowerCase());            

            } 

        }
    }
    //consultar
    public DietaCliente consultaDieta(String chave) throws ClassNotFoundException
    {
        DietaCliente dcliente = null; 
        
        try { 

            try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM iddietas WHERE MATRICULA = ?")) {
                
                ps.setString(1, chave);
                
                
                ResultSet r1 = ps.executeQuery();
                
                if (r1.next()) {
                    
                    dcliente = new DietaCliente(r1.getString("MATRICULA"), r1.getString("SEGUNDA"), r1.getString("TERCA"), r1.getString("QUARTA"), r1.getString("QUINTA"), r1.getString("SEXTA"), r1.getString("SABADO"), r1.getString("DOMINGO"));
                    
                }
                
            } 

        } catch (SQLException e) {
            // Trate o erro apropriadamente

        } 
        
        return dcliente;
        
    }
    public boolean excluirDieta(String nome) throws SQLException, ClassNotFoundException { 

        Connection connection = null; 

        PreparedStatement stmt = null; 

 

        try { 

            connection = Conexao.getConnection(); // Obtenha a conexão com o banco de dados 

 

            // Crie a instrução SQL para excluir o cliente com a matrícula fornecida 

            String sql = "DELETE FROM iddietas WHERE MATRICULA = ?"; 

 

            // Prepare a declaração SQL com a matrícula fornecida 

            stmt = connection.prepareStatement(sql); 

            stmt.setString(1, nome); 

 

            // Execute a exclusão 

            int rowsAffected = stmt.executeUpdate(); 

 

            // Verifique se a exclusão foi bem-sucedida (verificando o número de linhas afetadas) 

            if (rowsAffected > 0) { 

                return true; // Exclusão bem-sucedida 

            } else { 

                return false; // Nenhum registro foi excluído (cliente não encontrado) 

            } 

        } finally { 

            // Feche a declaração e a conexão, mesmo em caso de exceção 

            if (stmt != null) { 

                stmt.close(); 

            } 

            if (connection != null) { 

                connection.close(); 

            } 

        } 

    }
    
    }
    

