package yasuaki.kyoto.com.thesimplestdaggermvp;

import android.app.Application;

import timber.log.Timber;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.ApplicationComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.component.DaggerApplicationComponent;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.module.ApplicationModule;

public class MvpApplication extends Application{

//    @Inject
//    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);

        //timber 使用準備
        if (BuildConfig.DEBUG) {
            Timber.uprootAll();
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ApplicationComponent getComponent(){
        return mApplicationComponent;
    }
}