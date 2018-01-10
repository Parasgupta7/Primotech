package com.example.paras.primotech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Navigation.class));
            return;
        }
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        btn = findViewById(R.id.buttonLogin);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference root = FirebaseDatabase.getInstance().getReference();
                DatabaseReference users = root.child("User23455");
                Query query = users.orderByChild("uname").equalTo(editTextUsername.getText().toString().trim());
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {

                            for (DataSnapshot user : dataSnapshot.getChildren()) {
                                User usersBean = user.getValue(User.class);

                                if (usersBean.pw.equals(editTextPassword.getText().toString().trim())) {
                                    Toast.makeText(getApplicationContext(), "Password is coorect", Toast.LENGTH_LONG).show();
                                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(usersBean);

                                    Intent intent = new Intent(getApplicationContext(), Navigation.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Password is wrong", Toast.LENGTH_LONG).show();
                                }
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }







}
