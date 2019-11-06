package com.example.lpgdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Setting_agen_form extends AppCompatActivity {


    static ArrayList<pangkalan> pangkalanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.setting_agen_form);
    }

    public ArrayList getList() {
        return pangkalanList;
    }
    public void addList(String idpangkalan,String namapangkalan,String hargapangkalan,String tglefektif,String nohppangkalan,String emailpangkalan) {
        pangkalanList.add(new pangkalan(idpangkalan,namapangkalan,hargapangkalan,tglefektif,nohppangkalan,emailpangkalan));
    }

    public void buatPangkalan(View view) {

        EditText inputIdPangkalan=(EditText)findViewById(R.id.settingagen_idpangkalan);
        String idpangkalan = inputIdPangkalan.getText().toString();
        EditText inputNamaPangkalan=(EditText)findViewById(R.id.settingagen_namapangkalan);
        String namapangkalan = inputNamaPangkalan.getText().toString();
        EditText inputHargaPangkalan=(EditText)findViewById(R.id.settingagen_hargapangkalan);
        String hargapangkalan = inputHargaPangkalan.getText().toString();
        EditText inputTglEfektif=(EditText)findViewById(R.id.settingagen_tglefektif);
        String tglefektif = inputTglEfektif.getText().toString();
        EditText inputNoHP=(EditText)findViewById(R.id.settingagen_nohppangkalan);
        String nohppangkalan = inputNoHP.getText().toString();
        EditText inputEmailPangkalan=(EditText)findViewById(R.id.settingagen_emailpangkalan);
        String emailpangkalan = inputEmailPangkalan.getText().toString();

        pangkalanList.add(new pangkalan(idpangkalan,namapangkalan,hargapangkalan,tglefektif,nohppangkalan,emailpangkalan));
        //  orders.addList(tanggal,jumlah,harga);
        Intent intent = new Intent(this, Setting_agen.class);
        startActivity(intent);
    }
    public void HalamanHomeAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home_agen.class);
        startActivity(intent);
    }
    public void HalamanOrderAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Order_agen.class);
        startActivity(intent);
    }
    ///Halaman Penjualan
    public void HalamanSettingAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Setting_agen.class);
        startActivity(intent);
    }
    ///Halaman Profile
    public void HalamanProfileAgen(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Profile_agen.class);
        startActivity(intent);
    }
}
