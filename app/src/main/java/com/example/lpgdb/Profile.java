package com.example.lpgdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_profile);
    }
    ///Halaman Order
    public void HalamanHome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    ///Halaman Penjualan
    public void HalamanPenjualan(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Penjualan.class);
        startActivity(intent);
    }
    ///Halaman Profile
    public void HalamanOrder(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Order.class);
        startActivity(intent);
    }
}
