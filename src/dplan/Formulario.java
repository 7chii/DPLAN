
package dplan;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class Formulario extends javax.swing.JFrame {
    int diaSemana = 0;
    LocalDate today = LocalDate.now();
    DayOfWeek dayOfWeek = today.getDayOfWeek();
    
    int div;
    int sdiv, tdiv, qdiv, qudiv, sediv, sadiv, ddiv = 0;
    String entrada = null;
    String selecionada = "";
    String SEG,TER,QUAR,QUI,SEX,SAB,DOM = null;
    DietaCliente dCliente = new DietaCliente(null, null, null, null, null, null, null, null);
    Cliente cliente = new Cliente("","","","","","","");
    Receita nRecei = new Receita("", "", "", "");
    
    IdDietasClientesDAO dietasdao = new IdDietasClientesDAO();
    ClienteDAO clientedao = new ClienteDAO();
    IdComidasDAO1 receitasdao = new IdComidasDAO1();
    
    
    
    public Formulario() {
        initComponents();
    }
    
    private void ExcluirD() throws ClassNotFoundException
    {
    try { 

            // Obtenha a matrícula do cliente que deseja excluir 

            String nome = dCliente.getMAT(); 

 

            // Verifique se a matrícula não está vazia 

            if (nome.isEmpty()) { 

                JOptionPane.showMessageDialog(null, "DIETA INEXISTENTE"); 

                return; 

            } 

 

            // Chame o método de exclusão do ClienteDAO 

            boolean sucesso = dietasdao.excluirDieta(nome); 

 

            if (sucesso) { 

                JOptionPane.showMessageDialog(null, "Dieta excluída com sucesso!"); 

                // Limpe os campos de texto após a exclusão 


            } else { 

                JOptionPane.showMessageDialog(null, "Não foi possível excluir a dieta."); 

            } 

        } catch (SQLException e) { 

            JOptionPane.showMessageDialog(null, "Erro ao excluir a dieta: " + e.toString()); 

        } 

    }
    
    @SuppressWarnings("empty-statement")
    private void ConsultaIng() throws SQLException
    {
        
        try {
            //String NOME = txtPesquisaIngPr1.getText();
            //for loop
            ContarEntradas nRecei1 = new ContarEntradas(0, "");
            ArrayList<String> ReceitaConsultada = receitasdao.consultaIngrediente();
            if (ReceitaConsultada != null) { 
                
                String[] arr = new String[ReceitaConsultada.size()];
                //nRecei1 = new ContarEntradas(ReceitaConsultada.getCONTADAS(), ReceitaConsultada.getNOMES());
                for(int i=0; i<ReceitaConsultada.size(); i++){
                    arr[i] = ReceitaConsultada.get(i);
                }
                lListaComidasPr1.setListData(arr);
                System.out.println(nRecei1.getCONTADAS());
                System.out.println(nRecei1.getNOMES());
            } else { 

                // Caso o cliente não seja encontrado, exiba uma mensagem 

                JOptionPane.showMessageDialog(null, "Receitas não carregadas!"); 

            } 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        };
        
    }
    
    private void ConsultaRec()
    {
        
        try {
            String NOME = txtMatRecPRecADD.getText();
            Receita ReceitaConsultada = receitasdao.consultaComida(NOME);
            
            if (ReceitaConsultada != null) { 

                // Preenche os campos de texto com os dados do cliente 
                nRecei.setID(ReceitaConsultada.getID());
                nRecei.setNOMERECEITA(ReceitaConsultada.getNOMERECEITA());
                nRecei.setCORPOTEX(ReceitaConsultada.getCORPOTEX());
                nRecei.setCLASSIF(ReceitaConsultada.getCLASSIF());
                
               

                JOptionPane.showMessageDialog(null, "Receita Carregada!"); 

            } else { 

                // Caso o cliente não seja encontrado, exiba uma mensagem 

                JOptionPane.showMessageDialog(null, "Receita não carregada!"); 

            } 

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "Erro Consulta Receita", ex);
        }
        
    }
    private void ConsultaRec1()
    {
        
        try {
            String NOME = selecionada;
            Receita ReceitaConsultada = receitasdao.consultaComida(NOME);
            
            if (ReceitaConsultada != null) { 

                // Preenche os campos de texto com os dados do cliente 
                nRecei.setID(ReceitaConsultada.getID());
                nRecei.setNOMERECEITA(ReceitaConsultada.getNOMERECEITA());
                nRecei.setCORPOTEX(ReceitaConsultada.getCORPOTEX());
                nRecei.setCLASSIF(ReceitaConsultada.getCLASSIF());
                
               

                JOptionPane.showMessageDialog(null, "Receita Carregada!"); 

            } else { 

                // Caso o cliente não seja encontrado, exiba uma mensagem 

                JOptionPane.showMessageDialog(null, "Receita não carregada!"); 

            } 

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "Erro Consulta Receita", ex);
        }
        
    }
    private void ConsultapRec()
    {
        
        try {
            String NOME = selecionada;
            
            Receita ReceitaConsultada = receitasdao.consultaRECEITA(NOME);
            
            if (ReceitaConsultada != null) { 

                // Preenche os campos de texto com os dados do cliente 
                nRecei.setID(ReceitaConsultada.getID());
                nRecei.setNOMERECEITA(ReceitaConsultada.getNOMERECEITA());
                nRecei.setCORPOTEX(ReceitaConsultada.getCORPOTEX());
                nRecei.setCLASSIF(ReceitaConsultada.getCLASSIF());
                
               

                JOptionPane.showMessageDialog(null, "Receita Carregada!"); 

            } else { 

                // Caso o cliente não seja encontrado, exiba uma mensagem 

                JOptionPane.showMessageDialog(null, "Receita não carregada!"); 

            } 

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "Erro Consulta Receita", ex);
        }
        
    }
    
    
    private void ConsultaD()throws Exception
     { 

        try { 

           // Obtém a matrícula a ser consultada do campo de texto 

            String NOME = cliente.getMAT();

         

            // Chama o método consultar da classe ClienteDAO para obter os dados do cliente 

            DietaCliente DclienteConsultado = dietasdao.consultaDieta(NOME);

            // Verifica se o cliente foi encontrado 

            if (DclienteConsultado != null) { 

                // Preenche os campos de texto com os dados do cliente 
                dCliente.setMAT(DclienteConsultado.getMAT());
                dCliente.setSEG(DclienteConsultado.getSEG());
                dCliente.setTER(DclienteConsultado.getTER());
                dCliente.setQUA(DclienteConsultado.getQUA());
                dCliente.setQUI(DclienteConsultado.getQUI());
                dCliente.setSEX(DclienteConsultado.getSEX());
                dCliente.setSAB(DclienteConsultado.getSAB());
                dCliente.setDOM(DclienteConsultado.getDOM());
               

                JOptionPane.showMessageDialog(null, "Dieta carregada!"); 

            } else { 

                // Caso o cliente não seja encontrado, exiba uma mensagem 

                JOptionPane.showMessageDialog(null, "Dieta não carregada!"); 

            } 

        } catch (Exception ex) { 

            ex.printStackTrace(); 

            // Trate o erro apropriadamente, exibindo uma mensagem de erro se necessário 

            JOptionPane.showMessageDialog(null, "Erro ao consultar dieta: " + ex.getMessage()); 

        } 

    }
 private void Log()
    {
        String nome = txtUserP2.getText();
        if (nome.isEmpty()) { 

                JOptionPane.showMessageDialog(null, "Informe Usuario."); 

                return; 

            }
        try {
            
            Cliente clienteConsultado = clientedao.consultar(nome);
            cliente.setMAT(clienteConsultado.getMAT());
            cliente.setEMAIL(clienteConsultado.getEMAIL());
            cliente.setNOME(clienteConsultado.getNOME());
            cliente.setSENHA(clienteConsultado.getSENHA());
            cliente.setIDADE(clienteConsultado.getIDADE());
            cliente.setPESO(clienteConsultado.getPESO());
            cliente.setMETA(clienteConsultado.getMETA());
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "USUARIO NAO ENCONTRADO", ex);
        }
        
        /*if (txtUserP2.getText().equals(cliente.getNOME())){
            if (txtSenhaP2.getText().equals(cliente.getSENHA())){
            JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO.");
            }
            }else if (txtUserP2.getText().equals(cliente.getEMAIL())){
                if (txtSenhaP2.getText().equals(cliente.getSENHA()))
                {
                    JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "LOGIN NAO REALIZADO.");
            }
        
        */
    }
    
    private void ExcluirRecei()
    {
        
        try {
            String nome = txtMatRecPRecADD.getText();
        if (nome.isEmpty()) { 

                JOptionPane.showMessageDialog(null, "Informe a matrícula da receita a ser excluída."); 


            } 
            boolean sucesso = receitasdao.excluirRec(nome);
            if (sucesso) { 

                JOptionPane.showMessageDialog(null, "Receita excluída com sucesso!"); 

                // Limpe os campos de texto após a exclusão 

                txtCORPOTEXTOPRecADD.setText(""); 

                txtRECEITAPRecADD.setText(""); 

                txtMatRecPRecADD.setText("");
                
                
                
                

            } else { 

                JOptionPane.showMessageDialog(null, "Não foi possível excluir a receita."); 

            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "ERRO EXCLUSAO SQL", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "ERRO CLASSE", ex);
        }
    }
    private void ExcluirCad() throws ClassNotFoundException
    {
    try { 

            // Obtenha a matrícula do cliente que deseja excluir 

            String nome = txtMatriculaPc.getText(); 

 

            // Verifique se a matrícula não está vazia 

            if (nome.isEmpty()) { 

                JOptionPane.showMessageDialog(null, "Informe a matrícula do cliente a ser excluído."); 

                return; 

            } 

 

            // Chame o método de exclusão do ClienteDAO 

            boolean sucesso = clientedao.excluir(nome); 

 

            if (sucesso) { 

                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!"); 

                // Limpe os campos de texto após a exclusão 

                txtNomePc.setText(""); 

                txtEmailPc.setText(""); 

                txtSenhaPc.setText("");
                
                txtIdadePc.setText("");
                
                txtPesoPc.setText("");
                
                

            } else { 

                JOptionPane.showMessageDialog(null, "Não foi possível excluir o cliente."); 

            } 

        } catch (SQLException e) { 

            JOptionPane.showMessageDialog(null, "Erro ao excluir o cliente: " + e.toString()); 

        } 

    } 

