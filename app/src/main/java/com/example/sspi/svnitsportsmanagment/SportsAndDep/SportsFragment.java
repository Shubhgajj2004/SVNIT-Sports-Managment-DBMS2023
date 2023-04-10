package com.example.sspi.svnitsportsmanagment.SportsAndDep;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sspi.svnitsportsmanagment.MainActivity;
import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.Sports.SportActivity;
import com.example.sspi.svnitsportsmanagment.databinding.FragmentSportsBinding;


public class SportsFragment extends Fragment {

    public SportsFragment() {
        // Required empty public constructor
    }
    FragmentSportsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSportsBinding.inflate(getLayoutInflater());

        //cricket button
        binding.cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SportActivity.class);
                intent.putExtra("SportName", "Cricket");
                startActivity(intent);
            }
        });

        //football button
        binding.football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SportActivity.class);
                intent.putExtra("SportName", "Football");
                startActivity(intent);
            }
        });

        //volleyball button
        binding.volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SportActivity.class);
                intent.putExtra("SportName", "Volleyball");
                startActivity(intent);
            }
        });

        //basketball button
        binding.basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SportActivity.class);
                intent.putExtra("SportName", "Basketball");
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}