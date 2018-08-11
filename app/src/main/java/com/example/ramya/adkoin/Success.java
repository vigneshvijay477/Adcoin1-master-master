package com.example.ramya.adkoin;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class Success extends AppCompatActivity implements Home.OnFragmentInteractionListener, Refer.OnFragmentInteractionListener, com.example.ramya.adkoin.history.OnFragmentInteractionListener{


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private Cashout cashfragment;
    private Balance balfragment;
    private Banners banfragment;
    private Bottomsheet bottomsheet;
    private Refer refer;
    private history history;
    private Home home;

    boolean mpressedonce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.navbot);

        cashfragment = new Cashout();
      //  balfragment = new Balance();
        banfragment = new Banners();
        bottomsheet = new Bottomsheet();
        refer = new Refer();
        history = new history();
        home= new Home();

        setFragment(cashfragment);

        BottomNavigationhelper.removeShiftMode(mMainNav);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_home:
                        setFragment(home);
                        return true;

                    case R.id.nav_cash:
                        setFragment(cashfragment);
                        return true;

                    case R.id.nav_ban:
                        setFragment(banfragment);
                        return true;

                    case R.id.nav_refer:
                     //   setFragment(refer);
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody = "Here is the share content body";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share via"));
                        //Toast.makeText(getApplicationContext(),"More Clicked",Toast.LENGTH_LONG).show();
                       // AccountKit.logOut();
                        //finish();

                        return true;
                    case R.id.nav_history:
                        setFragment(history);
                        return  true;



                    default:return false;

                }

            }
        });

    }

    private void setFragment(android.support.v4.app.Fragment fragment) {

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {

        if (mpressedonce) {
            super.onBackPressed();
            finishAffinity();

        }
        this.mpressedonce = true;
        Toast.makeText(this,"Press Back again to exit",Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mpressedonce = false;
            }
        }, 2000);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
