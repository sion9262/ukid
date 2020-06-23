package com.example.ukidapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ukidapp.api.Model.AuthModel;
import com.example.ukidapp.api.Model.ResultCode;
import com.example.ukidapp.api.RetrofitSender;
import com.example.ukidapp.src.PlayMovies;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.example.ukidapp.R;
import com.example.ukidapp.utils.Constants;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sonu on 10/11/17.
 * <p>
 * ### Here you need to extend the activity with YouTubeBaseActivity otherwise it will crash the app  ###
 */

public class YoutubePlayerActivity extends YouTubeBaseActivity {
    private static final String TAG = YoutubePlayerActivity.class.getSimpleName();
    private String videoID;
    private String videoTitle;
    private String videoCategory;
    private long startTime;
    private long stopTime;
    private String playTime;
    private String playDate;
    private YouTubePlayerView youTubePlayerView;

    private SimpleDateFormat df;
    private SimpleDateFormat df_time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_player_activity);
        // 데이트 포맷을 정하기
        df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.KOREA);
        df_time = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
        //get the video id
        videoID = getIntent().getStringExtra("video_id");
        videoTitle = getIntent().getStringExtra("video_title");
        videoCategory = getIntent().getStringExtra("video_category");


        youTubePlayerView = findViewById(R.id.youtube_player_view);
        initializeYoutubePlayer();
    }
    /*
        activity start -> current time
        activity stop -> current time
        stop - start = active time
        then
            post active time, id, title, category
     */

    @Override
    protected void onStart() {
        super.onStart();
        // 비디오 시작시간 저장
        startTime = System.currentTimeMillis();
        Date date = new Date(startTime);
        playDate = df.format(date);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTime = System.currentTimeMillis();
        playTime = setTime((stopTime-startTime)/1000);
        System.out.println(stopTime);
        System.out.println(startTime);
        System.out.println(playTime);
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
        String id = pref.getString("id", "");

        if (id == "") {

        }else {
            if (videoCategory == null) { videoCategory = ""; }
            PlayMovies movies = new PlayMovies(id, videoID, videoTitle, videoCategory, playDate, playTime);
            SavePlayMovieData(movies);
        }

    }
    // millis -> 시간 분 초
    private String setTime(long time){

        String date = "";
        long min = 0;
        long hour = 0;
        long second = 0;

        hour = time / 3600;
        min = (time % 3600) / 60;
        second = (time % 3600) % 60;

        if (hour > 0) {
            date += hour + "시 ";
        }
        if (min > 0) {
            date += min + "분 ";
        }
        date += second + "초";
        return date;
    }

    private void SavePlayMovieData(PlayMovies movies){

        RetrofitSender.getServer().userplaymovie(movies).enqueue(new Callback<ResultCode>() {
            @Override
            public void onResponse(Call<ResultCode> call, Response<ResultCode> response) {
                if (response.isSuccessful()){
                    ResultCode result = response.body();
                    System.out.println(result.getResultCode());
                    if (result.getResultCode() == 200) {

                    }
                }

            }
            @Override
            public void onFailure(Call<ResultCode> call, Throwable t) {
                System.out.println("서버 꺼짐");
            }
        });
    }

    /**
     * initialize the youtube player
     */


    private void initializeYoutubePlayer() {
        youTubePlayerView.initialize(Constants.DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer,
                                                boolean wasRestored) {

                //if initialization success then load the video id to youtube player
                if (!wasRestored) {
                    //set the player style here: like CHROMELESS, MINIMAL, DEFAULT
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);

                    //load the video
                    youTubePlayer.loadVideo(videoID);

                    //OR

                    //cue the video
                    //youTubePlayer.cueVideo(videoID);

                    //if you want when activity start it should be in full screen uncomment below comment
                    //  youTubePlayer.setFullscreen(true);

                    //If you want the video should play automatically then uncomment below comment
                    //  youTubePlayer.play();

                    //If you want to control the full screen event you can uncomment the below code
                    //Tell the player you want to control the fullscreen change
                   /*player.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CUSTOM_LAYOUT);
                    //Tell the player how to control the change
                    player.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                        @Override
                        public void onFullscreen(boolean arg0) {
                            // do full screen stuff here, or don't.
                            Log.e(TAG,"Full screen mode");
                        }
                    });*/

                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                //print or show error if initialization failed
                Log.e(TAG, "Youtube Player View initialization failed");
            }
        });
    }

}