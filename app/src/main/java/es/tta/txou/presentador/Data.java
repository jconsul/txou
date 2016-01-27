package es.tta.txou.presentador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import es.tta.txou.modelo.Choice;
import es.tta.txou.modelo.RestClient;
import es.tta.txou.modelo.Test;
import es.tta.txou.modelo.Asmakizun;
import es.tta.txou.modelo.Esaera;

/**
 * Created by jon on 24/01/16.
 */
public class Data {
        public Asmakizun getAsmakizun() {
            Asmakizun asmakizun = new Asmakizun();
            asmakizun.setWordingA1("ZORI ZORIA, BETI HEGAKA, EHIZTARIA ETORTZEA BETI PRESAKA NOR NAIZ?");
            asmakizun.setWordingA2("BETI DAGO ZUTIK ETA EZ DAKI IBILTZEN. HIRU BEGI DITU, AUTOAK GIDATZEN. GORRI, BERDE, HORI, ZUK ASMATU HORI");
            asmakizun.setWordingA3("BERE AITA OILARRA, BERE AMA OILOA ETA BERA HAUEN UMEA.ZER DA?");
            asmakizun.setErantzun1("USOA");
            asmakizun.setErantzun2("SEMAFOROA");
            asmakizun.setErantzun3("TXITA");

            return asmakizun;
        }
    public Esaera getEsaera(){
       Esaera esaera= new Esaera();
       try {
            Test test = new Test();
           // Esaera esaera= new Esaera();
            RestClient restClient= new RestClient("http://u017633.ehu.eus:18080/TxouServer/rest/Txou");
            JSONObject json = new JSONObject(restClient.getString("requestGalderak"));
            JSONArray array = json.getJSONArray("galdera");
            for(int i=0;i<array.length();i++){
                JSONObject item= array.getJSONObject(i);
                switch(i){
                    case 0:
                        esaera.setWording1(item.getString("enuntziatua"));
                        break;
                    case 1:
                        esaera.setWording2(item.getString("enuntziatua"));
                        break;
                    case 2:
                        esaera.setWording3(item.getString("enuntziatua"));
                }
            }
        }catch (JSONException e){
            return null;} catch (IOException e) {
            e.printStackTrace();
        }
        try {
            RestClient restClient= new RestClient("http://u017633.ehu.eus:18080/TxouServer/rest/Txou");
            JSONObject jsonE = new JSONObject(restClient.getString("requestErantzunak"));
            JSONArray arrayE = jsonE.getJSONArray("erantzuna");
            for (int i = 0; i < arrayE.length(); i++) {
                JSONObject item = arrayE.getJSONObject(i);
                switch (i) {
                    case 0:
                        ArrayList<Choice> choices1 = new ArrayList<Choice>();
                        for (int j = 0; j < 3; j++) {
                            switch (j) {
                                case 0:
                                    Choice choice = new Choice(j, item.getString("erantzuna1"), item.getInt("zuzena"));
                                    choices1.add(choice);
                                    break;
                                case 1:
                                    Choice choice2 = new Choice(j, item.getString("erantzuna2"), item.getInt("zuzena"));
                                    choices1.add(choice2);
                                    break;
                                case 2:
                                    Choice choice3 = new Choice(j, item.getString("erantzuna3"), item.getInt("zuzena"));
                                    choices1.add(choice3);
                                    break;
                            }
                        }
                        esaera.setChoices1(choices1);
                        break;
                    case 1:
                        ArrayList<Choice> choices2 = new ArrayList<Choice>();
                        for (int j = 0; j < 3; j++) {
                            switch (j) {
                                case 0:
                                    Choice choice = new Choice(j, item.getString("erantzuna1"), item.getInt("zuzena"));
                                    choices2.add(choice);
                                    break;
                                case 1:
                                    Choice choice2 = new Choice(j, item.getString("erantzuna2"), item.getInt("zuzena"));
                                    choices2.add(choice2);
                                    break;
                                case 2:
                                    Choice choice3 = new Choice(j, item.getString("erantzuna3"), item.getInt("zuzena"));
                                    choices2.add(choice3);
                                    break;
                            }
                        }
                        esaera.setChoices2(choices2);
                        break;
                    case 2:
                        ArrayList<Choice> choices3 = new ArrayList<Choice>();
                        for (int j = 0; j < 3; j++) {
                            switch (j) {
                                case 0:
                                    Choice choice = new Choice(j, item.getString("erantzuna1"), item.getInt("zuzena"));
                                    choices3.add(choice);
                                    break;
                                case 1:
                                    Choice choice2 = new Choice(j, item.getString("erantzuna2"), item.getInt("zuzena"));
                                    choices3.add(choice2);
                                    break;
                                case 2:
                                    Choice choice3 = new Choice(j, item.getString("erantzuna3"), item.getInt("zuzena"));
                                    choices3.add(choice3);
                                    break;
                            }
                        }
                        esaera.setChoices3(choices3);
                }
            }
            //return esaera;

        }catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return esaera;
    }

}
