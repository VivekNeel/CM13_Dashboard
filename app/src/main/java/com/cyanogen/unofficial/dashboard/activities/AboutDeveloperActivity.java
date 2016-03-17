package com.cyanogen.unofficial.dashboard.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.cyanogen.unofficial.dashboard.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shiva on 13-03-2016.
 */
public class AboutDeveloperActivity extends AppCompatActivity {

    @Bind(R.id.facebook_card)
    CardView facebookCard;
    @Bind(R.id.google_plus_card)
    CardView googleplusCard;
    @Bind(R.id.linkdeln_card)
    CardView linkdelnCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_dev);
        ButterKnife.bind(this);


        updateCards();
    }

    public void updateCards() {

        facebookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                facebookIntent.setData(Uri.parse(getResources().getString(R.string.facebook_link)));
                startActivity(facebookIntent);
            }
        });

        googleplusCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent googleplusIntent = new Intent(Intent.ACTION_VIEW);
                googleplusIntent.setData(Uri.parse(getResources().getString(R.string.google_plus_link)));
                startActivity(googleplusIntent);

            }
        });

        linkdelnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linkedlnIntent = new Intent(Intent.ACTION_VIEW);
                linkedlnIntent.setData(Uri.parse(getResources().getString(R.string.linkedln_link)));
                startActivity(linkedlnIntent);
            }
        });

    }
}
