package yasuaki.kyoto.com.thesimplestdaggermvp.ui;

public interface MvpPresenter<V extends MvpView> {

    void onAttachMvpView(V mvpView);

    void onDetachMvpView();
}
