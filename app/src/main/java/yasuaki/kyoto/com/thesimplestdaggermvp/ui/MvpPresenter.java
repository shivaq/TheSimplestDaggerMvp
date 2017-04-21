package yasuaki.kyoto.com.thesimplestdaggermvp.ui;

import yasuaki.kyoto.com.thesimplestdaggermvp.di.PerActivity;

@PerActivity
public interface MvpPresenter<V extends MvpView> {

    void onAttachMvpView(V mvpView);

    void onDetachMvpView();
}
