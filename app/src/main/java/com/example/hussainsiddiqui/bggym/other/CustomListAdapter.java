package com.example.hussainsiddiqui.bggym.other;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public CustomListAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Object object) {
        super.add(object);
        list.add(object);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    static class LayoutHandler {

        TextView NAME, EMAIL, MOBILE;
    }
}
