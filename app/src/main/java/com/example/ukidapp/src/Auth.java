package com.example.ukidapp.src;


import android.os.AsyncTask;

import com.example.ukidapp.api.Model.AuthModel;
import com.example.ukidapp.api.RetrofitSender;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;

public class Auth {
    private String email;
    private String password;
    private String phoneNumber;
    private String useraname;

    public Auth(String email, String password){
        this.email = email;
        this.password = password;
    }
    public Auth(String email, String password, String phoneNumber, String username){
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.useraname = username;
    }

    public boolean CheckEmail(){
        try {
            String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(email);
            if (m.matches()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean CheckPassword(){
        try {
            if (this.password.length() >= 6 ) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean CheckPhoneNumber(){
        try {
            if (this.phoneNumber.length() >= 11) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean CheckUserName(){
        try {
            if (this.useraname.length() >= 2) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /*
    public String login(final Auth user){
        new AsyncTask<Auth, Void, AuthModel>() {


            @Override
            protected AuthModel doInBackground(Auth... auths) {
                Call<AuthModel> call = RetrofitSender.getServer().login(user);

                try{
                    AuthModel result = call.execute().body();

                    return result;
                }catch(IOException e){
                    e.printStackTrace();
                }
                return new AuthModel();
            }

            @Override
            protected String onPostExecute(AuthModel result) {
                super.onPostExecute(result);

                if (result == null) {

                }else if (result.getResultCode() == 200 ){


                    return result.getResultData();

                }else {

                }

                System.out.println(aVoid.getResultCode());
                System.out.println(aVoid.getResultData());



            }
        }.execute();

    }*/
}
