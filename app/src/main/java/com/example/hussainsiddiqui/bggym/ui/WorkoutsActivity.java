package com.example.hussainsiddiqui.bggym.ui;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.VideoView;

import com.example.hussainsiddiqui.bggym.R;

import java.util.ArrayList;

public class WorkoutsActivity extends AppCompatActivity {

    VideoView videoView;
    ListView listView;
    ArrayList<String> videoList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);

        this.setTitle("Workout Videos");

        videoView = findViewById(R.id.videoView);
        listView = findViewById(R.id.listview);
        videoList = new ArrayList<>();
        videoList.add("Play Video 1");
        videoList.add("Play Video 2");
        videoList.add("Play Video 3");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, videoList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        String fileName = "video_tr";
                        String filePlace = "android.resource://" + getPackageName() + "/raw/" + fileName;
                        videoView.setVideoURI(Uri.parse(filePlace));
                        videoView.requestFocus();
                        videoView.start();
                        break;

                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ved));
                        break;

                    case 2:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.by));
                        break;

                    default:
                        break;
                }
            }
        });
    }
}
