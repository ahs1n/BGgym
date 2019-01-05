package com.example.hussainsiddiqui.bggym.other;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hussainsiddiqui.bggym.R;

public class Group_List extends AppCompatActivity {

    int[] IMAGES = {R.drawable.biceps, R.drawable.fitness, R.drawable.general_training,
            R.drawable.weight_gain, R.drawable.thaiboxing, R.drawable.weight_loss};

    String[] NAMES = {"Body Building", "Fitness", "General Training", "Weight Gain", "Thaiboxing", "Weight Loss"};

    String[] DESCRIPTION = {"a", "b", "c", "d", "e", "f"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        ListView listView = findViewById(R.id.ListView);
//        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
//                Arrays.asList(NAMES)));

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout, null);

            ImageView imageView = view.findViewById(R.id.imageView);
            TextView textView_name = view.findViewById(R.id.textView_name);
            TextView textView_description = view.findViewById(R.id.textView_description);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTION[i]);
            return null;
        }
    }
}
