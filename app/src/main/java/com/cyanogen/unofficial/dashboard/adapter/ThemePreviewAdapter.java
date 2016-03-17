package com.cyanogen.unofficial.dashboard.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cyanogen.unofficial.dashboard.R;


/**
 * Created by Shiva on 13-03-2016.
 */
public class ThemePreviewAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private int[] items;
    private Context context;
    private ImageView screenshotPreview;

    public ThemePreviewAdapter(Context context, int[] view_counts) {

        this.context = context;
        this.items = view_counts;
    }


    /**
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.preview_image, container, false);
        screenshotPreview = (ImageView) view.findViewById(R.id.preview_screenshot);
        screenshotPreview.setImageResource(items[position]);
        ((ViewPager) container).addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout) object;
    }


    @Override
    public int getCount() {
        return items.length;
    }


}
