
package dplan;

/**
 *
 * @author maria
 */
public class ContarEntradas {
    private int CONTADAS;
    private String NOMES;
    
    public ContarEntradas( int CONTADAS, String NOMES)
    {
        this.CONTADAS = CONTADAS;
        this.NOMES = NOMES;
        
    }
    
    public String getNOMES()
    {
        return NOMES;
    }
    public void setNOMES(String NOMES)
    {
        this.NOMES = NOMES;
    }
    
    public int getCONTADAS() {
        return CONTADAS;
    }

    public void setCONTADAS(int CONTADAS) {
        this.CONTADAS = CONTADAS;
    }
    
}
