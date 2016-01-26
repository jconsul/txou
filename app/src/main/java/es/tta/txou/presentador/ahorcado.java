package es.tta.txou.presentador;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

import es.tta.txou.R;

/**
 * Created by jone on 13/01/16.
 */
public class ahorcado
{
    private String palabras[] = {"XAGU", "LAINO","EKIPOA", "EGUZKIA", "EURIA", "ZENBAKI"} ;
    private String palabra;
    private int fallos=0;
    private int aciertos=0;
    private int maxFallos=6;
    private String guiones="";
    private String esandakoLetrak="";
    public int imagen;

    public String getGuiones()
    {
        return guiones;
    }

    public int getImagen()
    {
        return imagen;
    }

    public String getEsandakoLetrak()
    {
        return esandakoLetrak;
    }

    public void inicio()
    {
        //inicializar valores:
        palabra="";
        fallos=0;
        maxFallos=6;
        esandakoLetrak="";
        guiones="";
        aciertos=0;
        String esandakoLetrak="ESANDAKO LETRAK: ";
        //imagen=R.drawable.ahorcado1;
        elegirImagen();


        //elegimos una palabra:
        int n= (int) (Math.random()*5+1);
        palabra=palabras[n];

        //pintamos los guiones:
        for(int i=0;i<palabra.length();i++)
        {
            guiones=guiones+"_ ";
        }
    }

    public void elegirImagen() {


        switch (fallos) {
            case 0://se ha fallado una vez.
                imagen= R.drawable.ahorcado1;
                break;
            case 1://se ha fallado una vez.
                imagen= R.drawable.ahorcado2;
                break;
            case 2://se ha fallado una vez.
                imagen= R.drawable.ahorcado3;
                break;
            case 3://se ha fallado una vez.
                imagen= R.drawable.ahorcado4;
                break;
            case 4://se ha fallado una vez.
                imagen= R.drawable.ahorcado5;
                break;
            case 5://se ha fallado una vez.
                imagen= R.drawable.ahorcado6;
                break;
            case 6:
                imagen=R.drawable.ahorcado7;
                break;
        }

    }

    public String logicaJuego(String letra)
    {
        String guiones1;
        String vuelta=null;

        if (fallos==maxFallos)
        {
            vuelta="PARTIDA AMAITU DUZU";
        }
        else if (aciertos==palabra.length())
            vuelta="ZORIONAK! ASMATU EGIN DUZU =)";

        else if(esandakoLetrak.contains(letra) || guiones.contains(letra))
        {
            vuelta="beste batekin saiatu";
        }
        else
        {
            if (palabra.contains(letra)) {
                //ver donde está posicion
                int pos = palabra.indexOf(letra);
                guiones1 = "";

                if (guiones.charAt(2 * pos) == '_') {
                    guiones1 = guiones.substring(0, 2 * pos);
                    guiones1 = guiones1 + letra;
                    guiones1 = guiones1 + guiones.substring(2 * pos + 1, guiones.length());
                    guiones = guiones1;
                    aciertos++;
                }

            } else {
                fallos++;
                esandakoLetrak = esandakoLetrak + "  " + letra;

                if (fallos == maxFallos) {
                    vuelta="PARTIDA AMAITU DUZU";
                }
            }

            if (aciertos==palabra.length())
                vuelta="ZORIIONAK! ASMATU EGIN DUZU =)";

        }
        elegirImagen();
        return vuelta;
    }









}
