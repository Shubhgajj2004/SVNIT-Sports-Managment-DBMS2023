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

import com.example.sspi.svnitsportsmanagment.Department.UserProfileActivity;
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
        holder.id.setText(adp.getAdm_no());

        holder.depUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UserProfileActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name", adp.getName().toString());
                intent.putExtra("adm_no", adp.getAdm_no().toString());
                intent.putExtra("age", Integer.toString(adp.getAge()));
                intent.putExtra("dept", adp.getDept().toString());
                intent.putExtra("year", Integer.toString(adp.getYear()));
                intent.putExtra("gender", adp.getGender().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class userHolder extends RecyclerView.ViewHolder{
        TextView name, id;
        LinearLayout depUser;

        public userHolder(@NonNull View itemView) {
            super(itemView);
            name =itemView.findViewById(R.id.user_name);
            id = itemView.findViewById(R.id.user_roll_no);
            depUser = itemView.findViewById(R.id.dep_user_tile);
        }
    }
}