private void ConsultarDados() throws Exception{ 

        try { 

           // Obtém a matrícula a ser consultada do campo de texto 

            String NOME = txtMatriculaPc.getText(); 

         

            // Chama o método consultar da classe ClienteDAO para obter os dados do cliente 

            Cliente clienteConsultado = clientedao.consultarMat(NOME); 

 

            // Verifica se o cliente foi encontrado 

            if (clienteConsultado != null) { 

                // Preenche os campos de texto com os dados do cliente 
                txtMatriculaPc.setText(clienteConsultado.getMAT());
                
                txtNomePc.setText(clienteConsultado.getNOME()); 

                txtEmailPc.setText(clienteConsultado.getEMAIL());
                
                txtSenhaPc.setText(clienteConsultado.getSENHA());
                
                txtPesoPc.setText(clienteConsultado.getPESO());
                
                txtIdadePc.setText(clienteConsultado.getIDADE());
                
                switch (clienteConsultado.getMETA()) {
                    case "EN":
                        bEngordarPc1.setSelected(!bEngordarPc1.isSelected());
                        break;
                    case "EM":
                        bEmagrecerPc1.setSelected(!bEmagrecerPc1.isSelected());
                        break;
                    case "GM":
                        bGanhoMassPc1.setSelected(!bGanhoMassPc1.isSelected());
                        break;
                    default:
                        break;
                }

                JOptionPane.showMessageDialog(null, "Cliente encontrado!"); 

            } else { 

                // Caso o cliente não seja encontrado, exiba uma mensagem 

                JOptionPane.showMessageDialog(null, "Cliente não encontrado!"); 

            } 

        } catch (Exception ex) { 

            ex.printStackTrace(); 

            // Trate o erro apropriadamente, exibindo uma mensagem de erro se necessário 

            JOptionPane.showMessageDialog(null, "Erro ao consultar cliente: " + ex.getMessage()); 

        } 

    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p2 = new javax.swing.JFrame();
        panelDiaSemanaP2botoes = new javax.swing.JPanel();
        bRefeicao01P2 = new javax.swing.JButton();
        bRefeicao03P2 = new javax.swing.JButton();
        bRefeicao02P2 = new javax.swing.JButton();
        bRefeicao09P2 = new javax.swing.JButton();
        bRefeicao04P2 = new javax.swing.JButton();
        bRefeicao05P2 = new javax.swing.JButton();
        bRefeicao06P2 = new javax.swing.JButton();
        bRefeicao07P2 = new javax.swing.JButton();
        bRefeicao08P2 = new javax.swing.JButton();
        bRefeicao10P2 = new javax.swing.JButton();
        bEditarCadP2 = new javax.swing.JButton();
        bDieta = new javax.swing.JButton();
        bSairP2 = new javax.swing.JButton();
        txtDiaSemanaP2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bLimpaDieP2 = new javax.swing.JButton();
        PanelAdminReceitasP2 = new javax.swing.JPanel();
        bAdminReceitasP2 = new javax.swing.JButton();
        PC = new javax.swing.JFrame();
        bSalvarPc = new javax.swing.JButton();
        txtNomePc = new javax.swing.JTextField();
        txtEmailPc = new javax.swing.JTextField();
        txtSenhaPc = new javax.swing.JTextField();
        txtPesoPc = new javax.swing.JTextField();
        txtIdadePc = new javax.swing.JTextField();
        bCancelarPc = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        bEngordarPc1 = new javax.swing.JCheckBox();
        bEmagrecerPc1 = new javax.swing.JCheckBox();
        bGanhoMassPc1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        bConsultarPC = new javax.swing.JButton();
        bAlterarPc = new javax.swing.JButton();
        bExcluirPc = new javax.swing.JButton();
        txtMatriculaPc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        p2e = new javax.swing.JFrame();
        bLogoutP2e = new javax.swing.JButton();
        bFecharSysP2e = new javax.swing.JButton();
        bVoltarP2e = new javax.swing.JButton();
        receitaS = new javax.swing.JFrame();
        scrollpaneRS = new javax.swing.JScrollPane();
        txtCorpoRecRS = new javax.swing.JTextArea();
        txtNomeRefRS = new javax.swing.JTextField();
        txtEspRS = new javax.swing.JTextField();
        bVoltarRS = new javax.swing.JButton();
        p2d = new javax.swing.JFrame();
        bNovaDP2d = new javax.swing.JButton();
        bEditarDP2d = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        bVoltarP2d = new javax.swing.JButton();
        p3 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        panelSegundaP3 = new javax.swing.JPanel();
        bDivSegP3 = new javax.swing.JButton();
        panelTercaP3 = new javax.swing.JPanel();
        bDivTerP3 = new javax.swing.JButton();
        panelQuartaP3 = new javax.swing.JPanel();
        bDivQuaP3 = new javax.swing.JButton();
        panelQuintaP3 = new javax.swing.JPanel();
        bDivQuiP3 = new javax.swing.JButton();
        panelSextaP3 = new javax.swing.JPanel();
        bDivSexP3 = new javax.swing.JButton();
        panelSabadoP3 = new javax.swing.JPanel();
        bDivSabP3 = new javax.swing.JButton();
        panelDomingoP3 = new javax.swing.JPanel();
        bDivDomP3 = new javax.swing.JButton();
        bAvancarP3 = new javax.swing.JButton();
        bVoltarP3 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        p4 = new javax.swing.JFrame();
        jLabel21 = new javax.swing.JLabel();
        txtNUP4 = new javax.swing.JTextField();
        panelDomingoP4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        bdD5P4 = new javax.swing.JButton();
        bdD6P4 = new javax.swing.JButton();
        bdD10P4 = new javax.swing.JButton();
        bdD7P4 = new javax.swing.JButton();
        bdD1P4 = new javax.swing.JButton();
        bdD8P4 = new javax.swing.JButton();
        bdD4P4 = new javax.swing.JButton();
        bdD2P4 = new javax.swing.JButton();
        bdD3P4 = new javax.swing.JButton();
        bdD9P4 = new javax.swing.JButton();
        bVoltarP4 = new javax.swing.JButton();
        bEditarP4 = new javax.swing.JButton();
        panelQuartaP4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bdQ9P4 = new javax.swing.JButton();
        bdQ8P4 = new javax.swing.JButton();
        bdQ7P4 = new javax.swing.JButton();
        bdQ3P4 = new javax.swing.JButton();
        bdQ2P4 = new javax.swing.JButton();
        bdQ6P4 = new javax.swing.JButton();
        bdQ1P4 = new javax.swing.JButton();
        bdQ5P4 = new javax.swing.JButton();
        bdQ10P4 = new javax.swing.JButton();
        bdQ4P4 = new javax.swing.JButton();
        panelSegundaP4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        bdS1P4 = new javax.swing.JButton();
        bdS2P4 = new javax.swing.JButton();
        bdS3P4 = new javax.swing.JButton();
        bdS4P4 = new javax.swing.JButton();
        bdS5P4 = new javax.swing.JButton();
        bdS6P4 = new javax.swing.JButton();
        bdS7P4 = new javax.swing.JButton();
        bdS8P4 = new javax.swing.JButton();
        bdS9P4 = new javax.swing.JButton();
        bdS10P4 = new javax.swing.JButton();
        panelTercaP4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        bdT1P4 = new javax.swing.JButton();
        bdT2P4 = new javax.swing.JButton();
        bdT3P4 = new javax.swing.JButton();
        bdT4P4 = new javax.swing.JButton();
        bdT5P4 = new javax.swing.JButton();
        bdT6P4 = new javax.swing.JButton();
        bdT7P4 = new javax.swing.JButton();
        bdT8P4 = new javax.swing.JButton();
        bdT9P4 = new javax.swing.JButton();
        bdT10P4 = new javax.swing.JButton();
        panelQuintaP4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        bdQu9P4 = new javax.swing.JButton();
        bdQu1P4 = new javax.swing.JButton();
        bdQu5P4 = new javax.swing.JButton();
        bdQu6P4 = new javax.swing.JButton();
        bdQu7P4 = new javax.swing.JButton();
        bdQu3P4 = new javax.swing.JButton();
        bdQu8P4 = new javax.swing.JButton();
        bdQu10P4 = new javax.swing.JButton();
        bdQu2P4 = new javax.swing.JButton();
        bdQu4P4 = new javax.swing.JButton();
        panelSabadoP4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        bdSa2P4 = new javax.swing.JButton();
        bdSa5P4 = new javax.swing.JButton();
        bdSa10P4 = new javax.swing.JButton();
        bdSa4P4 = new javax.swing.JButton();
        bdSa1P4 = new javax.swing.JButton();
        bdSa6P4 = new javax.swing.JButton();
        bdSa3P4 = new javax.swing.JButton();
        bdSa8P4 = new javax.swing.JButton();
        bdSa7P4 = new javax.swing.JButton();
        bdSa9P4 = new javax.swing.JButton();
        panelSextaP4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        bdSe2P4 = new javax.swing.JButton();
        bdSe10P4 = new javax.swing.JButton();
        bdSe9P4 = new javax.swing.JButton();
        bdSe1P4 = new javax.swing.JButton();
        bdSe7P4 = new javax.swing.JButton();
        bdSe5P4 = new javax.swing.JButton();
        bdSe3P4 = new javax.swing.JButton();
        bdSe6P4 = new javax.swing.JButton();
        bdSe8P4 = new javax.swing.JButton();
        bdSe4P4 = new javax.swing.JButton();
        p5 = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        panelSegundaP5 = new javax.swing.JPanel();
        btESegP5 = new javax.swing.JToggleButton();
        panelTercaP5 = new javax.swing.JPanel();
        btETerP5 = new javax.swing.JToggleButton();
        panelQuartaP5 = new javax.swing.JPanel();
        btEQuarP5 = new javax.swing.JToggleButton();
        panelQuintaP5 = new javax.swing.JPanel();
        btEQuiP5 = new javax.swing.JToggleButton();
        panelSextaP5 = new javax.swing.JPanel();
        btESexP5 = new javax.swing.JToggleButton();
        panelSabadoP5 = new javax.swing.JPanel();
        btESabP5 = new javax.swing.JToggleButton();
        panelDomingoP5 = new javax.swing.JPanel();
        btEDomP5 = new javax.swing.JToggleButton();
        bAvancarP5 = new javax.swing.JButton();
        bVoltarP5 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        p6 = new javax.swing.JFrame();
        panelBotoesP6 = new javax.swing.JPanel();
        bd2P6 = new javax.swing.JButton();
        bd3P6 = new javax.swing.JButton();
        bd1P6 = new javax.swing.JButton();
        bd4P6 = new javax.swing.JButton();
        bd5P6 = new javax.swing.JButton();
        bd6P6 = new javax.swing.JButton();
        bd7P6 = new javax.swing.JButton();
        bd8P6 = new javax.swing.JButton();
        bd9P6 = new javax.swing.JButton();
        bd10P6 = new javax.swing.JButton();
        diaSemanaP6 = new javax.swing.JTextField();
        bSalvarP6 = new javax.swing.JButton();
        bVoltarP6 = new javax.swing.JButton();
        pr1 = new javax.swing.JFrame();
        scrollPr1 = new javax.swing.JScrollPane();
        lListaComidasPr1 = new javax.swing.JList<>();
        bRLPr1 = new javax.swing.JRadioButton();
        bRMPr1 = new javax.swing.JRadioButton();
        bRPPr1 = new javax.swing.JRadioButton();
        bPesqPr1 = new javax.swing.JButton();
        bSalvarPr1 = new javax.swing.JButton();
        bCancelarPr1 = new javax.swing.JButton();
        txtPesquisaIngPr1 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        pRecADD = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCORPOTEXTOPRecADD = new javax.swing.JTextArea();
        txtRECEITAPRecADD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bSalvarPRecADD = new javax.swing.JToggleButton();
        bVoltarPRecADD = new javax.swing.JButton();
        txtMatRecPRecADD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bPesoLevePRecADD = new javax.swing.JToggleButton();
        bPesoMedPRecADD = new javax.swing.JToggleButton();
        bPesoGranPRecADD = new javax.swing.JToggleButton();
        bConsultaRecPRecADD = new javax.swing.JButton();
        bExcluirRecPRecADD = new javax.swing.JButton();
        bAtualizarRecPRecADD = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtUserP2 = new javax.swing.JTextField();
        txtSenhaP2 = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        bLogP2 = new javax.swing.JButton();
        bCancelarP2 = new javax.swing.JButton();
        bCadastro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        p2.setTitle("BASE");
        p2.setMinimumSize(new java.awt.Dimension(528, 430));
        p2.setResizable(false);

        bRefeicao01P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefeicao01P2ActionPerformed(evt);
            }
        });

        bRefeicao03P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefeicao03P2ActionPerformed(evt);
            }
        });

        bRefeicao02P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefeicao02P2ActionPerformed(evt);
            }
        });

        bRefeicao09P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefeicao09P2ActionPerformed(evt);
            }
        });

        bRefeicao04P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefeicao04P2ActionPerformed(evt);
            }
        });

        bRefeicao05P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefeicao05P2ActionPerformed(evt);
            }
        });

        bRefeicao06P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefeicao06P2ActionPerformed(evt);
            }
        });

        bRefeicao07P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefeicao07P2ActionPerformed(evt);
            }
        });

        bRefeicao08P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefeicao08P2ActionPerformed(evt);
            }
        });

        bRefeicao10P2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefeicao10P2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDiaSemanaP2botoesLayout = new javax.swing.GroupLayout(panelDiaSemanaP2botoes);
        panelDiaSemanaP2botoes.setLayout(panelDiaSemanaP2botoesLayout);
        panelDiaSemanaP2botoesLayout.setHorizontalGroup(
            panelDiaSemanaP2botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDiaSemanaP2botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDiaSemanaP2botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bRefeicao05P2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(bRefeicao03P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRefeicao02P2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRefeicao09P2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRefeicao04P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRefeicao06P2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRefeicao07P2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRefeicao08P2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRefeicao10P2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bRefeicao01P2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDiaSemanaP2botoesLayout.setVerticalGroup(
            panelDiaSemanaP2botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDiaSemanaP2botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bRefeicao01P2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRefeicao02P2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRefeicao03P2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRefeicao04P2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRefeicao05P2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRefeicao06P2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRefeicao07P2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bRefeicao08P2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRefeicao09P2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRefeicao10P2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        bEditarCadP2.setText("EDITAR DADOS");
        bEditarCadP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarCadP2ActionPerformed(evt);
            }
        });

        bDieta.setText("DIETA");
        bDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDietaActionPerformed(evt);
            }
        });

        bSairP2.setBackground(new java.awt.Color(255, 102, 102));
        bSairP2.setText("SAIR");
        bSairP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairP2ActionPerformed(evt);
            }
        });

        txtDiaSemanaP2.setText("Terça-feira");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dplan/logopl.png"))); // NOI18N

        bLimpaDieP2.setText("LIMPAR DIETA");
        bLimpaDieP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpaDieP2ActionPerformed(evt);
            }
        });

        bAdminReceitasP2.setText("ADICIONAR RECEITAS");
        bAdminReceitasP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdminReceitasP2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAdminReceitasP2Layout = new javax.swing.GroupLayout(PanelAdminReceitasP2);
        PanelAdminReceitasP2.setLayout(PanelAdminReceitasP2Layout);
        PanelAdminReceitasP2Layout.setHorizontalGroup(
            PanelAdminReceitasP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAdminReceitasP2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bAdminReceitasP2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelAdminReceitasP2Layout.setVerticalGroup(
            PanelAdminReceitasP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAdminReceitasP2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bAdminReceitasP2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2.getContentPane());
        p2.getContentPane().setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p2Layout.createSequentialGroup()
                .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(p2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bLimpaDieP2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bEditarCadP2)
                                .addComponent(bDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bSairP2, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDiaSemanaP2)
                    .addComponent(panelDiaSemanaP2botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55)
                .addComponent(PanelAdminReceitasP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEditarCadP2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bLimpaDieP2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(bSairP2))
            .addGroup(p2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanelAdminReceitasP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(p2Layout.createSequentialGroup()
                        .addComponent(txtDiaSemanaP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDiaSemanaP2botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        PC.setTitle("CADASTRO");
        PC.setMinimumSize(new java.awt.Dimension(460, 400));
        PC.setResizable(false);

        bSalvarPc.setText("SALVAR");
        bSalvarPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarPcActionPerformed(evt);
            }
        });

        txtNomePc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomePcActionPerformed(evt);
            }
        });

        bCancelarPc.setText("VOLTAR");
        bCancelarPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarPcActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        jLabel10.setText("CADASTRO");

        jLabel11.setText("NOME");

        jLabel12.setText("EMAIL");

        jLabel13.setText("SENHA");

        jLabel14.setText("PESO");

        jLabel15.setText("IDADE");

        bEngordarPc1.setText("Engordar");
        bEngordarPc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEngordarPc1ActionPerformed(evt);
            }
        });

        bEmagrecerPc1.setText("Emagrecer");
        bEmagrecerPc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEmagrecerPc1ActionPerformed(evt);
            }
        });

        bGanhoMassPc1.setText("Ganho Massa Magra");
        bGanhoMassPc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGanhoMassPc1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dplan/logopl.png"))); // NOI18N

        bConsultarPC.setText("CONSULTAR");
        bConsultarPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarPCActionPerformed(evt);
            }
        });

        bAlterarPc.setText("ALTERAR");
        bAlterarPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarPcActionPerformed(evt);
            }
        });

        bExcluirPc.setText("EXCLUIR");
        bExcluirPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirPcActionPerformed(evt);
            }
        });

        txtMatriculaPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaPcActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        javax.swing.GroupLayout PCLayout = new javax.swing.GroupLayout(PC.getContentPane());
        PC.getContentPane().setLayout(PCLayout);
        PCLayout.setHorizontalGroup(
            PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PCLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(bEmagrecerPc1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bGanhoMassPc1))
                    .addGroup(PCLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PCLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PCLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMatriculaPc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(PCLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtEmailPc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNomePc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSenhaPc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(PCLayout.createSequentialGroup()
                                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addGroup(PCLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPesoPc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtIdadePc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(PCLayout.createSequentialGroup()
                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PCLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(bEngordarPc1))
                    .addGroup(PCLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bExcluirPc)
                            .addGroup(PCLayout.createSequentialGroup()
                                .addComponent(bConsultarPC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bAlterarPc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bSalvarPc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bCancelarPc)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PCLayout.setVerticalGroup(
            PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCLayout.createSequentialGroup()
                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PCLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtMatriculaPc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomePc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtEmailPc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenhaPc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesoPc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdadePc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEngordarPc1)
                    .addComponent(bEmagrecerPc1)
                    .addComponent(bGanhoMassPc1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelarPc)
                    .addComponent(bSalvarPc)
                    .addComponent(bConsultarPC)
                    .addComponent(bAlterarPc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bExcluirPc)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        p2e.setMinimumSize(new java.awt.Dimension(400, 96));
        p2e.setResizable(false);

        bLogoutP2e.setBackground(new java.awt.Color(255, 102, 102));
        bLogoutP2e.setText("logout");
        bLogoutP2e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogoutP2eActionPerformed(evt);
            }
        });

        bFecharSysP2e.setBackground(new java.awt.Color(255, 102, 102));
        bFecharSysP2e.setText("fechar sys");
        bFecharSysP2e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFecharSysP2eActionPerformed(evt);
            }
        });

        bVoltarP2e.setBackground(new java.awt.Color(255, 102, 102));
        bVoltarP2e.setText("voltar");
        bVoltarP2e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarP2eActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p2eLayout = new javax.swing.GroupLayout(p2e.getContentPane());
        p2e.getContentPane().setLayout(p2eLayout);
        p2eLayout.setHorizontalGroup(
            p2eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p2eLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(bLogoutP2e)
                .addGap(40, 40, 40)
                .addComponent(bFecharSysP2e)
                .addGap(37, 37, 37)
                .addComponent(bVoltarP2e)
                .addGap(49, 49, 49))
        );
        p2eLayout.setVerticalGroup(
            p2eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p2eLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p2eLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bVoltarP2e)
                    .addComponent(bFecharSysP2e)
                    .addComponent(bLogoutP2e))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        receitaS.setTitle("TERCA-FEIRA");
        receitaS.setMinimumSize(new java.awt.Dimension(398, 530));
        receitaS.setResizable(false);

        txtCorpoRecRS.setEditable(false);
        txtCorpoRecRS.setColumns(20);
        txtCorpoRecRS.setRows(5);
        txtCorpoRecRS.setText("Ingredientes (8 porções)(\n\n1 e 1/4 xícara (chá) de farinha de trigo\n\n1 colher (sopa) de açúcar\n\n3 colheres (chá) de fermento em pó\n\n2 ovos levemente batidos\n\n1 xícara (chá) de leite\n\n2 colheres (sopa) de manteiga derretida\n\npitada de sal\n\nóleo\n\nMODO DE PREPARO:\nMisture em um recipiente: a farinha, o açúcar, o fermento e o sal.\n\nEm outro recipiente, misture os ovos, o leite e a manteiga.\n\nAcrescente os líquidos aos secos, sem misturar em excesso.\n\nO ponto da massa não deve ser muito líquido, deve escorrer lentamente.\n\nAqueça e unte a frigideira com óleo, coloque a massa no centro, cerca de 1/4 xícara por panqueca.\n\nVire a massa para assar do outro lado e está pronto!");
        scrollpaneRS.setViewportView(txtCorpoRecRS);

        txtNomeRefRS.setEditable(false);
        txtNomeRefRS.setText("CAFE DA MANHÃ");

        txtEspRS.setEditable(false);
        txtEspRS.setText("dividir por (3);(366kcal;16g prot)");
        txtEspRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspRSActionPerformed(evt);
            }
        });

        bVoltarRS.setBackground(new java.awt.Color(255, 102, 102));
        bVoltarRS.setText("VOLTAR");
        bVoltarRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarRSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout receitaSLayout = new javax.swing.GroupLayout(receitaS.getContentPane());
        receitaS.getContentPane().setLayout(receitaSLayout);
        receitaSLayout.setHorizontalGroup(
            receitaSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receitaSLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bVoltarRS)
                .addGap(18, 18, 18))
            .addGroup(receitaSLayout.createSequentialGroup()
                .addGroup(receitaSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(receitaSLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(txtNomeRefRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(receitaSLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(txtEspRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(receitaSLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(scrollpaneRS, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        receitaSLayout.setVerticalGroup(
            receitaSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, receitaSLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txtNomeRefRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollpaneRS, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtEspRS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bVoltarRS)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        p2d.setTitle("ESCOLHA");
        p2d.setMinimumSize(new java.awt.Dimension(400, 190));
        p2d.setResizable(false);

        bNovaDP2d.setText("NOVA");
        bNovaDP2d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovaDP2dActionPerformed(evt);
            }
        });

        bEditarDP2d.setText("EDITAR");
        bEditarDP2d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarDP2dActionPerformed(evt);
            }
        });

        jLabel23.setText("NOVA DIETA ou EDITAR DIETA?");

        bVoltarP2d.setBackground(new java.awt.Color(255, 102, 102));
        bVoltarP2d.setText("VOLTAR");
        bVoltarP2d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarP2dActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p2dLayout = new javax.swing.GroupLayout(p2d.getContentPane());
        p2d.getContentPane().setLayout(p2dLayout);
        p2dLayout.setHorizontalGroup(
            p2dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p2dLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(p2dLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(bNovaDP2d)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bEditarDP2d)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p2dLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bVoltarP2d)
                .addGap(24, 24, 24))
        );
        p2dLayout.setVerticalGroup(
            p2dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p2dLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p2dLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNovaDP2d)
                    .addComponent(bEditarDP2d))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(bVoltarP2d)
                .addContainerGap())
        );

        p3.setMinimumSize(new java.awt.Dimension(861, 451));
        p3.setResizable(false);

        bDivSegP3.setText("nova divisao[]");
        bDivSegP3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bDivSegP3MouseClicked(evt);
            }
        });
        bDivSegP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDivSegP3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSegundaP3Layout = new javax.swing.GroupLayout(panelSegundaP3);
        panelSegundaP3.setLayout(panelSegundaP3Layout);
        panelSegundaP3Layout.setHorizontalGroup(
            panelSegundaP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSegundaP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bDivSegP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSegundaP3Layout.setVerticalGroup(
            panelSegundaP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSegundaP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bDivSegP3, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        bDivTerP3.setText("nova divisao[]");
        bDivTerP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDivTerP3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTercaP3Layout = new javax.swing.GroupLayout(panelTercaP3);
        panelTercaP3.setLayout(panelTercaP3Layout);
        panelTercaP3Layout.setHorizontalGroup(
            panelTercaP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTercaP3Layout.createSequentialGroup()
                .addComponent(bDivTerP3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTercaP3Layout.setVerticalGroup(
            panelTercaP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTercaP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bDivTerP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bDivQuaP3.setText("nova divisao[]");
        bDivQuaP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDivQuaP3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelQuartaP3Layout = new javax.swing.GroupLayout(panelQuartaP3);
        panelQuartaP3.setLayout(panelQuartaP3Layout);
        panelQuartaP3Layout.setHorizontalGroup(
            panelQuartaP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuartaP3Layout.createSequentialGroup()
                .addComponent(bDivQuaP3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelQuartaP3Layout.setVerticalGroup(
            panelQuartaP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuartaP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bDivQuaP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bDivQuiP3.setText("nova divisao[]");
        bDivQuiP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDivQuiP3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelQuintaP3Layout = new javax.swing.GroupLayout(panelQuintaP3);
        panelQuintaP3.setLayout(panelQuintaP3Layout);
        panelQuintaP3Layout.setHorizontalGroup(
            panelQuintaP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuintaP3Layout.createSequentialGroup()
                .addComponent(bDivQuiP3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelQuintaP3Layout.setVerticalGroup(
            panelQuintaP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuintaP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bDivQuiP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bDivSexP3.setText("nova divisao[]");
        bDivSexP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDivSexP3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSextaP3Layout = new javax.swing.GroupLayout(panelSextaP3);
        panelSextaP3.setLayout(panelSextaP3Layout);
        panelSextaP3Layout.setHorizontalGroup(
            panelSextaP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSextaP3Layout.createSequentialGroup()
                .addComponent(bDivSexP3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelSextaP3Layout.setVerticalGroup(
            panelSextaP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSextaP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bDivSexP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bDivSabP3.setText("nova divisao[]");
        bDivSabP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDivSabP3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSabadoP3Layout = new javax.swing.GroupLayout(panelSabadoP3);
        panelSabadoP3.setLayout(panelSabadoP3Layout);
        panelSabadoP3Layout.setHorizontalGroup(
            panelSabadoP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSabadoP3Layout.createSequentialGroup()
                .addComponent(bDivSabP3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelSabadoP3Layout.setVerticalGroup(
            panelSabadoP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSabadoP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bDivSabP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bDivDomP3.setText("nova divisao[]");
        bDivDomP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDivDomP3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDomingoP3Layout = new javax.swing.GroupLayout(panelDomingoP3);
        panelDomingoP3.setLayout(panelDomingoP3Layout);
        panelDomingoP3Layout.setHorizontalGroup(
            panelDomingoP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDomingoP3Layout.createSequentialGroup()
                .addComponent(bDivDomP3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelDomingoP3Layout.setVerticalGroup(
            panelDomingoP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDomingoP3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bDivDomP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bAvancarP3.setBackground(new java.awt.Color(153, 255, 153));
        bAvancarP3.setText("AVANCAR");
        bAvancarP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAvancarP3ActionPerformed(evt);
            }
        });

        bVoltarP3.setBackground(new java.awt.Color(255, 102, 102));
        bVoltarP3.setText("VOLTAR");
        bVoltarP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarP3ActionPerformed(evt);
            }
        });

        jLabel27.setText("SEGUNDA");

        jLabel28.setText("TERCA");

        jLabel29.setText("QUARTA");

        jLabel30.setText("QUINTA");

        jLabel31.setText("SEXTA");

        jLabel32.setText("SABADO");

        jLabel33.setText("DOMINGO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAvancarP3)
                        .addGap(48, 48, 48)
                        .addComponent(bVoltarP3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(panelSegundaP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTercaP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelQuartaP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelQuintaP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelSextaP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelSabadoP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDomingoP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 82, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel27)
                .addGap(70, 70, 70)
                .addComponent(jLabel28)
                .addGap(64, 64, 64)
                .addComponent(jLabel29)
                .addGap(71, 71, 71)
                .addComponent(jLabel30)
                .addGap(65, 65, 65)
                .addComponent(jLabel31)
                .addGap(66, 66, 66)
                .addComponent(jLabel32)
                .addGap(68, 68, 68)
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSegundaP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTercaP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelQuartaP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelQuintaP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSextaP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSabadoP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDomingoP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAvancarP3)
                    .addComponent(bVoltarP3))
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("DEFINA NUMERO DE DIVISOES EM CADA DIA DA SEMANA");

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3.getContentPane());
        p3.getContentPane().setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        p4.setMinimumSize(new java.awt.Dimension(758, 513));
        p4.setResizable(false);

        jLabel21.setText("dieta de:");

        txtNUP4.setText("nome usuario");

        panelDomingoP4.setMaximumSize(new java.awt.Dimension(100, 314));
        panelDomingoP4.setMinimumSize(new java.awt.Dimension(100, 314));

        jLabel19.setText("domingo");

        bdD5P4.setText("jButton3");
        bdD5P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdD5P4ActionPerformed(evt);
            }
        });

        bdD6P4.setText("jButton3");
        bdD6P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdD6P4ActionPerformed(evt);
            }
        });

        bdD10P4.setText("jButton3");
        bdD10P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdD10P4ActionPerformed(evt);
            }
        });

        bdD7P4.setText("jButton3");
        bdD7P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdD7P4ActionPerformed(evt);
            }
        });

        bdD1P4.setText("jButton3");
        bdD1P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdD1P4ActionPerformed(evt);
            }
        });

        bdD8P4.setText("jButton3");
        bdD8P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdD8P4ActionPerformed(evt);
            }
        });

        bdD4P4.setText("jButton3");
        bdD4P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdD4P4ActionPerformed(evt);
            }
        });

        bdD2P4.setText("jButton3");
        bdD2P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdD2P4ActionPerformed(evt);
            }
        });

        bdD3P4.setText("jButton3");
        bdD3P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdD3P4ActionPerformed(evt);
            }
        });

        bdD9P4.setText("jButton3");
        bdD9P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdD9P4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDomingoP4Layout = new javax.swing.GroupLayout(panelDomingoP4);
        panelDomingoP4.setLayout(panelDomingoP4Layout);
        panelDomingoP4Layout.setHorizontalGroup(
            panelDomingoP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDomingoP4Layout.createSequentialGroup()
                .addGroup(panelDomingoP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDomingoP4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel19))
                    .addGroup(panelDomingoP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDomingoP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bdD1P4)
                            .addComponent(bdD2P4)
                            .addComponent(bdD3P4)
                            .addComponent(bdD4P4)
                            .addComponent(bdD5P4)
                            .addComponent(bdD6P4)
                            .addComponent(bdD7P4)
                            .addComponent(bdD8P4)
                            .addComponent(bdD9P4)
                            .addComponent(bdD10P4))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelDomingoP4Layout.setVerticalGroup(
            panelDomingoP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDomingoP4Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdD1P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdD2P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdD3P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdD4P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdD5P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdD6P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdD7P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdD8P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdD9P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdD10P4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bVoltarP4.setBackground(new java.awt.Color(255, 102, 102));
        bVoltarP4.setText("VOLTAR");
        bVoltarP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarP4ActionPerformed(evt);
            }
        });

        bEditarP4.setText("EDITAR");
        bEditarP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarP4ActionPerformed(evt);
            }
        });

        panelQuartaP4.setMaximumSize(new java.awt.Dimension(100, 314));
        panelQuartaP4.setMinimumSize(new java.awt.Dimension(100, 314));

        jLabel5.setText("quarta");

        bdQ9P4.setText("jButton3");
        bdQ9P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQ9P4ActionPerformed(evt);
            }
        });

        bdQ8P4.setText("jButton3");
        bdQ8P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQ8P4ActionPerformed(evt);
            }
        });

        bdQ7P4.setText("jButton3");
        bdQ7P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQ7P4ActionPerformed(evt);
            }
        });

        bdQ3P4.setText("jButton3");
        bdQ3P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQ3P4ActionPerformed(evt);
            }
        });

        bdQ2P4.setText("jButton3");
        bdQ2P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQ2P4ActionPerformed(evt);
            }
        });

        bdQ6P4.setText("jButton3");
        bdQ6P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQ6P4ActionPerformed(evt);
            }
        });

        bdQ1P4.setText("jButton3");
        bdQ1P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQ1P4ActionPerformed(evt);
            }
        });

        bdQ5P4.setText("jButton3");
        bdQ5P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQ5P4ActionPerformed(evt);
            }
        });

        bdQ10P4.setText("jButton3");
        bdQ10P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQ10P4ActionPerformed(evt);
            }
        });

        bdQ4P4.setText("jButton3");
        bdQ4P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQ4P4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelQuartaP4Layout = new javax.swing.GroupLayout(panelQuartaP4);
        panelQuartaP4.setLayout(panelQuartaP4Layout);
        panelQuartaP4Layout.setHorizontalGroup(
            panelQuartaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuartaP4Layout.createSequentialGroup()
                .addGroup(panelQuartaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelQuartaP4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5))
                    .addGroup(panelQuartaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelQuartaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bdQ1P4)
                            .addComponent(bdQ2P4)
                            .addComponent(bdQ3P4)
                            .addComponent(bdQ4P4)
                            .addComponent(bdQ5P4)
                            .addComponent(bdQ6P4)
                            .addComponent(bdQ7P4)
                            .addComponent(bdQ8P4)
                            .addComponent(bdQ9P4)
                            .addComponent(bdQ10P4))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelQuartaP4Layout.setVerticalGroup(
            panelQuartaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuartaP4Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQ1P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQ2P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQ3P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQ4P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQ5P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQ6P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQ7P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQ8P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQ9P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQ10P4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSegundaP4.setMaximumSize(new java.awt.Dimension(100, 314));
        panelSegundaP4.setMinimumSize(new java.awt.Dimension(100, 314));

        jLabel6.setText("segunda");

        bdS1P4.setText("jButton1");
        bdS1P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdS1P4ActionPerformed(evt);
            }
        });

        bdS2P4.setText("jButton2");
        bdS2P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdS2P4ActionPerformed(evt);
            }
        });

        bdS3P4.setText("jButton3");
        bdS3P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdS3P4ActionPerformed(evt);
            }
        });

        bdS4P4.setText("jButton3");
        bdS4P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdS4P4ActionPerformed(evt);
            }
        });

        bdS5P4.setText("jButton3");
        bdS5P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdS5P4ActionPerformed(evt);
            }
        });

        bdS6P4.setText("jButton3");
        bdS6P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdS6P4ActionPerformed(evt);
            }
        });

        bdS7P4.setText("jButton3");
        bdS7P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdS7P4ActionPerformed(evt);
            }
        });

        bdS8P4.setText("jButton3");
        bdS8P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdS8P4ActionPerformed(evt);
            }
        });

        bdS9P4.setText("jButton3");
        bdS9P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdS9P4ActionPerformed(evt);
            }
        });

        bdS10P4.setText("jButton3");
        bdS10P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdS10P4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSegundaP4Layout = new javax.swing.GroupLayout(panelSegundaP4);
        panelSegundaP4.setLayout(panelSegundaP4Layout);
        panelSegundaP4Layout.setHorizontalGroup(
            panelSegundaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSegundaP4Layout.createSequentialGroup()
                .addGroup(panelSegundaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6))
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdS1P4))
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdS2P4))
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdS3P4))
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdS4P4))
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdS5P4))
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdS6P4))
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdS7P4))
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdS8P4))
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdS9P4))
                    .addGroup(panelSegundaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdS10P4)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelSegundaP4Layout.setVerticalGroup(
            panelSegundaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSegundaP4Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdS1P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdS2P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdS3P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdS4P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdS5P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdS6P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdS7P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdS8P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdS9P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdS10P4)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        panelTercaP4.setMaximumSize(new java.awt.Dimension(100, 314));
        panelTercaP4.setMinimumSize(new java.awt.Dimension(100, 314));

        jLabel20.setText("terca");
        jLabel20.setFocusable(false);
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        bdT1P4.setText("jButton3");
        bdT1P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdT1P4ActionPerformed(evt);
            }
        });

        bdT2P4.setText("jButton3");
        bdT2P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdT2P4ActionPerformed(evt);
            }
        });

        bdT3P4.setText("jButton3");
        bdT3P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdT3P4ActionPerformed(evt);
            }
        });

        bdT4P4.setText("jButton3");
        bdT4P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdT4P4ActionPerformed(evt);
            }
        });

        bdT5P4.setText("jButton3");
        bdT5P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdT5P4ActionPerformed(evt);
            }
        });

        bdT6P4.setText("jButton3");
        bdT6P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdT6P4ActionPerformed(evt);
            }
        });

        bdT7P4.setText("jButton3");
        bdT7P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdT7P4ActionPerformed(evt);
            }
        });

        bdT8P4.setText("jButton3");
        bdT8P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdT8P4ActionPerformed(evt);
            }
        });

        bdT9P4.setText("jButton3");
        bdT9P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdT9P4ActionPerformed(evt);
            }
        });

        bdT10P4.setText("jButton3");
        bdT10P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdT10P4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTercaP4Layout = new javax.swing.GroupLayout(panelTercaP4);
        panelTercaP4.setLayout(panelTercaP4Layout);
        panelTercaP4Layout.setHorizontalGroup(
            panelTercaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTercaP4Layout.createSequentialGroup()
                .addGroup(panelTercaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdT1P4))
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdT2P4))
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdT3P4))
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdT4P4))
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdT5P4))
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdT6P4))
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdT7P4))
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdT8P4))
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdT9P4))
                    .addGroup(panelTercaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bdT10P4)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelTercaP4Layout.setVerticalGroup(
            panelTercaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTercaP4Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdT1P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdT2P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdT3P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdT4P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdT5P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdT6P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdT7P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdT8P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdT9P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdT10P4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelQuintaP4.setMaximumSize(new java.awt.Dimension(100, 314));
        panelQuintaP4.setMinimumSize(new java.awt.Dimension(100, 314));

        jLabel22.setText("quinta");

        bdQu9P4.setText("jButton3");
        bdQu9P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQu9P4ActionPerformed(evt);
            }
        });

        bdQu1P4.setText("jButton3");
        bdQu1P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQu1P4ActionPerformed(evt);
            }
        });

        bdQu5P4.setText("jButton3");
        bdQu5P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQu5P4ActionPerformed(evt);
            }
        });

        bdQu6P4.setText("jButton3");
        bdQu6P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQu6P4ActionPerformed(evt);
            }
        });

        bdQu7P4.setText("jButton3");
        bdQu7P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQu7P4ActionPerformed(evt);
            }
        });

        bdQu3P4.setText("jButton3");
        bdQu3P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQu3P4ActionPerformed(evt);
            }
        });

        bdQu8P4.setText("jButton3");
        bdQu8P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQu8P4ActionPerformed(evt);
            }
        });

        bdQu10P4.setText("jButton3");
        bdQu10P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQu10P4ActionPerformed(evt);
            }
        });

        bdQu2P4.setText("jButton3");
        bdQu2P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQu2P4ActionPerformed(evt);
            }
        });

        bdQu4P4.setText("jButton3");
        bdQu4P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdQu4P4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelQuintaP4Layout = new javax.swing.GroupLayout(panelQuintaP4);
        panelQuintaP4.setLayout(panelQuintaP4Layout);
        panelQuintaP4Layout.setHorizontalGroup(
            panelQuintaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuintaP4Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(32, 32, 32))
            .addGroup(panelQuintaP4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelQuintaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bdQu1P4)
                    .addComponent(bdQu2P4)
                    .addComponent(bdQu3P4)
                    .addComponent(bdQu4P4)
                    .addComponent(bdQu5P4)
                    .addComponent(bdQu6P4)
                    .addComponent(bdQu7P4)
                    .addComponent(bdQu8P4)
                    .addComponent(bdQu9P4)
                    .addComponent(bdQu10P4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelQuintaP4Layout.setVerticalGroup(
            panelQuintaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuintaP4Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQu1P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQu2P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQu3P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQu4P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQu5P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQu6P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQu7P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQu8P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQu9P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdQu10P4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSabadoP4.setMaximumSize(new java.awt.Dimension(100, 314));
        panelSabadoP4.setMinimumSize(new java.awt.Dimension(100, 314));

        jLabel24.setText("sabado");

        bdSa2P4.setText("jButton3");
        bdSa2P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSa2P4ActionPerformed(evt);
            }
        });

        bdSa5P4.setText("jButton3");
        bdSa5P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSa5P4ActionPerformed(evt);
            }
        });

        bdSa10P4.setText("jButton3");
        bdSa10P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSa10P4ActionPerformed(evt);
            }
        });

        bdSa4P4.setText("jButton3");
        bdSa4P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSa4P4ActionPerformed(evt);
            }
        });

        bdSa1P4.setText("jButton3");
        bdSa1P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSa1P4ActionPerformed(evt);
            }
        });

        bdSa6P4.setText("jButton3");
        bdSa6P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSa6P4ActionPerformed(evt);
            }
        });

        bdSa3P4.setText("jButton3");
        bdSa3P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSa3P4ActionPerformed(evt);
            }
        });

        bdSa8P4.setText("jButton3");
        bdSa8P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSa8P4ActionPerformed(evt);
            }
        });

        bdSa7P4.setText("jButton3");
        bdSa7P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSa7P4ActionPerformed(evt);
            }
        });

        bdSa9P4.setText("jButton3");
        bdSa9P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSa9P4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSabadoP4Layout = new javax.swing.GroupLayout(panelSabadoP4);
        panelSabadoP4.setLayout(panelSabadoP4Layout);
        panelSabadoP4Layout.setHorizontalGroup(
            panelSabadoP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSabadoP4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(30, 30, 30))
            .addGroup(panelSabadoP4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSabadoP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bdSa1P4)
                    .addComponent(bdSa2P4)
                    .addComponent(bdSa3P4)
                    .addComponent(bdSa4P4)
                    .addComponent(bdSa5P4)
                    .addComponent(bdSa6P4)
                    .addComponent(bdSa7P4)
                    .addComponent(bdSa8P4)
                    .addComponent(bdSa9P4)
                    .addComponent(bdSa10P4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSabadoP4Layout.setVerticalGroup(
            panelSabadoP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSabadoP4Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSa1P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSa2P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSa3P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSa4P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSa5P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSa6P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSa7P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSa8P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSa9P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSa10P4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelSextaP4.setMaximumSize(new java.awt.Dimension(100, 314));
        panelSextaP4.setMinimumSize(new java.awt.Dimension(100, 314));

        jLabel25.setText("sexta");

        bdSe2P4.setText("jButton3");
        bdSe2P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSe2P4ActionPerformed(evt);
            }
        });

        bdSe10P4.setText("jButton3");
        bdSe10P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSe10P4ActionPerformed(evt);
            }
        });

        bdSe9P4.setText("jButton3");
        bdSe9P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSe9P4ActionPerformed(evt);
            }
        });

        bdSe1P4.setText("jButton3");
        bdSe1P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSe1P4ActionPerformed(evt);
            }
        });

        bdSe7P4.setText("jButton3");
        bdSe7P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSe7P4ActionPerformed(evt);
            }
        });

        bdSe5P4.setText("jButton3");
        bdSe5P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSe5P4ActionPerformed(evt);
            }
        });

        bdSe3P4.setText("jButton3");
        bdSe3P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSe3P4ActionPerformed(evt);
            }
        });

        bdSe6P4.setText("jButton3");
        bdSe6P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSe6P4ActionPerformed(evt);
            }
        });

        bdSe8P4.setText("jButton3");
        bdSe8P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSe8P4ActionPerformed(evt);
            }
        });

        bdSe4P4.setText("jButton3");
        bdSe4P4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdSe4P4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSextaP4Layout = new javax.swing.GroupLayout(panelSextaP4);
        panelSextaP4.setLayout(panelSextaP4Layout);
        panelSextaP4Layout.setHorizontalGroup(
            panelSextaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSextaP4Layout.createSequentialGroup()
                .addGroup(panelSextaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSextaP4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel25))
                    .addGroup(panelSextaP4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelSextaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bdSe1P4)
                            .addComponent(bdSe2P4)
                            .addComponent(bdSe3P4)
                            .addComponent(bdSe4P4)
                            .addComponent(bdSe5P4)
                            .addComponent(bdSe6P4)
                            .addComponent(bdSe7P4)
                            .addComponent(bdSe8P4)
                            .addComponent(bdSe9P4)
                            .addComponent(bdSe10P4))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelSextaP4Layout.setVerticalGroup(
            panelSextaP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSextaP4Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSe1P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSe2P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSe3P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSe4P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSe5P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSe6P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSe7P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSe8P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSe9P4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bdSe10P4)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout p4Layout = new javax.swing.GroupLayout(p4.getContentPane());
        p4.getContentPane().setLayout(p4Layout);
        p4Layout.setHorizontalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p4Layout.createSequentialGroup()
                .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(p4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bEditarP4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bVoltarP4))
                    .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, p4Layout.createSequentialGroup()
                            .addGap(256, 256, 256)
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNUP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(panelSegundaP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panelTercaP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panelQuartaP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panelQuintaP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panelSextaP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panelSabadoP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panelDomingoP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        p4Layout.setVerticalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p4Layout.createSequentialGroup()
                .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtNUP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelDomingoP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSabadoP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSextaP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelQuintaP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelQuartaP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTercaP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSegundaP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bVoltarP4)
                    .addComponent(bEditarP4))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        p5.setMaximumSize(new java.awt.Dimension(961, 538));
        p5.setMinimumSize(new java.awt.Dimension(961, 538));
        p5.setResizable(false);

        btESegP5.setText("EDITAR SEGUNDA");
        btESegP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btESegP5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSegundaP5Layout = new javax.swing.GroupLayout(panelSegundaP5);
        panelSegundaP5.setLayout(panelSegundaP5Layout);
        panelSegundaP5Layout.setHorizontalGroup(
            panelSegundaP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSegundaP5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btESegP5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSegundaP5Layout.setVerticalGroup(
            panelSegundaP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSegundaP5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btESegP5, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        btETerP5.setText("EDITAR TERCA");
        btETerP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btETerP5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTercaP5Layout = new javax.swing.GroupLayout(panelTercaP5);
        panelTercaP5.setLayout(panelTercaP5Layout);
        panelTercaP5Layout.setHorizontalGroup(
            panelTercaP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTercaP5Layout.createSequentialGroup()
                .addComponent(btETerP5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTercaP5Layout.setVerticalGroup(
            panelTercaP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTercaP5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btETerP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btEQuarP5.setText("EDITAR QUARTA");
        btEQuarP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEQuarP5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelQuartaP5Layout = new javax.swing.GroupLayout(panelQuartaP5);
        panelQuartaP5.setLayout(panelQuartaP5Layout);
        panelQuartaP5Layout.setHorizontalGroup(
            panelQuartaP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuartaP5Layout.createSequentialGroup()
                .addComponent(btEQuarP5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelQuartaP5Layout.setVerticalGroup(
            panelQuartaP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuartaP5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEQuarP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btEQuiP5.setText("EDITAR QUINTA");
        btEQuiP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEQuiP5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelQuintaP5Layout = new javax.swing.GroupLayout(panelQuintaP5);
        panelQuintaP5.setLayout(panelQuintaP5Layout);
        panelQuintaP5Layout.setHorizontalGroup(
            panelQuintaP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelQuintaP5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEQuiP5)
                .addContainerGap())
        );
        panelQuintaP5Layout.setVerticalGroup(
            panelQuintaP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelQuintaP5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEQuiP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btESexP5.setText("EDITAR SEXTA");
        btESexP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btESexP5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSextaP5Layout = new javax.swing.GroupLayout(panelSextaP5);
        panelSextaP5.setLayout(panelSextaP5Layout);
        panelSextaP5Layout.setHorizontalGroup(
            panelSextaP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSextaP5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btESexP5))
        );
        panelSextaP5Layout.setVerticalGroup(
            panelSextaP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSextaP5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btESexP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btESabP5.setText("EDITAR SABADO");
        btESabP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btESabP5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSabadoP5Layout = new javax.swing.GroupLayout(panelSabadoP5);
        panelSabadoP5.setLayout(panelSabadoP5Layout);
        panelSabadoP5Layout.setHorizontalGroup(
            panelSabadoP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSabadoP5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btESabP5)
                .addContainerGap())
        );
        panelSabadoP5Layout.setVerticalGroup(
            panelSabadoP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSabadoP5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btESabP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btEDomP5.setText("EDITAR DOMINGO");
        btEDomP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEDomP5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDomingoP5Layout = new javax.swing.GroupLayout(panelDomingoP5);
        panelDomingoP5.setLayout(panelDomingoP5Layout);
        panelDomingoP5Layout.setHorizontalGroup(
            panelDomingoP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDomingoP5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEDomP5)
                .addContainerGap())
        );
        panelDomingoP5Layout.setVerticalGroup(
            panelDomingoP5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDomingoP5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btEDomP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        bAvancarP5.setBackground(new java.awt.Color(153, 255, 153));
        bAvancarP5.setText("AVANCAR");
        bAvancarP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAvancarP5ActionPerformed(evt);
            }
        });

        bVoltarP5.setBackground(new java.awt.Color(255, 102, 102));
        bVoltarP5.setText("VOLTAR");
        bVoltarP5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarP5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAvancarP5)
                        .addGap(48, 48, 48)
                        .addComponent(bVoltarP5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(panelSegundaP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTercaP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelQuartaP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelQuintaP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelSextaP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelSabadoP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelDomingoP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSegundaP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTercaP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelQuartaP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelQuintaP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSextaP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSabadoP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDomingoP5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAvancarP5)
                    .addComponent(bVoltarP5))
                .addContainerGap())
        );

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setText("ESCOLHA DIA DA SEMANA");

        javax.swing.GroupLayout p5Layout = new javax.swing.GroupLayout(p5.getContentPane());
        p5.getContentPane().setLayout(p5Layout);
        p5Layout.setHorizontalGroup(
            p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p5Layout.createSequentialGroup()
                .addGroup(p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p5Layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        p5Layout.setVerticalGroup(
            p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(4, 4, 4)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        p6.setMaximumSize(new java.awt.Dimension(293, 450));
        p6.setMinimumSize(new java.awt.Dimension(293, 450));
        p6.setResizable(false);

        panelBotoesP6.setMaximumSize(new java.awt.Dimension(153, 316));
        panelBotoesP6.setMinimumSize(new java.awt.Dimension(153, 316));

        bd2P6.setText("div 2");
        bd2P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bd2P6ActionPerformed(evt);
            }
        });

        bd3P6.setText("div 3");
        bd3P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bd3P6ActionPerformed(evt);
            }
        });

        bd1P6.setText("div 1");
        bd1P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bd1P6ActionPerformed(evt);
            }
        });

        bd4P6.setText("div 4");
        bd4P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bd4P6ActionPerformed(evt);
            }
        });

        bd5P6.setText("div 5");
        bd5P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bd5P6ActionPerformed(evt);
            }
        });

        bd6P6.setText("div 6");
        bd6P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bd6P6ActionPerformed(evt);
            }
        });

        bd7P6.setText("div 7");
        bd7P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bd7P6ActionPerformed(evt);
            }
        });

        bd8P6.setText("div 8");
        bd8P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bd8P6ActionPerformed(evt);
            }
        });

        bd9P6.setText("div 9");
        bd9P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bd9P6ActionPerformed(evt);
            }
        });

        bd10P6.setText("div 10");
        bd10P6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bd10P6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesP6Layout = new javax.swing.GroupLayout(panelBotoesP6);
        panelBotoesP6.setLayout(panelBotoesP6Layout);
        panelBotoesP6Layout.setHorizontalGroup(
            panelBotoesP6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesP6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoesP6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bd2P6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(bd3P6, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(bd1P6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(bd4P6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(bd5P6, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(bd6P6, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(bd7P6, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(bd8P6, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(bd9P6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(bd10P6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBotoesP6Layout.setVerticalGroup(
            panelBotoesP6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesP6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bd1P6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd2P6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd3P6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd4P6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd5P6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd6P6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd7P6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd8P6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd9P6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd10P6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        diaSemanaP6.setText("SEGUNDA-FEIRA");

        bSalvarP6.setBackground(new java.awt.Color(153, 255, 153));
        bSalvarP6.setText("SALVAR");
        bSalvarP6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarP6ActionPerformed(evt);
            }
        });

        bVoltarP6.setBackground(new java.awt.Color(255, 102, 102));
        bVoltarP6.setText("VOLTAR");
        bVoltarP6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarP6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p6Layout = new javax.swing.GroupLayout(p6.getContentPane());
        p6.getContentPane().setLayout(p6Layout);
        p6Layout.setHorizontalGroup(
            p6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p6Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(p6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bSalvarP6)
                    .addGroup(p6Layout.createSequentialGroup()
                        .addComponent(diaSemanaP6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bVoltarP6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBotoesP6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        p6Layout.setVerticalGroup(
            p6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p6Layout.createSequentialGroup()
                .addComponent(diaSemanaP6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotoesP6, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(p6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalvarP6)
                    .addComponent(bVoltarP6))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pr1.setMaximumSize(new java.awt.Dimension(546, 321));
        pr1.setMinimumSize(new java.awt.Dimension(546, 321));
        pr1.setPreferredSize(new java.awt.Dimension(546, 321));
        pr1.setResizable(false);

        scrollPr1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPr1.setToolTipText("");

        lListaComidasPr1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lListaComidasPr1ValueChanged(evt);
            }
        });
        scrollPr1.setViewportView(lListaComidasPr1);

        bRLPr1.setText("REF. LEVES");

        bRMPr1.setText("REF. PESO MED.");

        bRPPr1.setText("REF. PESADAS");

        bPesqPr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dplan/download.png"))); // NOI18N
        bPesqPr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesqPr1ActionPerformed(evt);
            }
        });

        bSalvarPr1.setBackground(new java.awt.Color(153, 255, 153));
        bSalvarPr1.setText("SALVAR");
        bSalvarPr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarPr1ActionPerformed(evt);
            }
        });

        bCancelarPr1.setBackground(new java.awt.Color(255, 102, 102));
        bCancelarPr1.setText("CANCELAR");
        bCancelarPr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarPr1ActionPerformed(evt);
            }
        });

        jButton10.setText("visualizar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pr1Layout = new javax.swing.GroupLayout(pr1.getContentPane());
        pr1.getContentPane().setLayout(pr1Layout);
        pr1Layout.setHorizontalGroup(
            pr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pr1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bRLPr1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRMPr1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bRPPr1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pr1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pr1Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                        .addGap(139, 139, 139)
                        .addComponent(bSalvarPr1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelarPr1)
                        .addGap(18, 18, 18))
                    .addGroup(pr1Layout.createSequentialGroup()
                        .addComponent(txtPesquisaIngPr1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPesqPr1)
                        .addGap(75, 75, 75))
                    .addGroup(pr1Layout.createSequentialGroup()
                        .addComponent(scrollPr1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pr1Layout.setVerticalGroup(
            pr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pr1Layout.createSequentialGroup()
                .addGroup(pr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRLPr1)
                    .addComponent(bRMPr1)
                    .addComponent(bRPPr1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bPesqPr1)
                    .addComponent(txtPesquisaIngPr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPr1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pr1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(bSalvarPr1)
                    .addComponent(bCancelarPr1))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pRecADD.setMinimumSize(new java.awt.Dimension(500, 360));
        pRecADD.setResizable(false);

        txtCORPOTEXTOPRecADD.setColumns(20);
        txtCORPOTEXTOPRecADD.setRows(5);
        jScrollPane1.setViewportView(txtCORPOTEXTOPRecADD);

        jLabel8.setText("RECEITA:");

        bSalvarPRecADD.setBackground(new java.awt.Color(153, 255, 153));
        bSalvarPRecADD.setText("SALVAR");
        bSalvarPRecADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalvarPRecADDActionPerformed(evt);
            }
        });

        bVoltarPRecADD.setBackground(new java.awt.Color(255, 153, 153));
        bVoltarPRecADD.setText("VOLTAR");
        bVoltarPRecADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarPRecADDActionPerformed(evt);
            }
        });

        jLabel9.setText("ID");

        bPesoLevePRecADD.setText("PESO LEVE");
        bPesoLevePRecADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesoLevePRecADDActionPerformed(evt);
            }
        });

        bPesoMedPRecADD.setText("PESO MED");
        bPesoMedPRecADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesoMedPRecADDActionPerformed(evt);
            }
        });

        bPesoGranPRecADD.setText("PESO GRAN");
        bPesoGranPRecADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesoGranPRecADDActionPerformed(evt);
            }
        });

        bConsultaRecPRecADD.setText("CONSULTA");
        bConsultaRecPRecADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultaRecPRecADDActionPerformed(evt);
            }
        });

        bExcluirRecPRecADD.setText("EXCLUIR");
        bExcluirRecPRecADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirRecPRecADDActionPerformed(evt);
            }
        });

        bAtualizarRecPRecADD.setText("ATUALIZAR");
        bAtualizarRecPRecADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtualizarRecPRecADDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pRecADDLayout = new javax.swing.GroupLayout(pRecADD.getContentPane());
        pRecADD.getContentPane().setLayout(pRecADDLayout);
        pRecADDLayout.setHorizontalGroup(
            pRecADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRecADDLayout.createSequentialGroup()
                .addGroup(pRecADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pRecADDLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(pRecADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pRecADDLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRECEITAPRecADD, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pRecADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bPesoLevePRecADD)
                            .addComponent(bPesoMedPRecADD)
                            .addComponent(bPesoGranPRecADD)
                            .addComponent(txtMatRecPRecADD, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))
                    .addGroup(pRecADDLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAtualizarRecPRecADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSalvarPRecADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bConsultaRecPRecADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bExcluirRecPRecADD)
                        .addGap(3, 3, 3)
                        .addComponent(bVoltarPRecADD)))
                .addGap(13, 13, 13))
        );
        pRecADDLayout.setVerticalGroup(
            pRecADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRecADDLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(pRecADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMatRecPRecADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pRecADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRECEITAPRecADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pRecADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pRecADDLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pRecADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bSalvarPRecADD)
                            .addComponent(bVoltarPRecADD)
                            .addComponent(bConsultaRecPRecADD)
                            .addComponent(bExcluirRecPRecADD)
                            .addComponent(bAtualizarRecPRecADD)))
                    .addGroup(pRecADDLayout.createSequentialGroup()
                        .addComponent(bPesoLevePRecADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPesoMedPRecADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bPesoGranPRecADD)))
                .addGap(8, 8, 8))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(350, 250));
        setMinimumSize(new java.awt.Dimension(350, 250));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel16.setText("LOGIN");

        txtUserP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserP2ActionPerformed(evt);
            }
        });

        jLabel17.setText("usuário");

        jLabel18.setText("senha");

        bLogP2.setBackground(new java.awt.Color(153, 255, 153));
        bLogP2.setText("ENTRAR");
        bLogP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogP2ActionPerformed(evt);
            }
        });

        bCancelarP2.setBackground(new java.awt.Color(255, 102, 102));
        bCancelarP2.setText("FECHAR");
        bCancelarP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarP2ActionPerformed(evt);
            }
        });

        bCadastro.setText("CADASTRO");
        bCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastroActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dplan/logopl.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(bCadastro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bLogP2)
                                .addGap(18, 18, 18)
                                .addComponent(bCancelarP2))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtUserP2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSenhaP2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel16)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenhaP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLogP2)
                    .addComponent(bCancelarP2)
                    .addComponent(bCadastro))
                .addGap(45, 45, 45))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bRefeicao01P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefeicao01P2ActionPerformed
        // TODO add your handling code here:
        selecionada = bRefeicao01P2.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("divida porcoes por 3!");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
    }//GEN-LAST:event_bRefeicao01P2ActionPerformed

    private void bEditarCadP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarCadP2ActionPerformed
        // TODO add your handling code here:
        PC.setVisible(true);
    }//GEN-LAST:event_bEditarCadP2ActionPerformed

    private void bDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDietaActionPerformed
        
        p2d.setVisible(true);
    }//GEN-LAST:event_bDietaActionPerformed

    private void bSairP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairP2ActionPerformed
        // TODO add your handling code here:
        p2e.setVisible(true);
    }//GEN-LAST:event_bSairP2ActionPerformed

    private void bSalvarPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarPcActionPerformed
        // TODO add your handling code here:
        /*if(bEngordarPc1.isEnabled()){
            cliente.setMETA("EN");
        }
        if(bEmagrecerPc1.isEnabled()){
            cliente.setMETA("EM");
        }
        if(bGanhoMassPc1.isEnabled()){
            cliente.setMETA("GM");
        }
         */     
        cliente.setMAT(txtMatriculaPc.getText());
        cliente.setEMAIL(txtEmailPc.getText());
        cliente.setNOME(txtNomePc.getText());
        cliente.setSENHA(txtSenhaPc.getText());
        cliente.setIDADE(txtIdadePc.getText());
        cliente.setPESO(txtPesoPc.getText());
        
        
        
        try {
            clientedao.adicionar(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "ERRO DE SALVAMENTO", ex);
        }
        
        
    }//GEN-LAST:event_bSalvarPcActionPerformed

    private void bCancelarPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarPcActionPerformed
        // TODO add your handling code here:
        PC.setVisible(false);
    }//GEN-LAST:event_bCancelarPcActionPerformed

    private void bEngordarPc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEngordarPc1ActionPerformed
        // TODO add your handling code here:
        cliente.setMETA("EN");
    }//GEN-LAST:event_bEngordarPc1ActionPerformed

    private void bEmagrecerPc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEmagrecerPc1ActionPerformed
        // TODO add your handling code here:
        cliente.setMETA("EM");
    }//GEN-LAST:event_bEmagrecerPc1ActionPerformed

    private void bGanhoMassPc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGanhoMassPc1ActionPerformed
        // TODO add your handling code here:
        cliente.setMETA("GM");
    }//GEN-LAST:event_bGanhoMassPc1ActionPerformed

    private void bLogP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogP2ActionPerformed
         // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Log();
            
            }
         catch (Exception ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "ERRO DATA", ex);
        }
        if(txtUserP2.getText().equals(cliente.getNOME())) {
            if(txtSenhaP2.getText().equals(cliente.getSENHA()))
                 JOptionPane.showMessageDialog(rootPane, "LOGIN REALIZADO COM SUCESSO!");
                try {
                    ConsultaIng();
                ConsultaD();
                } catch (Exception ex) {
                Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
                }
                PanelAdminReceitasP2.setVisible(false);
                p2.setVisible(true);
                bLogP2.setEnabled(false);
                txtUserP2.setEditable(false);
                txtSenhaP2.setEditable(false);
                
                bCadastro.setEnabled(false);
                bCancelarP2.setEnabled(false);
                
                switch (dayOfWeek) {
  case MONDAY:
    txtDiaSemanaP2.setText("Segunda");
    SEG=dCliente.getSEG();
        String [] Sdiv = SEG.split(";");
        String ds1 = Sdiv[0];
        String ds2 = Sdiv[1];
        String ds3 = Sdiv[2];
        String ds4 = Sdiv[3];
        String ds5 = Sdiv[4];
        String ds6 = Sdiv[5];
        String ds7 = Sdiv[6];
        String ds8 = Sdiv[7];
        String ds9 = Sdiv[8];
        String ds10 = Sdiv[9];
    bRefeicao01P2.setText(ds1);
    bRefeicao02P2.setText(ds2);
    bRefeicao03P2.setText(ds3);
    bRefeicao04P2.setText(ds4);
    bRefeicao05P2.setText(ds5);
    bRefeicao06P2.setText(ds6);
    bRefeicao07P2.setText(ds7);
    bRefeicao08P2.setText(ds8);
    bRefeicao09P2.setText(ds9);
    bRefeicao10P2.setText(ds10);
    
    break;
  case TUESDAY:
    txtDiaSemanaP2.setText("Terca");
    TER=dCliente.getTER();
        String [] Tdiv = TER.split(";");
        String Ts1 = Tdiv[0];
        String Ts2 = Tdiv[1];
        String Ts3 = Tdiv[2];
        String Ts4 = Tdiv[3];
        String Ts5 = Tdiv[4];
        String Ts6 = Tdiv[5];
        String Ts7 = Tdiv[6];
        String Ts8 = Tdiv[7];
        String Ts9 = Tdiv[8];
        String Ts10 = Tdiv[9];
        bRefeicao01P2.setText(Ts1);
    bRefeicao02P2.setText(Ts2);
    bRefeicao03P2.setText(Ts3);
    bRefeicao04P2.setText(Ts4);
    bRefeicao05P2.setText(Ts5);
    bRefeicao06P2.setText(Ts6);
    bRefeicao07P2.setText(Ts7);
    bRefeicao08P2.setText(Ts8);
    bRefeicao09P2.setText(Ts9);
    bRefeicao10P2.setText(Ts10);
    break;
  case WEDNESDAY:
    txtDiaSemanaP2.setText("Quarta");
    QUAR=dCliente.getQUA();
        String [] Qdiv = QUAR.split(";");
        String Qs1 = Qdiv[0];
        String Qs2 = Qdiv[1];
        String Qs3 = Qdiv[2];
        String Qs4 = Qdiv[3];
        String Qs5 = Qdiv[4];
        String Qs6 = Qdiv[5];
        String Qs7 = Qdiv[6];
        String Qs8 = Qdiv[7];
        String Qs9 = Qdiv[8];
        String Qs10 = Qdiv[9];
        bRefeicao01P2.setText(Qs1);
        bRefeicao02P2.setText(Qs2);
        bRefeicao03P2.setText(Qs3);
        bRefeicao04P2.setText(Qs4);
        bRefeicao05P2.setText(Qs5);
        bRefeicao06P2.setText(Qs6);
        bRefeicao07P2.setText(Qs7);
        bRefeicao08P2.setText(Qs8);
        bRefeicao09P2.setText(Qs9);
        bRefeicao10P2.setText(Qs10);
        
    break;
  case THURSDAY:
    txtDiaSemanaP2.setText("Quinta");
    QUI=dCliente.getQUI();
        String [] Qudiv = QUI.split(";");
        String Qus1 = Qudiv[0];
        String Qus2 = Qudiv[1];
        String Qus3 = Qudiv[2];
        String Qus4 = Qudiv[3];
        String Qus5 = Qudiv[4];
        String Qus6 = Qudiv[5];
        String Qus7 = Qudiv[6];
        String Qus8 = Qudiv[7];
        String Qus9 = Qudiv[8];
        String Qus10 = Qudiv[9];
        bRefeicao01P2.setText(Qus1);
        bRefeicao02P2.setText(Qus2);
        bRefeicao03P2.setText(Qus3);
        bRefeicao04P2.setText(Qus4);
        bRefeicao05P2.setText(Qus5);
        bRefeicao06P2.setText(Qus6);
        bRefeicao07P2.setText(Qus7);
        bRefeicao08P2.setText(Qus8);
        bRefeicao09P2.setText(Qus9);
        bRefeicao10P2.setText(Qus10);
    break;
  case FRIDAY:
    txtDiaSemanaP2.setText("Sexta");
    SEX=dCliente.getSEX();
        String [] Sediv = SEX.split(";");
        String Ses1 = Sediv[0];
        String Ses2 = Sediv[1];
        String Ses3 = Sediv[2];
        String Ses4 = Sediv[3];
        String Ses5 = Sediv[4];
        String Ses6 = Sediv[5];
        String Ses7 = Sediv[6];
        String Ses8 = Sediv[7];
        String Ses9 = Sediv[8];
        String Ses10 = Sediv[9];
        bRefeicao01P2.setText(Ses1);
        bRefeicao02P2.setText(Ses2);
        bRefeicao03P2.setText(Ses3);
        bRefeicao04P2.setText(Ses4);
        bRefeicao05P2.setText(Ses5);
        bRefeicao06P2.setText(Ses6);
        bRefeicao07P2.setText(Ses7);
        bRefeicao08P2.setText(Ses8);
        bRefeicao09P2.setText(Ses9);
        bRefeicao10P2.setText(Ses10);
        
    break;
  case SATURDAY:
    txtDiaSemanaP2.setText("Sabado");
    SAB=dCliente.getSAB();
        String [] Sadiv = SAB.split(";");
        String Sas1 = Sadiv[0];
        String Sas2 = Sadiv[1];
        String Sas3 = Sadiv[2];
        String Sas4 = Sadiv[3];
        String Sas5 = Sadiv[4];
        String Sas6 = Sadiv[5];
        String Sas7 = Sadiv[6];
        String Sas8 = Sadiv[7];
        String Sas9 = Sadiv[8];
        String Sas10 = Sadiv[9];
        bRefeicao01P2.setText(Sas1);
        bRefeicao02P2.setText(Sas2);
        bRefeicao03P2.setText(Sas3);
        bRefeicao04P2.setText(Sas4);
        bRefeicao05P2.setText(Sas5);
        bRefeicao06P2.setText(Sas6);
        bRefeicao07P2.setText(Sas7);
        bRefeicao08P2.setText(Sas8);
        bRefeicao09P2.setText(Sas9);
        bRefeicao10P2.setText(Sas10);
    break;
  case SUNDAY:
      DOM=dCliente.getDOM();
        String [] Ddiv = DOM.split(";");
        String Ds1 = Ddiv[0];
        String Ds2 = Ddiv[1];
        String Ds3 = Ddiv[2];
        String Ds4 = Ddiv[3];
        String Ds5 = Ddiv[4];
        String Ds6 = Ddiv[5];
        String Ds7 = Ddiv[6];
        String Ds8 = Ddiv[7];
        String Ds9 = Ddiv[8];
        String Ds10 = Ddiv[9];
        bRefeicao01P2.setText(Ds1);
        bRefeicao02P2.setText(Ds2);
        bRefeicao03P2.setText(Ds3);
        bRefeicao04P2.setText(Ds4);
        bRefeicao05P2.setText(Ds5);
        bRefeicao06P2.setText(Ds6);
        bRefeicao07P2.setText(Ds7);
        bRefeicao08P2.setText(Ds8);
        bRefeicao09P2.setText(Ds9);
        bRefeicao10P2.setText(Ds10);
    txtDiaSemanaP2.setText("Domingo");
    break;
}
        
        }else if(txtUserP2.getText().equals(cliente.getEMAIL())){
            if(txtSenhaP2.getText().equals(cliente.getSENHA()))
                JOptionPane.showMessageDialog(rootPane, "LOGIN REALIZADO COM SUCESSO!");
                try {
                    ConsultaIng();
                    ConsultaD();
                } catch (Exception ex) {
                    Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
                }
                    PanelAdminReceitasP2.setVisible(false);
                    p2.setVisible(true);
                    bLogP2.setEnabled(false);
                    txtUserP2.setEditable(false);
                    txtSenhaP2.setEditable(false);
                
                    bCadastro.setEnabled(false);
                    bCancelarP2.setEnabled(false);
                    
                    switch (dayOfWeek) {
  case MONDAY:
    txtDiaSemanaP2.setText("Segunda");
    SEG=dCliente.getSEG();
        String [] Sdiv = SEG.split(";");
        String ds1 = Sdiv[0];
        String ds2 = Sdiv[1];
        String ds3 = Sdiv[2];
        String ds4 = Sdiv[3];
        String ds5 = Sdiv[4];
        String ds6 = Sdiv[5];
        String ds7 = Sdiv[6];
        String ds8 = Sdiv[7];
        String ds9 = Sdiv[8];
        String ds10 = Sdiv[9];
    bRefeicao01P2.setText(ds1);
    bRefeicao02P2.setText(ds2);
    bRefeicao03P2.setText(ds3);
    bRefeicao04P2.setText(ds4);
    bRefeicao05P2.setText(ds5);
    bRefeicao06P2.setText(ds6);
    bRefeicao07P2.setText(ds7);
    bRefeicao08P2.setText(ds8);
    bRefeicao09P2.setText(ds9);
    bRefeicao10P2.setText(ds10);
    
    break;
  case TUESDAY:
    txtDiaSemanaP2.setText("Terca");
    TER=dCliente.getTER();
        String [] Tdiv = TER.split(";");
        String Ts1 = Tdiv[0];
        String Ts2 = Tdiv[1];
        String Ts3 = Tdiv[2];
        String Ts4 = Tdiv[3];
        String Ts5 = Tdiv[4];
        String Ts6 = Tdiv[5];
        String Ts7 = Tdiv[6];
        String Ts8 = Tdiv[7];
        String Ts9 = Tdiv[8];
        String Ts10 = Tdiv[9];
        bRefeicao01P2.setText(Ts1);
    bRefeicao02P2.setText(Ts2);
    bRefeicao03P2.setText(Ts3);
    bRefeicao04P2.setText(Ts4);
    bRefeicao05P2.setText(Ts5);
    bRefeicao06P2.setText(Ts6);
    bRefeicao07P2.setText(Ts7);
    bRefeicao08P2.setText(Ts8);
    bRefeicao09P2.setText(Ts9);
    bRefeicao10P2.setText(Ts10);
    break;
  case WEDNESDAY:
    txtDiaSemanaP2.setText("Quarta");
    QUAR=dCliente.getQUA();
        String [] Qdiv = QUAR.split(";");
        String Qs1 = Qdiv[0];
        String Qs2 = Qdiv[1];
        String Qs3 = Qdiv[2];
        String Qs4 = Qdiv[3];
        String Qs5 = Qdiv[4];
        String Qs6 = Qdiv[5];
        String Qs7 = Qdiv[6];
        String Qs8 = Qdiv[7];
        String Qs9 = Qdiv[8];
        String Qs10 = Qdiv[9];
        bRefeicao01P2.setText(Qs1);
        bRefeicao02P2.setText(Qs2);
        bRefeicao03P2.setText(Qs3);
        bRefeicao04P2.setText(Qs4);
        bRefeicao05P2.setText(Qs5);
        bRefeicao06P2.setText(Qs6);
        bRefeicao07P2.setText(Qs7);
        bRefeicao08P2.setText(Qs8);
        bRefeicao09P2.setText(Qs9);
        bRefeicao10P2.setText(Qs10);
        
    break;
  case THURSDAY:
    txtDiaSemanaP2.setText("Quinta");
    QUI=dCliente.getQUI();
        String [] Qudiv = QUI.split(";");
        String Qus1 = Qudiv[0];
        String Qus2 = Qudiv[1];
        String Qus3 = Qudiv[2];
        String Qus4 = Qudiv[3];
        String Qus5 = Qudiv[4];
        String Qus6 = Qudiv[5];
        String Qus7 = Qudiv[6];
        String Qus8 = Qudiv[7];
        String Qus9 = Qudiv[8];
        String Qus10 = Qudiv[9];
        bRefeicao01P2.setText(Qus1);
        bRefeicao02P2.setText(Qus2);
        bRefeicao03P2.setText(Qus3);
        bRefeicao04P2.setText(Qus4);
        bRefeicao05P2.setText(Qus5);
        bRefeicao06P2.setText(Qus6);
        bRefeicao07P2.setText(Qus7);
        bRefeicao08P2.setText(Qus8);
        bRefeicao09P2.setText(Qus9);
        bRefeicao10P2.setText(Qus10);
    break;
  case FRIDAY:
    txtDiaSemanaP2.setText("Sexta");
    SEX=dCliente.getSEX();
        String [] Sediv = SEX.split(";");
        String Ses1 = Sediv[0];
        String Ses2 = Sediv[1];
        String Ses3 = Sediv[2];
        String Ses4 = Sediv[3];
        String Ses5 = Sediv[4];
        String Ses6 = Sediv[5];
        String Ses7 = Sediv[6];
        String Ses8 = Sediv[7];
        String Ses9 = Sediv[8];
        String Ses10 = Sediv[9];
        bRefeicao01P2.setText(Ses1);
        bRefeicao02P2.setText(Ses2);
        bRefeicao03P2.setText(Ses3);
        bRefeicao04P2.setText(Ses4);
        bRefeicao05P2.setText(Ses5);
        bRefeicao06P2.setText(Ses6);
        bRefeicao07P2.setText(Ses7);
        bRefeicao08P2.setText(Ses8);
        bRefeicao09P2.setText(Ses9);
        bRefeicao10P2.setText(Ses10);
        
    break;
  case SATURDAY:
    txtDiaSemanaP2.setText("Sabado");
    SAB=dCliente.getSAB();
        String [] Sadiv = SAB.split(";");
        String Sas1 = Sadiv[0];
        String Sas2 = Sadiv[1];
        String Sas3 = Sadiv[2];
        String Sas4 = Sadiv[3];
        String Sas5 = Sadiv[4];
        String Sas6 = Sadiv[5];
        String Sas7 = Sadiv[6];
        String Sas8 = Sadiv[7];
        String Sas9 = Sadiv[8];
        String Sas10 = Sadiv[9];
        bRefeicao01P2.setText(Sas1);
        bRefeicao02P2.setText(Sas2);
        bRefeicao03P2.setText(Sas3);
        bRefeicao04P2.setText(Sas4);
        bRefeicao05P2.setText(Sas5);
        bRefeicao06P2.setText(Sas6);
        bRefeicao07P2.setText(Sas7);
        bRefeicao08P2.setText(Sas8);
        bRefeicao09P2.setText(Sas9);
        bRefeicao10P2.setText(Sas10);
    break;
  case SUNDAY:
      DOM=dCliente.getDOM();
        String [] Ddiv = DOM.split(";");
        String Ds1 = Ddiv[0];
        String Ds2 = Ddiv[1];
        String Ds3 = Ddiv[2];
        String Ds4 = Ddiv[3];
        String Ds5 = Ddiv[4];
        String Ds6 = Ddiv[5];
        String Ds7 = Ddiv[6];
        String Ds8 = Ddiv[7];
        String Ds9 = Ddiv[8];
        String Ds10 = Ddiv[9];
        bRefeicao01P2.setText(Ds1);
        bRefeicao02P2.setText(Ds2);
        bRefeicao03P2.setText(Ds3);
        bRefeicao04P2.setText(Ds4);
        bRefeicao05P2.setText(Ds5);
        bRefeicao06P2.setText(Ds6);
        bRefeicao07P2.setText(Ds7);
        bRefeicao08P2.setText(Ds8);
        bRefeicao09P2.setText(Ds9);
        bRefeicao10P2.setText(Ds10);
    txtDiaSemanaP2.setText("Domingo");
    break;}
                    
        }else if(txtUserP2.getText().equals("admin")){
            if(txtSenhaP2.getText().equals("1234")){
            JOptionPane.showMessageDialog(rootPane, "LOGIN REALIZADO COM SUCESSO!");
                PanelAdminReceitasP2.setVisible(true);
                try {
                    ConsultaIng();
                } catch (SQLException ex) {
                    Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
                }
                p2.setVisible(true);
            }}else{
            JOptionPane.showMessageDialog(rootPane, "LOGIN NAO REALIZADO!");
            
        }     
    }//GEN-LAST:event_bLogP2ActionPerformed

    private void bCancelarP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarP2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bCancelarP2ActionPerformed

    private void bCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastroActionPerformed
        try {
            // TODO add your handling code here:
            Cliente clientea = clientedao.ContarEntradasSQL();
            txtMatriculaPc.setText(clientea.getMAT());
            PC.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "ERRO CONTAGEM", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "ERRO CLASSE", ex);
        }
        
        
    }//GEN-LAST:event_bCadastroActionPerformed

    private void txtNomePcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomePcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomePcActionPerformed

    private void txtUserP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserP2ActionPerformed

    private void bLogoutP2eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogoutP2eActionPerformed
        // TODO add your handling code here:
        
        p2e.setVisible(false);
        bLogP2.setEnabled(true);
        txtUserP2.setEditable(true);
        txtSenhaP2.setEditable(true);
        txtUserP2.setText("");
        txtSenhaP2.setText("");
        bCadastro.setEnabled(true);
        bCancelarP2.setEnabled(true);
        p2.setVisible(false);
        //p1.setVisible(true);
    }//GEN-LAST:event_bLogoutP2eActionPerformed

    private void bFecharSysP2eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFecharSysP2eActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bFecharSysP2eActionPerformed

    private void bVoltarP2eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarP2eActionPerformed
        // TODO add your handling code here:
        p2.setVisible(true);
        p2e.setVisible(false);
    }//GEN-LAST:event_bVoltarP2eActionPerformed

    private void bVoltarRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarRSActionPerformed
        // TODO add your handling code here:
        receitaS.setVisible(false);
        txtNomeRefRS.setText("");
        txtEspRS.setText("");
        txtCorpoRecRS.setText("");
    }//GEN-LAST:event_bVoltarRSActionPerformed

    private void bRefeicao02P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefeicao02P2ActionPerformed
        // TODO add your handling code here:
