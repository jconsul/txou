package es.tta.txou.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import es.tta.txou.R;
import es.tta.txou.presentador.ahorcado;

public class AhorkatuaActivity extends AppCompatActivity {

    ahorcado a=new ahorcado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorkatua);

        inicio(new View(this));
    }

    public void inicio(View v)
    {
        a.inicio();
        //visualizar primera imagen
        ImageView image = (ImageView) findViewById(R.id.ahorcadoImagen);
        image.setImageResource(a.getImagen());

        //visualizar guiones
        TextView t = (TextView) findViewById(R.id.palabra);
        t.setText(a.getGuiones());

        //visualizar esandako letrak
        TextView t1 = (TextView) findViewById(R.id.esandakoLetrak);
        t1.setText(a.getEsandakoLetrak());
    }

    public void juego(View v)
    {
        String  letra= (String) v.getTag();

        if(a.logicaJuego(letra)!=null)
            Toast.makeText(AhorkatuaActivity.this, a.logicaJuego(letra), Toast.LENGTH_SHORT).show();

        //actualizamos los guiones
        TextView t = (TextView) findViewById(R.id.palabra);
        t.setText(a.getGuiones());
        //actualizamos las letras ya dichas
        TextView t1 = (TextView) findViewById(R.id.esandakoLetrak);
        t1.setText(a.getEsandakoLetrak());
        //actualizamos la imagen
        ImageView image = (ImageView) findViewById(R.id.ahorcadoImagen);
        image.setImageResource(a.getImagen());
    }



    public void salir(View v)
    {
        Intent intent = new Intent(this,JokoakActivity.class);
        startActivity(intent);
    }



}
