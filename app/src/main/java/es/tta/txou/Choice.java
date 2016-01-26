package es.tta.txou;

/**
 * Created by jon on 15/01/16.
 */
public class Choice {
    private int id;
    private String erantzuna;
    private int zuzena;

    public Choice(int id, String erantzuna, int zuzena){
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
    public int getZuzena(){
        return zuzena;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setErantzuna(String erantzuna){
        this.erantzuna=erantzuna;
    }
    public void setZuzena(int zuzena){
        this.zuzena=zuzena;
    }
}
