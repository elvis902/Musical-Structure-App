package com.example.musicalstructureapp;

public class MyMusicDetail {
    private String mSongName;
    private String mAuthorName;
    private int mReleaseYear;
    private String mProducer;

    public MyMusicDetail(String songName, String authorName, int releaseYear, String producer) {

        this.mSongName = songName;
        this.mAuthorName = authorName;
        this.mReleaseYear = releaseYear;
        this.mProducer = producer;

    }

    public String getmSongName() {
        return mSongName;
    }

    public String getmAuthorName() {
        return mAuthorName;
    }

    public int getmReleaseYear() {
        return mReleaseYear;
    }

    public String getmProdecer() {
        return mProducer;
    }

}


