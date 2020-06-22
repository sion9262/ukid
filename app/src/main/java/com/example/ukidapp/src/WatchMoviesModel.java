package com.example.ukidapp.src;

public class WatchMoviesModel {

    private String userID;
    private String movieID;
    private String movieTitle;
    private String movieCategory;
    private String watchTime;

    public WatchMoviesModel(String userID, String movieID, String movieCategory, String movieTitle, String watchTime){
        this.userID = userID;
        this.movieCategory = movieCategory;
        this.movieTitle = movieTitle;
        this.movieID = movieID;
        this.watchTime = watchTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public String getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(String watchTime) {
        this.watchTime = watchTime;
    }


}
