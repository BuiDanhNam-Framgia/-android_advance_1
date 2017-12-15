package com.example.buidanhnam.retrofit.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bui Danh Nam on 15/12/2017.
 */

public class Movie  {
    @SerializedName("title")
    private String title ;
    @SerializedName("id")
    private int id ;
    @SerializedName("video")
    private boolean video ;
    @SerializedName("id")
    private List<Integer> genreIds = new ArrayList<Integer>();

    public Movie(String title, int id, boolean video, List<Integer> genreIds) {
        this.title = title;
        this.id = id;
        this.video = video;
        this.genreIds = genreIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }
}
