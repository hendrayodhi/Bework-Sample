package napodev.bework.sample.view.fragment.fragment2;

import napodev.framework.bework.corebase.view.BaseFragment;
import napodev.framework.bework.corebase.worker.view.BaseFragmentControl;

/**
 * Created by opannapo on 4/30/17.
 */
public class Fragment2Worker extends BaseFragmentControl implements Fragment2View.WorkerImpl {
    Fragment2View.ViewImpl view;

    public Fragment2Worker(BaseFragment fragment) {
        super(fragment);
        this.view = (Fragment2View.ViewImpl) fragment.getViewModel().getViewImpl();
    }


    @Override
    public void requestDetailFragment() {
        view.viewFragmentLoaded("This is Fragment2");
    }
}
