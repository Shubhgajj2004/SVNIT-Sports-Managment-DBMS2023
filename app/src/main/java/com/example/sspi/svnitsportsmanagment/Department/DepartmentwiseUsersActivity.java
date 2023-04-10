package com.example.sspi.svnitsportsmanagment.Department;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.sspi.svnitsportsmanagment.Adapters.DepUserAdapter;
import com.example.sspi.svnitsportsmanagment.Models.DepUserModel;
import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.databinding.ActivityDepartmentwiseUsersBinding;

import java.util.ArrayList;

//Quesrie to be perfomred
//1.) Insertion
//2.) Sorting according to rollNo

public class DepartmentwiseUsersActivity extends AppCompatActivity {

    ActivityDepartmentwiseUsersBinding binding;

    ArrayList<DepUserModel> list;
    DepUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDepartmentwiseUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //content of list is fed in the recyclerView
        list = new ArrayList<>();
        list.add(new DepUserModel("Shubh Gajjar", "U21CS037"));
        list.add((new DepUserModel("Krishna Pandey", "U21CS031")));

        //Set the Recyclerview with adapter
        adapter = new DepUserAdapter(list,getApplicationContext());
        binding.depUserProfilesRec.setAdapter(adapter);
        binding.depUserProfilesRec.setLayoutManager(new LinearLayoutManager(getApplicationContext()));






    }
}