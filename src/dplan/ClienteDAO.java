
package dplan;

import java.awt.HeadlessException;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    public void adicionar(Cliente obj ) throws Exception{ 

        String  sql = "INSERT INTO cliente(MATRICULA, EMAIL, NOME, SENHA, IDADE, PESO, META)VALUES(?, ?, ?, ?, ?, ?, ?)"; 

        Connection conn = null; 

        PreparedStatement pstm = null; 
       
        try{ 

            conn = Conexao.getConnection(); 

            pstm = (PreparedStatement) conn.prepareStatement(sql); 
            
            pstm.setString(1,obj.getMAT());
                    
            pstm.setString(2, obj.getEMAIL());        

            pstm.setString(3, obj.getNOME()); 
            
            pstm.setString(4, obj.getSENHA());
            
            pstm.setString(5, obj.getIDADE()); 
            
            pstm.setString(6, obj.getPESO()); 
            
            pstm.setString(7, obj.getMETA());


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
    public Cliente consultar(String chave) throws ClassNotFoundException { 

        Cliente cliente = null; 
        
        try { 

            try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM cliente WHERE NOME = ?")) {
                
                ps.setString(1, chave);
                
                
                ResultSet r1 = ps.executeQuery();
                
                if (r1.next()) {
                    
                    cliente = new Cliente(r1.getString("MATRICULA"), r1.getString("EMAIL"), r1.getString("NOME"), r1.getString("SENHA"), r1.getString("IDADE"), r1.getString("PESO"), r1.getString("META"));
                    
                }
                
            } 

        } catch (SQLException e) {
            // Trate o erro apropriadamente

        } 
        
        return cliente; 
        
    }
    public Cliente consultarMat(String chave) throws ClassNotFoundException { 

        Cliente cliente = null; 
        
        try { 

            try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM cliente WHERE MATRICULA = ?")) {
                
                ps.setString(1, chave);
                
                
                ResultSet r1 = ps.executeQuery();
                
                if (r1.next()) {
                    
                    cliente = new Cliente(r1.getString("MATRICULA"), r1.getString("EMAIL"), r1.getString("NOME"), r1.getString("SENHA"), r1.getString("IDADE"), r1.getString("PESO"), r1.getString("META"));
                    
                }
                
            } 

        } catch (SQLException e) {
            // Trate o erro apropriadamente

        } 
        
        return cliente; 
        
    }
    //nao funfa!
    public Cliente atualizarCadastro(Cliente obj, String chave) throws SQLException
    {
        Connection conn;
        try {
            conn = Conexao.getConnection();PreparedStatement ps = conn.prepareStatement("UPDATE cliente SET EMAIL=? ,NOME=? ,SENHA=? ,IDADE=? ,PESO=? ,META=?  WHERE NOME = ?");
            ps.setString(1, obj.getEMAIL());
            ps.setString(2, obj.getNOME());
            ps.setString(3, obj.getSENHA());
            ps.setString(4, obj.getIDADE());
            ps.setString(5, obj.getPESO());
            ps.setString(6, obj.getMETA());
            ps.setString(7, chave);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "Erro ao Alterar dados "+ ex.toString());
        }
        return null;

    }
    public boolean excluir(String nome) throws SQLException, ClassNotFoundException { 

        Connection connection = null; 

        PreparedStatement stmt = null; 

 

        try { 

            connection = Conexao.getConnection(); // Obtenha a conexão com o banco de dados 

 

            // Crie a instrução SQL para excluir o cliente com a matrícula fornecida 

            String sql = "DELETE FROM cliente WHERE MATRICULA = ?"; 

 

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
    public Cliente ContarEntradasSQL() throws SQLException, ClassNotFoundException
    {
        Cliente clientea = null;
        Connection conn;
        conn = Conexao.getConnection();PreparedStatement ps;
        ps = conn.prepareStatement("SELECT COUNT(*) AS contagem FROM cliente");
        ResultSet r1 = ps.executeQuery();
        if (r1.next()) {
            int Contas = r1.getInt("contagem");
            System.out.println(Contas);
            String MatriculaNova = String.valueOf(Contas + 1);
            clientea = new Cliente(MatriculaNova,"","","","","","");
        }
        return clientea;
        
        
    }
    } 

    //ClienteDAO() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    //}

