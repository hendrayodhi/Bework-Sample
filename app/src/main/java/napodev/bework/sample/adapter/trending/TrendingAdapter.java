package napodev.bework.sample.adapter.trending;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import napodev.bework.sample.R;
import napodev.bework.sample.adapter.GeneralFooterVH;
import napodev.bework.sample.adapter.GeneralHeaderVH;
import napodev.bework.sample.models.Trending;
import napodev.framework.bework.corebase.worker.adapter.BaseRecyclerViewAdapter;
import napodev.framework.bework.corebase.worker.adapter.BaseViewHolder;

/**
 * Created by opannapo on 11/17/16.
 */
public class TrendingAdapter extends BaseRecyclerViewAdapter {
    private static final int VIEW_TYPE_INFO = 1;
    private static final int VIEW_TYPE_DEFAULT = 2;

    public TrendingAdapter(Context context, ArrayList<Object> dataModels, Object headerObject, Object footerObject) {
        super(context, dataModels, headerObject, footerObject);
    }

    @Override
    public int contentItemsViewType(int position) {
        Trending t = (Trending) getContentByPosition(position);
        if (t.type == 1) {
            return VIEW_TYPE_INFO;
        }
        return VIEW_TYPE_DEFAULT;
    }

    @Override
    public RecyclerView.ViewHolder createItemsViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_INFO) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_trending_info, parent, false);
            return new VHTrendingInfo(v, this);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_trending_list, parent, false);
            return new VHTrendingList(v, this);
        }
    }

    @Override
    public BaseViewHolder createHeaderViewHolder(ViewGroup parent, int viewType) {
        header = new GeneralHeaderVH(LayoutInflater.from(context).inflate(R.layout.vh_general_header, parent, false), this);
        return header;
    }

    @Override
    public BaseViewHolder createFooterViewHolder(ViewGroup parent, int viewType) {
        footer = new GeneralFooterVH(LayoutInflater.from(context).inflate(R.layout.vh_general_footer, parent, false), this);
        return footer;
    }
}
