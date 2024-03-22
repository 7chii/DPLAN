
package dplan;

public class Cliente {
    //private Integer ID;
    private String MAT;
    private String EMAIL;
    private String NOME;
    private String SENHA;
    private String IDADE;
    private String PESO;
    private String META;
    
    public Cliente(String MAT, String EMAIL, String NOME, String SENHA, String IDADE, String PESO, String META)
    {
        //this.ID = ID;
        this.MAT = MAT;
        this.EMAIL = EMAIL;
        this.NOME = NOME;
        this.SENHA = SENHA;
        this.IDADE = IDADE;
        this.PESO = PESO;
        this.META = META;
    }


    //public int getID() {
        //return ID;
    //}

    //public void setID(int ID) {
       // this.ID = ID;
    //}
    public String getMAT()
    {
        return MAT;
    }
    
    public void setMAT(String MAT)
    {
        this.MAT = MAT;
    }
    
    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getSENHA() {
        return SENHA;
    }

    public void setSENHA(String SENHA) {
        this.SENHA = SENHA;
    }

    public String getIDADE() {
        return IDADE;
    }

    public void setIDADE(String IDADE) {
        this.IDADE = IDADE;
    }

    public String getPESO() {
        return PESO;
    }

    public void setPESO(String PESO) {
        this.PESO = PESO;
    }

    public String getMETA() {
        return META;
    }

    public void setMETA(String META) {
        this.META = META;
    }
    
}
