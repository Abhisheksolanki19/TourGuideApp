package com.merchpandas.tourguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.merchpandas.tourguide.databinding.VisitsListItemBinding;

import java.util.ArrayList;

public class VistsListAdapter extends RecyclerView.Adapter<VistsListAdapter.VisitViewHolder> {
    public VistsListAdapter(ArrayList<VisitItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    ArrayList<VisitItem> arrayList;
    Context context;

    @NonNull
    @Override
    public VisitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        return new VisitViewHolder(VisitsListItemBinding.inflate(li, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VisitViewHolder holder, final int position) {
        holder.title.setText(arrayList.get(position).getTitle());
        holder.img.setImageResource(arrayList.get(position).getResourceId());

        holder.base.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(context.getString(R.string.title), arrayList.get(position).getTitle());
                intent.putExtra(context.getString(R.string.img), arrayList.get(position).getResourceId());
                intent.putExtra(context.getString(R.string.location), arrayList.get(position).getLocation());
                intent.setClass(context, TouristVisit.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class VisitViewHolder extends RecyclerView.ViewHolder {
        VisitsListItemBinding binding;
        private TextView title;
        private ImageView img;
        private LinearLayout base;

        public VisitViewHolder(@NonNull VisitsListItemBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
            title = binding.visitTitle;
            img = binding.visitsImg;
            base = binding.base;

        }
    }
}
