package es.tta.txou;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class JokoakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokoak);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void esaerak(View view){
        Intent intent= new Intent(this, EsaerakActivity.class);
        startActivity(intent);
    }
    public void asmakizunak(View view){
        Intent intent= new Intent(this, AsmakizunakActivity.class);
        startActivity(intent);
    }
    public void ahorkatua(View view){
        Intent intent= new Intent(this, AhorkatuaActivity.class);
        startActivity(intent);
    }
    public void video(View view){
        Intent intent= new Intent(this, VideoActivity.class);
        startActivity(intent);
    }



}