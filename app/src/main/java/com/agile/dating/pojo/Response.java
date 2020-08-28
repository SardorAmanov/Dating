package com.agile.dating.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("searchSessionId")
    private String searchSessionId;

    @SerializedName("cnt")
    private Object cnt;

    @SerializedName("users")
    private List<User> users = null;

    @SerializedName("errors")
    private List<Object> errors = null;

    @SerializedName("status")
    private String status;

    public String getSearchSessionId() {
        return searchSessionId;
    }

    public void setSearchSessionId(String searchSessionId) {
        this.searchSessionId = searchSessionId;
    }

    public Object getCnt() {
        return cnt;
    }

    public void setCnt(Object cnt) {
        this.cnt = cnt;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
