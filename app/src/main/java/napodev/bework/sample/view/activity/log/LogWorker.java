package napodev.bework.sample.view.activity.log;

import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;


/**
 * Created by opannapo on 4/24/17.
 */
public class LogWorker extends BaseActivityControl implements LogView.WorkerImpl {
    LogView.ViewImpl view;

    public LogWorker(BaseViewModel viewModel) {
        super(viewModel);
        this.view = (LogView.ViewImpl) getViewModel().getViewImpl();
    }


    @Override
    public void requestPrintLog() {
        view.viewUpdateLog("THis is LOG, DETAILS");
    }
}

