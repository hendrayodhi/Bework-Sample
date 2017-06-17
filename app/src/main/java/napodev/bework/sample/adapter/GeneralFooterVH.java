package napodev.bework.sample.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import napodev.bework.sample.R;
import napodev.bework.sample.models.GeneralFooterDataModel;
import napodev.framework.bework.corebase.view.BaseActivity;
import napodev.framework.bework.corebase.worker.adapter.BaseRecyclerViewAdapter;
import napodev.framework.bework.corebase.worker.adapter.BaseViewHolder;
import napodev.framework.bework.utils.napoinject.Child;
import napodev.framework.bework.utils.napoinject.FontBold;
import napodev.framework.bework.utils.napoinject.FontDefault;
import napodev.framework.bework.utils.napoinject.FontInjector;
import napodev.framework.bework.utils.napoinject.FontItalic;
import napodev.framework.bework.utils.napoinject.ViewInjector;

/**
 * Created by opannapo on 11/17/16.
 */
@FontDefault("Raleway-Regular.ttf")
@FontItalic("Infinity.ttf")
@FontBold("Raleway-Bold.ttf")
public class GeneralFooterVH extends BaseViewHolder {
    @Child(R.id.tLabel)
    TextView tLabel;
    @Child(R.id.progressBar)
    ProgressBar progressBar;

    public GeneralFooterVH(View itemView, BaseRecyclerViewAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void onInit(View itemView) {
        ViewInjector.inject(this, (ViewGroup) itemView);
        FontInjector.inject(this, (BaseActivity) getContext(), (ViewGroup) itemView);
    }

    @Override
    public void onViewBinding(Object objectEntities, int position) {
        GeneralFooterDataModel footerDataModel = (GeneralFooterDataModel) objectEntities;
        if (footerDataModel.isHasnNextPage()) {
            tLabel.setText("Loading bro...");
            tLabel.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            tLabel.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
            tLabel.setText("No More");
        }
    }


}
