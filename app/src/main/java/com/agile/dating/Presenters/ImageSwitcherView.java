package com.agile.dating.Presenters;

import com.agile.dating.pojo.Photo;
import com.agile.dating.pojo.User;

import java.util.List;

public interface ImageSwitcherView {
    void getData(List<Photo> photos, List<User> users);
    void showError();
}
