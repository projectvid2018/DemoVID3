package com.example.gmmha.demovid3;

public class Artist {

    String artistName;
    String artistId;

    public Artist() {


    }

    public Artist(String artistName, String artistId) {
        this.artistName = artistName;
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistId() {
        return artistId;
    }
}
