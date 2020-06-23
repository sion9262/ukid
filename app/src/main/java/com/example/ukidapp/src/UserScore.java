package com.example.ukidapp.src;

import java.util.Comparator;

public class UserScore implements Comparable<UserScore>{
    private String category;
    private int score;



    public UserScore(String category, int score){
        this.category = category;
        this.score = score;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public int compareTo(UserScore o) {
        if (this.score < o.score){
            return -1;
        }else if (this.score == o.score){
            return 0;
        }else{
            return 1;
        }
    }
}
