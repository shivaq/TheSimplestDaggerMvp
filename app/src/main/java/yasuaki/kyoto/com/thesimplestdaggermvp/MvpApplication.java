package yasuaki.kyoto.com.thesimplestdaggermvp;

import android.app.Application;

import javax.inject.Inject;

import timber.log.Timber;
import yasuaki.kyoto.com.thesimplestdaggermvp.data.DataManager;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.ApplicationComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.DaggerApplicationComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.module.ApplicationModule;

/**
 * Application は Presenter の業界団体の如きもの。
 * Application 会長は契約者でもあり、アカシックレコードに手を伸ばす能力を持つ。
 * Application会長 がアカシックレコードから DataManager を取得する。
 *
 * 各 Presenter （もしくは BasePresenter) はガンダム化によって、
 * フィールドに DataManager を取り込み、そこでようやく
 * DataManager の呪術を UI 世界の理に組み込んだ 新たな呪術を精錬し、
 * 最果ての契約者 空条承太郎のを通じて UI 世界に解き放つ
 */
public class MvpApplication extends Application{

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);

        if (BuildConfig.DEBUG) {
            Timber.uprootAll();
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ApplicationComponent getComponent(){
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent){
        mApplicationComponent = applicationComponent;
    }
}