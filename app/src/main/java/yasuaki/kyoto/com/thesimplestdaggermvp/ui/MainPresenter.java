package yasuaki.kyoto.com.thesimplestdaggermvp.ui;

import javax.inject.Inject;

import yasuaki.kyoto.com.thesimplestdaggermvp.data.DataManager;

/**
 * 自らをガンダム化し、Application 会長に接続。
 * Application会長経由で DataManager の力を取り出し、フィールドに取り込み、
 * マスターである契約者の黒子となって情報を手渡す。
 * @param <V>
 */
public class MainPresenter<V extends MvpView> implements MvpPresenter<V> {

    // メフィストフェレスが契約者リストに入れていないため？？
    // 契約者でないものが、フィールドに Inject をつけるとよくないことが起きる。
    // リストにないならば、お前がガンダムになるしかない。
    private DataManager mDataManager;
    private V mMvpView;

    // 創造主@Module が このPresenter を求めている。
    // 契約者も求めている。
    // 求められている@Provides 供物に 刻印@Inject を打つ事でガンダム化し、
    // アカシックレコードに取り込まないと、世界の理がゆらぎ、よくないことが起きる。
    // ※契約者は、ガンダム化はしなくてもアカシックレコードに取り込まれるため、
    // 刻印無しで創造主に利用される
    @Inject
    public MainPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void onAttachMvpView(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetachMvpView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }
}
