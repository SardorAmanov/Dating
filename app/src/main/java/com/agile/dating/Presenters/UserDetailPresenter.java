package com.agile.dating.Presenters;

import com.agile.dating.api.ApiFactory;
import com.agile.dating.api.ApiService;
import com.agile.dating.screens.users.UserDetailActivity;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserDetailPresenter {

    private CompositeDisposable compositeDisposable;
    private UserDetailView view;


    public UserDetailPresenter(UserDetailView view) {
        this.view = view;
    }

    public void loadData() {
        ApiFactory apiFactory = ApiFactory.getInstance();
        ApiService apiService = apiFactory.getApiService();
        compositeDisposable = new CompositeDisposable();
        Disposable disposable = apiService.getUsers(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    view.showData(response.getUsers());
                }, throwable -> {
                    view.showError();
                });
        compositeDisposable.add(disposable);
    }

    public void disposeDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
