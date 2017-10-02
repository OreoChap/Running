package com.yogurtoreo.android.running.RunningList.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yogurtoreo.android.running.R;
import com.yogurtoreo.android.running.RunningList.adapter.ListItemAdapter;
import com.yogurtoreo.android.running.RunningList.presenter.IRunningListPresenter;
import com.yogurtoreo.android.running.RunningList.presenter.RunningListPresenter;

/**
 * @date 创建时间：2017/9/26
 * @author  Oreooo
 * @Description
 */

public class RunningListFragment extends Fragment implements IRunningListFragment {

    private RecyclerView recyclerList;
    private IRunningListPresenter mPresenter;

    public static RunningListFragment newInstance() {
        RunningListFragment fragment = new RunningListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        recyclerList = (RecyclerView)view.findViewById(R.id.running_list_recycler_view);
        recyclerList.setLayoutManager(new LinearLayoutManager(getActivity()));

        mPresenter = new RunningListPresenter(getActivity(), this);
        mPresenter.onCreate();

        return view;
    }

    @Override
    public void setAdapter(ListItemAdapter adapter) {
        recyclerList.setAdapter(adapter);
    }
}
