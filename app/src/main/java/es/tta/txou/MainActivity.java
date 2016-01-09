package es.tta.txou;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.print.PrintHelper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void entrar(View view)
    {
        //Quitar el botón:
        LinearLayout layout = (LinearLayout)findViewById(R.id.inicio);
        layout.removeView(findViewById(R.id.botonEntrar));

        //añadir saludo
        TextView text= (TextView)findViewById(R.id.agurra);
        text.setText("Kaixo ni Txou naiz");

        //Dibujar Txou:
        ImageView imagen=(ImageView)findViewById(R.id.txou_normal);
        imagen.setVisibility(View.VISIBLE);

        Button btn = (Button)findViewById(R.id.button_jarraitu);
        btn.setVisibility(View.VISIBLE);


        /*ImageView txouIrudia = (ImageView)findViewById(R.id.txou_normal);

        String myJpgPath = "/drawable://txou.jpg"; //UPDATE WITH YOUR OWN JPG FILE
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap bm = BitmapFactory.decodeFile(myJpgPath, options);
        txouIrudia.setImageBitmap(bm);
*/

    }
    public void irAMenu(View view)
    {
        Intent intent = new Intent(this,MenuActivity.class);
        startActivity(intent);
    }


}
