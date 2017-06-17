package napodev.bework.sample.view.activity.sharedpreference;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import napodev.bework.sample.R;
import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.view.BaseActivity;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;
import napodev.framework.bework.utils.Log;

public class SharedPreferenceActivity extends BaseActivity implements SharedPreferenceView.ViewImpl, View.OnClickListener {
    SharedPreferenceWorker worker;
    SharedPreferenceView view;

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
        view = new SharedPreferenceView(this, this, worker);
        worker = new SharedPreferenceWorker(view);

        view.btnSave.setOnClickListener(this);
        view.btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                worker.saveData(view.eInputKey.getText().toString(),
                        view.eeInputValue.getText().toString());
                break;
            case R.id.btnRead:
                worker.readData(view.eReadKey.getText().toString());
                break;
        }
    }

    @Override
    protected void onBack() {
        finishWithAnim(ANIM_TYPE.BOTTOM_TO_TOP);
    }


    @Override
    public void viewDataSaved(String text) {
        Toast.makeText(thisActivity(), "Saved " + text, Toast.LENGTH_SHORT).show();
        Log.d(text);
    }

    @Override
    public void viewDataLoaded(String text) {
        view.tOutput.setText(text);
        Log.d(text);
    }
}
