package com.example.onlineshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.onlineshop.databinding.ViewholderReviewBinding;
import com.example.onlineshop.domain.ReviewDomain;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.viewHolder> {
    ArrayList<ReviewDomain> items;
    Context context;

    public ReviewAdapter(ArrayList<ReviewDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ReviewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderReviewBinding binding;
        binding = ViewholderReviewBinding.inflate(LayoutInflater.from(context), parent, false);
        context = parent.getContext();
        return new viewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.viewHolder holder, int position) {
        holder.binding.nameTxt.setText(items.get(position).getName());
        holder.binding.descTxt.setText(items.get(position).getDescription());
        holder.binding.ratingTxt.setText("" + items.get(position).getRating());

        Glide.with(context)
                .load(items.get(position).getPicUrl())
                .transform(new GranularRoundedCorners(100, 100, 100, 100))
                .into(holder.binding.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ViewholderReviewBinding binding;

        public viewHolder(ViewholderReviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
