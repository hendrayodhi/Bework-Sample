package napodev.bework.sample.view.activity.list;


import java.util.ArrayList;

import napodev.bework.sample.models.Trending;
import napodev.framework.bework.corebase.model.view.BaseViewModel;
import napodev.framework.bework.corebase.worker.view.BaseActivityControl;


/**
 * Created by opannapo on 4/24/17.
 */
public class TrendingWorker extends BaseActivityControl implements TrendingView.WorkerImpl {
    TrendingView.ViewImpl view;

    public TrendingWorker(BaseViewModel viewModel) {
        super(viewModel);
        this.view = (TrendingView.ViewImpl) getViewModel().getViewImpl();
    }

    @Override
    public void requestDataList() {
        view.viewDataLoaded(generateDummyTranding());
    }


    public ArrayList<Trending> generateDummyTranding() {
        ArrayList<Trending> trendings = new ArrayList<>();
        int[] tType = {
                1, 2, 2, 2, 2, 2, 2,
                1, 3, 3, 3, 3,
                1, 4, 4, 4

        };
        int[] tId = {
                1, 2, 3, 4, 44, 45, 46,
                5, 6, 7, 8, 88,
                9, 10, 11, 12
        };
        String[] tName = {
                "Destination", "Bali", "Bengkulu", "Jogja", "Papua", "Lombok", "Sumatera Barat",
                "Transportation", "Garuda Indonesia", "KAI", "Lion Air", "Sriwijaya Air",
                "Flight Search", "Traveloka.com", "Pegipegi.com", "tiket.com"
        };
        int[] tCount = {
                0, 1001, 973, 362, 321, 310, 201,
                0, 730, 421, 122, 92,
                0, 4209, 3710, 3692
        };

        for (int i = 0; i < tType.length; i++) {
            Trending t1 = new Trending();
            t1.id = tId[i];
            t1.type = tType[i];
            t1.name = tName[i];
            t1.count = tCount[i];
            trendings.add(t1);
        }

        return trendings;
    }
}
