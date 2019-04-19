package com.anirudh.wenotes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder>{

    private Context mCtx;

    private List<Course> courseAdapter;

    public CardAdapter(Context mCtx, List<Course> courseAdapter) {
        this.mCtx = mCtx;
        this.courseAdapter = courseAdapter;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View v= inflater.inflate(R.layout.activity_list_item,null);
        return new CardViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        Course mCourse = courseAdapter.get(i);

        cardViewHolder.mCourseImage.setImageDrawable(mCtx.getResources().getDrawable(mCourse.getImagesrc()));
        cardViewHolder.mCourseName.setText(String.valueOf(mCourse.getCourseName()));
        cardViewHolder.mFileCount.setText(String.valueOf(mCourse.getPdfCount()));
    }

    @Override
    public int getItemCount() {
        return courseAdapter.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder{

        TextView mFileCount,mCourseName;
        ImageView mCourseImage;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            mFileCount = itemView.findViewById(R.id.pdf_count_view);
            mCourseName = itemView.findViewById(R.id.course_name);
            mCourseImage = itemView.findViewById(R.id.course_img);
        }
    }
}
