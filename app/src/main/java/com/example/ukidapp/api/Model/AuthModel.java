package com.example.ukidapp.api.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class AuthModel {

    @Expose
    private Integer resultCode;
    @SerializedName("jwt")
    @Expose
    private String jwt;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("setUserInfo")
    @Expose
    private boolean setUserInfo;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("math")
    @Expose
    private String math;

    @SerializedName("place")
    @Expose
    private String place;

    @SerializedName("physical")
    @Expose
    private String physical;

    @SerializedName("music")
    @Expose
    private String music;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhysical() {
        return physical;
    }

    public void setPhysical(String physical) {
        this.physical = physical;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @SerializedName("relationship")
    @Expose
    private String relationship;

    @SerializedName("personal")
    @Expose
    private String personal;

    @SerializedName("nature")
    @Expose
    private String nature;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSetUserInfo() {
        return setUserInfo;
    }

    public void setSetUserInfo(boolean setUserInfo) {
        this.setUserInfo = setUserInfo;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}