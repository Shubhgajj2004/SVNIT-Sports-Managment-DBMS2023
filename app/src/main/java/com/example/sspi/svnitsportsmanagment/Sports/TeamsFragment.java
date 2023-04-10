package com.example.sspi.svnitsportsmanagment.Sports;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sspi.svnitsportsmanagment.Adapters.PlayerAdapter;
import com.example.sspi.svnitsportsmanagment.Adapters.TeamAdapter;
import com.example.sspi.svnitsportsmanagment.Models.PlayerModel;
import com.example.sspi.svnitsportsmanagment.Models.TeamModel;
import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.databinding.FragmentTeamsBinding;

import java.util.ArrayList;


public class TeamsFragment extends Fragment {


    public TeamsFragment() {
        // Required empty public constructor
    }

    FragmentTeamsBinding binding;

    ArrayList<TeamModel> list;
    TeamAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTeamsBinding.inflate(getLayoutInflater());


        //Todo: Fed data appropriately in list from database
        //content of list is fed in the recyclerView
        list = new ArrayList<>();
        list.add(new TeamModel("U21CS037", "Team Falcon", 11));
        list.add((new TeamModel("U21CS031", "Team Angel", 12)));

        //Set the Recyclerview with adapter
        adapter = new TeamAdapter(list, getContext());
        binding.teamRec.setAdapter(adapter);
        binding.teamRec.setLayoutManager(new LinearLayoutManager(getContext()));






        return binding.getRoot();
    }
}