package com.example.paras.primotech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private static final String TAG = Register.class.getSimpleName();
    EditText editTextUsername, editTextEmail, editTextPassword,editTextphone;
    TextView tv;
    Button btnregister;

    DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //if the user is already logged in we will directly start the profile activity
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Navigation.class));
            return;
        }

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextphone=findViewById(R.id.editTextPhone);
        btnregister = findViewById(R.id.buttonRegister);
        tv= findViewById(R.id.textViewLogin);


        mFirebaseInstance = FirebaseDatabase.getInstance();

        mFirebaseDatabase = mFirebaseInstance.getReference("User23455");

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = editTextUsername.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String pw = editTextPassword.getText().toString().trim();
                String phone = editTextphone.getText().toString().trim();
                if (!TextUtils.isEmpty(uname)) {
                    String id = mFirebaseDatabase.push().getKey();
                    User user = new User(id,uname,email,pw,phone);


                    mFirebaseDatabase.child(id).setValue(user);

                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                    Toast.makeText(getApplicationContext(), "Registered Succesfully", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(getApplicationContext(), "Please enter a Username", Toast.LENGTH_LONG).show();
                }



            }

        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this,Login.class);
                startActivity(i);
            }
        });


    }
}

