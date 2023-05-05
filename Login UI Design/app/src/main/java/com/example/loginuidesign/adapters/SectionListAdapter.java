package com.example.loginuidesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginuidesign.Model.AppItem;
import com.example.loginuidesign.Model.DataManager;
import com.example.loginuidesign.R;

import java.util.ArrayList;
import java.util.List;

public class SectionListAdapter extends RecyclerView.Adapter<SectionListAdapter.SingleViewHolder> {

    ArrayList<AppItem> itemsList;
    Context mContext;

    public SectionListAdapter(Context ctx, ArrayList<AppItem> apps){
        this.mContext = ctx;
        this.itemsList = apps;
    }
    @NonNull
    @Override
    public SingleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_item, parent, false);
        return new SingleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleViewHolder holder, int position) {
        AppItem singleItem = itemsList.get(position);
        holder.appName.setText(singleItem.getAppName());
        holder.appRating.setText(String.valueOf(singleItem.getAppRating()));
    }

    @Override
    public int getItemCount() {
        return itemsList == null ? 0 : itemsList.size();
    }

    public static class SingleViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView appName;
        TextView appRating;
        public SingleViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.itemImage);
            this.appName = (TextView) itemView.findViewById(R.id.appName);
            this.appRating = (TextView) itemView.findViewById(R.id.appRating);
        }
    }
}
