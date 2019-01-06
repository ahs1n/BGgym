package com.example.hussainsiddiqui.bggym.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.hussainsiddiqui.bggym.R;

public class GroupListActivity extends AppCompatActivity {

    ListView listView;
    Integer[] IMAGES = {R.drawable.biceps, R.drawable.fitness, R.drawable.general_training,
            R.drawable.weight_gain, R.drawable.thaiboxing, R.drawable.weight_loss};

    String[] NAMES = {"Body Building", "Fitness", "General Training", "Weight Gain", "Thaiboxing", "Weight Loss"};

    String[] DESCRIPTION = {"Display 1", "Display 2", "Display 3", "Display 4", "Display 5", "Display 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        ListView listView = findViewById(R.id.ListView);
//        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
//                Arrays.asList(NAMES)));

//        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_2,
//                Arrays.asList(IMAGES)));


//        CustomAdapter customAdapter = new CustomAdapter();
//        listView.setAdapter(customAdapter);
    }
}

/*
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

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView textView_name = (TextView) view.findViewById(R.id.textView_name);
        TextView textView_description = (TextView) view.findViewById(R.id.textView_description);

        imageView.setImageResource(IMAGES[i]);
        textView_name.setText(NAMES[i]);
        textView_description.setText(DESCRIPTION[i]);
        return null;
    }
}
}
*/
