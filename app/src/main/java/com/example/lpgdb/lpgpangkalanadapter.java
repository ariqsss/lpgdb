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

public class lpgpangkalanadapter extends ArrayAdapter<pangkalan>{
    private Context mContext;
    private List<pangkalan> pangkalanList = new ArrayList<>();

    public lpgpangkalanadapter(@NonNull Context context, @LayoutRes ArrayList<pangkalan> list) {
        super(context, 0 , list);
        mContext = context;
        pangkalanList = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.pangkalan_list,parent,false);

        pangkalan currentorder = pangkalanList.get(position);

        TextView idpangkalan = (TextView) listItem.findViewById(R.id.text_idpangkalan);
        idpangkalan.setText(currentorder.getSettingagen_idpangkalan());

        TextView namapangkalan = (TextView) listItem.findViewById(R.id.text_namapangkalan);
        namapangkalan.setText(currentorder.getSettingagen_namapangkalan());

        TextView hargapangkalan = (TextView) listItem.findViewById(R.id.text_hargapangkalan);
        hargapangkalan.setText(currentorder.getSettingagen_hargapangkalan());

        TextView tglefektif = (TextView) listItem.findViewById(R.id.text_tglefektif);
        tglefektif.setText(currentorder.getSettingagen_tglefektif());

        TextView nohppangkalan = (TextView) listItem.findViewById(R.id.text_nohp);
        nohppangkalan.setText(currentorder.getSettingagen_nohppangkalan());

        TextView emailpangkalan = (TextView) listItem.findViewById(R.id.text_emailpangkalan);
        emailpangkalan.setText(currentorder.getSettingagen_emailpangkalan());

        return listItem;
    }
}
