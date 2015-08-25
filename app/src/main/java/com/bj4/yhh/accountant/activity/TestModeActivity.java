package com.bj4.yhh.accountant.activity;

import android.os.Bundle;

import com.bj4.yhh.accountant.R;
import com.bj4.yhh.accountant.fragments.testmode.TestModeItemFragment;

/**
 * Created by yenhsunhuang on 15/8/25.
 */
public class TestModeActivity extends BaseActivity {
    private static int sContainerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sContainerId = R.id.container;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_mode);
        getFragmentManager().beginTransaction().replace(getMainFragmentContainerId(), new TestModeItemFragment()).commit();
    }

    public static int getMainFragmentContainerId() {
        return sContainerId;
    }
}
