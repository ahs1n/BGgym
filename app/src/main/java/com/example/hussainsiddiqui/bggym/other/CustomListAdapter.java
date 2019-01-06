package com.example.hussainsiddiqui.bggym.other;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hussainsiddiqui.bggym.R;
import com.example.hussainsiddiqui.bggym.contract.UserDataProvider;
import com.example.hussainsiddiqui.bggym.ui.Registration;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {

    ArrayList<UserDataProvider> list;
    Context context;

    public CustomListAdapter(Context context, int textViewResourceId, ArrayList<UserDataProvider> objects) {
        super(context, textViewResourceId, objects);
        list = objects;

        this.context = context;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        View v = view;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.customlayout, null);
        final TextView name = v.findViewById(R.id.textView_name);
        TextView email = v.findViewById(R.id.textView_email);

        name.setText(list.get(position).getName());
        email.setText(list.get(position).getEmail());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cb = new Intent(context, Registration.class);
                cb.putExtra("userInfo", list.get(position));
                context.startActivity(cb);
            }
        });

        return v;
    }
}
