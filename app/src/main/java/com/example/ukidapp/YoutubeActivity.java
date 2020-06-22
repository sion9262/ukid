package com.example.ukidapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.example.ukidapp.adapter.YoutubeVideoAdapter;
import com.example.ukidapp.api.Model.MoviesObject;
import com.example.ukidapp.model.YoutubeVideoModel;
import com.example.ukidapp.utils.RecyclerViewOnClickListener;

import java.util.ArrayList;


import com.example.ukidapp.api.Model.YoutubeModel;
import com.example.ukidapp.api.RetrofitSender;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YoutubeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    YoutubeModel movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        setUpRecyclerView();

        //populateRecyclerView();
        getYoutube();

    }

    /**
     * setup the recyclerview here
     */
    private void setUpRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /**
     * populate the recyclerview and implement the click event here
     */
    private void populateRecyclerView(ArrayList<YoutubeVideoModel> YoutubeModel) {
        final ArrayList<YoutubeVideoModel> youtubeVideoModelArrayList = YoutubeModel;
        YoutubeVideoAdapter adapter = new YoutubeVideoAdapter(this, youtubeVideoModelArrayList);
        recyclerView.setAdapter(adapter);

        //set click event
        recyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(this, new RecyclerViewOnClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //넘겨줘야할 데이터 : id, title, category
                //start youtube player activity by passing selected video id via intent
                startActivity(new Intent(YoutubeActivity.this, YoutubePlayerActivity.class)
                        .putExtra("video_id", youtubeVideoModelArrayList.get(position).getVideoId())
                        .putExtra("video_title", youtubeVideoModelArrayList.get(position).getTitle()));

            }
        }));
    }

    private void getYoutube(){
        // http 통신 시작
        RetrofitSender.getServer().movies().enqueue(new Callback<YoutubeModel>() {

            @Override
            public void onResponse(Call<YoutubeModel> call, Response<YoutubeModel> response) {
                if (response.isSuccessful()){
                    YoutubeModel result = response.body();
                    System.out.println(result.getMoviesObject());
                    MoviesObject[] datas = result.getMoviesObject();
                    try {
                        ArrayList<String> MovieIDs = new ArrayList<String>();
                        ArrayList<String> MovieTitle = new ArrayList<String>();
                        ArrayList<String> MovieCategory = new ArrayList<String>();
                        String[] videoIDArray = MovieIDs.toArray(new String[MovieIDs.size()]);

                        for (MoviesObject data : datas){
                            MovieIDs.add(data.getMovieId());
                            MovieTitle.add(data.getTitle());
                            MovieCategory.add(data.getCategory());
                        }
                        System.out.println(MovieTitle);

                        String[] IDs = MovieIDs.toArray(new String[MovieIDs.size()]);
                        //System.out.println(MovieIDs);
                        String[] Titles = MovieTitle.toArray(new String[MovieTitle.size()]);
                        System.out.println(Titles);
                        //System.out.println(MovieTitle);
                        ArrayList<YoutubeVideoModel> YoutubeModel = generateDummyVideoList(IDs, Titles);
                        populateRecyclerView(YoutubeModel);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else{
                    System.out.println("실패");
                }

            }
            @Override
            public void onFailure(Call<YoutubeModel> call, Throwable t) {
                System.out.println("서버 꺼짐");
            }
        });

    }

    /**
     * method to generate dummy array list of videos
     *
     * @return
     */
    private ArrayList<YoutubeVideoModel> generateDummyVideoList(String[] IDs, String[] Titles) {
        ArrayList<YoutubeVideoModel> youtubeVideoModelArrayList = new ArrayList<>();
        //get the video id array, title array and duration array from strings.xml
        //String[] videoIDArray = MovieIDs.toArray(new String[MovieIDs.size()]);

        //String[] videoDurationArray = getResources().getStringArray(R.array.video_duration_array);

        //loop through all items and add them to arraylist
        for (int i = 0; i < IDs.length; i++) {

            YoutubeVideoModel youtubeVideoModel = new YoutubeVideoModel();
            youtubeVideoModel.setVideoId(IDs[i]);
            youtubeVideoModel.setTitle(Titles[i]);
            //youtubeVideoModel.setDuration(videoDurationArray[i]);
            youtubeVideoModelArrayList.add(youtubeVideoModel);

        }

        return youtubeVideoModelArrayList;
    }
}
