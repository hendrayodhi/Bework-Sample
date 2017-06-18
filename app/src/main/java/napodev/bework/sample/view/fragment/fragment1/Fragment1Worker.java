package napodev.bework.sample.view.fragment.fragment1;

import napodev.framework.bework.corebase.view.BaseFragment;
import napodev.framework.bework.corebase.worker.view.BaseFragmentControl;

/**
 * Created by opannapo on 4/30/17.
 */
public class Fragment1Worker extends BaseFragmentControl implements Fragment1View.WorkerImpl {
    Fragment1View.ViewImpl view;

    public Fragment1Worker(BaseFragment fragment) {
        super(fragment);
        this.view = (Fragment1View.ViewImpl) fragment.getViewModel().getViewImpl();
    }


    @Override
    public void requestDetailFragment() {
        view.viewFragmentLoaded("This is Fragment1");
    }
}
