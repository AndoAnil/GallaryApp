package com.example.galarryapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private List<Integer> mThumbId;
    private Context mContext;

    public ImageAdapter(List<Integer> mThumbId, Context mContext) {
        this.mThumbId = mThumbId;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mThumbId.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return mThumbId.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=(ImageView) convertView;
        if(imageView==null)
        {
            imageView=new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300,400));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        imageView.setImageResource(mThumbId.get(position));
        return imageView;
    }
}
