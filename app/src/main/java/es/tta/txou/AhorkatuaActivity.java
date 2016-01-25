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

    String palabras[] = {"ZENBAKI", "LAINO","EKIPOA", "EGUZKIA", "EURIA", "XAGUA"} ;
    String dichas="";
    public String palabra;
    public int fallos=0;
    public int maxFallos=6;
    public int longitudPalabra;
    public String guiones="";
    public String guiones1="";
    public String esandakoLetrak="";
    //public char[] guiones=new char[30];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorkatua);

        inicio();
    }

    public void inicio()
    {
        //elegimos una palabra:
        int n= (int) (Math.random()*6+1);
        palabra=palabras[n];

        //pintamos los guiones:
        longitudPalabra=palabra.length();



        for(int i=0;i<longitudPalabra;i++)
        {
            guiones=guiones+"_ ";
        }

        Toast.makeText(AhorkatuaActivity.this, palabra, Toast.LENGTH_SHORT).show();

        TextView t = (TextView) findViewById(R.id.palabra);
        t.setText(guiones);
        TextView t1 = (TextView) findViewById(R.id.esandakoLetrak);
        t1.setText("ESANDAKO LETRAK: ");

        fallos=0;
    }

    public void juego(View v)
    {
        String  letra= (String) v.getTag();

        if(palabra.contains(letra))
        {
            //ver donde está posicion
            int pos = palabra.indexOf(letra);
            //cambiar en el array

            for(int i=0;i<guiones.length();i++)
            {
                if(i==2*pos && guiones.charAt(i)=='_')
                {
                    guiones1=guiones1+letra+" ";
                }
                else
                {
                    if(guiones.charAt(i)=='_')
                    {
                        guiones1=guiones1+"_ ";

                    }
                }
                guiones=guiones1;
                guiones1="";

            }

            //recargar los guiones
            TextView t = (TextView) findViewById(R.id.palabra);
            Toast.makeText(AhorkatuaActivity.this, "esta es la letra que coges: "+letra.charAt(0), Toast.LENGTH_SHORT).show();
            t.setText(guiones);
        }
        else
        {
            fallos++;
            TextView t1 = (TextView) findViewById(R.id.esandakoLetrak);
            esandakoLetrak=esandakoLetrak+", "+letra;
            t1.setText("ESANDAKO LETRAK: " + esandakoLetrak);
            if (fallos==maxFallos)
            {
                t1.setText("partida amaitu duzu.");
            }
        }

        visualizarImagen();

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
