package com.example.sspi.svnitsportsmanagment.Department;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.databinding.ActivityAddUserDepartmentBinding;

public class AddUserDepartmentActivity extends AppCompatActivity {

    ActivityAddUserDepartmentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddUserDepartmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}