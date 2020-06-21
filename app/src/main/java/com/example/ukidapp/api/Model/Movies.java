package com.example.ukidapp.api.Model;

public class Movies {
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
        return "ClassPojo [moviesObject = "+moviesObject+", resultCode = "+resultCode+"]";
    }
}
