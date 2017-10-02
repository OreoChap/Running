package com.yogurtoreo.android.running.RunningList.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yogurtoreo.android.running.R;
import com.yogurtoreo.android.running.model.Work;

import java.util.List;

/**
 * @date 创建时间：2017/10/2
 * @author  Oreooo
 * @Description
 */

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder>{
    private List<Work> mList;

    public ListItemAdapter(List<Work> list) {
        mList = list;
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bindData(mList.get(i));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_running, null);
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView attributionItem;
        private TextView timeItem;

        public ViewHolder(View v) {
            super(v);
            attributionItem = (TextView)v.findViewById(R.id.list_item_attribution);
        }

        public void bindData(Work work) {
            attributionItem.setText(work.getAttribution());

        }
    }
}
