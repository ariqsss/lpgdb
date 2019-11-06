package com.example.lpgdb;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OrderForm extends AppCompatActivity {


    static ArrayList<pojo> orderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.order_form);


    }
    public ArrayList getList() {
        return orderList;
    }
    public void addList(String jumlah,String tanggal,String harga) {
        orderList.add(new pojo(jumlah,tanggal,harga));
    }

    public void buatOrder(View view) {

        EditText inputJumlah=(EditText)findViewById(R.id.settingagen_idpangkalan);
        String jumlah = inputJumlah.getText().toString();
        EditText inputTanggal=(EditText)findViewById(R.id.settingagen_namapangkalan);
        String tanggal = inputTanggal.getText().toString();
        EditText inputHarga=(EditText)findViewById(R.id.settingagen_tglefektif);
        String harga = inputHarga.getText().toString();
        orderList.add(new pojo(jumlah,tanggal,harga));
      //  orders.addList(tanggal,jumlah,harga);
        Intent intent = new Intent(this, Order.class);
        startActivity(intent);
    }
    public void HalamanHome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
    public void HalamanOrder(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Order.class);
        startActivity(intent);
    }
    ///Halaman Penjualan
    public void HalamanPenjualan(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Penjualan.class);
        startActivity(intent);
    }
    ///Halaman Profile
    public void HalamanProfile(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}
