package com.yogurtoreo.android.running.model;

import java.util.Date;
import java.util.UUID;

/**
 * @date 创建时间：2017/9/26
 * @author  Oreooo
 * @Description
 */

public class Work {
    private String mAttribution;
    private String mDescription;
    private Date mDate;
    private UUID mId;

    public Work() {
        this(UUID.randomUUID());
    }

    private Work(UUID id) {
        mId = id;
    }

    public String getAttribution() {
        return mAttribution;
    }

    public void setAttribution(String attribution) {
        mAttribution = attribution;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public UUID getId() {
        return mId;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
