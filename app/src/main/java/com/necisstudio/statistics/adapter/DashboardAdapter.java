package com.necisstudio.statistics.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.necisstudio.statistics.R;
import com.necisstudio.statistics.item.DashboardItem;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by vim on 31/10/16.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardHolder> {
    Context context;
    ArrayList<DashboardItem> itemlist;

    public DashboardAdapter(Context context, ArrayList<DashboardItem> itemlist){
        this.context = context;
        this.itemlist = itemlist;
    }


    @Override
    public DashboardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewitem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard, parent, false);
        DashboardHolder holderDahsboard = new DashboardHolder(viewitem);
        return holderDahsboard;
    }

    @Override
    public void onBindViewHolder(DashboardHolder holder, int position) {
        //holder.txtName.setText(itemlist.get(position).getName());
    }
    public void add(DashboardItem item, int position) {
        itemlist.add(position, item);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return (null != itemlist ? itemlist.size() : 0);
    }

    public class DashboardHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.txtName)
        public TextView txtName;
        @InjectView(R.id.txtPercent)
        public TextView txtPercent;
        @InjectView(R.id.txtDate)
        public TextView txtDate;

        public DashboardHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this,itemView);
        }
    }
}