selecionada = bRefeicao02P2.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("divida porcoes por 3!");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
    }//GEN-LAST:event_bRefeicao02P2ActionPerformed

    private void bRefeicao03P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefeicao03P2ActionPerformed
        // TODO add your handling code here:
        selecionada = bRefeicao03P2.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("divida porcoes por 3!");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());

        receitaS.setVisible(true);
    }//GEN-LAST:event_bRefeicao03P2ActionPerformed

    private void bRefeicao04P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefeicao04P2ActionPerformed
        // TODO add your handling code here:
        selecionada = bRefeicao04P2.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("divida porcoes por 3!");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());

        receitaS.setVisible(true);
    }//GEN-LAST:event_bRefeicao04P2ActionPerformed

    private void bRefeicao09P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefeicao09P2ActionPerformed
        // TODO add your handling code here:
        selecionada = bRefeicao09P2.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("divida porcoes por 3!");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
    }//GEN-LAST:event_bRefeicao09P2ActionPerformed

    private void txtEspRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspRSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEspRSActionPerformed

    private void bNovaDP2dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovaDP2dActionPerformed
        // TODO add your handling code here:
        dCliente.setSEG("");
        dCliente.setTER("");
        dCliente.setQUA("");
        dCliente.setQUI("");
        dCliente.setSEX("");
        dCliente.setSAB("");
        dCliente.setDOM("");
        p2.setVisible(false);
        p3.setVisible(true);
        p2d.setVisible(false);
        bd1P6.setVisible(false);
        bd2P6.setVisible(false);
        bd3P6.setVisible(false);
        bd4P6.setVisible(false);
        bd5P6.setVisible(false);
        bd6P6.setVisible(false);
        bd7P6.setVisible(false);
        bd8P6.setVisible(false);
        bd9P6.setVisible(false);
        bd10P6.setVisible(false);
    }//GEN-LAST:event_bNovaDP2dActionPerformed

    private void bEditarDP2dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarDP2dActionPerformed
        // TODO add your handling code here:
        
        if(dCliente!=null){
        txtNUP4.setText(cliente.getNOME());
        
        //separar strings dieta
        //seg
        SEG=dCliente.getSEG();
        String [] Sdiv = SEG.split(";");
        String ds1 = Sdiv[0];
        String ds2 = Sdiv[1];
        String ds3 = Sdiv[2];
        String ds4 = Sdiv[3];
        String ds5 = Sdiv[4];
        String ds6 = Sdiv[5];
        String ds7 = Sdiv[6];
        String ds8 = Sdiv[7];
        String ds9 = Sdiv[8];
        String ds10 = Sdiv[9];
        bdS1P4.setText(ds1);
        bdS2P4.setText(ds2);
        bdS3P4.setText(ds3);
        bdS4P4.setText(ds4);
        bdS5P4.setText(ds5);
        bdS6P4.setText(ds6);
        bdS7P4.setText(ds7);
        bdS8P4.setText(ds8);
        bdS9P4.setText(ds9);
        bdS10P4.setText(ds10);
        
        //ter
        TER=dCliente.getTER();
        String [] Tdiv = TER.split(";");
        String Ts1 = Tdiv[0];
        String Ts2 = Tdiv[1];
        String Ts3 = Tdiv[2];
        String Ts4 = Tdiv[3];
        String Ts5 = Tdiv[4];
        String Ts6 = Tdiv[5];
        String Ts7 = Tdiv[6];
        String Ts8 = Tdiv[7];
        String Ts9 = Tdiv[8];
        String Ts10 = Tdiv[9];
        bdT1P4.setText(Ts1);
        bdT2P4.setText(Ts2);
        bdT3P4.setText(Ts3);
        bdT4P4.setText(Ts4);
        bdT5P4.setText(Ts5);
        bdT6P4.setText(Ts6);
        bdT7P4.setText(Ts7);
        bdT8P4.setText(Ts8);
        bdT9P4.setText(Ts9);
        bdT10P4.setText(Ts10);
        
        
        //qua
        QUAR=dCliente.getQUA();
        String [] Qdiv = QUAR.split(";");
        String Qs1 = Qdiv[0];
        String Qs2 = Qdiv[1];
        String Qs3 = Qdiv[2];
        String Qs4 = Qdiv[3];
        String Qs5 = Qdiv[4];
        String Qs6 = Qdiv[5];
        String Qs7 = Qdiv[6];
        String Qs8 = Qdiv[7];
        String Qs9 = Qdiv[8];
        String Qs10 = Qdiv[9];
        bdQ1P4.setText(Qs1);
        bdQ2P4.setText(Qs2);
        bdQ3P4.setText(Qs3);
        bdQ4P4.setText(Qs4);
        bdQ5P4.setText(Qs5);
        bdQ6P4.setText(Qs6);
        bdQ7P4.setText(Qs7);
        bdQ8P4.setText(Qs8);
        bdQ9P4.setText(Qs9);
        bdQ10P4.setText(Qs10);
        
        
        //qui
        QUI=dCliente.getQUI();
        String [] Qudiv = QUI.split(";");
        String Qus1 = Qudiv[0];
        String Qus2 = Qudiv[1];
        String Qus3 = Qudiv[2];
        String Qus4 = Qudiv[3];
        String Qus5 = Qudiv[4];
        String Qus6 = Qudiv[5];
        String Qus7 = Qudiv[6];
        String Qus8 = Qudiv[7];
        String Qus9 = Qudiv[8];
        String Qus10 = Qudiv[9];
        bdQu1P4.setText(Qus1);
        bdQu2P4.setText(Qus2);
        bdQu3P4.setText(Qus3);
        bdQu4P4.setText(Qus4);
        bdQu5P4.setText(Qus5);
        bdQu6P4.setText(Qus6);
        bdQu7P4.setText(Qus7);
        bdQu8P4.setText(Qus8);
        bdQu9P4.setText(Qus9);
        bdQu10P4.setText(Qus10);
        
        //sex
        SEX=dCliente.getSEX();
        String [] Sediv = SEX.split(";");
        String Ses1 = Sediv[0];
        String Ses2 = Sediv[1];
        String Ses3 = Sediv[2];
        String Ses4 = Sediv[3];
        String Ses5 = Sediv[4];
        String Ses6 = Sediv[5];
        String Ses7 = Sediv[6];
        String Ses8 = Sediv[7];
        String Ses9 = Sediv[8];
        String Ses10 = Sediv[9];
        bdSe1P4.setText(Ses1);
        bdSe2P4.setText(Ses2);
        bdSe3P4.setText(Ses3);
        bdSe4P4.setText(Ses4);
        bdSe5P4.setText(Ses5);
        bdSe6P4.setText(Ses6);
        bdSe7P4.setText(Ses7);
        bdSe8P4.setText(Ses8);
        bdSe9P4.setText(Ses9);
        bdSe10P4.setText(Ses10);
        
        //sab
        SAB=dCliente.getSAB();
        String [] Sadiv = SAB.split(";");
        String Sas1 = Sadiv[0];
        String Sas2 = Sadiv[1];
        String Sas3 = Sadiv[2];
        String Sas4 = Sadiv[3];
        String Sas5 = Sadiv[4];
        String Sas6 = Sadiv[5];
        String Sas7 = Sadiv[6];
        String Sas8 = Sadiv[7];
        String Sas9 = Sadiv[8];
        String Sas10 = Sadiv[9];
        bdSa1P4.setText(Sas1);
        bdSa2P4.setText(Sas2);
        bdSa3P4.setText(Sas3);
        bdSa4P4.setText(Sas4);
        bdSa5P4.setText(Sas5);
        bdSa6P4.setText(Sas6);
        bdSa7P4.setText(Sas7);
        bdSa8P4.setText(Sas8);
        bdSa9P4.setText(Sas9);
        bdSa10P4.setText(Sas10);
        
        
        //dom
        DOM=dCliente.getDOM();
        String [] Ddiv = DOM.split(";");
        String Ds1 = Ddiv[0];
        String Ds2 = Ddiv[1];
        String Ds3 = Ddiv[2];
        String Ds4 = Ddiv[3];
        String Ds5 = Ddiv[4];
        String Ds6 = Ddiv[5];
        String Ds7 = Ddiv[6];
        String Ds8 = Ddiv[7];
        String Ds9 = Ddiv[8];
        String Ds10 = Ddiv[9];
        bdD1P4.setText(Ds1);
        bdD2P4.setText(Ds2);
        bdD3P4.setText(Ds3);
        bdD4P4.setText(Ds4);
        bdD5P4.setText(Ds5);
        bdD6P4.setText(Ds6);
        bdD7P4.setText(Ds7);
        bdD8P4.setText(Ds8);
        bdD9P4.setText(Ds9);
        bdD10P4.setText(Ds10);
        
        
        
        p2.setVisible(false);
        p2d.setVisible(false);
        p4.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Usuario nao possui dietas prontas!"); 
        }
    }//GEN-LAST:event_bEditarDP2dActionPerformed

    private void bVoltarP2dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarP2dActionPerformed
        // TODO add your handling code here:
        p2d.setVisible(false);
        p2.setVisible(true);
    }//GEN-LAST:event_bVoltarP2dActionPerformed

    private void bDivSegP3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDivSegP3MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_bDivSegP3MouseClicked

    private void bDivSegP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDivSegP3ActionPerformed
        // TODO add your handling code here:
    sdiv += 1;
    if (sdiv>10){
        sdiv = 1;
        bDivSegP3.setText("divisoes["+ sdiv+"]");
    }
    bDivSegP3.setText("divisoes["+ sdiv+"]");
    }//GEN-LAST:event_bDivSegP3ActionPerformed

    private void bDivTerP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDivTerP3ActionPerformed
        // TODO add your handling code here:
        tdiv += 1;
        
    if (tdiv>10){
        tdiv = 1;
        bDivTerP3.setText("divisoes["+ tdiv+"]");
    }bDivTerP3.setText("divisoes["+ tdiv+"]");
    }//GEN-LAST:event_bDivTerP3ActionPerformed

    private void bDivQuaP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDivQuaP3ActionPerformed
        // TODO add your handling code here:
        qdiv += 1;
        
    if (qdiv>10){
        qdiv = 1;
        bDivQuaP3.setText("divisoes["+ qdiv+"]");
    }bDivQuaP3.setText("divisoes["+ qdiv+"]");
    }//GEN-LAST:event_bDivQuaP3ActionPerformed

    private void bDivQuiP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDivQuiP3ActionPerformed
        // TODO add your handling code here:
        qudiv += 1;
        
    if (qudiv>10){
        qudiv = 1;
        bDivQuiP3.setText("divisoes["+ qudiv+"]");
    }bDivQuiP3.setText("divisoes["+ qudiv+"]");
    }//GEN-LAST:event_bDivQuiP3ActionPerformed

    private void bDivSexP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDivSexP3ActionPerformed
        // TODO add your handling code here:
        sediv += 1;
        
    if (sediv>10){
        sediv = 1;bDivSexP3.setText("divisoes["+ sediv+"]");
    }bDivSexP3.setText("divisoes["+ sediv+"]");
    }//GEN-LAST:event_bDivSexP3ActionPerformed

    private void bDivSabP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDivSabP3ActionPerformed
        // TODO add your handling code here:
        sadiv += 1;
        
    if (sadiv>10){
        sadiv = 1;
        bDivSabP3.setText("divisoes["+ sadiv+"]");
    }bDivSabP3.setText("divisoes["+ sadiv+"]");
    }//GEN-LAST:event_bDivSabP3ActionPerformed

    private void bDivDomP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDivDomP3ActionPerformed
        // TODO add your handling code here:
        ddiv += 1;
        
    if (ddiv>10){
        ddiv = 0;
        bDivDomP3.setText("divisoes["+ ddiv+"]");
    }bDivDomP3.setText("divisoes["+ ddiv+"]");
    }//GEN-LAST:event_bDivDomP3ActionPerformed

    private void bAvancarP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAvancarP3ActionPerformed
        // TODO add your handling code here:

        p4.setVisible(false);
        p5.setVisible(true);
    }//GEN-LAST:event_bAvancarP3ActionPerformed

    private void bVoltarP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarP3ActionPerformed
        // TODO add your handling code here:
        p2.setVisible(true);
        p3.setVisible(false);
    }//GEN-LAST:event_bVoltarP3ActionPerformed

    private void bVoltarP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarP4ActionPerformed
        // TODO add your handling code here:
        p2.setVisible(true);
        p4.setVisible(false);
    }//GEN-LAST:event_bVoltarP4ActionPerformed

    private void bEditarP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarP4ActionPerformed
        // TODO add your handling code here:
        if(dCliente!=null){
        sdiv=10;
        tdiv=10;
        qdiv=10;
        qudiv=10;
        sediv=10;
        sadiv=10;
        ddiv=10;
        }
        p4.setVisible(false);
        p5.setVisible(true);
    }//GEN-LAST:event_bEditarP4ActionPerformed

    private void btEQuiP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEQuiP5ActionPerformed
        // TODO add your handling code here:
        diaSemana=4;
        switch (qudiv) {
  case 1 -> bd1P6.setVisible(true);
  case 2 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
            }
  case 3 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
            }
  case 4 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      
            }
  case 5 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
            }
  case 6 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
            }
  case 7 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
            }
  case 8 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
            }
  case 9 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
            }
  case 10 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
      bd10P6.setVisible(true);
            }
        }
        //pr1.setTitle(dayOfWeek.toString());
        diaSemanaP6.setText("quinta-feira");
            diaSemanaP6.setEditable(false);
    }//GEN-LAST:event_btEQuiP5ActionPerformed

    private void btEDomP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEDomP5ActionPerformed
        // TODO add your handling code here:
        diaSemana=7;
        switch (ddiv) {
  case 1 -> bd1P6.setVisible(true);
  case 2 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
            }
  case 3 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
            }
  case 4 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
            }
  case 5 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
            }
  case 6 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
            }
  case 7 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd7P6.setVisible(true);
            }
  case 8 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
            }
  case 9 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
            }
  case 10 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
      bd10P6.setVisible(true);
            }
        }
        //pr1.setTitle(dayOfWeek.toString());
        diaSemanaP6.setText("domingo");
        diaSemanaP6.setEditable(false);
    }//GEN-LAST:event_btEDomP5ActionPerformed

    private void bAvancarP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAvancarP5ActionPerformed
        // TODO add your handling code here:
        
        

        p6.setVisible(true);
    }//GEN-LAST:event_bAvancarP5ActionPerformed

    private void bVoltarP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarP5ActionPerformed
        // TODO add your handling code here:
        p5.setVisible(false);

    }//GEN-LAST:event_bVoltarP5ActionPerformed

    private void bd2P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bd2P6ActionPerformed
        // TODO add your handling code here:
        div = 2;
        pr1.setVisible(true);
        pr1.setTitle("divisao 2");
    }//GEN-LAST:event_bd2P6ActionPerformed

    private void bVoltarP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarP6ActionPerformed
        // TODO add your handling code here:
        bd1P6.setVisible(false);
        bd2P6.setVisible(false);
        bd3P6.setVisible(false);
        bd4P6.setVisible(false);
        bd5P6.setVisible(false);
        bd6P6.setVisible(false);
        bd7P6.setVisible(false);
        bd8P6.setVisible(false);
        bd9P6.setVisible(false);
        bd10P6.setVisible(false);
        p6.setVisible(false);
    }//GEN-LAST:event_bVoltarP6ActionPerformed

    private void bConsultarPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarPCActionPerformed
        try {
            // TODO add your handling code here:
            ConsultarDados();
        } catch (Exception ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bConsultarPCActionPerformed

    private void bAlterarPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarPcActionPerformed
        // TODO add your handling code here:
        cliente.setMAT(txtMatriculaPc.getText());
        cliente.setEMAIL(txtEmailPc.getText());
        cliente.setNOME(txtNomePc.getText());
        cliente.setSENHA(txtSenhaPc.getText());
        cliente.setIDADE(txtIdadePc.getText());
        cliente.setPESO(txtPesoPc.getText());
        try {
            ExcluirCad();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clientedao.adicionar(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_bAlterarPcActionPerformed

    private void bExcluirPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirPcActionPerformed
        
        try {
            // TODO add your handling code here:
            ExcluirCad();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bExcluirPcActionPerformed

    private void txtMatriculaPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaPcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaPcActionPerformed

    private void lListaComidasPr1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lListaComidasPr1ValueChanged
        // TODO add your handling code here:
        selecionada = lListaComidasPr1.getSelectedValue();
        ConsultapRec();
    }//GEN-LAST:event_lListaComidasPr1ValueChanged

    private void bSalvarPr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarPr1ActionPerformed
        // TODO add your handling code here:
        
       switch (div) {
  case 1 -> bd1P6.setText(nRecei.getID());
  case 2 -> bd2P6.setText(nRecei.getID());
  case 3 -> bd3P6.setText(nRecei.getID());
  case 4 -> bd4P6.setText(nRecei.getID());
  case 5 -> bd5P6.setText(nRecei.getID());
  case 6 -> bd6P6.setText(nRecei.getID());
  case 7 -> bd7P6.setText(nRecei.getID());
  case 8 -> bd8P6.setText(nRecei.getID());
  case 9 -> bd9P6.setText(nRecei.getID());
  case 10 -> bd10P6.setText(nRecei.getID());
}
        
        /*dCliente.setSEG("11111");
        dCliente.setTER("11111");
        dCliente.setQUA("11111");
        dCliente.setQUI("11111");
        dCliente.setSEX("11111");
        dCliente.setSAB("11111");
        dCliente.setDOM("11111");
        */
       /* switch (diaSemana) {
  case 1 -> dCliente.setSEG(nRecei.getID());
  case 2 -> dCliente.setTER(nRecei.getID());
  case 3 -> dCliente.setQUA(nRecei.getID());
  case 4 -> dCliente.setQUI(nRecei.getID());
  case 5 -> dCliente.setSEX(nRecei.getID());
  case 6 -> dCliente.setSAB(nRecei.getID());
  case 7 -> dCliente.setDOM(nRecei.getID());
}*/
        pr1.setVisible(false);
              
        
    }//GEN-LAST:event_bSalvarPr1ActionPerformed

    private void bLimpaDieP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpaDieP2ActionPerformed
        try {
            // TODO add your handling code here:
            ExcluirD();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "ERRO EXCLUSAO", ex);
        }
    }//GEN-LAST:event_bLimpaDieP2ActionPerformed

    private void bSalvarPRecADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarPRecADDActionPerformed
        // TODO add your handling code here:
        nRecei.setID(txtMatRecPRecADD.getText());
        nRecei.setNOMERECEITA(txtRECEITAPRecADD.getText());
        nRecei.setCORPOTEX(txtCORPOTEXTOPRecADD.getText());
        System.out.println(nRecei.getID());
        System.out.println(nRecei.getNOMERECEITA());
        System.out.println(nRecei.getCLASSIF());
        try {
            receitasdao.InserirComida(nRecei);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bSalvarPRecADDActionPerformed

    private void bPesoLevePRecADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesoLevePRecADDActionPerformed
        // TODO add your handling code here:
        nRecei.setCLASSIF("P");
    }//GEN-LAST:event_bPesoLevePRecADDActionPerformed

    private void bPesoMedPRecADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesoMedPRecADDActionPerformed
        // TODO add your handling code here:
        nRecei.setCLASSIF("M");
    }//GEN-LAST:event_bPesoMedPRecADDActionPerformed

    private void bPesoGranPRecADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesoGranPRecADDActionPerformed
        // TODO add your handling code here:
        nRecei.setCLASSIF("G");
    }//GEN-LAST:event_bPesoGranPRecADDActionPerformed

    private void bAdminReceitasP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdminReceitasP2ActionPerformed
        // TODO add your handling code here:
        pRecADD.setVisible(true);
    }//GEN-LAST:event_bAdminReceitasP2ActionPerformed

    private void bVoltarPRecADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarPRecADDActionPerformed
        // TODO add your handling code here:
        pRecADD.setVisible(false);
    }//GEN-LAST:event_bVoltarPRecADDActionPerformed

    private void bConsultaRecPRecADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultaRecPRecADDActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ConsultaRec();
            txtCORPOTEXTOPRecADD.setText(nRecei.getCORPOTEX());
            txtRECEITAPRecADD.setText(nRecei.getNOMERECEITA());
            txtMatRecPRecADD.setText(nRecei.getID());
        } catch (Exception ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bConsultaRecPRecADDActionPerformed

    private void bExcluirRecPRecADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirRecPRecADDActionPerformed
        // TODO add your handling code here:
        ExcluirRecei();
        nRecei.setID("");
        nRecei.setCORPOTEX("");
        nRecei.setCLASSIF("");
        nRecei.setNOMERECEITA("");
    }//GEN-LAST:event_bExcluirRecPRecADDActionPerformed

    private void bAtualizarRecPRecADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtualizarRecPRecADDActionPerformed
        // TODO add your handling code here:
        nRecei.setID(txtMatRecPRecADD.getText());
        nRecei.setNOMERECEITA(txtRECEITAPRecADD.getText());
        nRecei.setCORPOTEX(txtCORPOTEXTOPRecADD.getText());
        ExcluirRecei();
        try {
            receitasdao.InserirComida(nRecei);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bAtualizarRecPRecADDActionPerformed

    private void bPesqPr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesqPr1ActionPerformed
        
    }//GEN-LAST:event_bPesqPr1ActionPerformed

    private void btESegP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btESegP5ActionPerformed
        // TODO add your handling code here:
        diaSemana=1;
        switch (sdiv) {
  case 1 -> bd1P6.setVisible(true);
  case 2 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
            }
  case 3 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
            }
  case 4 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
            }
  case 5 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
            }
  case 6 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
            }
  case 7 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
            }
  case 8 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
            }
  case 9 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
            }
  case 10 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
      bd10P6.setVisible(true);
            }
        }
        diaSemanaP6.setText("segunda-feira");
            diaSemanaP6.setEditable(false);
    }//GEN-LAST:event_btESegP5ActionPerformed

    private void btETerP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btETerP5ActionPerformed
        // TODO add your handling code here:
        diaSemana=2;
        switch (tdiv) {
  case 1 -> bd1P6.setVisible(true);
  case 2 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
            }
  case 3 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
            }
  case 4 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
            }
  case 5 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
            }
  case 6 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
            }
  case 7 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
            }
  case 8 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
            }
  case 9 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
            }
  case 10 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
      bd10P6.setVisible(true);
            }
        }
        //pr1.setTitle(dayOfWeek.toString());
        diaSemanaP6.setText("terca-feira");
            diaSemanaP6.setEditable(false);
    }//GEN-LAST:event_btETerP5ActionPerformed

    private void btEQuarP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEQuarP5ActionPerformed
        // TODO add your handling code here:
        diaSemana=3;
        switch (qdiv) {
  case 1 -> bd1P6.setVisible(true);
  case 2 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
            }
  case 3 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
            }
  case 4 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
            }
  case 5 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
            }
  case 6 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
            }
  case 7 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
            }
  case 8 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
            }
  case 9 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
            }
  case 10 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
      bd10P6.setVisible(true);
            }
        }
        //pr1.setTitle(dayOfWeek.toString());
        diaSemanaP6.setText("quarta-feira");
            diaSemanaP6.setEditable(false);
    }//GEN-LAST:event_btEQuarP5ActionPerformed

    private void btESabP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btESabP5ActionPerformed
        // TODO add your handling code here:
         
        diaSemana=6;
        switch (sadiv) {
  case 1 -> bd1P6.setVisible(true);
  case 2 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
            }
  case 3 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
            }
  case 4 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
            }
  case 5 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
            }
  case 6 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
            }
  case 7 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd7P6.setVisible(true);
            }
  case 8 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
            }
  case 9 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
            }
  case 10 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
      bd10P6.setVisible(true);
            }
        }
            diaSemanaP6.setText("sabado");
            diaSemanaP6.setEditable(false);

    }//GEN-LAST:event_btESabP5ActionPerformed

    private void btESexP5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btESexP5ActionPerformed
        // TODO add your handling code here:
        diaSemana=5;
        switch (sediv) {
  case 1 -> bd1P6.setVisible(true);
  case 2 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
            }
  case 3 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
            }
  case 4 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
            }
  case 5 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
            }
  case 6 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
            }
  case 7 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
            }
  case 8 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
            }
  case 9 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
            }
  case 10 -> {
      bd1P6.setVisible(true);
      bd2P6.setVisible(true);
      bd3P6.setVisible(true);
      bd4P6.setVisible(true);
      bd5P6.setVisible(true);
      bd6P6.setVisible(true);
      bd7P6.setVisible(true);
      bd8P6.setVisible(true);
      bd9P6.setVisible(true);
      bd10P6.setVisible(true);
            }
        }
        
            diaSemanaP6.setText("sexta-feira");
            diaSemanaP6.setEditable(false);
    }//GEN-LAST:event_btESexP5ActionPerformed

    private void bd7P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bd7P6ActionPerformed
        // TODO add your handling code here:
        div = 7;
        pr1.setVisible(true);
        pr1.setTitle("divisao 7");
    }//GEN-LAST:event_bd7P6ActionPerformed

    private void bd8P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bd8P6ActionPerformed
        // TODO add your handling code here:
        div = 8;
        pr1.setVisible(true);
        pr1.setTitle("divisao 8");
    }//GEN-LAST:event_bd8P6ActionPerformed

    private void bd1P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bd1P6ActionPerformed
        // TODO add your handling code here:
        div = 1;
        pr1.setVisible(true);
        pr1.setTitle("divisao 1");
    }//GEN-LAST:event_bd1P6ActionPerformed

    private void bd3P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bd3P6ActionPerformed
        // TODO add your handling code here:
        div = 3;
        pr1.setVisible(true);
        pr1.setTitle("divisao 3");
    }//GEN-LAST:event_bd3P6ActionPerformed

    private void bd4P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bd4P6ActionPerformed
        // TODO add your handling code here:
        div = 4;
        pr1.setVisible(true);
        pr1.setTitle("divisao 4");
    }//GEN-LAST:event_bd4P6ActionPerformed

    private void bd5P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bd5P6ActionPerformed
        // TODO add your handling code here:
        div = 5;
        pr1.setVisible(true);
        pr1.setTitle("divisao 5");
    }//GEN-LAST:event_bd5P6ActionPerformed

    private void bd6P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bd6P6ActionPerformed
        // TODO add your handling code here:
        div = 6;
        pr1.setVisible(true);
        pr1.setTitle("divisao 6");
    }//GEN-LAST:event_bd6P6ActionPerformed

    private void bd9P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bd9P6ActionPerformed
        // TODO add your handling code here:
        div = 9;
        pr1.setVisible(true);
        pr1.setTitle("divisao 9");
    }//GEN-LAST:event_bd9P6ActionPerformed

    private void bd10P6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bd10P6ActionPerformed
        // TODO add your handling code here:
        div = 10;
        pr1.setVisible(true);
        pr1.setTitle("divisao 10");
    }//GEN-LAST:event_bd10P6ActionPerformed

    private void bSalvarP6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalvarP6ActionPerformed
        // TODO add your handling code here:
        //entrada = bd1P6.getText()+";"+bd2P6.getText()+";";
        switch (div) {
  case 1 -> entrada = bd1P6.getText()+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-";
  case 2 -> entrada = bd1P6.getText()+";"+bd2P6.getText()+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-";
  case 3 -> entrada = bd1P6.getText()+";"+bd2P6.getText()+";"+bd3P6.getText()+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-";
  case 4 -> entrada = bd1P6.getText()+";"+bd2P6.getText()+";"+bd3P6.getText()+";"+bd4P6.getText()+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-";
  case 5 -> entrada = bd1P6.getText()+";"+bd2P6.getText()+";"+bd3P6.getText()+";"+bd4P6.getText()+";"+bd5P6.getText()+";"+"-"+";"+"-"+";"+"-"+";"+"-"+";"+"-";
  case 6 -> entrada = bd1P6.getText()+";"+bd2P6.getText()+";"+bd3P6.getText()+";"+bd4P6.getText()+";"+bd5P6.getText()+";"+bd6P6.getText()+";"+"-"+";"+"-"+";"+"-"+";"+"-";
  case 7 -> entrada = bd1P6.getText()+";"+bd2P6.getText()+";"+bd3P6.getText()+";"+bd4P6.getText()+";"+bd5P6.getText()+";"+bd6P6.getText()+";"+bd7P6.getText()+";"+"-"+";"+"-"+";"+"-";
  case 8 -> entrada = bd1P6.getText()+";"+bd2P6.getText()+";"+bd3P6.getText()+";"+bd4P6.getText()+";"+bd5P6.getText()+";"+bd6P6.getText()+";"+bd7P6.getText()+";"+bd8P6.getText()+";"+"-"+";"+"-";
  case 9 -> entrada = bd1P6.getText()+";"+bd2P6.getText()+";"+bd3P6.getText()+";"+bd4P6.getText()+";"+bd5P6.getText()+";"+bd6P6.getText()+";"+bd7P6.getText()+";"+bd8P6.getText()+";"+bd9P6.getText()+";"+"-";
  case 10 -> entrada = bd1P6.getText()+";"+bd2P6.getText()+";"+bd3P6.getText()+";"+bd4P6.getText()+";"+bd5P6.getText()+";"+bd6P6.getText()+";"+bd7P6.getText()+";"+bd8P6.getText()+";"+bd9P6.getText()+";"+bd10P6.getText();
        }
        dCliente.setMAT(cliente.getMAT());
        switch (diaSemana) {
  case 1 -> dCliente.setSEG(entrada);
  case 2 -> dCliente.setTER(entrada);
  case 3 -> dCliente.setQUA(entrada);
  case 4 -> dCliente.setQUI(entrada);
  case 5 -> dCliente.setSEX(entrada);
  case 6 -> dCliente.setSAB(entrada);
  case 7 -> dCliente.setDOM(entrada);
}
        bd1P6.setText("div 1");
        bd2P6.setText("div 2");
        bd3P6.setText("div 3");
        bd4P6.setText("div 4");
        bd5P6.setText("div 5");
        bd6P6.setText("div 6");
        bd7P6.setText("div 7");
        bd8P6.setText("div 8");
        bd9P6.setText("div 9");
        bd10P6.setText("div 10");
        entrada = null;
