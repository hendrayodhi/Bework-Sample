package napodev.bework.sample.view.activity.tab;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;

import napodev.bework.sample.R;
import napodev.bework.sample.view.fragment.fragment1.Fragment1;
import napodev.bework.sample.view.fragment.fragment2.Fragment2;
import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.view.BaseActivity;
import napodev.framework.bework.corebase.view.BaseFragment;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;

public class TabActivity extends BaseActivity implements TabView.ViewImpl, View.OnClickListener {
    TabWorker worker;
    TabView view;


    public FragmentTransaction fragmentTransaction;
    public BaseFragment fragmentSelected;
    public Fragment1 fragment1;
    public Fragment2 fragment2;

    public static final int TAB_1 = 0;
    public static final int TAB_2 = 1;
    public int TAB_SELECTED = -1;

    @Override
    public BaseViewModel getViewModel() {
        return view;
    }

    @Override
    public BaseActivityControl getWorker() {
        return worker;
    }

    @Override
    public void onActivityCreate(Bundle bundle) {
        view = new TabView(this, this, worker);
        worker = new TabWorker(view);

        view.tab1.setOnClickListener(this);
        view.tab2.setOnClickListener(this);

        setupFragmentChilds();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab1:
                setupTabView(TAB_1);
                break;
            case R.id.tab2:
                setupTabView(TAB_2);
                break;
        }
    }

    @Override
    protected void onBack() {
        finishWithAnim(ANIM_TYPE.LEFT_TO_RIGHT);
    }


    public void setupFragmentChilds() {
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(view.frameFragments.getId(), fragment1);
        fragmentTransaction.add(view.frameFragments.getId(), fragment2);
        fragmentTransaction.commit();

        setupTabView(TAB_1);
    }

    public void setupTabView(int pos) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (pos == TAB_1) {
            fragmentSelected = fragment1;
            fragmentTransaction.show(fragment1);
            fragmentTransaction.hide(fragment2);

            view.tab1.setAlpha(1.0f);
            view.tab2.setAlpha(0.6f);
            ((ViewGroup) view.tab1).getChildAt(0).setAlpha(1.0f);
            ((ViewGroup) view.tab2).getChildAt(0).setAlpha(0.4f);
        } else if (pos == TAB_2) {
            fragmentSelected = fragment2;
            fragmentTransaction.hide(fragment1);
            fragmentTransaction.show(fragment2);
            view.tab1.setAlpha(0.6f);
            view.tab2.setAlpha(1.0f);
            ((ViewGroup) view.tab1).getChildAt(0).setAlpha(0.4f);
            ((ViewGroup) view.tab2).getChildAt(0).setAlpha(1.0f);
        }

        fragmentTransaction.commit();
        TAB_SELECTED = pos;
    }
}
