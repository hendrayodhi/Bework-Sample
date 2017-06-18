package napodev.bework.sample.view.activity.tab;

import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;


/**
 * Created by opannapo on 4/24/17.
 */
public class TabWorker extends BaseActivityControl implements TabView.WorkerImpl {
    TabView.ViewImpl view;

    public TabWorker(BaseViewModel viewModel) {
        super(viewModel);
        this.view = (TabView.ViewImpl) getViewModel().getViewImpl();
    }


}

