package com.test.xebia.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.test.xebia.myapplication.R;

/**
 * Created by sandeepsingh on 5/16/18.
 */

public class Addressfragment extends Fragment implements View.OnClickListener {
    private EditText add1, add2;
    private Button btnSignUp;
    String f_name, l_name, dob, address1, address2, city;
    MaterialSpinner spinner;

    public Addressfragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address, container, false);
        getActivity().setTitle("Address");
        f_name = getArguments().getString("f_name");
        l_name = getArguments().getString("l_name");
        dob = getArguments().getString("dob");


        add1 = (EditText) view.findViewById(R.id.input_add1);
        add2 = (EditText) view.findViewById(R.id.input_add2);
        btnSignUp = (Button) view.findViewById(R.id.btn_save);
        btnSignUp.setOnClickListener(this);
        spinner = (MaterialSpinner) view.findViewById(R.id.spinner);
        spinner.setItems("Gurgaon", "Noida", "Delhi", "Faridabad");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                city = item;
                Toast.makeText(getActivity(), "Clicked " + item, Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_save) {

            address1 = add1.getText().toString();
            address2 = add2.getText().toString();
            if (address1.matches("") && address2.matches("")) {
                Toast.makeText(getActivity(), "Please add all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment startingFragment;
            startingFragment = new UserProfile();
            Bundle args = new Bundle();
            args.putString("f_name", f_name);
            args.putString("l_name", l_name);
            args.putString("dob", dob);
            args.putString("address1", address1);
            args.putString("address2", address2);
            args.putString("city", city);
            startingFragment.setArguments(args);
            fragmentTransaction.replace(R.id.home_fragment_container, startingFragment);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_exit).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        getActivity().finish();
        return  true;
    }
}
