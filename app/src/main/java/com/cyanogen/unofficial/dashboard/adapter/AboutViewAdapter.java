package com.cyanogen.unofficial.dashboard.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cyanogen.unofficial.dashboard.R;
import com.cyanogen.unofficial.dashboard.model.AboutInfo;

import java.util.List;

/**
 * Created by Shiva on 14-03-2016.
 */
public class AboutViewAdapter extends RecyclerView.Adapter<AboutViewAdapter.MyHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<AboutInfo> aboutInfos;

    String text1 , text2;

    public AboutViewAdapter(Context context, List<AboutInfo> aboutInfos) {
        layoutInflater = layoutInflater.from(context);
        this.aboutInfos = aboutInfos;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item , parent,false);
        MyHolder myHolder = new MyHolder(v);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {



        holder.about.setText(aboutInfos.get(position).about);
        holder.aboutdesc.setText(aboutInfos.get(position).about_desc);

    }

    @Override
    public int getItemCount() {
        return aboutInfos.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView about, aboutdesc;

        public MyHolder(View itemView) {
            super(itemView);
            about = (TextView) itemView.findViewById(R.id.about_text);
            aboutdesc = (TextView) itemView.findViewById(R.id.about_text_desc);

        }
    }
}
