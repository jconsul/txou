package es.tta.txou;

/**
 * Created by jon on 15/01/16.
 */
public class Choice {
    private int id;
    private String erantzuna;
    private boolean zuzena;

    public Choice(int id, String erantzuna, boolean zuzena){
        this.id=id;
        this.erantzuna=erantzuna;
        this.zuzena=zuzena;
    }
    public int getId(){
        return id;
    }
    public String getErantzuna(){
        return erantzuna;
    }
    public boolean getZuzena(){
        return zuzena;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setErantzuna(String erantzuna){
        this.erantzuna=erantzuna;
    }
    public void setZuzena(boolean zuzena){
        this.zuzena=zuzena;
    }
}
