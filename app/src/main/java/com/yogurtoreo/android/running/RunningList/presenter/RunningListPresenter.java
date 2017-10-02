package com.yogurtoreo.android.running.RunningList.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yogurtoreo.android.running.R;
import com.yogurtoreo.android.running.RunningList.IListItemInteractor;
import com.yogurtoreo.android.running.RunningList.ListItemInteractor;
import com.yogurtoreo.android.running.RunningList.adapter.ListItemAdapter;
import com.yogurtoreo.android.running.RunningList.view.IRunningListFragment;
import com.yogurtoreo.android.running.RunningList.view.RunningListFragment;
import com.yogurtoreo.android.running.model.Work;

import java.util.List;

/**
 * @date 创建时间：2017/9/26
 * @author  Oreooo
 * @Description
 */

public class RunningListPresenter implements IRunningListPresenter {

    private IRunningListFragment mFragment;
    private IListItemInteractor mInteractor;
    private Context mContext;

    public RunningListPresenter(Context context, IRunningListFragment fragment) {
        mContext = context;
        mFragment = fragment;
    }

    @Override
    public void onCreate() {
        mInteractor = new ListItemInteractor();
        mFragment.setAdapter(new ListItemAdapter(mInteractor.getList()));
    }

}
