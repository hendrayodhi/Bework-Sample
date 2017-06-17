package napodev.bework.sample.view.activity.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import napodev.bework.sample.R;
import napodev.bework.sample.models.Trending;
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
@Root(R.layout.activity_trending)
@FontDefault("Raleway-Regular.ttf")
@FontItalic("Infinity.ttf")
@FontBold("Raleway-Bold.ttf")
public class TrendingView extends BaseViewModel {
    @Child(R.id.recyclerview)
    public RecyclerView recyclerview;
    @Child(R.id.toolbar)
    public Toolbar toolbar;


    public interface ViewImpl extends BaseViewImpl {
        void viewDataLoaded(ArrayList<Trending> trendings);
    }

    public interface WorkerImpl extends BaseWorkerImpl {
        void requestDataList();
    }

    public TrendingView(BaseActivity activity, BaseViewImpl viewImpl, WorkerImpl workerImpl) {
        super(activity, viewImpl, workerImpl);
    }
}