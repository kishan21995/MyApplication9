package com.example.myapplication.Models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Models.category.CategoryDetailData;
import com.example.myapplication.R;


/**
 * Created by rbpatel on 9/29/2017.
 */

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {
    private Context applicationContext;
    private CategoryDetailData categoryDetailData;

    public CourseListAdapter(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public CourseListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new CourseListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CourseListAdapter.ViewHolder holder, final int position) {




        holder.first.setText("" + categoryDetailData.getDetails().get(holder.getAdapterPosition()).getCatName());


    }

    @Override
    public int getItemCount() {
        if (categoryDetailData != null && categoryDetailData.getDetails() != null) {
            return categoryDetailData.getDetails().size();
        } else {
            return 0;
        }
    }

    public void setData(CategoryDetailData CourseLists) {
        this.categoryDetailData = CourseLists;
    }


    /**
     * View Holder for CONFIG LIST
     */

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView first, second;

        public ViewHolder(View view) {
            super(view);
            first = itemView.findViewById(R.id.text1);
            second = itemView.findViewById(R.id.text2);
        }
    }


}
