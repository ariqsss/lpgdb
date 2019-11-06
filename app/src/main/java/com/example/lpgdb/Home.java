package com.example.lpgdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {


    private String usernameextra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_home);
        Intent currentintent = getIntent();
        usernameextra = currentintent.getStringExtra("USER_NAME");
        Toast.makeText(getApplicationContext(),usernameextra, Toast.LENGTH_SHORT).show();

    }
    ///Halaman Order
    public void HalamanOrder(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Order.class);
       intent.putExtra("USER_NAME",usernameextra);
        startActivity(intent);
    }
    ///Halaman Penjualan
    public void HalamanPenjualan(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Penjualan.class);
        intent.putExtra("USER_NAME",usernameextra);
        startActivity(intent);
    }
    ///Halaman Profile
    public void HalamanProfile(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Profile.class);
        intent.putExtra("USER_NAME",usernameextra);
        startActivity(intent);
    }

}
