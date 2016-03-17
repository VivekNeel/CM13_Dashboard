package com.cyanogen.unofficial.dashboard.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cyanogen.unofficial.dashboard.R;
import com.cyanogen.unofficial.dashboard.adapter.AboutViewAdapter;
import com.cyanogen.unofficial.dashboard.model.AboutInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Shiva on 16-03-2016.
 */
public class AboutAppActivity extends AppCompatActivity {

    @Bind(R.id.recyler_container)
    RecyclerView recyclerView;

    AboutViewAdapter aboutViewAdapter;
    List<AboutInfo> aboutInfoList = new ArrayList<>();
    ;
    AboutInfo aboutInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyler_view);
        ButterKnife.bind(this);
        aboutViewAdapter = new AboutViewAdapter(getApplicationContext(), aboutInfoList);


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.setAdapter(aboutViewAdapter);
        getData();
    }


    public void getData() {
        aboutInfo = new AboutInfo("one", "onedesc");
        aboutInfoList.add(aboutInfo);

        aboutInfo = new AboutInfo("two", "twodesc");
        aboutInfoList.add(aboutInfo);

        aboutInfo = new AboutInfo("three", "Threedesc");
        aboutInfoList.add(aboutInfo);



    }
}
