package com.example.myapplication.Domain;

public class ArtistApi {
    private String id;
    private String musicName;
    private String musicUrl;

    public ArtistApi(String id, String musicName, String musicUrl){
        this.id=id;
        this.musicName=musicName;
        this.musicUrl=musicUrl;
    }

    public String getId() {
        return id;
    }

    public String getMusicName() {
        return musicName;
    }

    public String getMusicUrl(){
        return musicUrl;
    }
    @Override
    public String toString() {
        return "ArtistApi{" +
                "id='" + id + '\'' +
                ", musicName='" + musicName + '\'' +
                ", musicUrl='" + musicUrl + '\'' +
                '}';
    }
}
