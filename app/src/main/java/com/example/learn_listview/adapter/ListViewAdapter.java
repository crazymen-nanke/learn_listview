package com.example.learn_listview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learn_listview.R;
import com.example.learn_listview.bean.DataBean;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    ArrayList<DataBean> list;
    Context context;

    public ListViewAdapter(ArrayList<DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.listview_item,null);
            viewHold = new ViewHold();
            convertView.setTag(viewHold);
            viewHold.imageView = convertView.findViewById(R.id.imageView);
            viewHold.textView = convertView.findViewById(R.id.textView);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        viewHold.imageView.setImageResource(list.get(position).getSrc());
        viewHold.textView.setText(list.get(position).getText());
        return convertView;
    }

    class ViewHold {
        ImageView imageView;
        TextView textView;
    }
}
