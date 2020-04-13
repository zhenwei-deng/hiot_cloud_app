package com.huatec.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huatec.myapplication.R;
import com.huatec.myapplication.model.EquipmentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备适配器
 */
public class EquipmemtAdapter extends RecyclerView.Adapter<EquipmemtAdapter.ViewHolder> {

    private Context context;

    private List<EquipmentBean> dataList = new ArrayList<>();

    /**
     * 点击接口变量
     */
    private OnItemClickListener onItemClickListener;
    public EquipmemtAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    //构造函数ViewHolder
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //创建itemView
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.adapter_item_equipment,parent,false);

        //创建ViewHolder
        return new EquipmemtAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        final EquipmentBean equipmentBean = dataList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(equipmentBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 设置列表
     * @param list
     */
    public void setData(List<EquipmentBean> list) {
        dataList.addAll(list);
    }

    public interface OnItemClickListener{
        void onItemClick(EquipmentBean item);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        private TextView tvDesc;
        private ImageView ivTest;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            ivTest = itemView.findViewById(R.id.iv_test);
        }

        /**
         * 修改列表项内容
         * @param position
         */
        public void bindData(int position) {
            EquipmentBean bean = dataList.get(position);
            tvTitle.setText(bean.getTitle());
            tvDesc.setText(bean.getDescription());
            ivTest.setImageResource(bean.getImgId());
        }
    }
}
