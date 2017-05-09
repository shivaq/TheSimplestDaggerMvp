package yasuaki.kyoto.com.thesimplestdaggermvp.di.module;

import android.app.Activity;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.ActivityContext;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
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

}