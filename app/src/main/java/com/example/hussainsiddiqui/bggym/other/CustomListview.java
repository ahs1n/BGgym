package com.example.hussainsiddiqui.bggym.other;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListview extends ArrayAdapter<String> {

    private Integer[] IMAGES;
    private String[] NAMES;
    private String[] DESCRIPTION;
    private Activity context;

    public CustomListview(Activity context, String[] NAMES, String[] DESCRIPTION, Integer[] IMAGES) {
        super(context, com.example.hussainsiddiqui.bggym.R.layout.customlayout, NAMES);

        this.context = context;
        this.NAMES = NAMES;
        this.DESCRIPTION = DESCRIPTION;
        this.IMAGES = IMAGES;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if (r == null) {

            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(com.example.hussainsiddiqui.bggym.R.layout.customlayout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.ivw.setImageResource(IMAGES[position]);

        viewHolder.tvw1.setText(NAMES[position]);
        viewHolder.tvw1.setText(DESCRIPTION[position]);


        return super.getView(position, convertView, parent);
    }

    class ViewHolder {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;

        ViewHolder(View v) {
            tvw1 = v.findViewById(com.example.hussainsiddiqui.bggym.R.id.textView_name);
            tvw1 = v.findViewById(com.example.hussainsiddiqui.bggym.R.id.textView_description);
            ivw = v.findViewById(com.example.hussainsiddiqui.bggym.R.id.imageView);
        }
    }
}
