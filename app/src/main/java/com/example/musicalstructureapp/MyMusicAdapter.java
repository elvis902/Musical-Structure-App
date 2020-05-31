package com.example.musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyMusicAdapter extends ArrayAdapter<MyMusicDetail> {
    Context context2;
    public MyMusicAdapter(@NonNull Context context, @NonNull ArrayList<MyMusicDetail> objects) {
        super(context, 0, objects);
        this.context2 = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            MyMusicDetail currentMusicDetail = getItem(position);

            TextView musicName = (TextView)listItemView.findViewById(R.id.music_name);
            TextView authorName = (TextView)listItemView.findViewById(R.id.author_name);
          TextView tapToPlay = (TextView)listItemView.findViewById(R.id.tap_to_play);


            assert currentMusicDetail != null;
            musicName.setText(currentMusicDetail.getmSongName());
            authorName.setText("By "+currentMusicDetail.getmAuthorName()+"(Tap to play music)");
            tapToPlay.setText("Tap to Play");


        }

        return listItemView;
    }
}
