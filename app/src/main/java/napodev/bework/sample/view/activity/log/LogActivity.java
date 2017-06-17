package napodev.bework.sample.view.activity.log;

import android.os.Bundle;
import android.view.View;

import napodev.bework.sample.R;
import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.view.BaseActivity;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;
import napodev.framework.bework.utils.Log;

public class LogActivity extends BaseActivity implements LogView.ViewImpl, View.OnClickListener {
    LogWorker worker;
    LogView view;

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
        view = new LogView(this, this, worker);
        worker = new LogWorker(view);

        view.btnSampleLog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSampleLog:
                worker.requestPrintLog();
                break;
        }
    }

    @Override
    protected void onBack() {
        finishWithAnim(ANIM_TYPE.TOP_TO_BOTTOM);
    }

    @Override
    public void viewUpdateLog(String text) {
        Log.d(text);
        Log.e(text);
        Log.i(text);
    }
}
