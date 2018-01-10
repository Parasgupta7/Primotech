package com.example.paras.primotech;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class profile extends Fragment {

    TextView textViewId, textViewUsername, textViewEmail, textViewGender;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewId = (TextView)getView(). findViewById(R.id.textViewId);
        textViewUsername = (TextView)getView(). findViewById(R.id.textViewUsername);
        textViewEmail = (TextView)getView(). findViewById(R.id.textViewEmail);
        textViewGender = (TextView)getView(). findViewById(R.id.textViewGender);


       // User user = SharedPrefManager.getInstance(this.getActivity()).getUser();

        //setting the values to the textviews
      //  textViewId.setText(String.valueOf(user.getId()));
       // textViewUsername.setText(user.getUsername());
      //  textViewEmail.setText(user.getEmail());
       // textViewGender.setText(user.getGender());
        getActivity().setTitle("profile");


        getView().findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                SharedPrefManager.getInstance(getActivity().getApplicationContext()).logout();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        if (!SharedPrefManager.getInstance(this.getActivity()).isLoggedIn()) {
            getActivity().finish();
            startActivity(new Intent(this.getActivity(), Login.class));
        }







        return inflater.inflate(R.layout.fragment_profile, container, false);
    }


}