try {
            ExcluirD();
            dietasdao.inserirRotina(dCliente);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, "erro gravamento", ex);
        }
p6.setVisible(false);
    }//GEN-LAST:event_bSalvarP6ActionPerformed

    private void bCancelarPr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarPr1ActionPerformed
        // TODO add your handling code here:
        pr1.setVisible(false);
    }//GEN-LAST:event_bCancelarPr1ActionPerformed

    private void bdS1P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdS1P4ActionPerformed
        // TODO add your handling code here:
        if(!bdS1P4.getText().equals("-")){
        selecionada = bdS1P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
    }
        
    }//GEN-LAST:event_bdS1P4ActionPerformed

    private void bdS2P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdS2P4ActionPerformed
        // TODO add your handling code here:
        if(!bdS2P4.getText().equals("-")){
        selecionada = bdS2P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
        }
    }//GEN-LAST:event_bdS2P4ActionPerformed

    private void bdS3P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdS3P4ActionPerformed
        // TODO add your handling code here:
        if(!bdS3P4.getText().equals("-")){
        selecionada = bdS3P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
    }
    }//GEN-LAST:event_bdS3P4ActionPerformed

    private void bdS4P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdS4P4ActionPerformed
        // TODO add your handling code here:
        selecionada = bdS4P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
        
    }//GEN-LAST:event_bdS4P4ActionPerformed

    private void bdS5P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdS5P4ActionPerformed
        // TODO add your handling code here:
        selecionada = bdS5P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
        
    }//GEN-LAST:event_bdS5P4ActionPerformed

    private void bdS6P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdS6P4ActionPerformed
        // TODO add your handling code here:
        selecionada = bdS6P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
        
    }//GEN-LAST:event_bdS6P4ActionPerformed

    private void bdS7P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdS7P4ActionPerformed
        // TODO add your handling code here:
        selecionada = bdS7P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
        
    }//GEN-LAST:event_bdS7P4ActionPerformed

    private void bdS8P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdS8P4ActionPerformed
        // TODO add your handling code here:
        selecionada = bdS8P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
        
    }//GEN-LAST:event_bdS8P4ActionPerformed

    private void bdS9P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdS9P4ActionPerformed
        // TODO add your handling code here:
        selecionada = bdS9P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
        
    }//GEN-LAST:event_bdS9P4ActionPerformed

    private void bdS10P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdS10P4ActionPerformed
        // TODO add your handling code here:
        selecionada = bdS10P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
        
        
        
    }//GEN-LAST:event_bdS10P4ActionPerformed

    private void bdT1P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdT1P4ActionPerformed
