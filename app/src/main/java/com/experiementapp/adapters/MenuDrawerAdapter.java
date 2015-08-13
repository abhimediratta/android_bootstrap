package com.experiementapp.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.experiementapp.R;

public class MenuDrawerAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public MenuDrawerAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.row_drawer, itemname);
        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.row_drawer, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(android.R.id.text1);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.menu_icon);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        return rowView;

    };
}