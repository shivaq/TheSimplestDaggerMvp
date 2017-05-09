package yasuaki.kyoto.com.thesimplestdaggermvp.ui.base;

import javax.inject.Inject;
import yasuaki.kyoto.com.thesimplestdaggermvp.data.DataManager;

/**
 * Presenter extends BaseMvpView to pass logical interaction with BaseMvpView People.
 */
public class BasePresenterImpl<V extends BaseMvpView> implements BasePresenter<V> {

    private final DataManager dataManager;

    private V mvpView;

    @Inject
    public BasePresenterImpl(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void onAttachMvpView(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void onDetachMvpView() {
        mvpView = null;
    }

    public boolean isViewAttached(){
        return mvpView != null;
    }

    public V getMvpView(){
        return mvpView;
    }

    public DataManager getDataManager(){
        return dataManager;
    }
}
