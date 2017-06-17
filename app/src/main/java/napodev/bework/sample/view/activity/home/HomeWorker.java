package napodev.bework.sample.view.activity.home;

import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;


/**
 * Created by opannapo on 4/24/17.
 */
public class HomeWorker extends BaseActivityControl implements HomeView.WorkerImpl {
    HomeView.ViewImpl view;

    public HomeWorker(BaseViewModel viewModel) {
        super(viewModel);
        this.view = (HomeView.ViewImpl) getViewModel().getViewImpl();
    }

    @Override
    public void requestUpdateData() {
        view.viewUpdateData("This is Title", "This is Message", "This is Note");
    }

}