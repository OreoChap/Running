package com.yogurtoreo.android.running;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.aigestudio.wheelpicker.WheelPicker;
import com.yogurtoreo.android.running.model.Work;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2017/9/13.
 */

public class DetailFragment extends DialogFragment{

    //@BindView(R.id.time_register)TimePicker register;
    private EditText mDescriptionEdit;
    private Work mWork;
    private Date mDate;
    private WheelPicker mWheelPicker;
    private EditText mAttributionEdit;

    public static DetailFragment newInstance() {
        DetailFragment fragment = new DetailFragment();
        return fragment;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)  {
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.item_detail, null);
        mWork = new Work();

        mDescriptionEdit = (EditText)v.findViewById(R.id.work_description);
        mWheelPicker = (WheelPicker)v.findViewById(R.id.time_select_wheel) ;
        mAttributionEdit = (EditText)v.findViewById(R.id.work_attribution) ;

        setTimeWheel();

        DescriptionListener dListener = new DescriptionListener();
        AttributionListener aListener = new AttributionListener();

        mDescriptionEdit.addTextChangedListener(dListener);
        mAttributionEdit.addTextChangedListener(aListener);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("123")
                .setPositiveButton("Running", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "666", Toast.LENGTH_SHORT).show();
                        RunningLab.getInstance().addWork(mWork);
                        //mWork = null;
                        //mDate = null;
                    }
                })
                .create();
    }



    private void setTimeWheel() {
        List<Integer> data = new ArrayList<>();
        for (int i = 25; i < 65; i = i + 5) {
            data.add(i);
        }

        mWheelPicker.setSameWidth(true);
        mWheelPicker.setData(data);
        mWheelPicker.setVisibleItemCount(3);
        //mWheelPicker.setCyclic(true);
        mWheelPicker.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object select, int position) {
                mDate = new Date(Long.valueOf(String.valueOf(select)));
                mWork.setDate(mDate);
            }
        });
    }

    class DescriptionListener implements TextWatcher {
        @Override
        public void afterTextChanged(Editable editable) {

        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            mWork.setDescription(charSequence.toString());
        }
    }

    class AttributionListener implements TextWatcher {
        @Override
        public void afterTextChanged(Editable editable) {

        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            mWork.setAttribution(charSequence.toString());
        }
    }
}
