package com.anirudh.wenotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.lang.reflect.Array;

public class OptionsActivity extends AppCompatActivity {

    AutoCompleteTextView mACTVcollege,mACTVbranch,mACTVsemester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_activity);

        mACTVcollege = findViewById(R.id.actv_college);
        mACTVbranch = findViewById(R.id.actv_branch);
        mACTVsemester = findViewById(R.id.actv_semester);

        String[] mColleges = getResources().getStringArray(R.array.colleges);
        String[] mBranch = getResources().getStringArray(R.array.Branch);
        String[] mSemester = getResources().getStringArray(R.array.semester);

        ArrayAdapter<String> collegeAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,mColleges);
        mACTVcollege.setAdapter(collegeAdapter);

        ArrayAdapter<String> branchAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,mBranch);
        mACTVbranch.setAdapter(branchAdapter);

        ArrayAdapter<String> semesterAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, mSemester);
        mACTVsemester.setAdapter(semesterAdapter);
    }
}