selecionada = bdT1P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());  
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdT1P4ActionPerformed

    private void bdT2P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdT2P4ActionPerformed
selecionada = bdT2P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
receitaS.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_bdT2P4ActionPerformed

    private void bdT3P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdT3P4ActionPerformed
selecionada = bdT3P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX()); 
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdT3P4ActionPerformed

    private void bdT4P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdT4P4ActionPerformed
selecionada = bdT4P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());  
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdT4P4ActionPerformed

    private void bdT5P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdT5P4ActionPerformed
selecionada = bdT5P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
receitaS.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_bdT5P4ActionPerformed

    private void bdT6P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdT6P4ActionPerformed
selecionada = bdT6P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());  
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdT6P4ActionPerformed

    private void bdT7P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdT7P4ActionPerformed
selecionada = bdT7P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdT7P4ActionPerformed

    private void bdT8P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdT8P4ActionPerformed
selecionada = bdT8P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX()); 
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdT8P4ActionPerformed

    private void bdT9P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdT9P4ActionPerformed
selecionada = bdT9P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX()); 
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdT9P4ActionPerformed

    private void bdT10P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdT10P4ActionPerformed
selecionada = bdT10P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
receitaS.setVisible(true);
       // TODO add your handling code here:
    }//GEN-LAST:event_bdT10P4ActionPerformed

    private void bdQ1P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQ1P4ActionPerformed
