package com.example.loginuidesign.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginuidesign.Model.AppItem;
import com.example.loginuidesign.Model.DataManager;
import com.example.loginuidesign.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    public ArrayList<DataManager> data;
    private final Context mContext;

    public RecyclerViewAdapter (Context ctx, ArrayList<DataManager> dt){
        this.mContext = ctx;
        this.data = dt;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.section_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String sectionName = data.get(position).getHeaderTitle();
        ArrayList<AppItem>  singleSectionItem = data.get(position).getApps();
        holder.itemTitle.setText(sectionName);

        holder.itemView.getContext();
        SectionListAdapter adapter = new SectionListAdapter(mContext, singleSectionItem);
        holder.recyclerView_list.setHasFixedSize(true);
        holder.recyclerView_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView_list.setAdapter(adapter);
    }


    @Override
    public int getItemCount() {
        return data == null ? 0:data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemTitle;
        Button btnMore;
        RecyclerView recyclerView_list;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemTitle = (TextView)itemView.findViewById(R.id.itemTitle);
            this.btnMore = (Button) itemView.findViewById(R.id.btnMore);
            this.recyclerView_list = (RecyclerView) itemView.findViewById(R.id.recycler_view_list);
        }
    }
}
