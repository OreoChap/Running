package com.yogurtoreo.android.running;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yogurtoreo.android.running.RunningList.view.RunningListFragment;
import com.yogurtoreo.android.running.RunningList.detail.DetailFragment;

import butterknife.BindView;

/**
 * @date 创建时间：2017/9/26
 * @author  Oreooo
 * @Description
 */

public class MainActivity extends AppCompatActivity {

    private static final String RUNNING_DIALOG = "runningDialog";

    @BindView(R.id.running_start)TextView startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Fragment newDetail = RunningListFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, newDetail)
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void running(View view) {
        if (view.getId() == R.id.running_start) {
            DetailFragment fragment = DetailFragment.newInstance();
            FragmentManager manager = getSupportFragmentManager();
            fragment.show(manager, RUNNING_DIALOG);
        }
    }


}