selecionada = bdQ1P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());  
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQ1P4ActionPerformed

    private void bdQ2P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQ2P4ActionPerformed
selecionada = bdQ2P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQ2P4ActionPerformed

    private void bdQ3P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQ3P4ActionPerformed
selecionada = bdQ3P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());  
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQ3P4ActionPerformed

    private void bdQ4P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQ4P4ActionPerformed
selecionada = bdQ4P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());  
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQ4P4ActionPerformed

    private void bdQ5P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQ5P4ActionPerformed
selecionada = bdQ5P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());  
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQ5P4ActionPerformed

    private void bdQ6P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQ6P4ActionPerformed
selecionada = bdQ6P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX()); 
receitaS.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_bdQ6P4ActionPerformed

    private void bdQ7P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQ7P4ActionPerformed
selecionada = bdQ7P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQ7P4ActionPerformed

    private void bdQ8P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQ8P4ActionPerformed
selecionada = bdQ8P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQ8P4ActionPerformed

    private void bdQ9P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQ9P4ActionPerformed
selecionada = bdQ9P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQ9P4ActionPerformed

    private void bdQ10P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQ10P4ActionPerformed
selecionada = bdQ10P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX()); 
receitaS.setVisible(true);
         // TODO add your handling code here:
    }//GEN-LAST:event_bdQ10P4ActionPerformed

    private void bdQu1P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQu1P4ActionPerformed
