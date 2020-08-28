package com.agile.dating.screens.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.agile.dating.Adapters.UserAdapter;
import com.agile.dating.Presenters.UserListPresenter;
import com.agile.dating.Presenters.UsersListView;
import com.agile.dating.R;
import com.agile.dating.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity implements UsersListView {

    private static final String TAG = "TAG";
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private UserListPresenter presenter;
    private int clickedPosition;
    private LinearLayoutManager linearLayoutManager;
    private List<User> allUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new UserListPresenter(this);
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new UserAdapter(getApplicationContext());
        adapter.setUsers(new ArrayList<>());
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        presenter.loadData();
        presenter.addData();
    }

    @Override
    protected void onDestroy() {
        presenter.disposeDisposable();
        super.onDestroy();
    }

    @Override
    public void showData(List<User> users) {
        allUsers.addAll(users);
        adapter.setUsers(allUsers);

        adapter.setOnItemClickListener((position) -> {
            clickedPosition = position;
            Intent intent = new Intent(this, UserDetailActivity.class);
            intent.putExtra("clickedPositionNick", users.get(position).getNick());
            Log.d(TAG, "showData: " + users.get(position).getNick() + " position: " + position);
            startActivity(intent);
        });
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addData(List<User> users) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();

                if(lastVisibleItem == users.size() - 1){

                }
            }
        });
    }

    @Override
    public String getNick(List<User> users) {
        return users.get(clickedPosition).getNick();
    }




}
