package com.huatec.myapplication.model;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huatec.myapplication.R;
import com.huatec.myapplication.adapter.EquipmemtAdapter;

import java.util.ArrayList;
import java.util.List;

public class EquipmentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_list);
        //recycleView 初始化
        RecyclerView rvEquipment = findViewById(R.id.rv_equipment);
        rvEquipment.setHasFixedSize(true);
        rvEquipment.setLayoutManager(new LinearLayoutManager(this));


        //初始化列表数据，设置到适配器
        List<EquipmentBean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            EquipmentBean equipmentBean = new EquipmentBean();
            equipmentBean.setTitle("第" + (i+1) +"个设备的标题");
            if(i%2==0){
                equipmentBean.setDescription("由于温度与湿度不管是从物理量本身还是在实际人们的生活中都有密切关系，所以温湿度一体的传感器就会相应产生。温湿度传感器是指能将温度量和湿度量转换成容易被测量处理的电信号的设备或装置。 市场上的温湿度传感器一般是测量温度量和相对湿度量。");
                equipmentBean.setImgId(R.drawable.led);
            }else{
                equipmentBean.setDescription("电能表是用来测量电能的仪表，又称电度表，火表，千瓦小时表，指测量各种电学量的仪表。\n" +
                        "使用电能表时要注意，在低电压（不超过500伏）和小电流（几十安）的情况下，电能表可直接接入电路进行测量。在高电压或大电流的情况下，电能表不能直接接入线路，需配合电压互感器或电流互感器使用。");
                equipmentBean.setImgId(R.drawable.watch);
            }
            list.add(equipmentBean);
        }

        //设置适配器
        EquipmemtAdapter equipmentAdapter = new EquipmemtAdapter(this);
        equipmentAdapter.setData(list);
        rvEquipment.setAdapter(equipmentAdapter);
        equipmentAdapter.setOnItemClickListener(new EquipmemtAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(EquipmentBean item) {
                Toast.makeText(EquipmentListActivity.this, item.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
