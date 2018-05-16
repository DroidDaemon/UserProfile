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
import android.widget.Toast;

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

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_cont) {
            String f_name = inputFirstName.getText().toString();
            String l_name = inputLastname.getText().toString();
            String dob = inputDob.getText().toString();
            if (f_name.matches("") && l_name.matches("") && dob.matches("")) {
                Toast.makeText(getActivity(), "Please add all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment startingFragment;
            String startingFragmentTag = null;
            startingFragment = new Addressfragment();
            Bundle args = new Bundle();
            args.putString("f_name", f_name);
            args.putString("l_name", l_name);
            args.putString("dob", dob);
            startingFragment.setArguments(args);
            fragmentTransaction.replace(R.id.home_fragment_container, startingFragment);
            fragmentTransaction.commit();

        }

    }
}
