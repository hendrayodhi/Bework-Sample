package napodev.bework.sample.view.fragment.fragment1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import napodev.framework.bework.corebase.model.view.BaseFragmentViewModel;
import napodev.framework.bework.corebase.view.BaseFragment;
import napodev.framework.bework.corebase.worker.view.BaseFragmentControl;

/**
 * Created by opannapo on 4/30/17.
 */
public class Fragment1 extends BaseFragment implements Fragment1View.ViewImpl {
    Fragment1View view;
    Fragment1Worker worker;

    @Override
    public BaseFragmentViewModel getViewModel() {
        return view;
    }

    @Override
    public BaseFragmentControl getWorker() {
        return worker;
    }

    @Override
    public void onViewCreatedBase(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = new Fragment1View(this, this, worker, inflater, container);
        worker = new Fragment1Worker(this);
    }

    @Override
    public void onHiddenChangedBase(boolean isHidden) {
        if (!isHidden && isFirstVisible()) {
            worker.requestDetailFragment();
        }
    }

    @Override
    public void onDestroyViewBase() {

    }

    @Override
    public void onAttachBase() {

    }

    @Override
    public void viewFragmentLoaded(String detail) {
        view.tDetail.setText(detail);
        view.tDetail.setTextColor(Color.parseColor("#00ff00"));
        ((ViewGroup) view.tDetail.getParent()).setBackgroundColor(Color.parseColor("#ffffff"));
    }
}
