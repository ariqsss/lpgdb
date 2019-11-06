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

import java.util.ArrayList;
import java.util.List;

public class lpgorderadapter extends ArrayAdapter<pojo>{
    private Context mContext;
    private List<pojo> orderList = new ArrayList<>();

    public lpgorderadapter(@NonNull Context context, @LayoutRes ArrayList<pojo> list) {
        super(context, 0 , list);
        mContext = context;
        orderList = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.order_list,parent,false);

        pojo currentorder = orderList.get(position);

        TextView jumlah = (TextView) listItem.findViewById(R.id.textView_jumlah);
        jumlah.setText(currentorder.getOrder_jumlah());

        TextView tanggal = (TextView) listItem.findViewById(R.id.textView_tanggal);
        tanggal.setText(currentorder.getOrder_tanggal());

        TextView harga = (TextView) listItem.findViewById(R.id.textView_harga);
        harga.setText(currentorder.getOrder_harga());

        return listItem;
    }
}
