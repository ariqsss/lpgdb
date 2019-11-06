package com.example.lpgdb;
import android.content.Context;
import android.graphics.Movie;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.LayoutRes;

import java.util.ArrayList;
import java.util.List;

import model.Penjualanmodel;

public class lpgpenjualanadapter extends ArrayAdapter<Penjualanmodel>{
    private Context mContext;
    private List<Penjualanmodel> penjualanList = new ArrayList<>();

    public lpgpenjualanadapter(@NonNull Context context, @LayoutRes ArrayList<Penjualanmodel> list) {
        super(context, 0 , list);
        mContext = context;
        penjualanList = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.penjualan_list,parent,false);

        Penjualanmodel currentorder = penjualanList.get(position);

        TextView nama = (TextView) listItem.findViewById(R.id.text_nama);
        nama.setText(currentorder.getNama());

        TextView status = (TextView) listItem.findViewById(R.id.text_status);
        status.setText(currentorder.getStatus());

        TextView alamat = (TextView) listItem.findViewById(R.id.text_alamat);
        alamat.setText(currentorder.getAlamat());

        TextView jumlah = (TextView) listItem.findViewById(R.id.text_jumlah);
        jumlah.setText(currentorder.getJumlah());

        TextView tanggal = (TextView) listItem.findViewById(R.id.text_tanggal);
        tanggal.setText(currentorder.getTanggal());



        return listItem;
    }
}
