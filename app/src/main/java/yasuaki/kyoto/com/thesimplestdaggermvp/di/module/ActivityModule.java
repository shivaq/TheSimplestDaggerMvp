package yasuaki.kyoto.com.thesimplestdaggermvp.di.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.ActivityContext;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.PerActivity;
import yasuaki.kyoto.com.thesimplestdaggermvp.ui.MainPresenter;
import yasuaki.kyoto.com.thesimplestdaggermvp.ui.MvpPresenter;
import yasuaki.kyoto.com.thesimplestdaggermvp.ui.MvpView;

/**
 * Created by Yasuaki on 2017/03/05.
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    MvpPresenter<MvpView> provideMainPresenter(MainPresenter<MvpView> presenter) {
        return presenter;
    }
}