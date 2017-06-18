package napodev.bework.sample.view.fragment.fragment2;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import napodev.bework.sample.R;
import napodev.framework.bework.corebase.model.view.BaseFragmentViewImpl;
import napodev.framework.bework.corebase.model.view.BaseFragmentViewModel;
import napodev.framework.bework.corebase.model.view.BaseFragmentWorkerImpl;
import napodev.framework.bework.corebase.view.BaseFragment;
import napodev.framework.bework.utils.napoinject.Child;
import napodev.framework.bework.utils.napoinject.FontBold;
import napodev.framework.bework.utils.napoinject.FontDefault;
import napodev.framework.bework.utils.napoinject.FontItalic;
import napodev.framework.bework.utils.napoinject.Root;

/**
 * Created by opannapo on 4/30/17.
 */
@Root(R.layout.fragment)
@FontDefault("Raleway-Regular.ttf")
@FontItalic("Infinity.ttf")
@FontBold("Raleway-Bold.ttf")
public class Fragment2View extends BaseFragmentViewModel {
    @Child(R.id.tDetail)
    TextView tDetail;

    public interface ViewImpl extends BaseFragmentViewImpl {
        void viewFragmentLoaded(String detail);
    }

    public interface WorkerImpl extends BaseFragmentWorkerImpl {
        void requestDetailFragment();
    }

    public Fragment2View(BaseFragment fragment, BaseFragmentViewImpl viewImpl, BaseFragmentWorkerImpl workerImpl, LayoutInflater inflater, ViewGroup container) {
        super(fragment, viewImpl, workerImpl, inflater, container);
    }
}
