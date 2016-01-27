package es.tta.txou.vista;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import es.tta.txou.R;
import es.tta.txou.modelo.Choice;
import es.tta.txou.modelo.Esaera;
import es.tta.txou.presentador.Data;

public class EsaerakActivity extends AppCompatActivity {
    int correct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esaerak);

        final Data data= new Data();
        //hio secundario
        new Thread() {
            @Override
            public void run() {
                try {
                    final Esaera esaera = data.getEsaera();
                    runOnUiThread(new Runnable() {
                            @Override
                                    public void run(){

                                esa1(esaera);
                            }

                    });

                } catch (Exception e) {
                    Log.e("Kontuz", e.getMessage(), e);
                }

            }
        }.start();





    }
    public void esa1(final Esaera esaera){
        //Pregunta
        TextView titulo = (TextView) findViewById(R.id.test_wording);
        titulo.setText(esaera.getWording1());
        RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
        int i=0;
        for(Choice choice : esaera.getChoices1()){
            RadioButton radio = new RadioButton(this);
            radio.setText(choice.getErantzuna());
            correct=choice.getZuzena();

            group.addView(radio);
        }
        Button bidali= (Button)findViewById(R.id.buttonBidali);
        bidali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
                int selectedId=group.getCheckedRadioButtonId();
                View radioButton= group.findViewById(selectedId);
                int selected = group.indexOfChild(radioButton);
                group.getChildAt(0).setBackgroundColor(Color.TRANSPARENT);
                group.getChildAt(1).setBackgroundColor(Color.TRANSPARENT);
                group.getChildAt(2).setBackgroundColor(Color.TRANSPARENT);
                if(selected!=correct){
                    group.getChildAt(selected).setBackgroundColor(Color.RED);
                    Toast.makeText(EsaerakActivity.this, "Erantzun Okerra", Toast.LENGTH_SHORT).show();
                }else{
                    group.getChildAt(selected).setBackgroundColor(Color.GREEN);
                    Toast.makeText(EsaerakActivity.this,"Erantzun Zuzena!", Toast.LENGTH_SHORT).show();
            }

            }
        });
        Button hurrengoa= (Button)findViewById(R.id.buttonSiguiente);
        hurrengoa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioGroup group = (RadioGroup) findViewById(R.id.test_choices);
                group.removeAllViews();

                esa2(esaera);

            }
        });

    }
    public void esa2(final Esaera esaera){
        //Pregunta
        TextView titulo = (TextView) findViewById(R.id.test_wording);
        titulo.setText(esaera.getWording2());
        RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
        int i=0;
        for(Choice choice : esaera.getChoices2()){
            RadioButton radio = new RadioButton(this);
            radio.setText(choice.getErantzuna());
            correct=choice.getZuzena();

            group.addView(radio);
        }
        Button bidali= (Button)findViewById(R.id.buttonBidali);
        bidali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
                int selectedId=group.getCheckedRadioButtonId();
                View radioButton= group.findViewById(selectedId);
                int selected = group.indexOfChild(radioButton);
                group.getChildAt(0).setBackgroundColor(Color.TRANSPARENT);
                group.getChildAt(1).setBackgroundColor(Color.TRANSPARENT);
                group.getChildAt(2).setBackgroundColor(Color.TRANSPARENT);
                if(selected!=correct){
                    group.getChildAt(selected).setBackgroundColor(Color.RED);
                    Toast.makeText(EsaerakActivity.this, "Erantzun Okerra", Toast.LENGTH_SHORT).show();
                }else{
                    group.getChildAt(selected).setBackgroundColor(Color.GREEN);
                    Toast.makeText(EsaerakActivity.this,"Erantzun Zuzena!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        Button hurrengoa= (Button)findViewById(R.id.buttonSiguiente);
        hurrengoa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
                group.removeAllViews();

                esa3(esaera);

            }
        });
    }
    public void esa3(Esaera esaera) {
        //Pregunta
        TextView titulo = (TextView) findViewById(R.id.test_wording);
        titulo.setText(esaera.getWording3());
        RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
        int i=0;
        for(Choice choice : esaera.getChoices3()){
            RadioButton radio = new RadioButton(this);
            radio.setText(choice.getErantzuna());
            correct=choice.getZuzena();

            group.addView(radio);
        }
        Button bidali= (Button)findViewById(R.id.buttonBidali);
        bidali.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioGroup group = (RadioGroup)findViewById(R.id.test_choices);
                int selectedId=group.getCheckedRadioButtonId();
                View radioButton= group.findViewById(selectedId);
                int selected = group.indexOfChild(radioButton);
                group.getChildAt(0).setBackgroundColor(Color.TRANSPARENT);
                group.getChildAt(1).setBackgroundColor(Color.TRANSPARENT);
                group.getChildAt(2).setBackgroundColor(Color.TRANSPARENT);
                if(selected!=correct){
                    group.getChildAt(selected).setBackgroundColor(Color.RED);
                    Toast.makeText(EsaerakActivity.this, "Erantzun Okerra",Toast.LENGTH_SHORT).show();
                }else{
                    group.getChildAt(selected).setBackgroundColor(Color.GREEN);
                    Toast.makeText(EsaerakActivity.this,"Erantzun Zuzena!",Toast.LENGTH_SHORT).show();
                }

            }
        });
        Button hurrengoa = (Button) findViewById(R.id.buttonSiguiente);
        hurrengoa.setText("Irten");
        hurrengoa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(EsaerakActivity.this, JokoakActivity.class);
                EsaerakActivity.this.startActivity(myIntent);


            }
        });
    }



}
