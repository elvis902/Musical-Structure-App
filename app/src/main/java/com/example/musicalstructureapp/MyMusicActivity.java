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
   public ArrayList<MyMusicDetail> myMusicDetails = new ArrayList<MyMusicDetail>();
   Button currentPlaying;
   int index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music);

        currentPlaying = (Button)findViewById(R.id.current_playing);

        myMusicDetails.add(new MyMusicDetail("SongName1","ByArtist1",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName2","ByArtist12",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName3","ByArtist13",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName4","ByArtist14",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName1","ByArtist1",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName2","ByArtist12",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName3","ByArtist13",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName4","ByArtist14",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName1","ByArtist1",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName2","ByArtist12",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName3","ByArtist13",2001,"Producer1"));
        myMusicDetails.add(new MyMusicDetail("SongName4","ByArtist14",2001,"Producer1"));

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
}
