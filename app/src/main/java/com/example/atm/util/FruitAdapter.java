package com.example.atm.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.atm.R;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.date = (TextView) view.findViewById(R.id.textView1);
            viewHolder.exchange= (TextView) view.findViewById(R.id.textView2);
            viewHolder.type = (TextView) view.findViewById(R.id.textView3);
            view.setTag(viewHolder); //将ViewHoder存储至View中
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); //重新获取ViewHolder
        }
        viewHolder.date.setText(fruit.getDate());
        viewHolder.exchange.setText(fruit.getExchange());
        viewHolder.type.setText(fruit.getType());
        return view;
    }
    // 新建类将控件的所有实例都放在ViewHolder中， 没有必要每次都通过findViewById()方法来获取控件实例了
    class ViewHolder {
        TextView date;
        TextView exchange;
        TextView type;
    }
}
