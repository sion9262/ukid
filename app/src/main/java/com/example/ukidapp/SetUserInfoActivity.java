package com.example.ukidapp;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ukidapp.api.Model.ResultCode;
import com.example.ukidapp.api.RetrofitSender;
import com.example.ukidapp.src.SetUpDataManager;
import com.example.ukidapp.ui.UserSetUp.MathFragment;
import com.example.ukidapp.ui.UserSetUp.MusicFragment;
import com.example.ukidapp.ui.UserSetUp.PersonalFragment;
import com.example.ukidapp.ui.UserSetUp.PhysicalFragment;
import com.example.ukidapp.ui.UserSetUp.PlaceFragment;
import com.example.ukidapp.ui.UserSetUp.RelationshipFragment;
import com.example.ukidapp.ui.UserSetUp.UserInfoFragment;
import com.example.ukidapp.ui.UserSetUp.LanguageFragment;
import com.example.ukidapp.ui.UserSetUp.NatureFragment;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
* 로그인 후 첫 유저가 등록했을 시
* 설문 조사 및 정보 입력받는 곳
* */
public class SetUserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private int mPage = 9;
    private int pageIndex = 1;

    Button next;
    Button prev;
    FragmentManager fm;
    FragmentTransaction tran;
    UserInfoFragment userInfoFragment;
    LanguageFragment languageFragment;
    MathFragment mathFragment;
    PlaceFragment placeFragment;
    PhysicalFragment physicalFragment;
    MusicFragment musicFragment;
    RelationshipFragment relationshipFragment;
    PersonalFragment personalFragment;
    NatureFragment natureFragment;

    SetUpDataManager User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        next = (Button)findViewById(R.id.nextButton);
        prev = (Button)findViewById(R.id.prevButton);
        next.setOnClickListener(this);
        prev.setOnClickListener(this);
        userInfoFragment = new UserInfoFragment();
        languageFragment = new LanguageFragment();
        mathFragment = new MathFragment();
        placeFragment = new PlaceFragment();
        physicalFragment = new PhysicalFragment();
        musicFragment = new MusicFragment();
        relationshipFragment = new RelationshipFragment();
        personalFragment = new PersonalFragment();
        natureFragment = new NatureFragment();
        fm = getSupportFragmentManager();

        User = new SetUpDataManager();
        setFrag(1);

    }

    public void firstNextClick(){
        onClick(next);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.nextButton:
                if (next.getText() == "완료"){
                    if (checkAllData()) {
                        postUserInfo();

                    }else {
                        errToast();
                    }
                }
                if (mPage > pageIndex) {
                    System.out.println(v.getId());
                    pageIndex++;
                    setFrag(pageIndex);
                }
                break;
            case R.id.prevButton:
                if (pageIndex > 0){
                    pageIndex--;
                    setFrag(pageIndex);
                }
                break;

        }
    }

    public void setFrag(int n){

        tran = fm.beginTransaction();
        System.out.println(" 번호 "+n);
        switch (n) {
            case 1 :
                prev.setVisibility(View.INVISIBLE);
                next.setVisibility(View.INVISIBLE);
                tran.replace(R.id.SetUser, this.userInfoFragment);
                tran.commit();
                break;
            case 2:
                if (userInfoFragment.checkData()){
                    prev.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                    tran.replace(R.id.SetUser, this.languageFragment);
                    tran.commit();
                }else {
                    pageIndex--;
                    errToast();
                }
                break;
            case 3:
                if (languageFragment.checkData()){
                    tran.replace(R.id.SetUser, this.mathFragment);
                    tran.commit();
                }else {
                    pageIndex--;
                    errToast();
                }
                break;
            case 4:
                if (mathFragment.checkData()){
                    tran.replace(R.id.SetUser, this.placeFragment);
                    tran.commit();
                }else {
                    pageIndex--;
                    errToast();
                }
                break;
            case 5:
                if (placeFragment.checkData()){
                    tran.replace(R.id.SetUser, this.physicalFragment);
                    tran.commit();
                }else {
                    pageIndex--;
                    errToast();
                }
                break;
            case 6:
                if (physicalFragment.checkData()){
                    tran.replace(R.id.SetUser, this.musicFragment);
                    tran.commit();
                }else {
                    pageIndex--;
                    errToast();
                }
                break;
            case 7:
                if (musicFragment.checkData()){
                    prev.setVisibility(View.VISIBLE);
                    tran.replace(R.id.SetUser, this.relationshipFragment);
                    tran.commit();
                }else {
                    pageIndex--;
                    errToast();
                }
                break;
            case 8 :
                if (next.getText() == "완료") { next.setText("다음 >");}
                if (relationshipFragment.checkData()) {
                    tran.replace(R.id.SetUser, this.personalFragment);
                    tran.commit();
                }else {
                    pageIndex--;
                    errToast();
                }

                break;
            case 9 :
                if(personalFragment.checkData()) {
                    next.setText("완료");
                    tran.replace(R.id.SetUser, this.natureFragment);
                    tran.commit();
                }else{
                    pageIndex--;
                    errToast();
                }

                break;
        }
    }

    private void errToast(){
        Toast toast = Toast.makeText(getApplicationContext(), "정보를 입력해주세요.", Toast.LENGTH_LONG);
        toast.show();
    }

    private boolean checkAllData(){
        // 모든 fragment의 데이터 가져오는 부분.
        if (natureFragment.checkData()){
            JSONObject initUserData = userInfoFragment.getData();

            try {
                User.setName(initUserData.getString("name"));
                User.setAge(Integer.parseInt(initUserData.getString("age")));
                User.setGender(initUserData.getString("gender"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            User.setLanguage(languageFragment.getData());
            User.setMath(mathFragment.getData());
            User.setMusic(musicFragment.getData());
            User.setNature(natureFragment.getData());
            User.setPersonal(personalFragment.getData());
            User.setPhysical(physicalFragment.getData());
            User.setPlace(placeFragment.getData());
            User.setRelationship(relationshipFragment.getData());

            return true;
        }else{
            return false;
        }

    }


    private void postUserInfo() {
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);

        User.setId(pref.getString("id", ""));
        // http 통신 시작
        RetrofitSender.getServer().setupuser(User).enqueue(new Callback<ResultCode>() {
            @Override
            public void onResponse(Call<ResultCode> call, Response<ResultCode> response) {
                if (response.isSuccessful()){
                    ResultCode result = response.body();
                    System.out.println(result.getResultCode());
                    if (result.getResultCode() == 200) {
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("checkSetUp", "true");
                        editor.putString("nickname", User.getName());
                        editor.putString("gender", User.getGender());
                        int age = User.getAge();
                        editor.putString("age", String.valueOf(age));
                        editor.putString("language", String.valueOf(User.getLanguage()));
                        editor.putString("math", String.valueOf(User.getMath()));
                        editor.putString("place", String.valueOf(User.getPlace()));
                        editor.putString("physical", String.valueOf(User.getPhysical()));
                        editor.putString("music", String.valueOf(User.getMusic()));
                        editor.putString("relationship", String.valueOf(User.getRelationship()));
                        editor.putString("personal", String.valueOf(User.getPersonal()));
                        editor.putString("nature", String.valueOf(User.getNature()));
                        editor.commit();
                        Intent MainPage = new Intent(SetUserInfoActivity.this, MainActivity.class);
                        startActivity(MainPage);
                        finish();
                    }
                }else{
                    errToast();
                }

            }
            @Override
            public void onFailure(Call<ResultCode> call, Throwable t) {
                System.out.println("서버 꺼짐");
            }
        });
    }

}
    