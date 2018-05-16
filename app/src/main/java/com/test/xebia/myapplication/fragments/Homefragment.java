package com.test.xebia.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.test.xebia.myapplication.R;


/**
 * Created by sandeepsingh on 5/16/18.
 */

public class Homefragment extends Fragment implements View.OnClickListener {
    private EditText inputFirstName, inputLastname, inputDob;
    private Button btnSignUp;

    public Homefragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        inputFirstName = (EditText) view.findViewById(R.id.input_first_name);
        inputLastname = (EditText) view.findViewById(R.id.input_last_name);
        inputDob = (EditText) view.findViewById(R.id.input_dob);
        btnSignUp = (Button) view.findViewById(R.id.btn_cont);
        btnSignUp.setOnClickListener(this);
        inputDob.setOnClickListener(this);

    return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_cont) {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Determine what fragment to start in. This is done through checking if the user
            // is logged in or not.
            Fragment startingFragment;
            String startingFragmentTag = null;
            startingFragment = new Addressfragment();
            fragmentTransaction.replace(R.id.home_fragment_container, startingFragment);
            fragmentTransaction.commit();

        }else if(id == R.id.input_dob){

        }

    }
}
