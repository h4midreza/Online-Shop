package com.example.onlineshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.onlineshop.R;
import com.example.onlineshop.domain.SliderItem;

import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.viewHolder> {
    private ArrayList<SliderItem> sliderItems;
    private ViewPager2 viewPager;
    private Context context;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };

    public SliderAdapter(ArrayList<SliderItem> sliderItems, ViewPager2 viewPager) {
        this.sliderItems = sliderItems;
        this.viewPager = viewPager;
    }

    @NonNull
    @Override
    public SliderAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.slider_item_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.viewHolder holder, int position) {
        holder.setImage(sliderItems.get(position));
        if (position == sliderItems.size()-2){
            viewPager.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlide);
        }
        void setImage (SliderItem sliderItem){
            RequestOptions requestOptions = new RequestOptions();
            requestOptions = new RequestOptions().transform();
            Glide.with(context)
                    .load(sliderItem.getUrl())
                    .apply(requestOptions)
                    .into(imageView);
        }
    }
}
