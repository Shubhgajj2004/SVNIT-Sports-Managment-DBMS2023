package com.example.sspi.svnitsportsmanagment.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sspi.svnitsportsmanagment.Models.DepUserModel;
import com.example.sspi.svnitsportsmanagment.Models.TeamPlayerModel;
import com.example.sspi.svnitsportsmanagment.R;

import java.util.ArrayList;

public class TeamPlayerAdapter extends RecyclerView.Adapter<TeamPlayerAdapter.teamPlayerHolder>{

    ArrayList<TeamPlayerModel> list;
    Context context;

    public TeamPlayerAdapter(ArrayList<TeamPlayerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public teamPlayerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team_sport_player, parent, false);
        return new teamPlayerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull teamPlayerHolder holder, int position) {
        TeamPlayerModel adp=list.get(position);

        holder.name.setText(adp.getName());
        holder.id.setText(adp.getId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class teamPlayerHolder extends RecyclerView.ViewHolder{
        TextView name, id;
        View delete;
        public teamPlayerHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.team_player_name);
            id = itemView.findViewById(R.id.team_player_roll_no);
            delete = itemView.findViewById(R.id.delete_team_player);

        }
    }
}
