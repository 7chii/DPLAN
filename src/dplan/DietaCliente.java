
package dplan;

/**
 *
 * @author maria
 */
public class DietaCliente {
    private String MAT;
    private String SEG;
    private String TER;
    private String QUA;
    private String QUI;
    private String SEX;
    private String SAB;
    private String DOM;
    
    public DietaCliente(String MAT, String SEG, String TER, String QUA, String QUI, String SEX, String SAB, String DOM)
    {
    this.MAT = MAT;
    this.SEG = SEG;
    this.TER = TER;
    this.QUA = QUA;
    this.QUI = QUI;
    this.SEX = SEX;
    this.SAB = SAB;
    this.DOM = DOM;
    
    }

    public String getMAT() {
        return MAT;
    }

    public void setMAT(String MAT) {
        this.MAT = MAT;
    }

    public String getSEG() {
        return SEG;
    }

    public void setSEG(String SEG) {
        this.SEG = SEG;
    }

    public String getTER() {
        return TER;
    }

    public void setTER(String TER) {
        this.TER = TER;
    }

    public String getQUA() {
        return QUA;
    }

    public void setQUA(String QUA) {
        this.QUA = QUA;
    }

    public String getQUI() {
        return QUI;
    }

    public void setQUI(String QUI) {
        this.QUI = QUI;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public String getSAB() {
        return SAB;
    }

    public void setSAB(String SAB) {
        this.SAB = SAB;
    }

    public String getDOM() {
        return DOM;
    }

    public void setDOM(String DOM) {
        this.DOM = DOM;
    }
    
}
