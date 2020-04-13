package com.huatec.myapplication.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.huatec.myapplication.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        final EditText etTest=findViewById(R.id.et_password);
        Button btConfirm=findViewById(R.id.bt_confirm);
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this,etTest.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        Button btClose= findViewById(R.id.bt_close);
        btClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        CheckBox cbRun=findViewById(R.id.cb_run);
//         添加复选框事件
        cbRun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(SecondActivity.this, compoundButton.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox cbMusic=findViewById(R.id.cb_music);
        cbMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(SecondActivity.this, compoundButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        Switch swTest=findViewById(R.id.sw_test);
//        添加switch监听器
        swTest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Switch sw=((Switch)compoundButton);
                String text=b?sw.getTextOn().toString():sw.getTextOff().toString();
                Toast.makeText(SecondActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
