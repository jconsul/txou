package es.tta.txou;

import android.content.Intent;
import android.media.Image;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        cargarMenu();

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
    }

    //cargar pantalla del Menu
    public void cargarMenu()
    {
        //Título
        TextView titulo = (TextView) findViewById(R.id.tituloPagina);
        titulo.setText("Menua!");

        //Botones:

        //LinearLayout layoutBotones = (LinearLayout) findViewById(R.id.botonesMenu);

        ImageButton btn1 = (ImageButton) findViewById(R.id.botonesMenu1);
        btn1.setImageResource(R.drawable.juegos);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Primer boton", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton btn2 = (ImageButton) findViewById(R.id.botonesMenu2);
        btn2.setImageResource(R.drawable.comida);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Segundo boton", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton btn3 = (ImageButton) findViewById(R.id.botonesMenu3);
        btn3.setImageResource(R.drawable.medico);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Tercer boton", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton btn4 = (ImageButton) findViewById(R.id.botonesMenu4);
        btn4.setImageResource(R.drawable.ropa);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pantallaRopa(v);
            }
        });

        //Añadir imagen de Txou:
        ImageView image =(ImageView) findViewById(R.id.txouImagen);
        image.setImageResource(R.drawable.txou_normal);


    }
    public void pantallaRopa(View View)
    {
        //Título
        TextView titulo = (TextView) findViewById(R.id.tituloPagina);
        titulo.setText("Arropa");

        //Botones:

        //LinearLayout layoutBotones = (LinearLayout) findViewById(R.id.botonesMenu);


        ImageButton btn1 = (ImageButton) findViewById(R.id.botonesMenu1);
        btn1.setImageResource(R.drawable.guantes);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ElegirRopa.cambiarRopa(0);
                ImageView image =(ImageView) findViewById(R.id.txouImagen);
                image.setImageResource(ElegirRopa.elegirImagen());



            }
        });

        ImageButton btn2 = (ImageButton) findViewById(R.id.botonesMenu2);
        btn2.setImageResource(R.drawable.falda);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ElegirRopa.cambiarRopa(1);
                ImageView image =(ImageView) findViewById(R.id.txouImagen);
                image.setImageResource(ElegirRopa.elegirImagen());
            }
        });

        ImageButton btn3 = (ImageButton) findViewById(R.id.botonesMenu3);
        btn3.setImageResource(R.drawable.pantalon);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ElegirRopa.cambiarRopa(2);
                ImageView image =(ImageView) findViewById(R.id.txouImagen);
                image.setImageResource(ElegirRopa.elegirImagen());

            }
        });

        ImageButton btn4 = (ImageButton) findViewById(R.id.botonesMenu4);
        btn4.setImageResource(R.drawable.bufanda);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ElegirRopa.cambiarRopa(3);
                ImageView image =(ImageView) findViewById(R.id.txouImagen);
                image.setImageResource(ElegirRopa.elegirImagen());
            }
        });

    }

}
