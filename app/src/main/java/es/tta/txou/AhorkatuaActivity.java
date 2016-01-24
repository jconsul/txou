package es.tta.txou;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AhorkatuaActivity extends AppCompatActivity {

    String palabras[] = {"ERREKA", "LAINOA","ETXEA", "EGUZKIA", "EURIA", "TXAKURRA"} ;
    String dichas="";
    public String palabra;
    public int fallos=0;
    public int maxFallos=6;
    public int longitudPalabra;
    //public String guiones="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorkatua);

        inicio();
    }

    public void inicio()
    {
        //elegimos una palabra:
       // int n= (int) (Math.random()*6+1);
        //palabra=palabras[n];
        palabra="AMIGO";
        //pintamos los guiones:
        longitudPalabra=palabra.length();


        String guiones="";
        for(int i=0;i<longitudPalabra;i++)
        {
            guiones=guiones+"_ ";

        }
        TextView t = (TextView) findViewById(R.id.palabra);
        t.setText(guiones);
        fallos=0;
    }

    public void juego(View v)
    {
        String letra="A";
        if(palabra.contains(letra))
        {
            //ver donde está posicion
            int pos = palabra.indexOf(letra);
            //cambiar en el array

            //recargar los guiones
            TextView t = (TextView) findViewById(R.id.palabra);
        }
        else
            fallos++;

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
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }



}