selecionada = bdQu1P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
receitaS.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_bdQu1P4ActionPerformed

    private void bdQu2P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQu2P4ActionPerformed
selecionada = bdQu2P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQu2P4ActionPerformed

    private void bdQu3P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQu3P4ActionPerformed
selecionada = bdQu3P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX()); 
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQu3P4ActionPerformed

    private void bdQu4P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQu4P4ActionPerformed
selecionada = bdQu4P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQu4P4ActionPerformed

    private void bdQu5P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQu5P4ActionPerformed
selecionada = bdQu5P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQu5P4ActionPerformed

    private void bdQu6P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQu6P4ActionPerformed
selecionada = bdQu6P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());     
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQu6P4ActionPerformed

    private void bdQu7P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQu7P4ActionPerformed
selecionada = bdQu7P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());     
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQu7P4ActionPerformed

    private void bdQu8P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQu8P4ActionPerformed
selecionada = bdQu8P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQu8P4ActionPerformed

    private void bdQu9P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQu9P4ActionPerformed
selecionada = bdQu9P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdQu9P4ActionPerformed

    private void bdQu10P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdQu10P4ActionPerformed
selecionada = bdQu10P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
receitaS.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_bdQu10P4ActionPerformed

    private void bdSe1P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSe1P4ActionPerformed
