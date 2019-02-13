package com.example.myapplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Models.category.CategoryDetailData;
import com.example.myapplication.R;

public class Adapters extends RecyclerView.Adapter<Adapters.ViewHolder> {
    private Context applicationContext;
    private CategoryDetailData categoryDetailData;

    public Adapters(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @NonNull
    @Override
    public Adapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new Adapters.ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull final Adapters.ViewHolder viewHolder, final int i) {
        viewHolder.first.setText(categoryDetailData.getDetails().get(viewHolder.getAdapterPosition()).getCatName());
    }

    @Override
    public int getItemCount() {
        if (categoryDetailData != null) {
            return categoryDetailData.getDetails().size();
        } else {
            return 0;
        }

    }

    public void setData(CategoryDetailData CourseLists) {
        this.categoryDetailData = CourseLists;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView first, second;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            first = itemView.findViewById(R.id.text1);
            second = itemView.findViewById(R.id.text2);
        }
    }
}
