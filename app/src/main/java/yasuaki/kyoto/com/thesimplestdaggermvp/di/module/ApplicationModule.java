package yasuaki.kyoto.com.thesimplestdaggermvp.di.module;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import yasuaki.kyoto.com.thesimplestdaggermvp.data.AppDataManager;
import yasuaki.kyoto.com.thesimplestdaggermvp.data.DataManager;
import yasuaki.kyoto.com.thesimplestdaggermvp.di.ApplicationContext;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
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

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

}
