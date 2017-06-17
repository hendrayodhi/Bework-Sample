package napodev.bework.sample.view.activity.home;

import android.widget.Button;
import android.widget.TextView;

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
@Root(R.layout.activity_main)
@FontDefault("Raleway-Regular.ttf")
@FontItalic("Infinity.ttf")
@FontBold("Raleway-Bold.ttf")
public class HomeView extends BaseViewModel {
    @Child(R.id.tTitle)
    public TextView tTitle;
    @Child(R.id.tMessage)
    public TextView tMessage;
    @Child(R.id.tNote)
    public TextView tNote;
    @Child(R.id.btnSampleLog)
    public Button btnSampleLog;
    @Child(R.id.btnSampleList)
    public Button btnSampleList;
    @Child(R.id.btnSampleSharedPreference)
    public Button btnSampleSharedPreference;


    public interface ViewImpl extends BaseViewImpl {
        void viewUpdateData(String title, String msg, String note);
    }

    public interface WorkerImpl extends BaseWorkerImpl {
        void requestUpdateData();
    }

    public HomeView(BaseActivity activity, BaseViewImpl viewImpl, WorkerImpl workerImpl) {
        super(activity, viewImpl, workerImpl);
    }
}