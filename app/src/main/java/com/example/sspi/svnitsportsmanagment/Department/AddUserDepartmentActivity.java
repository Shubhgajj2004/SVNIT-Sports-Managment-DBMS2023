package com.example.sspi.svnitsportsmanagment.Department;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sspi.svnitsportsmanagment.R;
import com.example.sspi.svnitsportsmanagment.SQLHelper;
import com.example.sspi.svnitsportsmanagment.databinding.ActivityAddUserDepartmentBinding;

public class AddUserDepartmentActivity extends AppCompatActivity {

    ActivityAddUserDepartmentBinding binding;
    SQLHelper sqlHelper;
    Button addBtn;
    EditText addName, addAge, addTeam, addYear, addAdmNo, addOvrScore, addGender, addSport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddUserDepartmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String deptName = getIntent().getStringExtra("dept");

        sqlHelper = new SQLHelper(getApplicationContext());

        addName = (EditText) findViewById(R.id.addName);
        addAdmNo = (EditText) findViewById(R.id.addAdmNo);
        addAge = (EditText) findViewById(R.id.addAge);
//        addTeam = (EditText) findViewById(R.id.addTeam);
        addYear = (EditText) findViewById(R.id.addYear);
        addGender = (EditText) findViewById(R.id.addGender);
        addSport = (EditText) findViewById(R.id.addSport);
        addOvrScore = (EditText) findViewById(R.id.addOvrScore);

        addBtn = (Button) findViewById(R.id.addButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pName = addName.getText().toString();
                String pAdmNo = addAdmNo.getText().toString();
                String pAge = addAge.getText().toString();
                String pYear = addYear.getText().toString();
                String pGender = addGender.getText().toString();
//                int pTeam = Integer.valueOf(addTeam.getText().toString());
                int pScore = Integer.valueOf(addOvrScore.getText().toString());
                long flag = sqlHelper.addPlayer(pName, pAdmNo, pAge, pGender=="Male", deptName, pYear);
                if(flag==-1) {
                    Toast.makeText(AddUserDepartmentActivity.this, "Data can't be inserted in Player", Toast.LENGTH_SHORT).show();
                }

                String sport = addSport.getText().toString();
                Cursor c1 = sqlHelper.getSId(sport);
                @SuppressLint("Range") String sID = c1.getString(c1.getColumnIndex("sports_id"));

                flag = sqlHelper.addPlayerInSport(pAdmNo, Integer.parseInt(sID), pScore);
                if(flag==-1) {
                    Toast.makeText(AddUserDepartmentActivity.this, "Data can't be inserted in Sport", Toast.LENGTH_SHORT).show();
                }

                Cursor c2 = sqlHelper.getTeamIdFromSports(Integer.parseInt(sID));
                @SuppressLint("Range") int teamID = c2.getInt(c2.getColumnIndex("team_id"));
                flag = sqlHelper.addPlayerInTeam(teamID , pAdmNo);
                if(flag==-1) {
                    Toast.makeText(AddUserDepartmentActivity.this, "Data can't be inserted in Team", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(), DepartmentwiseUsersActivity.class);
                intent.putExtra("dept", deptName);
                startActivity(intent);
            }
        });
    }
}
