package com.shakibmansoori.sqlitedatabaseoperations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.shakibmansoori.sqlitedatabaseoperations.Activities.SignUpActivty.CountryModel;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<CountryModel> {


    public CountryAdapter(Context context, ArrayList<CountryModel> list) {
        super(context, 0, list);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.country_list_item, parent, false);
        }

        CountryModel currentItem = getItem(position);
        TextView countryNameTv, countryFlagTv, countryCodeTv, coyntryisoTv;

        countryNameTv = listItem.findViewById(R.id.countryNameTv);
        countryNameTv.setText(currentItem.getCountryName());

        countryFlagTv = listItem.findViewById(R.id.countryFlagTv);
        countryFlagTv.setText(currentItem.getCountryFlag());

        countryCodeTv = listItem.findViewById(R.id.countryCodeTv);
        countryCodeTv.setText(currentItem.getPhoneCode());

        return listItem;

    }
}
