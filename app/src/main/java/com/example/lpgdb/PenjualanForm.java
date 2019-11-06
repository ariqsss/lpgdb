package com.example.lpgdb;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import helpers.InputValidation;
import model.Penjualanmodel;
import sql.DatabaseHelper;

public class PenjualanForm extends AppCompatActivity {

    private final AppCompatActivity activity = PenjualanForm.this;

    static ArrayList<Penjualanmodel> penjualanList = new ArrayList<>();
    private EditText inputNama;
    private EditText inputAlamat;
    private EditText inputJumlah;
    private EditText inputTanggal;
    private Spinner spinnerstatus;
    private String status;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private Penjualanmodel penjualanmodel;

   private String usernameextra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.penjualan_form);

        Intent currentintent = getIntent();
        usernameextra = currentintent.getStringExtra("USER_NAME");
        Toast.makeText(getApplicationContext(),usernameextra, Toast.LENGTH_SHORT).show();
        initViews();
        initObjects();
    }
    public void initViews(){
        inputNama=(EditText)findViewById(R.id.penjualan_nama);
         inputAlamat=(EditText)findViewById(R.id.penjualan_alamat);
    inputJumlah=(EditText)findViewById(R.id.penjualan_jumlah);
       inputTanggal=(EditText)findViewById(R.id.penjualan_tanggal);
        spinnerstatus = (Spinner) findViewById(R.id.spinner1);
    }
    public void initObjects(){
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        penjualanmodel = new Penjualanmodel(inputNama.getText().toString().trim()
                ,spinnerstatus.getSelectedItem().toString().trim(),
                inputAlamat.getText().toString().trim(),
                inputJumlah.getText().toString().trim(),
                inputTanggal.getText().toString().trim());

    }

    public void postDataToSQLite(View view) {
//        if (!inputValidation.isInputEditTextFilled(EditTextUsername, getString(R.string.error_message_name))) {
//            return;
//        }
//
//        if (!inputValidation.isInputEditTextFilled(EditTextPassword, getString(R.string.error_message_password))) {
//            return;
//        }

        penjualanmodel.setNama(inputNama.getText().toString().trim());
        penjualanmodel.setStatus(spinnerstatus.getSelectedItem().toString().trim());
        penjualanmodel.setAlamat(inputAlamat.getText().toString().trim());
        penjualanmodel.setJumlah(inputJumlah.getText().toString().trim());
        penjualanmodel.setTanggal(inputTanggal.getText().toString().trim());
        penjualanmodel.setPangkalan(usernameextra);
        databaseHelper.addPenjualan(penjualanmodel);

        Intent intent = new Intent(this, Penjualan.class);
        intent.putExtra("USER_NAME",usernameextra);
        startActivity(intent);
    }

    public ArrayList getList() {
        return penjualanList;
    }








    public void HalamanHome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("USER_NAME",usernameextra);
        startActivity(intent);
    }
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
