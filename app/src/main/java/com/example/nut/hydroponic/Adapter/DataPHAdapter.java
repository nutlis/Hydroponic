package com.example.nut.hydroponic.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nut.hydroponic.Models.DataPH;
import com.example.nut.hydroponic.R;

import java.util.List;

public class DataPHAdapter extends RecyclerView.Adapter<DataPHAdapter.MyViewHolder> {
    private Context context;
    private List<DataPH> dataPHList;

    public DataPHAdapter(Context context, List<DataPH> dataPHList) {
        this.context = context;
        this.dataPHList = dataPHList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_statistics, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataPH data = dataPHList.get(position);

        holder.phTv.setText(String.valueOf(data.getPhsensor()));
        holder.disTv.setText(String.valueOf(data.getDistance()));
    }

    @Override
    public int getItemCount() {
        return dataPHList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView phTv, disTv;

        MyViewHolder(View itemView) {
            super(itemView);

            phTv = itemView.findViewById(R.id.phTv);
            disTv = itemView.findViewById(R.id.distanceTv);
        }
    }
}
