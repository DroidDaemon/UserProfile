package com.test.xebia.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.test.xebia.myapplication.R;

/**
 * Created by sandeepsingh on 5/16/18.
 */

public class UserProfile extends Fragment implements View.OnClickListener  {
    private TextView f_name,l_name,dob,add1,add2,city;
    private Button addMore;

    public UserProfile() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userprofile, container, false);


        f_name = (TextView) view.findViewById(R.id.first_name);
        l_name = (TextView) view.findViewById(R.id.last_name);
        dob = (TextView) view.findViewById(R.id.dob);
        add1 = (TextView) view.findViewById(R.id.add1);
        add2 = (TextView) view.findViewById(R.id.add2);
        city = (TextView) view.findViewById(R.id.city);
        addMore = (Button) view.findViewById(R.id.btn_addmore);
        addMore.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_addmore) {

        }
    }
}
