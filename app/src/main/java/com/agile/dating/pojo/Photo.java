package com.agile.dating.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {
    @SerializedName("errors")
    private List<Object> errors = null;

    @SerializedName("url")
    private String url;

    @SerializedName("urlBig")
    private String urlBig;

    @SerializedName("photo_id")
    private Integer photoId;

    @SerializedName("liked")
    private Object liked;

    @SerializedName("likedCount")
    private Object likedCount;

    @SerializedName("descr")
    private Object descr;
    @SerializedName("status")
    private Object status;

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlBig() {
        return urlBig;
    }

    public void setUrlBig(String urlBig) {
        this.urlBig = urlBig;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public Object getLiked() {
        return liked;
    }

    public void setLiked(Object liked) {
        this.liked = liked;
    }

    public Object getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(Object likedCount) {
        this.likedCount = likedCount;
    }

    public Object getDescr() {
        return descr;
    }

    public void setDescr(Object descr) {
        this.descr = descr;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

}
