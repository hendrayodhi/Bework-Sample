package napodev.bework.sample.view.activity.tab;

import android.widget.FrameLayout;
import android.widget.LinearLayout;

import napodev.bework.sample.R;
import napodev.framework.bework.corebase.model.view.BaseViewImpl;
import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.model.view.BaseWorkerImpl;
import napodev.framework.bework.corebase.view.BaseActivity;
import napodev.framework.bework.utils.napoinject.Child;
import napodev.framework.bework.utils.napoinject.FontBold;
import napodev.framework.bework.utils.napoinject.FontDefault;
import napodev.framework.bework.utils.napoinject.FontItalic;
import napodev.framework.bework.utils.napoinject.Root;

/**
 * Created by opannapo on 4/23/17.
 */
@Root(R.layout.activity_tab)
@FontDefault("Raleway-Regular.ttf")
@FontItalic("Infinity.ttf")
@FontBold("Raleway-Bold.ttf")
public class TabView extends BaseViewModel {

    @Child(R.id.frameFragments)
    public FrameLayout frameFragments;
    @Child(R.id.tab1)
    public LinearLayout tab1;
    @Child(R.id.tab2)
    public LinearLayout tab2;


    public interface ViewImpl extends BaseViewImpl {

    }

    public interface WorkerImpl extends BaseWorkerImpl {

    }

    public TabView(BaseActivity activity, BaseViewImpl viewImpl, WorkerImpl workerImpl) {
        super(activity, viewImpl, workerImpl);
    }
}