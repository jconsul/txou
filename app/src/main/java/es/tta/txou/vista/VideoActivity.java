package es.tta.txou.vista;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.VideoView;

import es.tta.txou.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        showVideo();
    }

    public void showVideo(){
        VideoView video = new VideoView(this);
        //video.setVideoURI(Uri.parse("“rtsp://v4.cache3.c youtube.com/CjYLENy73wIaLQlW_ji2apr6AxMYDSANFEIJbXYtZ29vZ2xlSARSBXdhdGNoYOr_86Xm06e5UAw=/0/0/0/video.3gp"));
        video.setVideoURI(Uri.parse("http://techslides.com/demos/sample-videos/small.mp4"));
        ViewGroup.LayoutParams params =new ViewGroup.LayoutParams( ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        video.setLayoutParams(params);

        MediaController controller = new MediaController(this){
            @Override
            public void hide(){

            }
            @Override
            public boolean dispatchKeyEvent(KeyEvent event){
                if(event.getKeyCode() == KeyEvent.KEYCODE_BACK)
                    finish();
                return super.dispatchKeyEvent(event);
            }
        };
        controller.setAnchorView(video);
        video.setMediaController(controller);
        LinearLayout layout =(LinearLayout)findViewById(R.id.video);
        layout.addView(video);
        video.start();


    }

}
