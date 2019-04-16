package com.anirudh.wenotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;

public class OptionsActivity extends AppCompatActivity {

    AutoCompleteTextView mACTVcollege, mACTVbranch, mACTVsemester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);

        Button mNextButton = findViewById(R.id.next_options);

        mACTVcollege = findViewById(R.id.actv_college);
        mACTVbranch = findViewById(R.id.actv_branch);
        mACTVsemester = findViewById(R.id.actv_semester);

        String[] mColleges = getResources().getStringArray(R.array.colleges);
        String[] mBranch = getResources().getStringArray(R.array.Branch);
        String[] mSemester = getResources().getStringArray(R.array.semester);

        ArrayAdapter<String> collegeAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mColleges);
        mACTVcollege.setAdapter(collegeAdapter);

        ArrayAdapter<String> branchAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mBranch);
        mACTVbranch.setAdapter(branchAdapter);

        ArrayAdapter<String> semesterAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mSemester);
        mACTVsemester.setAdapter(semesterAdapter);


        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkActivity();
            }
        });
    }

    void checkActivity() {

        int i = 0;
        if (mACTVcollege.getText().toString().isEmpty()) {
            i++;
        }
        if (mACTVbranch.getText().toString().isEmpty()) {
            i++;
        }
        if (mACTVsemester.getText().toString().isEmpty()) {
            i++;
        }
        if (i > 0) {
            Toast.makeText(OptionsActivity.this, "Please fill all the fields", Toast.LENGTH_LONG).show();
        } else {
            startActivity(new Intent(OptionsActivity.this, Main2Activity.class));
        }
    }


}
