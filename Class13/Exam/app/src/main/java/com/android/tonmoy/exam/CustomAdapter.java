package com.android.tonmoy.exam;

import android.app.Activity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataBase> {
    private ArrayList<DataBase> peoples;
    Activity context;

    public CustomAdapter(Activity context, ArrayList<DataBase> peoples) {
        super(context, R.layout.row_layout, peoples);
        this.context = context;
        this.peoples = peoples;
    }
}
