package es.tta.txou.presentador;

/**
 * Created by jon on 26/01/16.
 */
public class Egoera {
    private static boolean[] egoera = {false,false,false};//mina,gosea,aspertu
    private static int mina=0,gosea=0,aspertu=0;

    public boolean[] getEgoera(){

        if(mina>15)
            egoera[0]=true;
        else
            egoera[0]=false;
        if(gosea>10)
            egoera[1]=true;
        else
            egoera[1]=false;
        if(aspertu>20)
            egoera[2]=true;
        else
            egoera[2]=false;

        return egoera;
    }
    public void gehituEgoera(){
        mina++;
        gosea++;
        aspertu++;
    }
    public void resetMina(){
        mina=0;
    }
    public void resetGosea(){
        gosea=0;
    }
    public void resetAspertu(){
        aspertu=0;
    }

}
