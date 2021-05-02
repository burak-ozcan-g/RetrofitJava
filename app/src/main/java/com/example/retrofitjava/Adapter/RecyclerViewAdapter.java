package com.example.retrofitjava.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitjava.Model.CrytoModel;
import com.example.retrofitjava.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {

    private Context mContext;
    private ArrayList<CrytoModel> mCryptoList;
    private String[] colors = {"#a2ff00","#ee3b3b","#f47932","#ff00aa","#ffe200","#5bc0de","#042069","#8a2be2"};

    public RecyclerViewAdapter(Context mContext, ArrayList<CrytoModel> mCryptoList) {
        this.mContext = mContext;
        this.mCryptoList = mCryptoList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(mCryptoList.get(position),colors,position);
    }

    @Override
    public int getItemCount() {
        return mCryptoList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {

        private TextView textName;
        private TextView textPrice;

        public RowHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void bind(CrytoModel crytoModel, String[] colors, Integer position){
            textName = itemView.findViewById(R.id.textname);
            textPrice = itemView.findViewById(R.id.textprice);
            textName.setText(crytoModel.getCurrency());
            textPrice.setText(crytoModel.getPrice());
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]));
        }
    }
}
