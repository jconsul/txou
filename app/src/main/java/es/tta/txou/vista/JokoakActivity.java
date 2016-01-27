package es.tta.txou.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import es.tta.txou.R;

public class JokoakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokoak);


    }

    public void irAMenu(View view)
    {
        Intent intent= new Intent(this, MenuActivity.class);
        startActivity(intent);

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
