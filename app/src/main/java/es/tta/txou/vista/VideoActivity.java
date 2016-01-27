package es.tta.txou.vista;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import es.tta.txou.R;

public class VideoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        String frameVideo = "<html><body><iframe width=\"320\" height=\"515\" src=\"https://www.youtube.com/embed/AaOsfA-yzyg?feature=player_detailpage\" frameborder=\"0\" allowfullscreen></iframe></body></html>";//<html><body>Youtube video .. <br> <iframe width=\"320\" height=\"315\" src=\"https://www.youtube.com/embed/lY2H2ZP56K4\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        WebView displayVideo = (WebView)findViewById(R.id.webView);
        displayVideo.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = displayVideo.getSettings();
        webSettings.setJavaScriptEnabled(true);
        displayVideo.loadData(frameVideo, "text/html", "utf-8");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
