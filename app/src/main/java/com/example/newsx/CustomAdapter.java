package com.example.newsx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsx.Models.NewsHeadLines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<NewsHeadLines> headLines;

    public CustomAdapter(Context context, List<NewsHeadLines> headLines) {
        this.context = context;
        this.headLines = headLines;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate
                (R.layout.headline_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            holder.text_title.setText(headLines.get(position).getTitle());
            holder.text_source.setText(headLines.get(position).getSource().getName());

            if(headLines.get(position).getUrlToImage()!= null){
                Picasso.get().load
                        (headLines.get(position).getUrlToImage()).into(holder.img_headline);
            }
    }

    @Override
    public int getItemCount() {
        return headLines.size();
    }
}
