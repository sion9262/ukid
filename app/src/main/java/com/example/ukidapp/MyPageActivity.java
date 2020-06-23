package com.example.ukidapp;


import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.EventLogTags;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ukidapp.api.Model.MovieData;
import com.example.ukidapp.api.Model.PlayTime;
import com.example.ukidapp.api.RetrofitSender;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;


import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.*;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MyPageActivity extends AppCompatActivity {

    TextView userName;
    TextView userAge;
    ImageView img;
    PieChart pieChart;
    BarChart barChart;
    ListView listView;
    private ListView m_oListView = null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);


        pieChart = findViewById(R.id.piechart);
        barChart = findViewById(R.id.barchart);
        listView = (ListView) findViewById(R.id.listview);

        init();
        pichate();
        getPlayTime();


    }
    private void init(){
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
        userName = (TextView) findViewById(R.id.Name);
        userAge = (TextView) findViewById(R.id.Age);
        img = (ImageView)findViewById(R.id.MyImage);
        userName.setText("이름 : " + pref.getString("nickname", ""));
        userAge.setText("나이 : "+ pref.getString("age", "") + "세");
        String gender = pref.getString("gender", "여아");

        if(gender.equals("남아")){
            img.setImageResource(R.drawable.boy_profile2);
        }else if(gender.equals("여아")) {
            img.setImageResource(R.drawable.girl_profile);
        }
    }



    private void pichate(){

        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);

        String language = pref.getString("language", "0");
        String math = pref.getString("math", "0");
        String relationship = pref.getString("relationship", "0");
        String personal = pref.getString("personal", "0");
        String place = pref.getString("place", "0");
        String music = pref.getString("music", "0");
        String physical = pref.getString("physical", "0");
        String nature = pref.getString("nature", "0");
        ArrayList datas = new ArrayList();

        datas.add(new Entry(Float.parseFloat(language), 0));
        datas.add(new Entry(Float.parseFloat(math), 1));
        datas.add(new Entry(Float.parseFloat(relationship), 2));
        datas.add(new Entry(Float.parseFloat(personal), 3));
        datas.add(new Entry(Float.parseFloat(place), 4));
        datas.add(new Entry(Float.parseFloat(music), 5));
        datas.add(new Entry(Float.parseFloat(physical), 6));
        datas.add(new Entry(Float.parseFloat(nature), 7));
        PieDataSet dataSet = new PieDataSet(datas, "");

        ArrayList labels = new ArrayList();
        labels.add("언어지능");
        labels.add("논리수학지능");
        labels.add("대인관계지능");
        labels.add("자기성찰지능");
        labels.add("공간지능");
        labels.add("음악지능");
        labels.add("신체운동지능");
        labels.add("자연친화지능");

        PieData data = new PieData(labels, dataSet);
        pieChart.setData(data);
        dataSet.setValueTextSize(13);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setDescription(null);
        pieChart.animateXY(2000, 2000);

    }



    private void getPlayTime(){
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
        String id = pref.getString("id", "");
        System.out.println(id);
        RetrofitSender.getServer().playtime(id).enqueue(new Callback<PlayTime>() {
            @Override
            public void onResponse(Call<PlayTime> call, Response<PlayTime> response) {

                if (response.isSuccessful()){
                    PlayTime result = response.body();
                    System.out.println(Arrays.toString(result.getMovieData()) + "고고고곡고고고고고고");
                    if (result.getResultCode() == 200) {
                        System.out.println(Arrays.toString(result.getMovieData()) + "고고고곡고고고고고고");
                        MovieData[] datas = result.getMovieData();
                        ArrayList<String> MovieTitle = new ArrayList<String>();
                        ArrayList<String> MovieCategory = new ArrayList<String>();
                        ArrayList<String> PlayDate = new ArrayList<String>();
                        ArrayList<String> PlayTime = new ArrayList<String>();

                        for (MovieData data : datas) {
                            MovieCategory.add(data.getMovieCategory());
                            PlayTime.add(data.getPlayTime());
                            MovieTitle.add(data.getMovieTitle());
                            PlayDate.add(data.getPlayDate());
                        }

                        HashMap<String, Integer> duplicate_count = new HashMap<String, Integer>();
                        for (int i = 0 ; i < MovieCategory.size() ; i++){ // ArrayList 만큼 반복
                            String category = MovieCategory.get(i);
                            String[] dataCategory = category.split(", ");

                            for (int j=0; j<dataCategory.length; j++){
                                if (duplicate_count.containsKey(dataCategory[j])) { // HashMap 내부에 이미 key 값이 존재하는지 확인
                                    duplicate_count.put(dataCategory[j], duplicate_count.get(dataCategory[j])  + 1);  // key가 이미 있다면 value에 +1
                                } else { // key값이 존재하지 않으면
                                    duplicate_count.put(dataCategory[j] , 1); // key 값을 생성후 value를 1로 초기화
                                }
                            }

                        }
                        System.out.println(duplicate_count + "가나다라마바사");
                        System.out.println(duplicate_count.get("언어지능"));
                        System.out.println(duplicate_count.get("논리수학지능"));
                        System.out.println(duplicate_count.get("대인관계지능"));
                        System.out.println(duplicate_count.get("자기성찰지능"));
                        System.out.println(duplicate_count.get("공간지능"));
                        System.out.println(duplicate_count.get("음악지능"));
                        System.out.println(duplicate_count.get("신체운동지능"));
                        System.out.println(duplicate_count.get("자연친화지능"));

                        ArrayList bardata = new ArrayList();

                        if(duplicate_count.get("언어지능") == null){
                            float language = 0;
                            bardata.add(new BarEntry(language, 0));
                        }else{
                            float language = duplicate_count.get("언어지능");
                            bardata.add(new BarEntry(language, 0));
                        }
                        if(duplicate_count.get("논리수학지능") == null){
                            float math = 0;
                            bardata.add(new BarEntry(math, 1));
                        }else{
                            float math = duplicate_count.get("논리수학지능");
                            bardata.add(new BarEntry(math, 1));
                        }
                        if(duplicate_count.get("대인관계지능") == null){
                            float relationship = 0;
                            bardata.add(new BarEntry(relationship, 2));
                        }else{
                            float relationship = duplicate_count.get("대인관계지능");
                            bardata.add(new BarEntry(relationship, 2));
                        }

                        if(duplicate_count.get("자기성찰지능") == null){
                            float personel = 0;
                            bardata.add(new BarEntry(personel, 3));
                        }else{
                            float perosnel = duplicate_count.get("자기성찰지능");
                            bardata.add(new BarEntry(perosnel, 3));
                        }

                        if(duplicate_count.get("공간지능") == null){
                            float space = 0;
                            bardata.add(new BarEntry(space, 4));
                        }else{
                            float space = duplicate_count.get("공간지능");
                            bardata.add(new BarEntry(space, 4));
                        }

                        if(duplicate_count.get("음악지능") == null){
                            float music = 0;
                            bardata.add(new BarEntry(music, 5));
                        }else{
                            float music = duplicate_count.get("음악지능");
                            bardata.add(new BarEntry(music, 5));
                        }

                        if(duplicate_count.get("신체운동지능") == null){
                            float exercise = 0;
                            bardata.add(new BarEntry(exercise, 6));
                        }else{
                            float excercise = duplicate_count.get("언어지능");
                            bardata.add(new BarEntry(excercise, 6));
                        }

                        if(duplicate_count.get("자연친화지능") == null){
                            float nature = 0;
                            bardata.add(new BarEntry(nature, 7));
                        }else{
                            float nature = duplicate_count.get("자연친화지능");
                            bardata.add(new BarEntry(nature, 7));
                        }


                        BarDataSet dataSet = new BarDataSet(bardata, "다중지능");
                        dataSet.setValueTextSize(13);

                        ArrayList label = new ArrayList();
                        label.add("언어지능");
                        label.add("논리수학지능");
                        label.add("대인관계지능");
                        label.add("자기성찰지능");
                        label.add("공간지능");
                        label.add("음악지능");
                        label.add("신체운동지능");
                        label.add("자연친화지능");


                        BarData bardatas = new BarData(label,dataSet);
                        barChart.setData(bardatas);
                        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                        barChart.animateY(1000);
                        barChart.setDescription(null);


                        String[] Titles = MovieTitle.toArray(new String[MovieTitle.size()]);
                        String[] Dates = PlayDate.toArray(new String[PlayDate.size()]);
                        String[] Playtime = PlayTime.toArray(new String[PlayTime.size()]);
                        String[] Category = MovieCategory.toArray(new String[PlayTime.size()]);

                        /*
                        ArrayAdapter adapter = new ArrayAdapter(
                                getApplicationContext(), // 현재 화면의 제어권자
                                android.R.layout.simple_list_item_1,  //한행마다 보여줄 레이아웃을 지정
                                Titles); // 다량의 데이터

                        ListView lv = (ListView)findViewById(R.id.listview);
                        lv.setAdapter(adapter);
                        */
                        int nDatCnt=0;
                        ArrayList<ItemData> oData = new ArrayList<ItemData>();

                        /*
                        for (int i=0; i<Titles.length; ++i)
                        {
                            ItemData oItem = new ItemData();

                            oItem.strTitle = Titles[nDatCnt++];
                            //oItem.strDate = Dates[nDatCnt++];
                            oItem.strPlaytime = Playtime[nDatCnt++];
                            oData.add(oItem);
                            if (nDatCnt >= Titles.length) nDatCnt = 0;
                        }
                        */

                        for (int i=0; i<Titles.length; i++)
                        {
                            ItemData oItem = new ItemData();
                            oItem.strTitle = "제목 : " + Titles[i];
                            System.out.println(Titles[i]);
                            oItem.strDate = Dates[i];
                            System.out.println(Dates[i] + "가가가가가가가각가가가가가각가");
                            oItem.strPlaytime = "시청시간 : " + Playtime[i];
                            System.out.println(Playtime[i]);
                            oItem.strCategory = "카테고리 : " +Category[i];
                            oData.add(oItem);
                        }

                        //System.out.println(wData + "바바바바ㅏ바밥바ㅏ바바ㅏ바ㅏ바바ㅏ바밥바ㅏㅂ바바바");

                        m_oListView = (ListView)findViewById(R.id.listview);
                        ListAdapter oAdapter = new ListAdapter(oData);
                        m_oListView.setAdapter(oAdapter);
                        setListViewHeightBasedOnChildren(m_oListView);




                    }
                }else{
                    System.out.println(" 에러다다다다닫다ㅏ ");
                }

            }
            @Override
            public void onFailure(Call<PlayTime> call, Throwable t) {
                System.out.println("서버 꺼짐");
            }
        });
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = (ListAdapter) listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

}