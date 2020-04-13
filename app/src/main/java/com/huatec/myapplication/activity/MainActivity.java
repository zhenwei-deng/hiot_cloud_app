package com.huatec.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.huatec.myapplication.R;
import com.huatec.myapplication.adapter.PhotoAdapter;
import com.huatec.myapplication.model.BasicListActivity;
import com.huatec.myapplication.model.EquipmentListActivity;
import com.huatec.myapplication.model.SecondActivity;
import com.huatec.myapplication.utils.Constants;
import com.huatec.myapplication.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

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
        Button btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //保存登录状态
                SharedPreferencesUtil.getInstance(MainActivity.this).setLogin(false);

                //打开登录界面，关闭本界面
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                finish();
            }
        });
        //recycleview初始化
        RecyclerView rvPhoto = findViewById(R.id.rv_photo);
        rvPhoto.setHasFixedSize(true);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvPhoto.setLayoutManager(layoutManager);

        //初始化模拟图片数据
        List<String> list = new ArrayList<>();
        for (int i = 1;i < 30;i++){
            list.add(String.format("http://dev-courses-misuc.ixuea.com/detail-recyclerview/%d.jpg",i));
        }
        //创建adapter并配器
        final PhotoAdapter photoAdapter = new PhotoAdapter(this);
        photoAdapter.setData(list);
        photoAdapter.setOnItemClickListener(new PhotoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //打开图片详情界面

                Intent intent = new Intent(MainActivity.this, PhotoDetailActivity.class);
                //传递而外信息的方法，利用图片详情需要的intent额外参数key进行传
                String url = photoAdapter.getData().get(position);
                intent.putExtra(Constants.INTENT_EXTRAL_PHOTO_URL,url);
                startActivity(intent);
            }
        });
        rvPhoto.setAdapter(photoAdapter);
    }
}
