package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class BasicAdapter extends RecyclerView.Adapter<BasicAdapter.ViewHolder> {

    private Context context;
    private List<String> dataList = new ArrayList<>();
    public BasicAdapter(Context context, List<String> dataList) {
        this.context=context;
        this.dataList.addAll(dataList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建itemView
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(android.R.layout.simple_list_item_1,parent,false);

        //创建ViewHolder
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(android.R.id.text1);
        }

        public void bindData(int position) {
            String text = dataList.get(position);
            tv.setText(text);
        }
    }
}
