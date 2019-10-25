package com.example.flexbox_layout;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder> {

    private List<String> textList;
    private OnRecyclerViewItemClickListener itemClickListener;
    private int color = 0x66666666;

    public TextAdapter(List<String> textList) {
        this.textList = textList;
    }

    public void setItemClickListener(OnRecyclerViewItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnRecyclerViewItemClickListener {
        public void onItemClick(View view, int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_text, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        //接口回调
        if(itemClickListener != null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(v, holder.getAdapterPosition());
                }
            });
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = textList.get(position);
        holder.itemText.setText(text);
        color = color + 10000;
        holder.itemText.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return textList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemText;

        public ViewHolder(View textItem) {
            super(textItem);
            itemText = textItem.findViewById(R.id.my_TextView);
        }
    }
}
