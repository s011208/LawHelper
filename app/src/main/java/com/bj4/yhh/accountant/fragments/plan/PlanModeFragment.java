package com.bj4.yhh.accountant.fragments.plan;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ViewSwitcher;

import com.bj4.yhh.accountant.R;
import com.bj4.yhh.accountant.activity.MainActivity;
import com.bj4.yhh.accountant.utils.BaseFragment;

/**
 * Created by yenhsunhuang on 15/8/17.
 */
public class PlanModeFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "PlanModeFragment";
    private static final boolean DEBUG = true;
    private PlanListAdapter mPlanListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.plan_mode_fragment, null);
        Button addNewPlan = (Button) root.findViewById(R.id.add_new_plan);
        addNewPlan.setOnClickListener(this);
        Button removeAllPlans = (Button) root.findViewById(R.id.remove_all_plans);
        removeAllPlans.setOnClickListener(this);

        ViewSwitcher topArea = (ViewSwitcher) root.findViewById(R.id.top_area);
        ListView planList = (ListView) root.findViewById(R.id.plan_list);
        mPlanListAdapter = new PlanListAdapter(getActivity());
        planList.setAdapter(mPlanListAdapter);

        return root;
    }

    @Override
    public boolean onBackPress() {
        return false;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mPlanListAdapter != null) {
            mPlanListAdapter.updateContent();
            mPlanListAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View v) {
        final int vId = v.getId();
        if (vId == R.id.add_new_plan) {
            if (DEBUG) {
                Log.d(TAG, "add_new_plan");
            }
            getFragmentManager().beginTransaction().replace(MainActivity.getMainFragmentContainerId(), new AddPlanFragment()).addToBackStack(null).commit();
        } else if (vId == R.id.remove_all_plans) {
            if (DEBUG) {
                Log.d(TAG, "remove_all_plans");
            }
            Plan.deleteAllPlans(getActivity());
            if (mPlanListAdapter != null) {
                mPlanListAdapter.updateContent();
                mPlanListAdapter.notifyDataSetChanged();
            }
        }
    }
}
