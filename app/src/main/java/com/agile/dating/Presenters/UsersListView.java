package com.agile.dating.Presenters;

import com.agile.dating.pojo.User;

import java.util.List;

public interface UsersListView {
    void showData(List<User> users);
    void showError();
    void addData(List<User> users);
    String getNick(List<User> users);
}
