package com.example.ukidapp.src;

public class PlayMovies {
    private String user;
    private String movieID;
    private String movieTitle;
    private String movieCategory;
    private String playDate;
    private String playTime;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setmovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getPlayDate() {
        return playDate;
    }

    public void setPlayDate(String playDate) {
        this.playDate = playDate;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public PlayMovies(String userID, String movieID, String title, String category, String playDate, String playTime){
        this.user = userID;
        this.movieID = movieID;
        this.movieTitle = title;
        this.movieCategory = category;
        this.playDate = playDate;
        this.playTime = playTime;
    }
}
