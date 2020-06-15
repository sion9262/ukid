package com.example.ukidapp.api.Model;

public class MoviesObject
{
    private String movieId;

    private String title;

    private String category;

    public String getMovieId ()
    {
        return movieId;
    }

    public void setMovieId (String movieId)
    {
        this.movieId = movieId;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getCategory ()
{
    return category;
}

    public void setCategory (String category)
    {
        this.category = category;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [movieId = "+movieId+", title = "+title+", category = "+category+"]";
    }
}
