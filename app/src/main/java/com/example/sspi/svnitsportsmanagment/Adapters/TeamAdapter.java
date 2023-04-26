package com.example.sspi.svnitsportsmanagment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sspi.svnitsportsmanagment.Models.PlayerModel;
import com.example.sspi.svnitsportsmanagment.Models.TeamModel;
import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.Sports.TeamPlayerActivity;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.teamHolder>{

    ArrayList<TeamModel> list;
    Context context;

    public TeamAdapter(ArrayList<TeamModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public teamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false);
        return new teamHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull teamHolder holder, int position) {

        TeamModel adp=list.get(position);

        holder.name.setText(adp.getTeamName());
        holder.id.setText(Integer.toString(adp.getTeamId()));
        holder.size.setText(Integer.toString(adp.getTeamStrength()));

        holder.teamTile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TeamPlayerActivity.class);
                intent.putExtra("TeamName", adp.getTeamName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class teamHolder extends RecyclerView.ViewHolder{
        TextView name, id, size;
        LinearLayout teamTile;
        public teamHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.teamName);
            id = itemView.findViewById(R.id.teamId);
            size = itemView.findViewById(R.id.teamStrength);
            teamTile = itemView.findViewById(R.id.team_tile);
        }
    }
}
