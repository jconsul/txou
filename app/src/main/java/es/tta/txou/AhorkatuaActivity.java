package es.tta.txou;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AhorkatuaActivity extends AppCompatActivity {

    String palabras[] = {"XAGU", "LAINO","EKIPOA", "EGUZKIA", "EURIA", "ZENBAKI"} ;
    public String palabra;
    public int fallos=0;
    public int aciertos=0;
    public int maxFallos=6;
    public String guiones="";
    public String esandakoLetrak="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorkatua);

        inicio(new View(this));
    }

    public void inicio(View v)
    {
        //inicializar valores:
        palabra="";
        fallos=0;
        maxFallos=6;
        esandakoLetrak="";
        guiones="";
        aciertos=0;
        String esandakoLetrak="";
        visualizarImagen();


        //elegimos una palabra:
        int n= (int) (Math.random()*5+1);
        palabra=palabras[n];

        //pintamos los guiones:
        for(int i=0;i<palabra.length();i++)
        {
            guiones=guiones+"_ ";
        }

        Toast.makeText(AhorkatuaActivity.this, palabra, Toast.LENGTH_SHORT).show();

        TextView t = (TextView) findViewById(R.id.palabra);
        t.setText(guiones);
        TextView t1 = (TextView) findViewById(R.id.esandakoLetrak);
        t1.setText("ESANDAKO LETRAK: ");
    }

    public void juego(View v)
    {
        String  letra= (String) v.getTag();
        String guiones1;

        //String boton="R.id.boton"+letra;
        //Toast.makeText(AhorkatuaActivity.this, boton, Toast.LENGTH_SHORT).show();
        //Toast.makeText(AhorkatuaActivity.this, "aa=%d"+Integer.parseInt(boton), Toast.LENGTH_SHORT).show();
        //Button b = (Button) findViewById(Integer.parseInt(boton));
        //b.setClickable(false);


        if (fallos==maxFallos)
        {
            Toast.makeText(AhorkatuaActivity.this, "PARTIDA AMAITU DUZU", Toast.LENGTH_SHORT).show();
        }
        else if (aciertos==palabra.length())
        Toast.makeText(AhorkatuaActivity.this, "ZORIONAK! ASMATU EGIN DUZU =)", Toast.LENGTH_SHORT).show();

        else if(esandakoLetrak.contains(letra) || guiones.contains(letra))
        {
            Toast.makeText(AhorkatuaActivity.this, "beste batekin saiatu", Toast.LENGTH_SHORT).show();

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
                TextView t1 = (TextView) findViewById(R.id.esandakoLetrak);
                esandakoLetrak = esandakoLetrak + "  " + letra;
                t1.setText("ESANDAKO LETRAK: " + esandakoLetrak);
                if (fallos == maxFallos) {
                    Toast.makeText(AhorkatuaActivity.this, "PARTIDA AMAITU DUZU", Toast.LENGTH_SHORT).show();
                }
            }
        }
        TextView t = (TextView) findViewById(R.id.palabra);
        t.setText(guiones);
        visualizarImagen();
        if (aciertos==palabra.length())
            Toast.makeText(AhorkatuaActivity.this, "ZORIIONAK! ASMATU EGIN DUZU =)", Toast.LENGTH_SHORT).show();

    }

    public void visualizarImagen() {

        ImageView image = (ImageView) findViewById(R.id.ahorcadoImagen);


        switch (fallos) {
            case 1://se ha fallado una vez.
                image.setImageResource(R.drawable.ahorcado2);
                break;
            case 2://se ha fallado una vez.
                image.setImageResource(R.drawable.ahorcado3);
                break;
            case 3://se ha fallado una vez.
                image.setImageResource(R.drawable.ahorcado4);
                break;
            case 4://se ha fallado una vez.
                image.setImageResource(R.drawable.ahorcado5);
                break;
            case 5://se ha fallado una vez.
                image.setImageResource(R.drawable.ahorcado6);
                break;
            case 6:
                image.setImageResource(R.drawable.ahorcado7);
                break;
        }
    }

    public void salir(View v)
    {
        Intent intent = new Intent(this,JokoakActivity.class);
        startActivity(intent);
    }



}
