
package dplan;

/**
 *
 * @author maria
 */
public class Receita {
    String ID;
    String NOMERECEITA;
    String CORPOTEX;
    String CLASSIF;
    
    
    public Receita(String ID, String NOMERECEITA, String CORPOTEX, String CLASSIF)
    {
        this.ID = ID;
        this.NOMERECEITA = NOMERECEITA;
        this.CORPOTEX = CORPOTEX;
        this.CLASSIF = CLASSIF;
        
    }
    
    public String getNOMERECEITA()
    {
        return NOMERECEITA;
    }
    
    public void setNOMERECEITA(String NOMERECEITA)
    {
        this.NOMERECEITA = NOMERECEITA;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCORPOTEX() {
        return CORPOTEX;
    }

    public void setCORPOTEX(String CORPOTEX) {
        this.CORPOTEX = CORPOTEX;
    }

    public String getCLASSIF() {
        return CLASSIF;
    }

    public void setCLASSIF(String CLASSIF) {
        this.CLASSIF = CLASSIF;
    }
    
}
