package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PodcastActivity extends AppCompatActivity {

    ArrayList<MyMusicDetail> myMusicDetails = new ArrayList<MyMusicDetail>();
    Button currentPlaying;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podcast);


        currentPlaying = (Button)findViewById(R.id.current_playing);
        Button backBtn = findViewById(R.id.back_btn);

        myMusicDetails.add(new MyMusicDetail("PodcastName1","Artist1",2015,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("PodcastName2","Artist2",2015,"Producer2"));
        myMusicDetails.add(new MyMusicDetail("PodcastName3","Artist3",2015,"Producer3"));
        myMusicDetails.add(new MyMusicDetail("PodcastName4","Artist4",2016,"Producer4"));
        myMusicDetails.add(new MyMusicDetail("PodcastName5","Artist5",2017,"Producer5"));
        myMusicDetails.add(new MyMusicDetail("PodcastName6","Artist6",2018,"Producer6"));
        myMusicDetails.add(new MyMusicDetail("PodcastName7","Artist7",2019,"Producer7"));
        myMusicDetails.add(new MyMusicDetail("PodcastName8","Artist8",2019,"Producer8"));
        myMusicDetails.add(new MyMusicDetail("PodcastName9","Artist9",2019,"Producer9"));
        myMusicDetails.add(new MyMusicDetail("PodcastName10","Artist10",2019,"Producer10"));
        myMusicDetails.add(new MyMusicDetail("PodcastName11","Artist11",2020,"Producer11"));
        myMusicDetails.add(new MyMusicDetail("PodcastName12","Artist12",2020,"Producer12"));

        MyMusicAdapter adapter = new MyMusicAdapter(this,myMusicDetails);
        final ListView myMusicList = (ListView)findViewById(R.id.list);
        myMusicList.setAdapter(adapter);
        myMusicList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                index = position;

                Bundle extras = new Bundle();
                extras.putString("SONG_NAME",myMusicDetails.get(position).getmSongName());
                extras.putString("AUTHOR_NAME",myMusicDetails.get(position).getmAuthorName());
                extras.putInt("YEAR", myMusicDetails.get(position).getmReleaseYear());
                extras.putString("PRODUCER_NAME",myMusicDetails.get(position).getmProdecer());

                Intent detail = new Intent(myMusicList.getContext(),DetailActivity.class);
                detail.putExtras(extras);
                myMusicList.getContext().startActivity(detail);
            }
        });



        currentPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index != -1)
                {
                    Bundle extras = new Bundle();
                    extras.putString("SONG_NAME",myMusicDetails.get(index).getmSongName());
                    extras.putString("AUTHOR_NAME",myMusicDetails.get(index).getmAuthorName());
                    extras.putInt("YEAR", myMusicDetails.get(index).getmReleaseYear());
                    extras.putString("PRODUCER_NAME",myMusicDetails.get(index).getmProdecer());

                    Intent detail = new Intent(PodcastActivity.this,DetailActivity.class);
                    detail.putExtras(extras);
                    myMusicList.getContext().startActivity(detail);

                }
            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PodcastActivity.this,MainActivity.class);
                startActivity(i);
            }
        });






    }
}
