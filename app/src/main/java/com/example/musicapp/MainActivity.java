package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonPlayClick;
    private Button buttonPauseClick;
    private Button buttonStopClick;

    MediaPlayer mediaPlayer;
    int pauseCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonPlayClick = findViewById(R.id.buttonPlay);

        buttonPauseClick = findViewById(R.id.buttonPause);

        buttonStopClick = findViewById(R.id.buttonStop);

        buttonPlayClick.setOnClickListener(this);
        buttonPauseClick.setOnClickListener(this);
        buttonStopClick.setOnClickListener(this);

        buttonPlayClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){

                    case R.id.buttonPlay:
                        if(mediaPlayer == null){
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.music);
                        mediaPlayer.start();}

                        else if (!mediaPlayer.isPlaying()){
                            mediaPlayer.seekTo(pauseCurrentPosition);
                            mediaPlayer.start();
                        }
                        break;

                    case R.id.buttonPause:
                        if(mediaPlayer != null){
                            mediaPlayer.pause();
                            pauseCurrentPosition = mediaPlayer.getCurrentPosition();

                        }
                        break;

                    case R.id.buttonStop:
                        if(mediaPlayer != null) {
                            mediaPlayer.stop();
                            mediaPlayer = null;
                        }
                        break;


                }

            }
        });

        buttonPauseClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonStopClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
