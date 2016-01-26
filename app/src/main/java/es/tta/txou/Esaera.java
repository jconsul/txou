package es.tta.txou;

import java.util.ArrayList;

/**
 * Created by jon on 25/01/16.
 */
public class Esaera {
    public String wording1;
    public ArrayList<Choice> choices1=new ArrayList<Choice>();
    public String wording2;
    public ArrayList<Choice> choices2=new ArrayList<Choice>();
    public String wording3;
    public ArrayList<Choice> choices3=new ArrayList<Choice>();
    public String getWording1(){
        return wording1;
    }
    public void setWording1 ( String wording){
        this.wording1=wording;
    }
    public ArrayList<Choice> getChoices1(){
        return choices1;
    }
    public void setChoices1( ArrayList<Choice> choices){
        this.choices1=choices;
    }

    public String getWording2(){
        return wording2;
    }
    public void setWording2 ( String wording){
        this.wording2=wording;
    }
    public ArrayList<Choice> getChoices2(){
        return choices2;
    }
    public void setChoices2( ArrayList<Choice> choices){
        this.choices2=choices;
    }

    public String getWording3(){
        return wording3;
    }
    public void setWording3 ( String wording){
        this.wording3=wording;
    }
    public ArrayList<Choice> getChoices3(){
        return choices3;
    }
    public void setChoices3( ArrayList<Choice> choices){
        this.choices3=choices;
    }
}
