package com.huatec.myapplication.model;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huatec.myapplication.R;
import com.huatec.myapplication.adapter.BasicAdapter;

import java.util.ArrayList;
import java.util.List;

public class BasicListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list);
        //recycleView 初始化
        RecyclerView rvBasicList = findViewById(R.id.rv_basic_list);
        rvBasicList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvBasicList.setLayoutManager(linearLayoutManager);

        //初始化列表数据，设置适配器
        List<String> srcList = new ArrayList<>();
        for(int i=0;i < 100 ; i++){
            srcList.add("第" + (i+1) + "行");
        }

        BasicAdapter basicAdapter = new BasicAdapter(this,srcList);
        rvBasicList.setAdapter(basicAdapter);
    }
}
