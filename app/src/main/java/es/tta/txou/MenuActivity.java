package es.tta.txou;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import es.tta.txou.presentador.Egoera;
import es.tta.txou.presentador.ElegirRopa;
import es.tta.txou.vista.JokoakActivity;

public class MenuActivity extends AppCompatActivity {
    private MiTareaAsincrona tarea1;
    private int i;
    boolean a=true;
    private int fotoDeTxou=R.drawable.txou_normal;
    Egoera egoera= new Egoera();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tarea1 = new MiTareaAsincrona();// inicia el timer en el thread
        tarea1.execute();
        fotoDeTxou= ElegirRopa.elegirImagen();
        cargarMenu();
    }
    @Override
    public void onBackPressed() {
        tarea1.cancel(true);
        moveTaskToBack(true);
    }



    //cargar pantalla del Menu
    public void cargarMenu()
    {
        //Título
        TextView titulo = (TextView) findViewById(R.id.tituloPagina);
        titulo.setText("Menua");

        //Botones:
        ImageButton btn1 = (ImageButton) findViewById(R.id.botonesMenu1);
        btn1.setImageResource(R.drawable.juegos);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //a=false;
                egoera.resetAspertu();
                tarea1.cancel(true);
                Intent myIntent = new Intent(MenuActivity.this, JokoakActivity.class);
                MenuActivity.this.startActivity(myIntent);
            }
        });

        ImageButton btn2 = (ImageButton) findViewById(R.id.botonesMenu2);
        btn2.setImageResource(R.drawable.comida);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pantallaComida(v);
            }
        });

        ImageButton btn3 = (ImageButton) findViewById(R.id.botonesMenu3);
        btn3.setImageResource(R.drawable.medico);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pantallaMedico(v);
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
        image.setImageResource(fotoDeTxou);
        Button volver = (Button) findViewById(R.id.botonSalir);
        volver.setVisibility(android.view.View.INVISIBLE);
    }

    public void pantallaMedico(View View)
    {
        //Título
        TextView titulo = (TextView) findViewById(R.id.tituloPagina);
        titulo.setText("Medikua");

        //Botones:
        ImageButton btn1 = (ImageButton) findViewById(R.id.botonesMenu1);
        btn1.setImageResource(R.drawable.pirula);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egoera.resetMina();
            }
        });

        ImageButton btn2 = (ImageButton) findViewById(R.id.botonesMenu2);
        btn2.setImageResource(R.drawable.termometroa);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egoera.resetMina();
            }
        });

        ImageButton btn3 = (ImageButton) findViewById(R.id.botonesMenu3);
        btn3.setImageResource(R.drawable.kamomila);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egoera.resetMina();
            }
        });


        ImageButton btn4 = (ImageButton) findViewById(R.id.botonesMenu4);
        btn4.setImageResource(R.drawable.tirita);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egoera.resetMina();
            }
        });

        ImageView image =(ImageView) findViewById(R.id.txouImagen);
        image.setImageResource(fotoDeTxou);
        hacerVisible();

    }

    public void pantallaComida(View View)
    {
        //Título
        TextView titulo = (TextView) findViewById(R.id.tituloPagina);
        titulo.setText("Janaria");

        //Botones:
        ImageButton btn1 = (ImageButton) findViewById(R.id.botonesMenu1);
        btn1.setImageResource(R.drawable.leche);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egoera.resetGosea();
            }
        });

        ImageButton btn2 = (ImageButton) findViewById(R.id.botonesMenu2);
        btn2.setImageResource(R.drawable.carne);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egoera.resetGosea();
            }
        });

        ImageButton btn3 = (ImageButton) findViewById(R.id.botonesMenu3);
        btn3.setImageResource(R.drawable.manzana);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egoera.resetGosea();
            }
        });


        ImageButton btn4 = (ImageButton) findViewById(R.id.botonesMenu4);
        btn4.setImageResource(R.drawable.yogur);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egoera.resetGosea();
            }
        });

        //Imagen de Txou:
        ImageView image =(ImageView) findViewById(R.id.txouImagen);
        image.setImageResource(fotoDeTxou);
        hacerVisible();
    }


    public void pantallaRopa(View View)
    {
        //Título
        TextView titulo = (TextView) findViewById(R.id.tituloPagina);
        titulo.setText("Arropa");

        //Botones:
        ImageButton btn1 = (ImageButton) findViewById(R.id.botonesMenu1);
        btn1.setImageResource(R.drawable.guantes);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ElegirRopa.cambiarRopa(0);
                fotoDeTxou=ElegirRopa.elegirImagen();
                ImageView image =(ImageView) findViewById(R.id.txouImagen);
                image.setImageResource(fotoDeTxou);


            }
        });

        ImageButton btn2 = (ImageButton) findViewById(R.id.botonesMenu2);
        btn2.setImageResource(R.drawable.falda);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ElegirRopa.cambiarRopa(1);
                fotoDeTxou=ElegirRopa.elegirImagen();
                ImageView image =(ImageView) findViewById(R.id.txouImagen);
                image.setImageResource(fotoDeTxou);
            }
        });

        ImageButton btn3 = (ImageButton) findViewById(R.id.botonesMenu3);
        btn3.setImageResource(R.drawable.pantalon);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ElegirRopa.cambiarRopa(2);
                fotoDeTxou = ElegirRopa.elegirImagen();
                ImageView image = (ImageView) findViewById(R.id.txouImagen);
                image.setImageResource(fotoDeTxou);

            }
        });

        ImageButton btn4 = (ImageButton) findViewById(R.id.botonesMenu4);
        btn4.setImageResource(R.drawable.bufanda);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ElegirRopa.cambiarRopa(3);
                fotoDeTxou = ElegirRopa.elegirImagen();
                ImageView image = (ImageView) findViewById(R.id.txouImagen);
                image.setImageResource(fotoDeTxou);
            }
        });

        hacerVisible();
        //ImageView image =(ImageView) findViewById(R.id.txouImagen);
        //image.setImageResource(fotoDeTxou);

    }

    public void hacerVisible()
    {
        Button volver = (Button) findViewById(R.id.botonSalir);
        volver.setVisibility(android.view.View.VISIBLE);
        volver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cargarMenu();
            }
        });

    }

    private void tareaLarga()
    {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {e.printStackTrace();}
    }

    private class MiTareaAsincrona extends AsyncTask<Void, Integer, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {
            while(true) {
                tareaLarga();
                publishProgress(i);
                egoera.gehituEgoera();
                i++;
                if(isCancelled()){

                    break;
                }

            }
            return true;
        }
        @Override
        protected void onProgressUpdate(Integer... i) {
            ImageView minaI = (ImageView) findViewById(R.id.egoeraMina);
            ImageView goseaI = (ImageView) findViewById(R.id.egoeraGosea);
            ImageView aspertuI = (ImageView) findViewById(R.id.egoeraAspertu);
            if(egoera.getEgoera()[0])
                minaI.setVisibility(View.VISIBLE);
            else
                minaI.setVisibility(View.INVISIBLE);
            if(egoera.getEgoera()[1])
                goseaI.setVisibility(View.VISIBLE);
            else
                goseaI.setVisibility(View.INVISIBLE);
            if(egoera.getEgoera()[2])
                aspertuI.setVisibility(View.VISIBLE);
            else
                aspertuI.setVisibility(View.INVISIBLE);
        }
        @Override
        protected void onPreExecute() {

        }
        @Override
        protected void onPostExecute(Boolean result) {
           // if(result)
            //Toast.makeText(MenuActivity.this, "Tarea finalizada!", Toast.LENGTH_SHORT).show();

        }
        @Override
        protected void onCancelled() {
           // Toast.makeText(MenuActivity.this, "Tarea cancelada!", Toast.LENGTH_SHORT).show();

        }
    }

}
