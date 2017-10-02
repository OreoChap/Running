package com.yogurtoreo.android.running.RunningList;

import com.yogurtoreo.android.running.model.SingletonRunningList;

import java.util.List;

/**
 * @date 创建时间：2017/9/30
 * @author  Oreooo
 * @Description
 */

public class ListItemInteractor implements IListItemInteractor{

    @Override
    public List getList() {
        return SingletonRunningList.getInstance().getWorkList();
    }
}
