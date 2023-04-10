package com.example.sspi.svnitsportsmanagment.Sports;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.sspi.svnitsportsmanagment.Adapters.DepUserAdapter;
import com.example.sspi.svnitsportsmanagment.Adapters.TeamPlayerAdapter;
import com.example.sspi.svnitsportsmanagment.Models.DepUserModel;
import com.example.sspi.svnitsportsmanagment.Models.TeamPlayerModel;
import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.databinding.ActivityTeamPlayerBinding;

import java.util.ArrayList;

public class TeamPlayerActivity extends AppCompatActivity {

    ActivityTeamPlayerBinding binding;
    ArrayList<TeamPlayerModel> list;
    TeamPlayerAdapter adapter;
    String teamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTeamPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        teamName = getIntent().getStringExtra("TeamName");
        binding.teamPlayerTeamName.setText(teamName);

        //content of list is fed in the recyclerView
        list = new ArrayList<>();
        list.add(new TeamPlayerModel("Shubh Gajjar", "U21CS037"));
        list.add((new TeamPlayerModel("Krishna Pandey", "U21CS031")));

        //Set the Recyclerview with adapter
        adapter = new TeamPlayerAdapter(list,getApplicationContext());
        binding.depUserProfilesRec.setAdapter(adapter);
        binding.depUserProfilesRec.setLayoutManager(new LinearLayoutManager(getApplicationContext()));





    }
}