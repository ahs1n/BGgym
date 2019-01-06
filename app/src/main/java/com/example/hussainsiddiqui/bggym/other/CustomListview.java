package com.example.hussainsiddiqui.bggym.other;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hussainsiddiqui.bggym.R;

public class CustomListview extends ArrayAdapter<String> {

    private Integer[] IMAGES;
    private String[] NAMES;
    private String[] DESCRIPTION;
    private Activity context;

    public CustomListview(Activity context, String[] NAMES, String[] DESCRIPTION, Integer[] IMAGES) {
        super(context, R.layout.customlayout, NAMES);

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
            r = layoutInflater.inflate(R.layout.customlayout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.ivw.setImageResource(IMAGES[position]);

        viewHolder.tvw1.setText(NAMES[position]);
        viewHolder.tvw1.setText(DESCRIPTION[position]);

        return r;
    }

    class ViewHolder {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;

        ViewHolder(View v) {
            tvw1 = v.findViewById(R.id.textView_name);
            tvw2 = v.findViewById(R.id.textView_email);
            ivw = v.findViewById(R.id.imageView);
        }
    }
}
