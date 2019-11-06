package com.example.lpgdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class Order extends AppCompatActivity {

    private ListView listView;
    private lpgorderadapter lpgAdapter;
    private String usernameextra;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_order);

        Intent currentintent = getIntent();
         usernameextra = currentintent.getStringExtra("USER_NAME");
        Toast.makeText(getApplicationContext(),usernameextra, Toast.LENGTH_SHORT).show();

        ArrayList<pojo> orderList=OrderForm.orderList;


        listView = (ListView) findViewById(R.id.order_list);



        lpgAdapter = new lpgorderadapter(this,orderList);
        listView.setAdapter(lpgAdapter);

    }





    ///Halaman Order
    public void HalamanHome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("USER_NAME",usernameextra);
        startActivity(intent);
    }
    public void HalamanOrderForm(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, OrderForm.class);
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
