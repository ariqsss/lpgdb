package com.example.lpgdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Setting_agen extends AppCompatActivity {

    private ListView listView;
    private lpgpangkalanadapter lpgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.setting_agen);

        ArrayList<pangkalan> pangkalanList=Setting_agen_form.pangkalanList;


        listView = (ListView) findViewById(R.id.pangkalan_list);



        lpgAdapter = new lpgpangkalanadapter(this,pangkalanList);
        listView.setAdapter(lpgAdapter);
    }

    public void HalamanHomeAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home_agen.class);
        startActivity(intent);
    }

    ///Halaman Order
    public void HalamanOrderAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Order_agen.class);
        startActivity(intent);
    }
    public void HalamanSettingForm(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Setting_agen_form.class);
        startActivity(intent);
    }
    ///Halaman Profile
    public void HalamanProfileAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Profile_agen.class);
        startActivity(intent);
    }
}
