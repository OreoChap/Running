package com.yogurtoreo.android.running;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yogurtoreo.android.running.model.Work;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2017/9/13.
 */

public class RunningListFragment extends Fragment {

    private RecyclerView recyclerList;
    private ListAdapter mListAdapter;

    public static RunningListFragment newInstance() {
        RunningListFragment fragment = new RunningListFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        recyclerList = (RecyclerView)view.findViewById(R.id.running_list_recycler_view);
        recyclerList.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    public void updateUI() {
        RunningLab lab = RunningLab.getInstance();
        List<Work> works = lab.getWorkList();

        if (mListAdapter == null) {
            ListAdapter adapter = new ListAdapter(works);
            recyclerList.setAdapter(adapter);
        } else {
            mListAdapter.setWorks(works);
            mListAdapter.notifyDataSetChanged();
        }

    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView attributionItem;
        private TextView timeItem;

        public ListViewHolder(View itemView) {
            super(itemView);
            attributionItem = (TextView)itemView.findViewById(R.id.list_item_attribution);
            timeItem = (TextView)itemView.findViewById(R.id.list_item_time);


        }

        public void bindView(Work work) {

            attributionItem.setText(work.getAttribution());


        }
    }

    public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
        private List<Work> mWorks;


        public ListAdapter(List<Work> works) {
            mWorks = works;
        }

        @Override
        public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.list_item_running, parent, false);
            return new ListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ListViewHolder holder, int position) {
            Work work = mWorks.get(position);
            holder.bindView(work);
        }

        @Override
        public int getItemCount() {
            return mWorks.size();
        }

        private void setWorks(List<Work> works) {
            mWorks = works;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
