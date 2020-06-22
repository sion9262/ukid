package com.example.ukidapp.src;

public class SetUpDataManager {
    private String name;
    private int age;
    private int language;
    private int math;
    private int place;
    private int physical;
    private int music;
    private int relationship;
    private int personal;
    private int nature;
    private String token;
    private String id;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public int getLanguage() {
        return language;
    }

    public int getMath() {
        return math;
    }

    public int getPlace() {
        return place;
    }

    public int getPhysical() {
        return physical;
    }

    public int getMusic() {
        return music;
    }

    public int getRelationship() {
        return relationship;
    }

    public int getPersonal() {
        return personal;
    }

    public int getNature() {
        return nature;
    }

    public String getToken() {
        return token;
    }

    public String getId() {
        return id;
    }

    public SetUpDataManager(){
        name = "";
        age = 0;
        language = 0;
        math = 0;
        place = 0;
        physical = 0;
        music = 0;
        relationship = 0;
        personal = 0;
        nature = 0;
        token = "";
        id = "";
    }

    public String getName(){
        return this.name;
    }


    public void setToken(String token) {
        this.token = token;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public void setMusic(int music) {
        this.music = music;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }
}
