package com.example.ukidapp.api.Model;

import com.google.gson.annotations.Expose;

public class PlayTime {

    private String movieCount;

    private Integer resultCode;

    private MovieData[] movieData;

    public String getMovieCount ()
    {
        return movieCount;
    }

    public void setMovieCount (String movieCount)
    {
        this.movieCount = movieCount;
    }

    public Integer getResultCode ()
    {
        return resultCode;
    }

    public void setResultCode (Integer resultCode)
    {
        this.resultCode = resultCode;
    }

    public MovieData[] getMovieData ()
    {
        return movieData;
    }

    public void setMovieData (MovieData[] movieData)
    {
        this.movieData = movieData;
    }



}