selecionada = bdSe1P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSe1P4ActionPerformed

    private void bdSe2P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSe2P4ActionPerformed
selecionada = bdSe2P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSe2P4ActionPerformed

    private void bdSe3P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSe3P4ActionPerformed
selecionada = bdSe3P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSe3P4ActionPerformed

    private void bdSe4P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSe4P4ActionPerformed
selecionada = bdSe4P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSe4P4ActionPerformed

    private void bdSe5P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSe5P4ActionPerformed
selecionada = bdSe5P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());     
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSe5P4ActionPerformed

    private void bdSe6P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSe6P4ActionPerformed
selecionada = bdSe6P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSe6P4ActionPerformed

    private void bdSe7P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSe7P4ActionPerformed
selecionada = bdSe7P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSe7P4ActionPerformed

    private void bdSe8P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSe8P4ActionPerformed
selecionada = bdSe8P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSe8P4ActionPerformed

    private void bdSe9P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSe9P4ActionPerformed
selecionada = bdSe9P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSe9P4ActionPerformed

    private void bdSe10P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSe10P4ActionPerformed
selecionada = bdSe10P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());  
        receitaS.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_bdSe10P4ActionPerformed

    private void bdSa1P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSa1P4ActionPerformed
selecionada = bdSa2P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());      
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSa1P4ActionPerformed

    private void bdSa2P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSa2P4ActionPerformed
selecionada = bdSa3P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSa2P4ActionPerformed

    private void bdSa3P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSa3P4ActionPerformed
selecionada = bdSa4P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSa3P4ActionPerformed

    private void bdSa4P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSa4P4ActionPerformed
selecionada = bdSa5P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());  
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSa4P4ActionPerformed

    private void bdSa5P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSa5P4ActionPerformed
selecionada = bdSa6P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSa5P4ActionPerformed

    private void bdSa6P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSa6P4ActionPerformed
selecionada = bdSa6P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());     
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSa6P4ActionPerformed

    private void bdSa7P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSa7P4ActionPerformed
selecionada = bdSa7P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSa7P4ActionPerformed

    private void bdSa8P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSa8P4ActionPerformed
selecionada = bdSa8P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSa8P4ActionPerformed

    private void bdSa9P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSa9P4ActionPerformed
selecionada = bdSa9P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdSa9P4ActionPerformed

    private void bdSa10P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdSa10P4ActionPerformed
selecionada = bdSa10P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());   
        receitaS.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_bdSa10P4ActionPerformed

    private void bdD1P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdD1P4ActionPerformed
selecionada = bdD1P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdD1P4ActionPerformed

    private void bdD2P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdD2P4ActionPerformed
selecionada = bdD2P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdD2P4ActionPerformed

    private void bdD3P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdD3P4ActionPerformed
selecionada = bdD3P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdD3P4ActionPerformed

    private void bdD4P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdD4P4ActionPerformed
selecionada = bdD4P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());     
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdD4P4ActionPerformed

    private void bdD5P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdD5P4ActionPerformed
selecionada = bdD5P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());       
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdD5P4ActionPerformed

    private void bdD6P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdD6P4ActionPerformed
selecionada = bdD6P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdD6P4ActionPerformed

    private void bdD7P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdD7P4ActionPerformed
selecionada = bdD7P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX()); 
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdD7P4ActionPerformed

    private void bdD8P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdD8P4ActionPerformed
selecionada = bdD8P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());    
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdD8P4ActionPerformed

    private void bdD9P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdD9P4ActionPerformed
selecionada = bdD9P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());     
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdD9P4ActionPerformed

    private void bdD10P4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdD10P4ActionPerformed
selecionada = bdD10P4.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());  
        receitaS.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_bdD10P4ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void bRefeicao05P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefeicao05P2ActionPerformed
        // TODO add your handling code here:
        selecionada = bRefeicao05P2.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("divida porcoes por 3!");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
    }//GEN-LAST:event_bRefeicao05P2ActionPerformed

    private void bRefeicao06P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefeicao06P2ActionPerformed
        // TODO add your handling code here:
        selecionada = bRefeicao06P2.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("divida porcoes por 3!");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
    }//GEN-LAST:event_bRefeicao06P2ActionPerformed

    private void bRefeicao07P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefeicao07P2ActionPerformed
        // TODO add your handling code here:
        selecionada = bRefeicao07P2.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("divida porcoes por 3!");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
    }//GEN-LAST:event_bRefeicao07P2ActionPerformed

    private void bRefeicao08P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefeicao08P2ActionPerformed
        // TODO add your handling code here:
        selecionada = bRefeicao08P2.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("divida porcoes por 3!");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
    }//GEN-LAST:event_bRefeicao08P2ActionPerformed

    private void bRefeicao10P2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefeicao10P2ActionPerformed
        // TODO add your handling code here:
        selecionada = bRefeicao10P2.getText();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("divida porcoes por 3!");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
    }//GEN-LAST:event_bRefeicao10P2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        selecionada = nRecei.getID();
        ConsultaRec1();
        txtNomeRefRS.setText(nRecei.getNOMERECEITA());
        txtEspRS.setText("");
        txtCorpoRecRS.setText(nRecei.getCORPOTEX());
        receitaS.setVisible(true);
        
    }//GEN-LAST:event_jButton10ActionPerformed

        
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame PC;
    private javax.swing.JPanel PanelAdminReceitasP2;
    private javax.swing.JButton bAdminReceitasP2;
    private javax.swing.JButton bAlterarPc;
    private javax.swing.JButton bAtualizarRecPRecADD;
    private javax.swing.JButton bAvancarP3;
    private javax.swing.JButton bAvancarP5;
    private javax.swing.JButton bCadastro;
    private javax.swing.JButton bCancelarP2;
    private javax.swing.JButton bCancelarPc;
    private javax.swing.JButton bCancelarPr1;
    private javax.swing.JButton bConsultaRecPRecADD;
    private javax.swing.JButton bConsultarPC;
    private javax.swing.JButton bDieta;
    private javax.swing.JButton bDivDomP3;
    private javax.swing.JButton bDivQuaP3;
    private javax.swing.JButton bDivQuiP3;
    private javax.swing.JButton bDivSabP3;
    private javax.swing.JButton bDivSegP3;
    private javax.swing.JButton bDivSexP3;
    private javax.swing.JButton bDivTerP3;
    private javax.swing.JButton bEditarCadP2;
    private javax.swing.JButton bEditarDP2d;
    private javax.swing.JButton bEditarP4;
    private javax.swing.JCheckBox bEmagrecerPc1;
    private javax.swing.JCheckBox bEngordarPc1;
    private javax.swing.JButton bExcluirPc;
    private javax.swing.JButton bExcluirRecPRecADD;
    private javax.swing.JButton bFecharSysP2e;
    private javax.swing.JCheckBox bGanhoMassPc1;
    private javax.swing.JButton bLimpaDieP2;
    private javax.swing.JButton bLogP2;
    private javax.swing.JButton bLogoutP2e;
    private javax.swing.JButton bNovaDP2d;
    private javax.swing.JToggleButton bPesoGranPRecADD;
    private javax.swing.JToggleButton bPesoLevePRecADD;
    private javax.swing.JToggleButton bPesoMedPRecADD;
    private javax.swing.JButton bPesqPr1;
    private javax.swing.JRadioButton bRLPr1;
    private javax.swing.JRadioButton bRMPr1;
    private javax.swing.JRadioButton bRPPr1;
    private javax.swing.JButton bRefeicao01P2;
    private javax.swing.JButton bRefeicao02P2;
    private javax.swing.JButton bRefeicao03P2;
    private javax.swing.JButton bRefeicao04P2;
    private javax.swing.JButton bRefeicao05P2;
    private javax.swing.JButton bRefeicao06P2;
    private javax.swing.JButton bRefeicao07P2;
    private javax.swing.JButton bRefeicao08P2;
    private javax.swing.JButton bRefeicao09P2;
    private javax.swing.JButton bRefeicao10P2;
    private javax.swing.JButton bSairP2;
    private javax.swing.JButton bSalvarP6;
    private javax.swing.JToggleButton bSalvarPRecADD;
    private javax.swing.JButton bSalvarPc;
    private javax.swing.JButton bSalvarPr1;
    private javax.swing.JButton bVoltarP2d;
    private javax.swing.JButton bVoltarP2e;
    private javax.swing.JButton bVoltarP3;
    private javax.swing.JButton bVoltarP4;
    private javax.swing.JButton bVoltarP5;
    private javax.swing.JButton bVoltarP6;
    private javax.swing.JButton bVoltarPRecADD;
    private javax.swing.JButton bVoltarRS;
    private javax.swing.JButton bd10P6;
    private javax.swing.JButton bd1P6;
    private javax.swing.JButton bd2P6;
    private javax.swing.JButton bd3P6;
    private javax.swing.JButton bd4P6;
    private javax.swing.JButton bd5P6;
    private javax.swing.JButton bd6P6;
    private javax.swing.JButton bd7P6;
    private javax.swing.JButton bd8P6;
    private javax.swing.JButton bd9P6;
    private javax.swing.JButton bdD10P4;
    private javax.swing.JButton bdD1P4;
    private javax.swing.JButton bdD2P4;
    private javax.swing.JButton bdD3P4;
    private javax.swing.JButton bdD4P4;
    private javax.swing.JButton bdD5P4;
    private javax.swing.JButton bdD6P4;
    private javax.swing.JButton bdD7P4;
    private javax.swing.JButton bdD8P4;
    private javax.swing.JButton bdD9P4;
    private javax.swing.JButton bdQ10P4;
    private javax.swing.JButton bdQ1P4;
    private javax.swing.JButton bdQ2P4;
    private javax.swing.JButton bdQ3P4;
    private javax.swing.JButton bdQ4P4;
    private javax.swing.JButton bdQ5P4;
    private javax.swing.JButton bdQ6P4;
    private javax.swing.JButton bdQ7P4;
    private javax.swing.JButton bdQ8P4;
    private javax.swing.JButton bdQ9P4;
    private javax.swing.JButton bdQu10P4;
    private javax.swing.JButton bdQu1P4;
    private javax.swing.JButton bdQu2P4;
    private javax.swing.JButton bdQu3P4;
    private javax.swing.JButton bdQu4P4;
    private javax.swing.JButton bdQu5P4;
    private javax.swing.JButton bdQu6P4;
    private javax.swing.JButton bdQu7P4;
    private javax.swing.JButton bdQu8P4;
    private javax.swing.JButton bdQu9P4;
    private javax.swing.JButton bdS10P4;
    private javax.swing.JButton bdS1P4;
    private javax.swing.JButton bdS2P4;
    private javax.swing.JButton bdS3P4;
    private javax.swing.JButton bdS4P4;
    private javax.swing.JButton bdS5P4;
    private javax.swing.JButton bdS6P4;
    private javax.swing.JButton bdS7P4;
    private javax.swing.JButton bdS8P4;
    private javax.swing.JButton bdS9P4;
    private javax.swing.JButton bdSa10P4;
    private javax.swing.JButton bdSa1P4;
    private javax.swing.JButton bdSa2P4;
    private javax.swing.JButton bdSa3P4;
    private javax.swing.JButton bdSa4P4;
    private javax.swing.JButton bdSa5P4;
    private javax.swing.JButton bdSa6P4;
    private javax.swing.JButton bdSa7P4;
    private javax.swing.JButton bdSa8P4;
    private javax.swing.JButton bdSa9P4;
    private javax.swing.JButton bdSe10P4;
    private javax.swing.JButton bdSe1P4;
    private javax.swing.JButton bdSe2P4;
    private javax.swing.JButton bdSe3P4;
    private javax.swing.JButton bdSe4P4;
    private javax.swing.JButton bdSe5P4;
    private javax.swing.JButton bdSe6P4;
    private javax.swing.JButton bdSe7P4;
    private javax.swing.JButton bdSe8P4;
    private javax.swing.JButton bdSe9P4;
    private javax.swing.JButton bdT10P4;
    private javax.swing.JButton bdT1P4;
    private javax.swing.JButton bdT2P4;
    private javax.swing.JButton bdT3P4;
    private javax.swing.JButton bdT4P4;
    private javax.swing.JButton bdT5P4;
    private javax.swing.JButton bdT6P4;
    private javax.swing.JButton bdT7P4;
    private javax.swing.JButton bdT8P4;
    private javax.swing.JButton bdT9P4;
    private javax.swing.JToggleButton btEDomP5;
    private javax.swing.JToggleButton btEQuarP5;
    private javax.swing.JToggleButton btEQuiP5;
    private javax.swing.JToggleButton btESabP5;
    private javax.swing.JToggleButton btESegP5;
    private javax.swing.JToggleButton btESexP5;
    private javax.swing.JToggleButton btETerP5;
    private javax.swing.JTextField diaSemanaP6;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lListaComidasPr1;
    private javax.swing.JFrame p2;
    private javax.swing.JFrame p2d;
    private javax.swing.JFrame p2e;
    private javax.swing.JFrame p3;
    private javax.swing.JFrame p4;
    private javax.swing.JFrame p5;
    private javax.swing.JFrame p6;
    private javax.swing.JFrame pRecADD;
    private javax.swing.JPanel panelBotoesP6;
    private javax.swing.JPanel panelDiaSemanaP2botoes;
    private javax.swing.JPanel panelDomingoP3;
    private javax.swing.JPanel panelDomingoP4;
    private javax.swing.JPanel panelDomingoP5;
    private javax.swing.JPanel panelQuartaP3;
    private javax.swing.JPanel panelQuartaP4;
    private javax.swing.JPanel panelQuartaP5;
    private javax.swing.JPanel panelQuintaP3;
    private javax.swing.JPanel panelQuintaP4;
    private javax.swing.JPanel panelQuintaP5;
    private javax.swing.JPanel panelSabadoP3;
    private javax.swing.JPanel panelSabadoP4;
    private javax.swing.JPanel panelSabadoP5;
    private javax.swing.JPanel panelSegundaP3;
    private javax.swing.JPanel panelSegundaP4;
    private javax.swing.JPanel panelSegundaP5;
    private javax.swing.JPanel panelSextaP3;
    private javax.swing.JPanel panelSextaP4;
    private javax.swing.JPanel panelSextaP5;
    private javax.swing.JPanel panelTercaP3;
    private javax.swing.JPanel panelTercaP4;
    private javax.swing.JPanel panelTercaP5;
    private javax.swing.JFrame pr1;
    private javax.swing.JFrame receitaS;
    private javax.swing.JScrollPane scrollPr1;
    private javax.swing.JScrollPane scrollpaneRS;
    private javax.swing.JTextArea txtCORPOTEXTOPRecADD;
    private javax.swing.JTextArea txtCorpoRecRS;
    private javax.swing.JTextField txtDiaSemanaP2;
    private javax.swing.JTextField txtEmailPc;
    private javax.swing.JTextField txtEspRS;
    private javax.swing.JTextField txtIdadePc;
    private javax.swing.JTextField txtMatRecPRecADD;
    private javax.swing.JTextField txtMatriculaPc;
    private javax.swing.JTextField txtNUP4;
    private javax.swing.JTextField txtNomePc;
    private javax.swing.JTextField txtNomeRefRS;
    private javax.swing.JTextField txtPesoPc;
    private javax.swing.JTextField txtPesquisaIngPr1;
    private javax.swing.JTextField txtRECEITAPRecADD;
    private javax.swing.JPasswordField txtSenhaP2;
    private javax.swing.JTextField txtSenhaPc;
    private javax.swing.JTextField txtUserP2;
    // End of variables declaration//GEN-END:variables
}
