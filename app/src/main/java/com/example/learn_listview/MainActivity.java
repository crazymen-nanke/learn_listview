package com.example.learn_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.learn_listview.adapter.ListViewAdapter;
import com.example.learn_listview.bean.DataBean;
import com.example.learn_listview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //模拟数据
    String[] text = {"花卉1", "花卉2", "花卉3", "花卉4"};
    int[] src = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

    private ArrayList<DataBean> beans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = com.example.learn_listview.databinding.ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListViewByBaseAdapter();
    }

    //使用BaseAdapter，使用JavaBean对象封装复杂数据（数据类型不唯一）
    private void setListViewByBaseAdapter() {
        beans = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            DataBean bean = new DataBean();
            bean.setSrc(src[i]);
            bean.setText(text[i]);
            beans.add(bean);
        }

        ListViewAdapter adapter = new ListViewAdapter(beans, MainActivity.this);
        binding.listView.setAdapter(adapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, text[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    //使用SimpleAdapter,这个适配器只可以装配一些简单的数据（数据类型单一）
    private void setListViewBySimpleAdapter() {

        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("text", text[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, list, R.layout.listview_item, new String[]{"text"}, new int[]{R.id.textView});
        binding.listView.setAdapter(adapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, text[position], Toast.LENGTH_SHORT).show();
            }
        });
    }


}