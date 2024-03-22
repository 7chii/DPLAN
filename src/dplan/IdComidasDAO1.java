
package dplan;

import java.awt.HeadlessException;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IdComidasDAO1 {

    public IdComidasDAO1() {
    }
    //INSERIR
    public void InserirComida(Receita obj) throws ClassNotFoundException
    {
        String  sql = "INSERT INTO idcomidas(MATRICULA, RECEITA, CORPOTEXTO, CLASSF)VALUES(?, ?, ?, ?)"; 

        Connection conn = null; 

        PreparedStatement pstm = null; 
       
        try{ 

            conn = Conexao.getConnection(); 

            pstm = (PreparedStatement) conn.prepareStatement(sql); 
            
            pstm.setString(1,obj.getID());
                    
            pstm.setString(2, obj.getNOMERECEITA());        

            pstm.setString(3, obj.getCORPOTEX()); 
            
            pstm.setString(4, obj.getCLASSIF());
            
            


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
    //Consultar
    public Receita consultaComida(String chave) throws ClassNotFoundException
    {
        Receita rec = null; 
        
        try { 

            try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM idcomidas WHERE MATRICULA = ?")) {
                
                ps.setString(1, chave);
                
                
                ResultSet r1 = ps.executeQuery();
                
                if (r1.next()) {
                    
                    rec = new Receita(r1.getString("MATRICULA"), r1.getString("RECEITA"), r1.getString("CORPOTEXTO"), r1.getString("CLASSF"));
                    
                }
                
            } 

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Receita NAO encontrada");
            rec = new Receita("","","","");
        } 
        
        return rec;
    }
    public Receita consultaRECEITA(String chave) throws ClassNotFoundException
    {
        Receita rec = null; 
        
        try { 

            try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT * FROM idcomidas WHERE RECEITA = ?")) {
                
                ps.setString(1, chave);
                
                
                ResultSet r1 = ps.executeQuery();
                
                if (r1.next()) {
                    
                    rec = new Receita(r1.getString("MATRICULA"), r1.getString("RECEITA"), r1.getString("CORPOTEXTO"), r1.getString("CLASSF"));
                    
                }
                
            } 

        } catch (SQLException e) {
            // Trate o erro apropriadamente
            //NAOO
        } 
        
        return rec;
    }
    //Consulta ingrediente
    public ArrayList<String> consultaIngrediente() throws ClassNotFoundException
    {
        int a = 0;
        ContarEntradas rec = new ContarEntradas(a,"");
        ArrayList<String> resultList;
        resultList = new ArrayList<>();
        try { 
// WHERE RECEITA = ?
            try (Connection conn = Conexao.getConnection(); PreparedStatement ps = conn.prepareStatement("SELECT RECEITA FROM idcomidas")) {
                
                ResultSet r1 = ps.executeQuery();
                while (r1.next()) {
                    String result = r1.getString("RECEITA");
                    resultList.add(result);
                    rec = new ContarEntradas(1, result);
                    
                }System.out.println(resultList);System.out.println(rec.getNOMES());
                
            } 

        } catch (SQLException e) {
            // Trate o erro apropriadamente
            //NAOO
            JOptionPane.showMessageDialog(null, "ERRO SQL!!!");
        } 
        return resultList;
        
        
    }
    public ContarEntradas ContarEntradasSQL() throws SQLException, ClassNotFoundException
    {
        ContarEntradas entradas = null;
        Connection conn;
        conn = Conexao.getConnection();PreparedStatement ps;
        ps = conn.prepareStatement("SELECT COUNT(*) AS contagem FROM idcomidas");
        ResultSet r1 = ps.executeQuery();
        if (r1.next()) {
            int RECEITAS = r1.getInt("contagem");
            entradas = new ContarEntradas(RECEITAS, "");
            System.out.println(entradas.getCONTADAS());
        }
        return entradas;
        
        
    }
    //Excluir :P
    public boolean excluirRec(String nome) throws SQLException, ClassNotFoundException { 

        Connection connection = null; 

        PreparedStatement stmt = null; 

 

        try { 

            connection = Conexao.getConnection(); // Obtenha a conexão com o banco de dados 

 

            // Crie a instrução SQL para excluir o cliente com a matrícula fornecida 

            String sql = "DELETE FROM idcomidas WHERE MATRICULA = ?"; 

 

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

