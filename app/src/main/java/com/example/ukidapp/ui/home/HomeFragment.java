package com.example.ukidapp.ui.home;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ukidapp.MainActivity;
import com.example.ukidapp.R;
import com.example.ukidapp.YoutubeActivity;
import com.example.ukidapp.YoutubePlayerActivity;
import com.example.ukidapp.adapter.YoutubeVideoAdapter;
import com.example.ukidapp.api.Model.MoviesObject;
import com.example.ukidapp.api.Model.ResultCode;
import com.example.ukidapp.api.Model.YoutubeModel;
import com.example.ukidapp.api.RetrofitSender;
import com.example.ukidapp.model.YoutubeVideoModel;
import com.example.ukidapp.src.PlayMovies;
import com.example.ukidapp.utils.RecyclerViewOnClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    private FloatingActionButton fab, fab1, fab2, fab3, fab4, fab5, fab6, fab7, fab8;
    private TextView fabText1, fabText2, fabText3, fabText4, fabText5, fabText6, fabText7, fabText8;
    private Animation fab_open, fab_close;
    private Context mContext;
    private boolean isFabOpen = false;

    View root;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        setUpRecyclerView();
        getYoutube();

        return root;
    }

    private void setUpRecyclerView() {
        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /**
     * populate the recyclerview and implement the click event here
     */
    private void populateRecyclerView(ArrayList<YoutubeVideoModel> YoutubeModel) {
        final ArrayList<YoutubeVideoModel> youtubeVideoModelArrayList = YoutubeModel;
        YoutubeVideoAdapter adapter = new YoutubeVideoAdapter(mContext, youtubeVideoModelArrayList);
        recyclerView.setAdapter(adapter);

        //set click event
        recyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(mContext, new RecyclerViewOnClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                //start youtube player activity by passing selected video id via intent
                startActivity(new Intent(mContext, YoutubePlayerActivity.class)
                        .putExtra("video_id", youtubeVideoModelArrayList.get(position).getVideoId())
                        .putExtra("video_title", youtubeVideoModelArrayList.get(position).getTitle())
                        .putExtra("video_category", youtubeVideoModelArrayList.get(position).getCategory()));

            }
        }));
    }

    private void getYoutube(){
        // http 통신 시작
        RetrofitSender.getServer().movies().enqueue(new Callback<YoutubeModel>() {

            @Override
            public void onResponse(Call<YoutubeModel> call, Response<YoutubeModel> response) {
                if (response.isSuccessful()) {
                    YoutubeModel result = response.body();
                    System.out.println(result.getMoviesObject());
                    MoviesObject[] datas = result.getMoviesObject();
                    try {
                        ArrayList<String> MovieIDs = new ArrayList<String>();
                        ArrayList<String> MovieTitle = new ArrayList<String>();
                        ArrayList<String> MovieCategory = new ArrayList<String>();
                        String[] videoIDArray = MovieIDs.toArray(new String[MovieIDs.size()]);

                        for (MoviesObject data : datas) {
                            MovieIDs.add(data.getMovieId());
                            MovieTitle.add(data.getTitle());
                            MovieCategory.add(data.getCategory());
                        }
                        System.out.println(MovieTitle);

                        String[] IDs = MovieIDs.toArray(new String[MovieIDs.size()]);
                        //System.out.println(MovieIDs);
                        String[] Titles = MovieTitle.toArray(new String[MovieTitle.size()]);
                        System.out.println(Titles);
                        String[] Category = MovieCategory.toArray(new String[MovieCategory.size()]);
                        //System.out.println(MovieTitle);
                        ArrayList<YoutubeVideoModel> YoutubeModel = generateDummyVideoList(IDs, Titles, Category);
                        populateRecyclerView(YoutubeModel);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.println("실패");
                }

            }

            @Override
            public void onFailure(Call<YoutubeModel> call, Throwable t) {
                System.out.println("서버 꺼짐");
            }
        });

    }
    private ArrayList<YoutubeVideoModel> generateDummyVideoList(String[] IDs, String[] Titles, String[] Category) {
        ArrayList<YoutubeVideoModel> youtubeVideoModelArrayList = new ArrayList<>();
        //get the video id array, title array and duration array from strings.xml
        //String[] videoIDArray = MovieIDs.toArray(new String[MovieIDs.size()]);

        //String[] videoDurationArray = getResources().getStringArray(R.array.video_duration_array);

        //loop through all items and add them to arraylist
        for (int i = 0; i < IDs.length; i++) {

            YoutubeVideoModel youtubeVideoModel = new YoutubeVideoModel();
            youtubeVideoModel.setVideoId(IDs[i]);
            youtubeVideoModel.setTitle(Titles[i]);
            youtubeVideoModel.setCategory(Category[i]);
            //youtubeVideoModel.setDuration(videoDurationArray[i]);
            youtubeVideoModelArrayList.add(youtubeVideoModel);

        }

        return youtubeVideoModelArrayList;
    }

    private void init() {
        mContext = getActivity();
        fab_open = AnimationUtils.loadAnimation(mContext, R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(mContext, R.anim.fab_close);

        fab = (FloatingActionButton) root.findViewById(R.id.fab);
        fab1 = (FloatingActionButton) root.findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) root.findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) root.findViewById(R.id.fab3);
        fab4 = (FloatingActionButton) root.findViewById(R.id.fab4);
        fab5 = (FloatingActionButton) root.findViewById(R.id.fab5);
        fab6 = (FloatingActionButton) root.findViewById(R.id.fab6);
        fab7 = (FloatingActionButton) root.findViewById(R.id.fab7);
        fab8 = (FloatingActionButton) root.findViewById(R.id.fab8);

        fabText1 = (TextView) root.findViewById(R.id.fabText1);
        fabText2 = (TextView) root.findViewById(R.id.fabText2);
        fabText3 = (TextView) root.findViewById(R.id.fabText3);
        fabText4 = (TextView) root.findViewById(R.id.fabText4);
        fabText5 = (TextView) root.findViewById(R.id.fabText5);
        fabText6 = (TextView) root.findViewById(R.id.fabText6);
        fabText7 = (TextView) root.findViewById(R.id.fabText7);
        fabText8 = (TextView) root.findViewById(R.id.fabText8);


        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);
        fab5.setOnClickListener(this);
        fab6.setOnClickListener(this);
        fab7.setOnClickListener(this);
        fab8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                toggleFab();
                break;
        }
        if (isFabOpen){
            fab.setImageResource(R.drawable.clear);
            recyclerView.setAlpha(0.3f);
        }
        else {
            fab.setImageResource(R.drawable.honeybee);
            recyclerView.setAlpha(1.0f);
        }
    }



    private void toggleFab() {
        if (isFabOpen) {

            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab4.startAnimation(fab_close);
            fab5.startAnimation(fab_close);
            fab6.startAnimation(fab_close);
            fab7.startAnimation(fab_close);
            fab8.startAnimation(fab_close);

            fabText1.startAnimation(fab_close);
            fabText2.startAnimation(fab_close);
            fabText3.startAnimation(fab_close);
            fabText4.startAnimation(fab_close);
            fabText5.startAnimation(fab_close);
            fabText6.startAnimation(fab_close);
            fabText7.startAnimation(fab_close);
            fabText8.startAnimation(fab_close);

            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            fab5.setClickable(false);
            fab6.setClickable(false);
            fab7.setClickable(false);
            fab8.setClickable(false);

            isFabOpen = false;


            /*Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setAlpha(0);
            ((CoordinatorLayout)root.findViewById(R.id.layout)).setBackgroundColor(paint.getColor());*/

        } else {


            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab4.startAnimation(fab_open);
            fab5.startAnimation(fab_open);
            fab6.startAnimation(fab_open);
            fab7.startAnimation(fab_open);
            fab8.startAnimation(fab_open);

            fabText1.startAnimation(fab_open);
            fabText2.startAnimation(fab_open);
            fabText3.startAnimation(fab_open);
            fabText4.startAnimation(fab_open);
            fabText5.startAnimation(fab_open);
            fabText6.startAnimation(fab_open);
            fabText7.startAnimation(fab_open);
            fabText8.startAnimation(fab_open);

            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);
            fab5.setClickable(true);
            fab6.setClickable(true);
            fab7.setClickable(true);
            fab8.setClickable(true);


            isFabOpen = true;

        }

    }


}