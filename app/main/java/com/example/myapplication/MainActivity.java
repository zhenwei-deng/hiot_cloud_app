package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btBasicList = findViewById(R.id.bt_basic_list);
        Button btEquipmemtList = findViewById(R.id.bt_equipment_list);
        btBasicList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BasicListActivity.class);
                startActivity(intent);
            }
        });
        //设置设备列表点击事件
        btEquipmemtList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,EquipmentListActivity.class);
                startActivity(intent);
            }
        });
    }
}
