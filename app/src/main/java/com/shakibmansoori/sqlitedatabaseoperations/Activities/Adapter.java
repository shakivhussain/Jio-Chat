package com.shakibmansoori.sqlitedatabaseoperations.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shakibmansoori.sqlitedatabaseoperations.R;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Model> {

    public Adapter(Context context, ArrayList<Model> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Model currentItem = getItem(position);

        assert itemView != null;
        ImageView mProfile;

        TextView mTitleTv, mSubTitleTv;

        mProfile = itemView.findViewById(R.id.profileIv);
        mProfile.setImageResource(currentItem.getmImgViewid());

        mTitleTv = itemView.findViewById(R.id.titleTv);
        mTitleTv.setText(currentItem.getmTitle());

        mSubTitleTv = itemView.findViewById(R.id.subtitileTv);
        mSubTitleTv.setText(currentItem.getmSubtitle());

        return itemView;


    }
}
