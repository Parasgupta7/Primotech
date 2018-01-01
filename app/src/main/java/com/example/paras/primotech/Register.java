package com.example.paras.primotech;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextPhone;
    private EditText editTextdob;

    private Button submit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initializing views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextdob = (EditText) findViewById(R.id.editTextdob);

        submit_button = (Button) findViewById(R.id.submit_button);

        //Setting listeners to button
        submit_button.setOnClickListener(this);
    }

    //Adding a user
    private void addUser(){

        final String name = editTextName.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        final String uname = editTextUsername.getText().toString().trim();
        final String pass = editTextPassword.getText().toString().trim();
        final String phone = editTextPhone.getText().toString().trim();
        final String dob = editTextdob.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                loading = ProgressDialog.show(Register.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Register.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_USER_PASS,pass);
                params.put(Config.KEY_USER_NAME,name);
                params.put(Config.KEY_USER_EMAIL,email);
                params.put(Config.KEY_USER_UNAME,uname);
                params.put(Config.KEY_USER_PHONE,phone);
                params.put(Config.KEY_USER_DOB,dob);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == submit_button){
            addUser();
            startActivity(new Intent(this,Navigation.class));
        }

    }
}
