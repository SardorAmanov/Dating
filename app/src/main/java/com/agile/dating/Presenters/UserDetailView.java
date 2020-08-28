package com.agile.dating.Presenters;

import com.agile.dating.pojo.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDetailView {
    void showData(List<User> users);
    void showError();

}
