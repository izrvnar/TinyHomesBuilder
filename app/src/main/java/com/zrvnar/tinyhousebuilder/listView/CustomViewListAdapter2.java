package com.zrvnar.tinyhousebuilder.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zrvnar.tinyhousebuilder.R;

import java.util.ArrayList;

public class CustomViewListAdapter2 extends ArrayAdapter<DataType> {


    public CustomViewListAdapter2(@NonNull Context context, @NonNull ArrayList<DataType> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        DataType item = getItem(position);

        if (convertView == null) {
            convertView =
                    LayoutInflater
                            .from(getContext())
                            .inflate(R.layout.list_item_view_two,parent, false);
            TextView name =  convertView.findViewById(R.id.dataNameText2);
            name.setText(item.getName());
            TextView type = convertView.findViewById(R.id.typeText);
            type.setText(item.getType());
            TextView location = convertView.findViewById(R.id.locationText);
            location.setText(item.getLocation());

        }
        return convertView;
    }
}
