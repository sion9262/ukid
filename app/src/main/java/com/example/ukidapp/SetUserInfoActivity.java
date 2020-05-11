package com.example.ukidapp;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ukidapp.ui.UserSetUp.SetUpDataManager;
import com.example.ukidapp.ui.UserSetUp.FirstFragment;
import com.example.ukidapp.ui.UserSetUp.SecondFragment;
import com.example.ukidapp.ui.UserSetUp.ThreeFragment;

import org.json.JSONException;
import org.json.JSONObject;

/*
* 로그인 후 첫 유저가 등록했을 시
* 설문 조사 및 정보 입력받는 곳
* */
public class SetUserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private int mPage = 3;
    private int pageIndex = 1;

    Button next;
    Button prev;
    FragmentManager fm;
    FragmentTransaction tran;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThreeFragment threeFragment;

    SetUpDataManager User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        next = (Button)findViewById(R.id.nextButton);
        prev = (Button)findViewById(R.id.prevButton);
        next.setOnClickListener(this);
        prev.setOnClickListener(this);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        threeFragment = new ThreeFragment();
        fm = getSupportFragmentManager();

        User = new SetUpDataManager();
        setFrag(1);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.nextButton:
                if (next.getText() == "완료"){

                    if (checkAllData()) {
                        System.out.println("ok");
                        // 모든 데이터가 있을 시 데이터를 서버에 전송후 mainactivity 전환.
                    }else {
                        errToast();
                    }
                }
                if (mPage > pageIndex) {
                    pageIndex++;
                    setFrag(pageIndex);
                }
                break;
            case R.id.prevButton:
                if (pageIndex > 0){
                    pageIndex--;
                    setFrag(pageIndex);
                }
        }
    }

    public void setFrag(int n){

        tran = fm.beginTransaction();

        switch (n) {
            case 1 :
                prev.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
                tran.replace(R.id.SetUser, this.firstFragment);
                tran.commit();
                break;
            case 2 :
                if (next.getText() == "완료") { next.setText("다음 >");}
                if (firstFragment.checkData()) {
                    prev.setVisibility(View.VISIBLE);
                    tran.replace(R.id.SetUser, this.secondFragment);
                    tran.commit();
                }else {
                    pageIndex--;
                    errToast();
                }

                break;
            case 3 :
                if(secondFragment.checkData()) {
                    next.setText("완료");
                    tran.replace(R.id.SetUser, this.threeFragment);
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
        JSONObject initUserData = new JSONObject();

        initUserData = firstFragment.getData();

        try {
            User.setName(initUserData.getString("name"));
            User.setAge(Integer.parseInt(initUserData.getString("age")));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        User.setLanguage(secondFragment.getData());

        return true;
    }




}
    