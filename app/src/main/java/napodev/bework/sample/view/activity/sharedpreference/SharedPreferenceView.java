package napodev.bework.sample.view.activity.sharedpreference;

import android.widget.Button;
import android.widget.EditText;
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
@Root(R.layout.activity_shared_preference)
@FontDefault("Raleway-Regular.ttf")
@FontItalic("Infinity.ttf")
@FontBold("Raleway-Bold.ttf")
public class SharedPreferenceView extends BaseViewModel {

    @Child(R.id.eInputKey)
    public EditText eInputKey;
    @Child(R.id.eeInputValue)
    public EditText eeInputValue;
    @Child(R.id.btnSave)
    public Button btnSave;
    @Child(R.id.eReadKey)
    public EditText eReadKey;
    @Child(R.id.btnRead)
    public Button btnRead;
    @Child(R.id.tOutput)
    public TextView tOutput;


    public interface ViewImpl extends BaseViewImpl {
        void viewDataSaved(String text);

        void viewDataLoaded(String text);
    }

    public interface WorkerImpl extends BaseWorkerImpl {
        void saveData(String key, String val);

        void readData(String key);
    }

    public SharedPreferenceView(BaseActivity activity, BaseViewImpl viewImpl, WorkerImpl workerImpl) {
        super(activity, viewImpl, workerImpl);
    }
}