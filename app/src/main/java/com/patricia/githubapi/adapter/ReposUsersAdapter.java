package com.patricia.githubapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.patricia.githubapi.R;
import com.patricia.githubapi.model.GitHubUser;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by patricia on 29/03/18.
 */

public class ReposUsersAdapter extends RecyclerView.Adapter<ReposUsersAdapter.ReposViewHolder>  {

    private List<GitHubUser> users;
    private int rowLayout;
    private Context context;

    public ReposUsersAdapter(List<GitHubUser> users, int rowLayout, Context context) {
        this.setUsers(users);
        this.setRowLayout(rowLayout);
        this.setContext(context);
    }

    public List<GitHubUser> getUsers() {return users;}

    public void setUsers(List<GitHubUser> users) {this.users = users;}

    public int getRowLayout() {return rowLayout;}

    public void setRowLayout(int rowLayout) {this.rowLayout = rowLayout;}

    public Context getContext() {return context;}

    public void setContext(Context context) {this.context = context;}

    public static class ReposViewHolder extends RecyclerView.ViewHolder {

        LinearLayout usersLayout;
        TextView userLogin;
        ImageView userAvatar;

        public ReposViewHolder(View view) {
            super(view);
            usersLayout = (LinearLayout) view.findViewById(R.id.item_user_layout);
            userAvatar = (ImageView) view.findViewById(R.id.item_user_avatar);
            userLogin = (TextView) view.findViewById(R.id.item_user_login);
        }
    }

    @Override
    public ReposUsersAdapter.ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ReposViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ReposViewHolder holder, final int position) {
        Picasso.with(context)
                .load(users.get(position).getAvatar())
                .resize(200,200)
                .into(holder.userAvatar);
        holder.userLogin.setText(users.get(position).getLogin());
    }

    @Override
    public int getItemCount() { return users.size();}
}

