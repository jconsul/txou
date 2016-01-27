package es.tta.txou.vista;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.tta.txou.R;
import es.tta.txou.modelo.Asmakizun;
import es.tta.txou.presentador.Data;

public class AsmakizunakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmakizunak);

        Data data = new Data();
        Asmakizun asmakizun = data.getAsmakizun();
        asmak1(asmakizun);


    }
    public void asmak1(final Asmakizun asmakizun){
        //Pregunta
        final TextView titulo = (TextView) findViewById(R.id.test_wording);
        titulo.setText(asmakizun.getWordingA1());
        final EditText text=(EditText)findViewById(R.id.erantzuna);
        Button hurrengoa= (Button)findViewById(R.id.buttonSiguiente);
        hurrengoa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                asmak2(asmakizun);

            }
        });
       Button bidali= (Button)findViewById(R.id.button_send_test);
        bidali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String erantzun=asmakizun.getErantzun1();
                String erantzuna=text.getText().toString();
                Toast.makeText(getApplicationContext(),erantzun,Toast.LENGTH_SHORT);
                if(erantzun.equalsIgnoreCase(erantzuna)){
                    Toast.makeText(getApplicationContext(),"Erantzun Zuzena",Toast.LENGTH_SHORT).show();
                    text.setBackgroundColor(Color.GREEN);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Erantzun Okerra",Toast.LENGTH_SHORT).show();
                    text.setBackgroundColor(Color.RED);
                }


            }
        });

    }
    public void asmak2(final Asmakizun asmakizun){
        //Pregunta
        TextView titulo = (TextView) findViewById(R.id.test_wording);
        titulo.setText(asmakizun.getWordingA2());
        Button hurrengoa= (Button)findViewById(R.id.buttonSiguiente);
        final EditText text=(EditText)findViewById(R.id.erantzuna);
        text.setText("");
        text.setBackgroundColor(Color.TRANSPARENT);
        hurrengoa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                asmak3(asmakizun);

            }
        });
        Button bidali= (Button)findViewById(R.id.button_send_test);
        bidali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String erantzun=asmakizun.getErantzun2();
                String erantzuna=text.getText().toString();
                Toast.makeText(getApplicationContext(), erantzun, Toast.LENGTH_SHORT);
                if(erantzun.equalsIgnoreCase(erantzuna)){
                    Toast.makeText(getApplicationContext(),"Erantzun Zuzena",Toast.LENGTH_SHORT).show();
                    text.setBackgroundColor(Color.GREEN);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Erantzun Okerra",Toast.LENGTH_SHORT).show();
                    text.setBackgroundColor(Color.RED);
                }


            }
        });
    }
    public void asmak3(final Asmakizun asmakizun){
        //Pregunta
        TextView titulo = (TextView) findViewById(R.id.test_wording);
        titulo.setText(asmakizun.getWordingA3());
        Button hurrengoa= (Button)findViewById(R.id.buttonSiguiente);
        final EditText text=(EditText)findViewById(R.id.erantzuna);
        text.setBackgroundColor(Color.TRANSPARENT);
        text.setText("");
        hurrengoa.setText("Irten");
        hurrengoa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(AsmakizunakActivity.this, JokoakActivity.class);
                AsmakizunakActivity.this.startActivity(myIntent);
            }
        });
        Button bidali= (Button)findViewById(R.id.button_send_test);
        bidali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String erantzun=asmakizun.getErantzun3();
                String erantzuna=text.getText().toString();
                Toast.makeText(getApplicationContext(), erantzun, Toast.LENGTH_SHORT);
                if(erantzun.equalsIgnoreCase(erantzuna)){
                    Toast.makeText(getApplicationContext(),"Erantzun Zuzena",Toast.LENGTH_SHORT).show();
                    text.setBackgroundColor(Color.GREEN);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Erantzun Okerra",Toast.LENGTH_SHORT).show();
                    text.setBackgroundColor(Color.RED);
                }


            }
        });
    }


}
