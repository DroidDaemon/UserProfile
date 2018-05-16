package com.test.xebia.myapplication.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.xebia.myapplication.R;
import com.test.xebia.myapplication.fragments.Homefragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Determine what fragment to start in. This is done through checking if the user
        // is logged in or not.
        Fragment startingFragment;
        String startingFragmentTag = null;
        startingFragment = new Homefragment();
        fragmentTransaction.add(R.id.home_fragment_container, startingFragment);
        fragmentTransaction.commit();

    }
}
