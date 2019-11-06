package com.example.lpgdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import helpers.InputValidation;
import sql.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private final AppCompatActivity activity = MainActivity.this;


    private EditText EditTextUsername;
    private EditText EditTextPassword;

    private Button ButtonLogin;

    private TextView textViewsignuppangkalan;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initViews();

        initObjects();
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home.class);
        EditText editText = (EditText) findViewById(R.id.input_username);
        String message = EditTextUsername.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void initViews() {



       EditTextUsername = (EditText) findViewById(R.id.input_username);
        EditTextPassword = (EditText) findViewById(R.id.input_password);

       ButtonLogin = (Button) findViewById(R.id.button_login);

        textViewsignuppangkalan = (TextView) findViewById(R.id.text_signup_pangkalan);

    }

    /**

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);

    }



    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    public void verifyFromSQLite(View view) {
        if (!inputValidation.isInputEditTextFilled(EditTextUsername, getString(R.string.error_message_email))) {
            return;
        }

        if (!inputValidation.isInputEditTextFilled(EditTextPassword, getString(R.string.error_message_email))) {
            return;
        }

        if (databaseHelper.checkUser(EditTextUsername.getText().toString().trim()
                , EditTextPassword.getText().toString().trim()) == 1) {


            Intent accountsIntent = new Intent(activity, Home.class);
          accountsIntent.putExtra("USER_NAME", EditTextUsername.getText().toString().trim());

            Toast.makeText(getApplicationContext(),"Anda Login Sebagai Pangkalan", Toast.LENGTH_SHORT).show();
            startActivity(accountsIntent);


        }
        else if(databaseHelper.checkUser(EditTextUsername.getText().toString().trim()
                , EditTextPassword.getText().toString().trim()) == 2){
            Intent accountsIntent = new Intent(activity, Home_agen.class);
            accountsIntent.putExtra("USER_NAME", EditTextUsername.getText().toString().trim());
            emptyInputEditText();
            Toast.makeText(getApplicationContext(),"Anda Login Sebagai Agen", Toast.LENGTH_SHORT).show();
            startActivity(accountsIntent);
        }
        else{
           Toast.makeText(getApplicationContext(),"Username Password Tidak Terdaftar", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
       EditTextUsername.setText(null);
        EditTextPassword.setText(null);
    }


    public void HalamanSignUpPangkalan(View view){
        Intent intent=new Intent(this,signup_pangkalan.class);
                startActivity(intent);
    }
    public void HalamanSignUpAgen(View view){
        Intent intent=new Intent(this,signup_agen.class);
        startActivity(intent);
    }
}
