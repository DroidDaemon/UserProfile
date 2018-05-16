package com.test.xebia.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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

public class Addressfragment extends Fragment implements View.OnClickListener  {
    private EditText add1, add2;
    private Button btnSignUp;

    public Addressfragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address, container, false);


        add1 = (EditText) view.findViewById(R.id.input_add1);
        add2 = (EditText) view.findViewById(R.id.input_add2);
        btnSignUp = (Button) view.findViewById(R.id.btn_save);
        btnSignUp.setOnClickListener(this);
        MaterialSpinner spinner = (MaterialSpinner) view.findViewById(R.id.spinner);
        spinner.setItems("Gurgaon", "Noida", "Delhi", "Faridabad");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Toast.makeText(getActivity(), "Clicked " + item, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_save) {

        }else if(id == R.id.input_dob){

        }

    }
}
