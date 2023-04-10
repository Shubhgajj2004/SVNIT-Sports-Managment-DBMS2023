package com.example.sspi.svnitsportsmanagment.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sspi.svnitsportsmanagment.Models.DepUserModel;
import com.example.sspi.svnitsportsmanagment.R;

import java.util.ArrayList;

public class DepUserAdapter extends RecyclerView.Adapter<DepUserAdapter.userHolder>{

    ArrayList<DepUserModel> list;
    Context context;

    public DepUserAdapter(ArrayList<DepUserModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dep_user_profile, parent, false);
        return new userHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, int position) {

        DepUserModel adp=list.get(position);

        holder.name.setText(adp.getName());
        holder.id.setText(adp.getRollNo());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class userHolder extends RecyclerView.ViewHolder{
        TextView name, id;
        public userHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.user_name);
            id = itemView.findViewById(R.id.user_roll_no);
        }
    }
}
