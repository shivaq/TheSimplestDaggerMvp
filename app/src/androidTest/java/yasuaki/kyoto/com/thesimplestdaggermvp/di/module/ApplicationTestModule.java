package yasuaki.kyoto.com.thesimplestdaggermvp.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.ApplicationContext;

@Module
public class ApplicationTestModule {

    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

}