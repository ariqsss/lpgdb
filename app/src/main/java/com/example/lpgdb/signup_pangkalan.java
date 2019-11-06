package com.example.lpgdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.DatabaseMetaData;

import helpers.InputValidation;
import sql.DatabaseHelper;

public class signup_pangkalan extends AppCompatActivity {

    private final AppCompatActivity activity = signup_pangkalan.this;

    private EditText EditTextUsername;
    private EditText EditTextPassword;
    private Button ButtonSignup;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;
    private String usernameextra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_pangkalan);



        Toast.makeText(getApplicationContext(),usernameextra, Toast.LENGTH_SHORT).show();
        initViews();
        initObjects();
    }

    private void initViews() {
        EditTextUsername = (EditText) findViewById(R.id.signup_username);
        EditTextPassword = (EditText) findViewById(R.id.signup_password);
        ButtonSignup = (Button) findViewById(R.id.button_login);
    }

    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

    }

    public void postDataToSQLite(View view) {
        if (!inputValidation.isInputEditTextFilled(EditTextUsername, getString(R.string.error_message_name))) {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(EditTextPassword, getString(R.string.error_message_password))) {
            return;
        }


        if (databaseHelper.checkUser(EditTextUsername.getText().toString().trim())==0) {

            user.setUsername(EditTextUsername.getText().toString().trim());
            user.setPassword(EditTextPassword.getText().toString().trim());
            user.setRole("pangkalan");

            databaseHelper.addUser(user);


        }
        Intent intent = new Intent(this, Home.class);
        //intent.putExtra("USER_NAME",usernameextra);
        intent.putExtra("USER_NAME", EditTextUsername.getText().toString().trim());

        startActivity(intent);
    }
        public void HalamanHome (View view){
            // Do something in response to button
            Intent intent = new Intent(this, Home.class);
            intent.putExtra("USER_NAME",usernameextra);
            startActivity(intent);
        }
    }
