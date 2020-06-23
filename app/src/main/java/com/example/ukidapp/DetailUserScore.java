package com.example.ukidapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ukidapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


// 다중지능별 구체적인 내용 설명
public class DetailUserScore extends AppCompatActivity implements View.OnClickListener{
    Button detailFirst;
    Button detailSecond;
    Button detailThree;
    TextView mainTitle, explanation, Representative_person, Representative_occupation, Feature, Improving;
    ImageView imageView;
    private  InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailuserscore);

        String category1 = getIntent().getStringExtra("category1");
        String category2 = getIntent().getStringExtra("category2");
        String category3 = getIntent().getStringExtra("category3");

        detailFirst = (Button) findViewById(R.id.detailFirst);
        detailSecond = (Button) findViewById(R.id.detailSecond);
        detailThree = (Button) findViewById(R.id.detailThree);

        detailFirst.setText(category1);
        detailSecond.setText(category2);
        detailThree.setText(category3);

        mainTitle = findViewById(R.id.mainTitle);
        explanation = findViewById(R.id.explanation);
        Representative_person = findViewById(R.id.Representative_person);
        Representative_occupation = findViewById(R.id.Representative_occupation);
        Feature = findViewById(R.id.Feature);
        Improving = findViewById(R.id.Improving);

        imageView = findViewById(R.id.imageView);

        detailFirst.setOnClickListener(this);
        detailSecond.setOnClickListener(this);
        detailThree.setOnClickListener(this);
        Firstinit();

        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.detailFirst:
                Firstinit();
                break;
            case R.id.detailSecond:
                Secondinit();
                break;
            case R.id.detailThree:
                Threeinit();
                break;
        }
    }

    public void Ln(){ //언어지능
        mainTitle.setText(getString(R.string.Ln_mainTitle));
        explanation.setText(getString(R.string.Ln_analysis));
        Representative_person.setText(getString(R.string.Ln_Representative_person));
        Representative_occupation.setText(getString(R.string.Ln_Representative_occupation));
        Feature.setText(getString(R.string.Ln_Feature));
        Improving.setText(getString(R.string.Ln_Improving));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.lawyer));
    }

    public void LM(){ //논리수학지능
        mainTitle.setText(getString(R.string.LM_mainTitle));
        explanation.setText(getString(R.string.LM_analysis));
        Representative_person.setText(getString(R.string.LM_Representative_person));
        Representative_occupation.setText(getString(R.string.LM_Representative_occupation));
        Feature.setText(getString(R.string.LM_Feature));
        Improving.setText(getString(R.string.LM_Improving));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.doctor));
    }

    public void Int(){ //대인관계지능
        mainTitle.setText(getString(R.string.Int_mainTitle));
        explanation.setText(getString(R.string.Int_analysis));
        Representative_person.setText(getString(R.string.Int_Representative_person));
        Representative_occupation.setText(getString(R.string.Int_Representative_occupation));
        Feature.setText(getString(R.string.Int_Feature));
        Improving.setText(getString(R.string.Int_Improving));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.businessman));
    }

    public void Ira(){ //자기성찰지능
        mainTitle.setText(getString(R.string.Ira_mainTitle));
        explanation.setText(getString(R.string.Ira_analysis));
        Representative_person.setText(getString(R.string.Ira_Representative_person));
        Representative_occupation.setText(getString(R.string.Ira_Representative_occupation));
        Feature.setText(getString(R.string.Ira_Feature));
        Improving.setText(getString(R.string.Ira_Improving));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.kantz));
    }

    public void Sp(){ //공간지능
        mainTitle.setText(getString(R.string.Sp_mainTitle));
        explanation.setText(getString(R.string.Sp_analysis));
        Representative_person.setText(getString(R.string.Sp_Representative_person));
        Representative_occupation.setText(getString(R.string.Sp_Representative_occupation));
        Feature.setText(getString(R.string.Sp_Feature));
        Improving.setText(getString(R.string.Sp_Improving));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.photographer));
    }

    public void Mu(){ //음악지능
        mainTitle.setText(getString(R.string.Mu_mainTitle));
        explanation.setText(getString(R.string.Mu_analysis));
        Representative_person.setText(getString(R.string.Mu_Representative_person));
        Representative_occupation.setText(getString(R.string.Mu_Representative_occupation));
        Feature.setText(getString(R.string.Mu_Feature));
        Improving.setText(getString(R.string.Mu_Improving));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.violinist));
    }

    public void BK(){ //신체운동지능
        mainTitle.setText(getString(R.string.BK_mainTitle));
        explanation.setText(getString(R.string.BK_analysis));
        Representative_person.setText(getString(R.string.BK_Representative_person));
        Representative_occupation.setText(getString(R.string.BK_Representative_occupation));
        Feature.setText(getString(R.string.BK_Feature));
        Improving.setText(getString(R.string.BK_Improving));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.sport_girl));
    }

    public void Na(){ //자연친화지능
        mainTitle.setText(getString(R.string.Na_mainTitle));
        explanation.setText(getString(R.string.Na_analysis));
        Representative_person.setText(getString(R.string.Na_Representative_person));
        Representative_occupation.setText(getString(R.string.Na_Representative_occupation));
        Feature.setText(getString(R.string.Na_Feature));
        Improving.setText(getString(R.string.Na_Improving));
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.veterinarian));
    }

    public void Firstinit() {
        if (detailFirst.getText().equals("언어지능")) {
            Ln();
        } else if (detailFirst.getText().equals("논리수학지능")) {
            LM();
        } else if (detailFirst.getText().equals("대인간관계지능")) {
            Int();
        } else if (detailFirst.getText().equals("자기성찰지능")) {
            Ira();
        } else if (detailFirst.getText().equals("공간지능")) {
            Sp();
        } else if (detailFirst.getText().equals("음악지능")) {
            Mu();
        }else if(detailFirst.getText().equals("신체운동지능")) {
            BK();
        }else if(detailFirst.getText().equals("자연친화지능")) {
            Na();
        }

    }
    public void Secondinit() {
        if (detailSecond.getText().equals("언어지능")) {
            Ln();
        } else if (detailSecond.getText().equals("논리수학지능")) {
            LM();
        } else if (detailSecond.getText().equals("대인간관계지능")) {
            Int();
        } else if (detailSecond.getText().equals("자기성찰지능")) {
            Ira();
        } else if (detailSecond.getText().equals("공간지능")) {
            Sp();
        } else if (detailSecond.getText().equals("음악지능")) {
            Mu();
        }else if(detailSecond.getText().equals("신체운동지능")) {
            BK();
        }else if(detailSecond.getText().equals("자연친화지능")) {
            Na();
        }
     }


    public void Threeinit(){
        if (detailThree.getText().equals("언어지능")) {
            Ln();
        } else if (detailThree.getText().equals("논리수학지능")) {
            LM();
        } else if (detailThree.getText().equals("대인간관계지능")) {
            Int();
        } else if (detailThree.getText().equals("자기성찰지능")) {
            Ira();
        } else if (detailThree.getText().equals("공간지능")) {
            Sp();
        } else if (detailThree.getText().equals("음악지능")) {
            Mu();
        }else if(detailThree.getText().equals("신체운동지능")) {
            BK();
        }else if(detailThree.getText().equals("자연친화지능")) {
            Na();
        }
    }
}
