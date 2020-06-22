package com.example.ukidapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.ukidapp.api.Model.AuthModel;
import com.example.ukidapp.api.Model.SetUser;
import com.example.ukidapp.api.RetrofitSender;
import com.example.ukidapp.src.WatchMoviesModel;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.example.ukidapp.R;
import com.example.ukidapp.utils.Constants;

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
    private YouTubePlayerView youTubePlayerView;

    long activity_start;
    long activity_stop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube_player_activity);
        //get the video id, title, category
        videoID = getIntent().getStringExtra("video_id");
        videoTitle = getIntent().getStringExtra("video_title");
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
        activity_start = System.currentTimeMillis();
    }

    @Override
    protected void onStop() {
        super.onStop();
        activity_stop = System.currentTimeMillis();
        long active_time = (long)((activity_stop-activity_start)/1000.0);
        System.out.println(active_time);
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
        String userID = pref.getString("id", "");
        WatchMoviesModel model = new WatchMoviesModel(userID, videoTitle, "", videoID, String.valueOf(active_time));


        PostWatchMovie(model);
    }

    private void PostWatchMovie(WatchMoviesModel model){
        // http 통신 시작
        RetrofitSender.getServer().watchMovies(model).enqueue(new Callback<SetUser>() {
            @Override
            public void onResponse(Call<SetUser> call, Response<SetUser> response) {
                if (response.isSuccessful()){
                    SetUser result = response.body();
                    System.out.println(result.getResultCode());
                    if (result.getResultCode() == 200) {

                        try {


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }else{
                    System.out.println("실패");
                }
            }
            @Override
            public void onFailure(Call<SetUser> call, Throwable t) {
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