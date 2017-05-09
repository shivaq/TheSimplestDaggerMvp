package yasuaki.kyoto.com.thesimplestdaggermvp.ui;

import javax.inject.Inject;
import yasuaki.kyoto.com.thesimplestdaggermvp.data.DataManager;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.PerActivity;
import yasuaki.kyoto.com.thesimplestdaggermvp.ui.base.BasePresenter;

@PerActivity//Use this scope annotation to make presenter configure persistent
public class MainPresenter implements BasePresenter<MainMvpView> {

    private final DataManager dataManager;
    private MainMvpView mainMvpView;

    // A presenter is integrated into object graph.
    // Then a presenter could summon instances and be summoned from components.
    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void onAttachMvpView(MainMvpView mvpView) {
        mainMvpView = mvpView;
    }

    @Override
    public void onDetachMvpView() {
        mainMvpView = null;
    }

    public boolean isViewAttached() {
        return mainMvpView != null;
    }
}