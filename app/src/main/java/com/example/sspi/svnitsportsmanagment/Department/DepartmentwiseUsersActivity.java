package com.example.sspi.svnitsportsmanagment.Department;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sspi.svnitsportsmanagment.Adapters.DepUserAdapter;
import com.example.sspi.svnitsportsmanagment.Models.DepUserModel;
import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.SQLHelper;
import com.example.sspi.svnitsportsmanagment.databinding.ActivityDepartmentwiseUsersBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

//Queries to be performed
//1.) Insertion
//2.) Sorting according to rollNo

public class DepartmentwiseUsersActivity extends AppCompatActivity {

    ActivityDepartmentwiseUsersBinding binding;

    ArrayList<DepUserModel> list;
    DepUserAdapter adapter;

    FloatingActionButton button;

    //for query
    SQLHelper sqlHelper = new SQLHelper(this);
    public static final String PLAYER_TABLE_NAME = "student";
    public static final String PLAYER_NAME = "name1";
    public static final String PLAYER_AGE = "age";
    public static final String PLAYER_ADM_NO = "admission_no";
    public static final String PLAYER_GENDER = "gender";
    public static final String PLAYER_DEPT = "department";
    public static final String PLAYER_YEAR = "stu_year";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDepartmentwiseUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //get details from database
        Intent intent = getIntent();
        String dept1 = intent.getStringExtra("dept");
//        Toast.makeText(getApplicationContext(), dept1, Toast.LENGTH_SHORT).show();
        Cursor cursor = sqlHelper.getAllPlayersFromDept(dept1);
        if(cursor != null && !cursor.isClosed()){
            cursor.close();
        }

        list = new ArrayList<>();

        //Convert cursor to list

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(PLAYER_NAME));
                @SuppressLint("Range") String adm_no = cursor.getString(cursor.getColumnIndex((PLAYER_ADM_NO)));
                @SuppressLint("Range") int age = cursor.getInt(cursor.getColumnIndex(PLAYER_AGE));
                @SuppressLint("Range") String gender = (cursor.getInt(cursor.getColumnIndex(PLAYER_GENDER)) == 1) ? "Male" : "Female";
                @SuppressLint("Range") String dept = cursor.getString(cursor.getColumnIndex(PLAYER_DEPT));
                @SuppressLint("Range") int year = cursor.getInt(cursor.getColumnIndex(PLAYER_YEAR));
                DepUserModel depUserModel = new DepUserModel(name, adm_no, age, gender, dept, year);
                list.add(depUserModel);
            } while (cursor.moveToNext());
        }
        if(cursor != null && !cursor.isClosed()){
            cursor.close();
        }

        //content of list is fed in the recyclerView
//        list = new ArrayList<>();
//        list.add(new DepUserModel("Shubh Gajjar", "U21CS037",123, "Male", "CSE", 2));
//        list.add(new DepUserModel("Vraj Patel", "U21CS061",235, "Male", "CSE", 3));
//        list.add((new DepUserModel("Krishna Pandey", "U21CS031")));

        //Set the Recyclerview with adapter
        adapter = new DepUserAdapter(list,getApplicationContext());
        binding.depUserProfilesRec.setAdapter(adapter);
        binding.depUserProfilesRec.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        button = (FloatingActionButton) findViewById(R.id.addPlayerBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), AddUserDepartmentActivity.class);
                intent1.putExtra("dept",dept1);
                startActivity(intent1);
            }
        });

    }
}