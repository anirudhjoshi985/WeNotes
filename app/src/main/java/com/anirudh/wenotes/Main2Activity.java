package com.anirudh.wenotes;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    GoogleSignInClient mGoogleSignInClient;
    private long backPressedTime;
    Toast backToast;

    List<Course> Courselist;
    RecyclerView mRecyclerView;

    int semNo;
    int branchNo;
    int coursecount;

    /*
    Branch Number
    1 = CSE
    2.= CCE
    3.= ECE
    4.= ME
     */

    public Main2Activity() {
    }

    public Main2Activity(int semNo, int branchNo) {
        this.semNo = semNo;
        this.branchNo = branchNo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_1);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Courselist = new ArrayList<>();

        Courselist.add(new Course("course1",5,R.mipmap.ic_launcher));
        Courselist.add(new Course("course2",5,R.mipmap.ic_launcher));
        Courselist.add(new Course("course3",5,R.mipmap.ic_launcher));
        Courselist.add(new Course("course4",5,R.mipmap.ic_launcher));
        Courselist.add(new Course("course5",5,R.mipmap.ic_launcher));
        Courselist.add(new Course("course6",5,R.mipmap.ic_launcher));

        CardAdapter adapter = new CardAdapter(this,Courselist);
        mRecyclerView.setAdapter(adapter);

    }

    public void showPopup(View view){

        PopupMenu mPopupMenu = new PopupMenu(this,view);
        mPopupMenu.setOnMenuItemClickListener(this);
        mPopupMenu.inflate(R.menu.menu_1);
        mPopupMenu.show();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(Main2Activity.this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        switch(menuItem.getItemId())
        {
            case R.id.item_1 :
                signOut();
                Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_2 :

                Toast.makeText(this, "Feedback Sent", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_3 :

                Toast.makeText(this, "Shared", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item_4 :

                Toast.makeText(this, "Developers", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Main2Activity.this,"Successfully signed out",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Main2Activity.this, MainActivity.class));
                        finish();
                    }
                });
    }

    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis())
        {
            super.onBackPressed();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            finish();
            System.exit(0);
            // android.os.Process.killProcess(android.os.Process.myPid());
            return;
        }
        else{
            backToast = Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}
