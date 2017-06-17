package napodev.bework.sample.adapter.trending;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import napodev.bework.sample.R;
import napodev.bework.sample.models.Trending;
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
public class VHTrendingList extends BaseViewHolder {
    @Child(R.id.tName)
    public TextView tName;
    @Child(R.id.tCount)
    public TextView tCount;

    public VHTrendingList(View itemView, BaseRecyclerViewAdapter adapter) {
        super(itemView, adapter);
    }

    @Override
    public void onInit(View itemView) {
        ViewInjector.inject(this, (ViewGroup) itemView);
        FontInjector.inject(this, (BaseActivity) getContext(), (ViewGroup) itemView);
    }

    @Override
    public void onViewBinding(Object objectEntities, final int position) {
        Trending dataModel = (Trending) objectEntities;
        tName.setText(dataModel.name);
        tCount.setText("Total " + dataModel.count);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAdapter().getOnItemClickListener().onItemsClicked(getItemViewType(), position, v);
            }
        });
    }
}


