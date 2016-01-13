package es.tta.txou;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
=======
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
>>>>>>> origin/master

public class MenuActivity extends AppCompatActivity {
    private MiTareaAsincrona tarea1;
    private int gosea,aspertu,mina,i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tarea1 = new MiTareaAsincrona();// inicia el timer en el thread
        tarea1.execute();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public  void juegos(View view)
    {
        Intent intent=new Intent(this, Juegos.class);
        startActivity(intent);
    }

    public void comida(View view)
    {
        Intent intent=new Intent(this, Comida.class);
        startActivity(intent);

    }

    public void medico(View view)
    {
        Intent intent=new Intent(this, Medico.class);
        startActivity(intent);

    }

    public void ropa(View view)
    {
        Intent intent=new Intent(this, Ropa.class);
        startActivity(intent);

    }
    private void tareaLarga()
    {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {e.printStackTrace();}
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/
    private class MiTareaAsincrona extends AsyncTask<Void, Integer, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {
            while(true) {
                tareaLarga();
                publishProgress(i);
                i++;
                if(isCancelled()){
                    gosea=0;
                    aspertu=0;
                    mina=0;
                    break;
                }

            }
            return true;
        }
        @Override
        protected void onProgressUpdate(Integer... i) {
            gosea++;
            aspertu++;
            mina++;
            if(mina>10)
                Toast.makeText(MenuActivity.this, "Mina", Toast.LENGTH_SHORT).show();//activar imagen mina
            if(gosea>5)
                Toast.makeText(MenuActivity.this, "Gosea", Toast.LENGTH_SHORT).show();//activar imagen gosea
            if(aspertu>12)
                Toast.makeText(MenuActivity.this, "Aspertu", Toast.LENGTH_SHORT).show();//activar imagen aspertu

        }
        @Override
        protected void onPreExecute() {
            gosea=0;
            aspertu=0;
            mina=0;
            i=0;
        }
        @Override
        protected void onPostExecute(Boolean result) {
            if(result)
            Toast.makeText(MenuActivity.this, "Tarea finalizada!", Toast.LENGTH_SHORT).show();
            gosea=0;
            aspertu=0;
            mina=0;
            tarea1.cancel(true);
        }
        @Override
        protected void onCancelled() {
            Toast.makeText(MenuActivity.this, "Tarea cancelada!", Toast.LENGTH_SHORT).show();
            gosea=0;
            aspertu=0;
            mina=0;
            tarea1.cancel(true);
        }
    }

}
