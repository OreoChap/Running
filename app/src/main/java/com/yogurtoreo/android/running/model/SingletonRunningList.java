package com.yogurtoreo.android.running.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 创建时间：2017/9/26
 * @author  Oreooo
 * @Description
 */

public class SingletonRunningList {

    private static SingletonRunningList Instance = null;
    private List<Work> mWorkList;

    private SingletonRunningList() {
        mWorkList = new ArrayList<>();

    }

    private static synchronized void syncInit() {
        if (Instance == null) {
            Instance = new SingletonRunningList();
        }
    }

    public static SingletonRunningList getInstance() {
        if (Instance == null) {
            syncInit();
        }
        return Instance;
    }

    public List<Work> getWorkList() {
        return mWorkList;
    }

    public void addWork(Work work) {
        mWorkList.add(work);
    }

}
