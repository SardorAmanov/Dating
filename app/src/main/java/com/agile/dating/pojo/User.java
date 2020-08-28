package com.agile.dating.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @SerializedName("login")
    private String login;

    @SerializedName("name")
    private String name;

    @SerializedName("nick")
    private String nick;

    @SerializedName("iurl")
    private String iurl;

    @SerializedName("iurl_600")
    private String iurl600;

    @SerializedName("iurl_200")
    private String iurl200;

    @SerializedName("photos")
    private List<Photo> photos = null;

    @SerializedName("online")
    private Boolean online;

    @SerializedName("pcnt")
    private Integer pcnt;

    @SerializedName("age")
    private String age;

    @SerializedName("city")
    private String city;

    @SerializedName("aim")
    private String aim;

    @SerializedName("photo_id")
    private Integer photoId;

    @SerializedName("moderator")
    private Boolean moderator;

    @SerializedName("status")
    private Object status;

    @SerializedName("greeting")
    private String greeting;

    @SerializedName("lastVisit")
    private String lastVisit;

    @SerializedName("sex")
    private Integer sex;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIurl() {
        return iurl;
    }

    public void setIurl(String iurl) {
        this.iurl = iurl;
    }

    public String getIurl600() {
        return iurl600;
    }

    public void setIurl600(String iurl600) {
        this.iurl600 = iurl600;
    }

    public String getIurl200() {
        return iurl200;
    }

    public void setIurl200(String iurl200) {
        this.iurl200 = iurl200;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Integer getPcnt() {
        return pcnt;
    }

    public void setPcnt(Integer pcnt) {
        this.pcnt = pcnt;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Boolean getModerator() {
        return moderator;
    }

    public void setModerator(Boolean moderator) {
        this.moderator = moderator;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

}
