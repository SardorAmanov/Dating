package com.agile.dating.screens.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.agile.dating.Presenters.UserDetailPresenter;
import com.agile.dating.Presenters.UserDetailView;
import com.agile.dating.Presenters.UsersListView;
import com.agile.dating.R;
import com.agile.dating.pojo.User;
import com.bumptech.glide.Glide;

import java.util.List;

public class UserDetailActivity extends AppCompatActivity implements UserDetailView {

    private static final String TAG = "TAG";
    private UserDetailPresenter presenter;
    private TextView textViewLogin;
    private TextView textViewName;
    private TextView textViewNick;
    private TextView textViewAge;
    private TextView textViewCity;
    private TextView textViewGreeting;
    private TextView textViewLastVisit;
    private ImageButton imageButton;
    private int selectedPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        textViewLogin = findViewById(R.id.tv_login);
        textViewName = findViewById(R.id.tv_name);
        textViewNick = findViewById(R.id.tv_nick);
        textViewAge = findViewById(R.id.tv_age);
        textViewCity = findViewById(R.id.tv_city);
        textViewGreeting = findViewById(R.id.tv_greeting);
        textViewLastVisit = findViewById(R.id.tv_last_visit);
        imageButton = findViewById(R.id.image_button);
        presenter = new UserDetailPresenter(this);

        presenter.loadData();

    }

    @Override
    public void showData(List<User> users) {
        int i;
        for (i = 0; i < users.size(); i++) {
            Log.d(TAG, "showData: " + users.get(i).getNick());
            if (users.get(i).getNick().equals(getIntent().getStringExtra("clickedPositionNick"))) {
                textViewLogin.setText(String.format("Логин: %s", users.get(i).getLogin()));
                textViewName.setText(String.format("Имя: %s", users.get(i).getName()));
                textViewNick.setText(String.format("Ник: %s", users.get(i).getNick()));
                textViewAge.setText(String.format("Возраст: %s", users.get(i).getAge()));
                textViewCity.setText(String.format("Город: %s", users.get(i).getCity()));
                textViewGreeting.setText(String.format("О себе: %s", users.get(i).getGreeting()));
                textViewLastVisit.setText(String.format("Последний визит: %s", users.get(i).getLastVisit()));
                Glide.with(getApplicationContext())
                        .load(users.get(i).getIurl200())
                        .centerCrop()
                        .into(imageButton);

                selectedPosition = i;
            }
        }

        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ImageSwitcherActivity.class);
            intent.putExtra("clickedPositionPhotoId", users.get(selectedPosition).getPhotoId());
            Log.d(TAG, "showDataSentSelectedPhotoId: " +  users.get(selectedPosition).getPhotoId());
            startActivity(intent);
        });
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
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
    protected void onDestroy() {
        presenter.disposeDisposable();
        super.onDestroy();
    }
}
