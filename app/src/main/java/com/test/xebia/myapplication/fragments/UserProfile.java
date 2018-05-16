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
    private String name_s,name_l,dob_s,add1_s,add2_s,city_s;

    public UserProfile() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userprofile, container, false);
        name_s = getArguments().getString("f_name");
        name_l = getArguments().getString("l_name");
        dob_s = getArguments().getString("dob");
        add1_s= getArguments().getString("address1");
        add2_s = getArguments().getString("address2");
        city_s = getArguments().getString("city");


        f_name = (TextView) view.findViewById(R.id.first_name);
        l_name = (TextView) view.findViewById(R.id.last_name);
        dob = (TextView) view.findViewById(R.id.dob);
        add1 = (TextView) view.findViewById(R.id.add1);
        add2 = (TextView) view.findViewById(R.id.add2);
        city = (TextView) view.findViewById(R.id.city);
        addMore = (Button) view.findViewById(R.id.btn_addmore);
        addMore.setOnClickListener(this);
         setDataInTextView();

        return view;
    }

    private void setDataInTextView() {
        f_name.setText(name_s);
        l_name.setText(name_l);
        dob.setText(dob_s);
        add1.setText(add1_s);
        add2.setText(add2_s);
        city.setText(city_s);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btn_addmore) {

        }
    }
}
