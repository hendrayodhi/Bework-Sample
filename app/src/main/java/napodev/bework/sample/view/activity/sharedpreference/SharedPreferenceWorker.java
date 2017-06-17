package napodev.bework.sample.view.activity.sharedpreference;

import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;
import napodev.framework.bework.utils.local.SPreference;


/**
 * Created by opannapo on 4/24/17.
 */
public class SharedPreferenceWorker extends BaseActivityControl implements SharedPreferenceView.WorkerImpl {
    SharedPreferenceView.ViewImpl view;

    public SharedPreferenceWorker(BaseViewModel viewModel) {
        super(viewModel);
        this.view = (SharedPreferenceView.ViewImpl) getViewModel().getViewImpl();
    }


    @Override
    public void saveData(String key, String val) {
        SPreference.setEncryptPrefVal(key, val);
        view.viewDataSaved(key + ":" + val);
    }

    @Override
    public void readData(String key) {
        String valEnc = SPreference.getPrefVal(key);
        String valDec = SPreference.getDecryptPrefVal(key);
        view.viewDataLoaded("Saved : " + valEnc + "\nDecode : " + valDec);
    }
}

