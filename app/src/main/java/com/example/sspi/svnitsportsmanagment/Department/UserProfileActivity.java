package com.example.sspi.svnitsportsmanagment.Department;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.databinding.ActivityUserProfileBinding;

public class UserProfileActivity extends AppCompatActivity {

    ActivityUserProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}