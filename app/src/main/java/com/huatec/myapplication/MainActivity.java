package com.huatec.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.huatec.myapplication.model.BasicListActivity;
import com.huatec.myapplication.model.EquipmentListActivity;
import com.huatec.myapplication.model.SecondActivity;

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
                Intent intent = new Intent(MainActivity.this, BasicListActivity.class);
                startActivity(intent);
            }
        });
        //设置设备列表点击事件
        btEquipmemtList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EquipmentListActivity.class);
                startActivity(intent);
            }
        });
         final TextView tvTest = findViewById(R.id.tv_testName);
         final TextView tvTest1=findViewById(R.id.tv_testClass);
         final TextView tvTest2=findViewById(R.id.tv_testId);
        Button btTest = findViewById(R.id.bt_test);
        Log.d("tag1","debug1");
        Log.d("tag1","debug2");
        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTest.setText("邓振微");
                tvTest1.setText("17物联网2班");
                tvTest2.setText("20172398");

                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

                int a=100;
                try {
                    a=a/0;
                }catch (Exception e){
                    Log.e("tag",e.getMessage());
                }
            }
        });

    }

}
