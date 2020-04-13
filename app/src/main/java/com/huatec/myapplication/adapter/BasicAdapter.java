package com.huatec.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class BasicAdapter extends RecyclerView.Adapter<BasicAdapter.ViewHolder> {

    //把传入的两个参数，保存到内部的变量中，
    // 变量①Context context;
    // 变量列表②List<String>

    //
    private Context context;
    private List<String> dataList = new ArrayList<>();

    //构造BasicAdapter方法，实现列表数据参数的传输
    public BasicAdapter(Context context, List<String> dataList) {
        //对变量进行赋值
        this.context=context;
        //addAll的方法把我们传入的List<String>所有元素都赋值给它
        this.dataList.addAll(dataList);
    }

    @NonNull
    @Override
    //要实现的方法①onCreateViewHolder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建itemView，需要用到刚刚传入的context变量，来得到LayoutInflater inflater对象，布局创建类
        LayoutInflater inflater = LayoutInflater.from(context);
        //通过inflate方法传入三个参数
        //参数①列表布局android.R.layout.simple_list_item_1
        //参数②parent，列表项布局
        //参数③false
        //从而得到itemView
        //再通过View来创建ViewHolder
        View itemView = inflater.inflate(android.R.layout.simple_list_item_1,parent,false);

        //创建ViewHolder
        return new ViewHolder(itemView);
    }

    @Override
    //要实现的方法②onBindViewHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //把position传给bindData方法。通过position传数据后进行修改
        holder.bindData(position);
    }

    @Override

    //要实现的方法③getItemCount，给它列表的数量size
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        public ViewHolder(@NonNull View itemView) {
            //把列表项的itemView取出来，并保存
            super(itemView);
            //通过findViewById找出来，
            // tv没办法直接用，
            // 要把它放到类变量里面private TextView tv;

            tv = itemView.findViewById(android.R.id.text1);
        }

        public void bindData(int position) {
            //数据传到position，我们要设置对应的值，get是集合框架取特定元素所用的一个方法
            String text = dataList.get(position);
            //用保存的tv变量来设置数据setText
            tv.setText(text);
        }
    }
}
