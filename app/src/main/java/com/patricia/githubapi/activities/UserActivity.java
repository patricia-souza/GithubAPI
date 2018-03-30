package com.patricia.githubapi.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.patricia.githubapi.R;
import com.patricia.githubapi.adapter.ReposUsersAdapter;
import com.patricia.githubapi.model.GitHubUser;
import com.patricia.githubapi.rest.APIClient;
import com.patricia.githubapi.rest.GitHubUserEndPoints;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<GitHubUser> dataSource = new ArrayList<>();
    private RecyclerView.Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_users);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new ReposUsersAdapter(dataSource, R.layout.item_user, getApplicationContext());
        recyclerView.setAdapter(myAdapter);
        loadUsers();
    }

    public void loadUsers() {

        GitHubUserEndPoints apiService = APIClient.getClient().create(GitHubUserEndPoints.class);

        Call<List<GitHubUser>> call = apiService.getAllUsers();

        call.enqueue(new Callback<List<GitHubUser>>() {
            @Override
            public void onResponse(Call<List<GitHubUser>> call, Response<List<GitHubUser>> response) {
                dataSource.clear();
                dataSource.addAll(response.body());
                myAdapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<GitHubUser>> call, Throwable t) {
                Log.e("Failed get repos:", t.toString());
                Toast.makeText(UserActivity.this, "Falha ao recuperar dados.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
