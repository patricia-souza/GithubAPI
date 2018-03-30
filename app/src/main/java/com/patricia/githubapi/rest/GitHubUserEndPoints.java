package com.patricia.githubapi.rest;

import com.patricia.githubapi.model.GitHubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubUserEndPoints {

    @GET("/users")
    Call<List<GitHubUser>> getAllUsers();
}



