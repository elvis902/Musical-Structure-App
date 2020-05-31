package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView songName, authorName, releaseYear, producerName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        songName = (TextView)findViewById(R.id.songName);
        authorName = (TextView)findViewById(R.id.authorName);
        releaseYear = (TextView)findViewById(R.id.releaseYear);
        producerName = (TextView)findViewById(R.id.producerName);


        Intent intent = getIntent();
      Bundle extras = intent.getExtras();
        assert extras != null;
        final String songDetailName = extras.getString("SONG_NAME");
      String authorDetailName = extras.getString("AUTHOR_NAME");
      int year = extras.getInt("YEAR");
      String producerDetailName = extras.getString("PRODUCER_NAME");




     songName.setText("Name: "+songDetailName);
    authorName.setText("Artist: "+authorDetailName);
     releaseYear.setText("Release Date: "+String.valueOf(year));
     producerName.setText("Production: "+producerDetailName);








    }
}
