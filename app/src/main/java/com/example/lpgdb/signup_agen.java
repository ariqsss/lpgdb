package com.example.lpgdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import helpers.InputValidation;
import sql.DatabaseHelper;

public class signup_agen extends AppCompatActivity {

    private final AppCompatActivity activity = signup_agen.this;

    private EditText EditTextUsername;
    private EditText EditTextPassword;
    private Button ButtonSignup;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_agen);

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
            user.setRole("agen");

            databaseHelper.addUser(user);


        }
        Intent intent = new Intent(this, Home_agen.class);
        startActivity(intent);
    }


    public void HalamanHomeAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home_agen.class);
        startActivity(intent);
    }
}
