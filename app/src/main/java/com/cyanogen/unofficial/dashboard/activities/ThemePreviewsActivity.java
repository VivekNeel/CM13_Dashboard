package com.cyanogen.unofficial.dashboard.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import com.cyanogen.unofficial.dashboard.R;
import com.cyanogen.unofficial.dashboard.adapter.ThemePreviewAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.kaelaela.verticalviewpager.VerticalViewPager;
import me.kaelaela.verticalviewpager.transforms.StackTransformer;

/**
 * Created by Shiva on 13-03-2016.
 */
public class ThemePreviewsActivity extends FragmentActivity {

    private int[] preveiw_view_counts;
    private PagerAdapter pagerAdapter;
    @Bind(R.id.pager)
    VerticalViewPager verticalViewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.fragment_activity_viewpager);
        ButterKnife.bind(this);
        preveiw_view_counts = new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};
        pagerAdapter = new ThemePreviewAdapter(ThemePreviewsActivity.this, preveiw_view_counts);
        verticalViewPager.setAdapter(pagerAdapter);
        verticalViewPager.setPageTransformer(true, new StackTransformer());
    }
}
