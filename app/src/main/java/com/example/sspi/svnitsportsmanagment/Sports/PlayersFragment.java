package com.example.sspi.svnitsportsmanagment.Sports;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.sspi.svnitsportsmanagment.Adapters.DepUserAdapter;
import com.example.sspi.svnitsportsmanagment.Adapters.PlayerAdapter;
import com.example.sspi.svnitsportsmanagment.Models.DepUserModel;
import com.example.sspi.svnitsportsmanagment.Models.PlayerModel;
import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.databinding.FragmentPlayersBinding;

import java.util.ArrayList;

public class PlayersFragment extends Fragment {

    public PlayersFragment() {
        // Required empty public constructor
    }

    FragmentPlayersBinding binding;
    String [] filters= {"High-to-low" , "low-to-high"};
    String selectedFilter;

    ArrayList<PlayerModel> list;
    PlayerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPlayersBinding.inflate(getLayoutInflater());

        //Todo: Fed data appropriately in list from database
        //content of list is fed in the recyclerView
        list = new ArrayList<>();
        list.add(new PlayerModel("Team Falcon", "U21CS037", "Shubh Gajjar", 99));
        list.add((new PlayerModel("Team Angel", "U21CS031", "Krishna Pandey", 20)));

        //Set the Recyclerview with adapter
        adapter = new PlayerAdapter(list, getContext());
        binding.playerProfileRec.setAdapter(adapter);
        binding.playerProfileRec.setLayoutManager(new LinearLayoutManager(getContext()));





        ArrayAdapter<String> adapterFilter;
        adapterFilter=new ArrayAdapter<>(getContext(),R.layout.array_for_filters,filters);
        binding.rankingFilter.setAdapter(adapterFilter);


        //Here we are getting whatever user select from the ranking Filter
        binding.rankingFilter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedFilter=parent.getItemAtPosition(position).toString();
//                Toast.makeText(getApplicationContext(), selectedFilter, Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }
}