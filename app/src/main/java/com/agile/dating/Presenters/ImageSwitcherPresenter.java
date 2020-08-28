package com.agile.dating.Presenters;

import com.agile.dating.api.ApiFactory;
import com.agile.dating.api.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ImageSwitcherPresenter {

    private CompositeDisposable compositeDisposable;
    private ImageSwitcherView view;
    private UserListPresenter presenter;

    public ImageSwitcherPresenter(ImageSwitcherView view) {
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
                    view.getData(response.getUsers().get(0).getPhotos(), response.getUsers());
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
