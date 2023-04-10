package com.example.sspi.svnitsportsmanagment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sspi.svnitsportsmanagment.Models.DepUserModel;
import com.example.sspi.svnitsportsmanagment.Models.PlayerModel;
import com.example.sspi.svnitsportsmanagment.R;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.playerHolder>{

    ArrayList<PlayerModel> list;
    Context context;

    public PlayerAdapter(ArrayList<PlayerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public playerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_player, parent, false);
        return new playerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull playerHolder holder, int position) {

        PlayerModel adp=list.get(position);

        holder.name.setText(adp.getName());
        holder.id.setText(adp.getRollNo());
        holder.teamName.setText(adp.getTeamName());
        holder.points.setText(Integer.toString(adp.getPoint()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class playerHolder extends RecyclerView.ViewHolder{
        TextView name, id, teamName, points;
        public playerHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.player_name);
            id = itemView.findViewById(R.id.player_roll_no);
            teamName = itemView.findViewById(R.id.player_team_name);
            points = itemView.findViewById(R.id.player_point);
        }
    }
}
