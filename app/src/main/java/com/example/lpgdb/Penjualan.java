package com.example.lpgdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import model.Penjualanmodel;

public class Penjualan extends AppCompatActivity {

    private ListView listView;
    private lpgpenjualanadapter lpgAdapter;
    private String usernameextra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_penjualan);

        Intent currentintent = getIntent();
        usernameextra = currentintent.getStringExtra("USER_NAME");
        Toast.makeText(getApplicationContext(),usernameextra, Toast.LENGTH_SHORT).show();
        ArrayList<Penjualanmodel> penjualanList=PenjualanForm.penjualanList;


        listView = (ListView) findViewById(R.id.pangkalan_list);

        lpgAdapter = new lpgpenjualanadapter(this,penjualanList);
        listView.setAdapter(lpgAdapter);
    }
    ///Halaman Order
    public void HalamanHome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("USER_NAME",usernameextra);
        startActivity(intent);
    }
    public void HalamanPenjualan(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Penjualan.class);
        intent.putExtra("USER_NAME",usernameextra);
        startActivity(intent);
    }
    ///Halaman Order
    public void HalamanOrder(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Order.class);
        intent.putExtra("USER_NAME",usernameextra);
        startActivity(intent);
    }
    public void HalamanPenjualanForm(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, PenjualanForm.class);
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
