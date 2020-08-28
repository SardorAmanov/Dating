package com.agile.dating.screens.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import com.agile.dating.Presenters.ImageSwitcherPresenter;
import com.agile.dating.Presenters.ImageSwitcherView;
import com.agile.dating.R;
import com.agile.dating.pojo.Photo;
import com.agile.dating.pojo.User;
import com.bumptech.glide.Glide;

import java.util.List;

public class ImageSwitcherActivity extends AppCompatActivity implements ImageSwitcherView {

    private ImageButton btPrevious, btNext;
    private ImageSwitcher imageSwitcher;
    private ImageSwitcherPresenter presenter;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btPrevious = findViewById(R.id.bt_previous);
        btNext = findViewById(R.id.bt_next);
        imageSwitcher = findViewById(R.id.image_switcher);
        presenter = new ImageSwitcherPresenter(this);

        imageSwitcher.setFactory(() -> {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                    ConstraintLayout.LayoutParams.WRAP_CONTENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
            ));

            return imageView;
        });

        presenter.loadData();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getData(List<Photo> photos, List<User> users) {
        int photosSize = photos.size();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPhotoId() == getIntent().getIntExtra("clickedPositionPhotoId", 0)) {
                Glide.with(getApplicationContext())
                        .load(users.get(i).getPhotos().get(currentIndex).getUrlBig())
                        .centerCrop()
                        .into((ImageView) imageSwitcher.getCurrentView());
            }
        }

        btPrevious.setOnClickListener(v -> {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getPhotoId() == getIntent().getIntExtra("clickedPositionPhotoId", 0)) {
                    imageSwitcher.setInAnimation(this, R.anim.from_right);
                    imageSwitcher.setOutAnimation(this, R.anim.to_left);
                    --currentIndex;
                    if (currentIndex >= 0) {
                        Glide.with(getApplicationContext())
                                .load(users.get(i).getPhotos().get(currentIndex).getUrlBig())
                                .centerCrop()
                                .into((ImageView) imageSwitcher.getCurrentView());
                    } else {
                        currentIndex = users.get(i).getPhotos().size() - 1;
                        if (currentIndex != 0) {
                            Glide.with(getApplicationContext())
                                    .load(users.get(i).getPhotos().get(currentIndex).getUrlBig())
                                    .centerCrop()
                                    .into((ImageView) imageSwitcher.getCurrentView());
                            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
                        } else Toast.makeText(this, "No more images!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btNext.setOnClickListener(v -> {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getPhotoId() == getIntent().getIntExtra("clickedPositionPhotoId", 0)) {
                    imageSwitcher.setInAnimation(this, R.anim.from_left);
                    imageSwitcher.setOutAnimation(this, R.anim.to_right);
                    ++currentIndex;
                    if (currentIndex < users.get(i).getPhotos().size()) {
                        Glide.with(getApplicationContext())
                                .load(users.get(i).getPhotos().get(currentIndex).getUrlBig())
                                .centerCrop()
                                .into((ImageView) imageSwitcher.getCurrentView());
                    } else if (users.get(i).getPhotos().size() > 1 && users.get(i).getPhotos().size() != currentIndex) {
                        Glide.with(getApplicationContext())
                                .load(users.get(i).getPhotos().get(currentIndex).getUrlBig())
                                .centerCrop()
                                .into((ImageView) imageSwitcher.getCurrentView());
                        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
                    } else if (users.get(i).getPhotos().size() > 1) {
                        currentIndex = 0;
                        Glide.with(getApplicationContext())
                                .load(users.get(i).getPhotos().get(currentIndex).getUrlBig())
                                .centerCrop()
                                .into((ImageView) imageSwitcher.getCurrentView());
                    } else Toast.makeText(this, "No more images!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        presenter.disposeDisposable();
        super.onDestroy();
    }
}











