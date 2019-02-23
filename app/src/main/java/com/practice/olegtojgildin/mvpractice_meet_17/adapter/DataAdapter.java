package com.practice.olegtojgildin.mvpractice_meet_17.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.practice.olegtojgildin.mvpractice_meet_17.R;
import com.practice.olegtojgildin.mvpractice_meet_17.databinding.ItemDataBinding;
import com.practice.olegtojgildin.mvpractice_meet_17.model.ImageModel;
import com.practice.olegtojgildin.mvpractice_meet_17.viewmodel.DataImageViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private static final String TAG = "DataAdapter";
    private List<ImageModel> data;
    private OnImageListener mOnImageListener;


    public DataAdapter(OnImageListener onImageListener) {
        this.data = new ArrayList<>();
        this.mOnImageListener = onImageListener;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,
                new FrameLayout(parent.getContext()), false);
        return new DataViewHolder(itemView,mOnImageListener);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        ImageModel dataModel = data.get(position);
        holder.setViewModel(new DataImageViewModel(dataModel));
        Picasso.get()
                .load(dataModel.getUrlImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.binding.imageView);
    }


    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public void onViewAttachedToWindow(DataViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<ImageModel> data) {
        if (data == null || data.isEmpty()) {
            this.data.clear();
        } else {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    static class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ItemDataBinding binding;
        OnImageListener onImageListener;

        DataViewHolder(View itemView,OnImageListener onImageListener) {
            super(itemView);
            this.onImageListener=onImageListener;
            itemView.setOnClickListener(this);
            bind();
        }

        void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        void unbind() {
            if (binding != null) {
                binding.unbind();
            }
        }

        void setViewModel(DataImageViewModel viewModel) {
            if (binding != null) {
                binding.setViewModel(viewModel);
            }
        }

        @Override
        public void onClick(View view) {
            onImageListener.onImageClick(getAdapterPosition());
        }
    }

    public interface OnImageListener {
        void onImageClick(int position);

    }
}
