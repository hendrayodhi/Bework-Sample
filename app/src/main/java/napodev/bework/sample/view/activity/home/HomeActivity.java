package napodev.bework.sample.view.activity.home;

import android.os.Bundle;
import android.view.View;

import napodev.bework.sample.R;
import napodev.bework.sample.view.activity.list.TrendingActivity;
import napodev.bework.sample.view.activity.log.LogActivity;
import napodev.bework.sample.view.activity.sharedpreference.SharedPreferenceActivity;
import napodev.bework.sample.view.activity.tab.TabActivity;
import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.view.BaseActivity;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;

public class HomeActivity extends BaseActivity implements HomeView.ViewImpl, View.OnClickListener {
    HomeWorker worker;
    HomeView view;

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
        view = new HomeView(this, this, worker);
        worker = new HomeWorker(view);
        worker.requestUpdateData();

        view.btnSampleLog.setOnClickListener(this);
        view.btnSampleList.setOnClickListener(this);
        view.btnSampleSharedPreference.setOnClickListener(this);
        view.btnSampleFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSampleLog:
                redirect(LogActivity.class, ANIM_TYPE.RIGHT_TO_LEFT);
                break;
            case R.id.btnSampleList:
                redirect(TrendingActivity.class, ANIM_TYPE.RIGHT_TO_LEFT);
                break;
            case R.id.btnSampleSharedPreference:
                redirect(SharedPreferenceActivity.class, ANIM_TYPE.TOP_TO_BOTTOM);
                break;
            case R.id.btnSampleFragment:
                redirect(TabActivity.class, ANIM_TYPE.RIGHT_TO_LEFT);
                break;
        }
    }

    @Override
    public void viewUpdateData(String title, String msg, String note) {
        view.tTitle.setText(title);
        view.tMessage.setText(msg);
        view.tNote.setText(note);
    }

    @Override
    protected void onBack() {
        finishWithAnim(ANIM_TYPE.TOP_TO_BOTTOM);
    }
}
