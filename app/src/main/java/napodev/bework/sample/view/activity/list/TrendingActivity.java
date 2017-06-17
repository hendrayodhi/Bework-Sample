package napodev.bework.sample.view.activity.list;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import napodev.bework.sample.R;
import napodev.bework.sample.adapter.trending.TrendingAdapter;
import napodev.bework.sample.models.GeneralFooterDataModel;
import napodev.bework.sample.models.GeneralHeaderDataModel;
import napodev.bework.sample.models.Trending;
import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.view.BaseActivity;
import napodev.framework.bework.corebase.worker.adapter.BaseScrollingListener;
import napodev.framework.bework.corebase.worker.adapter.OnAdapterItemsClickListener;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;


/**
 * Created by opannapo on 4/28/17.
 */
public class TrendingActivity extends BaseActivity implements TrendingView.ViewImpl, View.OnClickListener {
    TrendingWorker worker;
    TrendingView view;

    public ArrayList<Object> trendings;
    public LinearLayoutManager sglm;
    public TrendingAdapter adapter;
    public GeneralFooterDataModel footer;
    public GeneralHeaderDataModel header;

    @Override
    public BaseViewModel getViewModel() {
        return view;
    }

    @Override
    public BaseActivityControl getWorker() {
        return worker;
    }

    @Override
    public void onActivityCreate(Bundle savedInstanceState) {
        view = new TrendingView(this, this, worker);
        worker = new TrendingWorker(view);

        //Execute worker to Load Data
        worker.requestDataList();

        view.toolbar.findViewById(R.id.toolbarBtnLeft).setOnClickListener(this);
        ((TextView) view.toolbar.findViewById(R.id.tLabelToolbar)).setText("List");

        //recyclerview
        sglm = new LinearLayoutManager(thisActivity());
        view.recyclerview.setLayoutManager(sglm);
        view.recyclerview.addOnScrollListener(new BaseScrollingListener(view.recyclerview, sglm) {
            @Override
            public void onStateStop() {

            }

            @Override
            public void onStateKeyDown() {

            }

            @Override
            public void onStateKeyUp() {

            }

            @Override
            public void onScrollingUp(RecyclerView recyclerView, int dx, int dy) {
                // TODO: 6/18/17 handle when scrolling up
            }

            @Override
            public void onScrollingDown(RecyclerView recyclerView, int dx, int dy) {
                // TODO: 6/18/17 handle when scrolling down
            }

            @Override
            public void onLastVisible(RecyclerView recyclerView, int dx, int dy) {
                // TODO: 6/18/17 handle when last items visible
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //UPDATE FOOTER , then notify adapter
                                footer.setHasnNextPage(false);
                                adapter.notifyFooter(footer);
                            }
                        });
                    }
                }, 500);
            }

            @Override
            public void onTopVisible(RecyclerView recyclerView, int dx, int dy) {
                // TODO: 6/18/17 handle when top items visible
            }
        });


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbarBtnLeft:
                onBack();
                break;
        }
    }

    @Override
    public void onBack() {
        finishWithAnim(ANIM_TYPE.LEFT_TO_RIGHT);
    }

    @Override
    public void viewDataLoaded(final ArrayList<Trending> trendings) {
        this.trendings = new ArrayList<>();
        this.trendings.addAll(trendings);
        this.footer = new GeneralFooterDataModel();
        this.header = new GeneralHeaderDataModel();

        footer.setCurrentPage(1);
        footer.setHasnNextPage(true);
        footer.setTotalPage(10);
        header.setLabel("Trending");
        header.setIconRes(R.drawable.ic_more_horiz_white_24dp);

        adapter = new TrendingAdapter(this, this.trendings, header, footer);
        view.recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnAdapterItemsClickListener() {
            @Override
            public void onItemsClicked(int viewType, int position, View v) {
                Toast.makeText(TrendingActivity.this, "Position:" + position +
                                " viewType:" + viewType +
                                " Data:" + ((Trending) adapter.getContentByPosition(position)).name,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
