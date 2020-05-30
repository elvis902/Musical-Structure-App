package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button myMusic , podcast, playMusicOnline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myMusic = (Button)findViewById(R.id.btn_my_music);
        podcast = (Button)findViewById(R.id.btn_podcast);
        playMusicOnline = (Button)findViewById(R.id.btn_play_music_online);

        myMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musicIntent = new Intent(MainActivity.this,MyMusicActivity.class);
                startActivity(musicIntent);
            }
        });

        podcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent podcastIntent = new Intent(MainActivity.this,PodcastActivity.class);
                startActivity(podcastIntent);
            }
        });


        playMusicOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent onlineMusicIntent = new Intent(MainActivity.this,PlayMusicOnlineActivity.class);
                startActivity(onlineMusicIntent);
            }
        });
    }
}
