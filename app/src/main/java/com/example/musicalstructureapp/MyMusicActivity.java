package com.example.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MyMusicActivity extends AppCompatActivity {
    ArrayList<MyMusicDetail> myMusicDetails = new ArrayList<MyMusicDetail>();
   Button currentPlaying;
   int index = -1;
   Button backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music);

        currentPlaying = (Button)findViewById(R.id.current_playing);
        backBtn = findViewById(R.id.back_btn);

        myMusicDetails.add(new MyMusicDetail("SongName1","Artist1",2015,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName2","Artist2",2015,"Producer2"));
        myMusicDetails.add(new MyMusicDetail("SongName3","Artist3",2015,"Producer3"));
        myMusicDetails.add(new MyMusicDetail("SongName4","Artist4",2016,"Producer4"));
        myMusicDetails.add(new MyMusicDetail("SongName5","Artist5",2017,"Producer5"));
        myMusicDetails.add(new MyMusicDetail("SongName6","Artist6",2018,"Producer6"));
        myMusicDetails.add(new MyMusicDetail("SongName7","Artist7",2019,"Producer7"));
        myMusicDetails.add(new MyMusicDetail("SongName8","Artist8",2019,"Producer8"));
        myMusicDetails.add(new MyMusicDetail("SongName9","Artist9",2019,"Producer9"));
        myMusicDetails.add(new MyMusicDetail("SongName10","Artist10",2019,"Producer10"));
        myMusicDetails.add(new MyMusicDetail("SongName11","Artist11",2020,"Producer11"));
        myMusicDetails.add(new MyMusicDetail("SongName12","Artist12",2020,"Producer12"));

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

                        Intent detail = new Intent(MyMusicActivity.this,DetailActivity.class);
                        detail.putExtras(extras);
                        myMusicList.getContext().startActivity(detail);

                    }
                }
            });

            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MyMusicActivity.this,MainActivity.class);
                    startActivity(i);
                }
            });



    }


}
