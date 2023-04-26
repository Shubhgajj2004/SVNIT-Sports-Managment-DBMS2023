package com.example.sspi.svnitsportsmanagment.SportsAndDep;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.sspi.svnitsportsmanagment.Department.DepartmentwiseUsersActivity;
import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.databinding.FragmentDepartmentBinding;


public class DepartmentFragment extends Fragment {

    public DepartmentFragment() {
        // Required empty public constructor
    }

    FragmentDepartmentBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDepartmentBinding.inflate(getLayoutInflater());

        binding.computerDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DepartmentwiseUsersActivity.class);
                intent.putExtra("dept","CSE");
                startActivity(intent);
            }
        });

        binding.electricalDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DepartmentwiseUsersActivity.class);
                intent.putExtra("dept","EE");
                startActivity(intent);
            }
        });

        binding.chemicalDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DepartmentwiseUsersActivity.class);
                intent.putExtra("dept", "CHEM");
                startActivity(intent);
            }
        });

        binding.electronicsDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DepartmentwiseUsersActivity.class);
                intent.putExtra("dept", "ECE");
                startActivity(intent);
            }
        });

        binding.mechanicalDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DepartmentwiseUsersActivity.class);
                intent.putExtra("dept","MECH");
                startActivity(intent);
            }
        });

        binding.civilDep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), DepartmentwiseUsersActivity.class);
                intent.putExtra("dept","CIVIL");
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}