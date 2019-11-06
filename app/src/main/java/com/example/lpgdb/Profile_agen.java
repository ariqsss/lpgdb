package com.example.lpgdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profile_agen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_profile_agen);
    }

    ///Halaman Order
    public void HalamanHomeAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home_agen.class);
        startActivity(intent);
    }
    ///Halaman Penjualan
    public void HalamanSettingAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Setting_agen.class);
        startActivity(intent);
    }
    ///Halaman Profile
    public void HalamanOrderAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Order_agen.class);
        startActivity(intent);
    }
}
