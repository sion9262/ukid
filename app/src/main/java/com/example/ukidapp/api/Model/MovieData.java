package com.example.ukidapp.api.Model;

import com.google.gson.annotations.Expose;

public class MovieData
{
    @Expose
    private String playDate;
    @Expose
    private String movieCategory;
    @Expose
    private String movieID;
    @Expose
    private String playTime;
    @Expose
    private String movieTitle;

    public String getPlayDate ()
    {
        return playDate;
    }

    public void setPlayDate (String playDate)
    {
        this.playDate = playDate;
    }

    public String getMovieCategory ()
    {
        return movieCategory;
    }

    public void setMovieCategory (String movieCategory)
    {
        this.movieCategory = movieCategory;
    }

    public String getMovieID ()
    {
        return movieID;
    }

    public void setMovieID (String movieID)
    {
        this.movieID = movieID;
    }

    public String getPlayTime ()
    {
        return playTime;
    }

    public void setPlayTime (String playTime)
    {
        this.playTime = playTime;
    }

    public String getMovieTitle ()
    {
        return movieTitle;
    }

    public void setMovieTitle (String movieTitle)
    {
        this.movieTitle = movieTitle;
    }



}