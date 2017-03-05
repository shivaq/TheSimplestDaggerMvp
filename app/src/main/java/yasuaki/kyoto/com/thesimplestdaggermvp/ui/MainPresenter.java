package yasuaki.kyoto.com.thesimplestdaggermvp.ui;

import javax.inject.Inject;

import timber.log.Timber;
import yasuaki.kyoto.com.thesimplestdaggermvp.data.DataManager;

public class MainPresenter<V extends MvpView> implements MvpPresenter<V> {

    // メフィストフェレスが契約者リストに入れていないため？？
    // メソッドに Inject をつけるとよくないことが起きる。
    // リストにないならば、お前がガンダムになるしかない。
    private DataManager mDataManager;
    private V mMvpView;

//    @Inject
//    public MainPresenter(DataManager dataManager) {
//        mDataManager = dataManager;
//        Timber.d("MainPresenter:MainPresenter: dataManager is %s", mDataManager);
//    }

    // 創造主@Module が このPresenter を求めている。
    // 契約者も求めている。
    // 求められている@Provides 供物に 刻印@Inject を打つ事でガンダム化し、
    // アカシックレコードに取り込まないと、世界の理がゆらぎ、よくないことが起きる。
    // ※契約者は、ガンダム化はしなくてもアカシックレコードに取り込まれるため、
    // 刻印無しで創造主に利用される
    @Inject
    public MainPresenter() {
    }

    @Override
    public void onAttachView(V mvpView) {
        mMvpView = mvpView;
        Timber.d("MainPresenter:onAttachView: mMvpView is %s", mMvpView);
    }

    @Override
    public void onDetachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }
}
