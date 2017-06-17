package napodev.bework.sample.view.activity.log;

import android.widget.Button;

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
@Root(R.layout.activity_log)
@FontDefault("Raleway-Regular.ttf")
@FontItalic("Infinity.ttf")
@FontBold("Raleway-Bold.ttf")
public class LogView extends BaseViewModel {

    @Child(R.id.btnSampleLog)
    public Button btnSampleLog;


    public interface ViewImpl extends BaseViewImpl {
        void viewUpdateLog(String text);
    }

    public interface WorkerImpl extends BaseWorkerImpl {
        void requestPrintLog();
    }

    public LogView(BaseActivity activity, BaseViewImpl viewImpl, WorkerImpl workerImpl) {
        super(activity, viewImpl, workerImpl);
    }
}