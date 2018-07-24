package de.bht.inf1;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by s72210 on 19.07.2018.
 */

public class MyArrayAdapter extends ArrayAdapter {

    public int count = 0;

    public MyArrayAdapter(TicketListActivity ticketListActivity, int simple_list_item_1, String[] strings) {
        super(ticketListActivity, simple_list_item_1, strings);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = super.getView(position, convertView, parent);
        TextView textView = (TextView) view.findViewById(android.R.id.text1);

        if(count%2==0){
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundColor(Color.GRAY);
        }else{
            textView.setTextColor(Color.GRAY);
            textView.setBackgroundColor(Color.WHITE);
        }

        count++;

        return view;
    }
}
