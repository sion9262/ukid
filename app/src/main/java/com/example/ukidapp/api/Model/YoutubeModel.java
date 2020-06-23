package com.example.ukidapp.api.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YoutubeModel {

    private MoviesObject[] moviesObject;

    private Integer resultCode;

    public MoviesObject[] getMoviesObject ()
    {
        return moviesObject;
    }

    public void setMoviesObject (MoviesObject[] moviesObject)
    {
        this.moviesObject = moviesObject;
    }

    public Integer getResultCode ()
    {
        return resultCode;
    }

    public void setResultCode (Integer resultCode)
    {
        this.resultCode = resultCode;
    }

    @Override
    public String toString()
    {
        return "[moviesObject = "+moviesObject+", resultCode = "+resultCode+"]";
    }


}


