package com.yogurtoreo.android.running;

import android.content.Intent;

import com.yogurtoreo.android.running.model.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2017/9/13.
 */

public class RunningLab {

    private static RunningLab Instance = null;
    private List<Work> mWorkList;

    private RunningLab() {
        mWorkList = new ArrayList<>();

    }

    private static synchronized void syncInit() {
        if (Instance == null) {
            Instance = new RunningLab();
        }
    }

    public static RunningLab getInstance() {
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
