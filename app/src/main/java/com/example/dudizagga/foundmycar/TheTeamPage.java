package com.example.dudizagga.foundmycar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class TheTeamPage extends AppCompatActivity {
VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_team_page);
        videoView=(VideoView)findViewById(R.id.video);

        videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.powerful_tmospheric);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        videoView.start();

    }
}
