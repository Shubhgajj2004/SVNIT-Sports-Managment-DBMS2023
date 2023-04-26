package com.example.sspi.svnitsportsmanagment.Department;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.SQLHelper;
import com.example.sspi.svnitsportsmanagment.databinding.ActivityUserProfileBinding;

public class UserProfileActivity extends AppCompatActivity {

    ActivityUserProfileBinding binding;

    TextView nameTV, adm_noTV, ageTV, yearTV, genderTV, deptTV, scoreTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String adm_no = intent.getStringExtra("adm_no");
        String age = intent.getStringExtra("age");
        String year = intent.getStringExtra("year");
        String gender = intent.getStringExtra("gender");
        String dept = intent.getStringExtra("dept");

        SQLHelper sqlHelper = new SQLHelper(this);
        Cursor cursor = sqlHelper.getScoreOfPlayer(adm_no);
        cursor.moveToFirst();
        @SuppressLint("Range") String score = cursor.getString(cursor.getColumnIndex(("avg_score")));

        nameTV = (TextView)findViewById(R.id.playerName);
        adm_noTV = (TextView)findViewById(R.id.playerId);
        ageTV = (TextView)findViewById(R.id.playerAge);
        scoreTV = (TextView)findViewById(R.id.playerScore);
        genderTV = (TextView)findViewById(R.id.playerGender);
        yearTV = (TextView)findViewById(R.id.playerYear);
        deptTV = (TextView)findViewById(R.id.playerDept);

        nameTV.setText(name);
        adm_noTV.setText(adm_no);
        ageTV.setText(age);
        scoreTV.setText(score);
        genderTV.setText(gender);
        yearTV.setText(year);
        deptTV.setText(dept);

    }
}