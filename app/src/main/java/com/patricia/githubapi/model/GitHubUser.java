package com.patricia.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GitHubUser {

    @SerializedName("login")
    private String login;

    @SerializedName("avatar_url")
    private String avatar;

    public GitHubUser(
                      String avatar,
                      String login) {
        this.setAvatar(avatar);
        this.setLogin(login);
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
