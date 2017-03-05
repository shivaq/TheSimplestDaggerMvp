package yasuaki.kyoto.com.thesimplestdaggermvp.ui;

public interface MvpPresenter<V extends MvpView> {

    void onAttachView(V mvpView);

    void onDetachView();
}
